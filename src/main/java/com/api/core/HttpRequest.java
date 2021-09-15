package com.api.core;


import com.api.constants.Constants;
import com.api.constants.RequestMethod;
import com.api.utils.Logging;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpRequest {

    protected String pathAndQueryString;
    protected RequestMethod requestMethod;
    protected String body;
    public String contentType;
    public String accept;
    protected String baseUrl;
    public String affiliateId;

    private HashMap<String, String> customHeaders;

    public HttpRequest() {
        customHeaders = new HashMap<String, String>();
    }

    public HttpResponse execute() throws Exception {
        HttpResponse httpResponse = new HttpResponse();
        String url = null;
        if (this.baseUrl != null) {
            url = this.baseUrl + this.pathAndQueryString;
        } else {
            url = Constants.URL_BASE + this.pathAndQueryString;
        }
        URL obj = new URL(url);
        HttpURLConnection con;
        if (url.startsWith("https")) {
            con = (HttpsURLConnection) obj.openConnection();
        } else {
            con = (HttpURLConnection) obj.openConnection();
        }

        // Build request headers
        con.setRequestMethod(this.requestMethod.value);
        if (this.contentType == null) {
            this.AddHeader("Content-Type", Constants.CONTENT_TYPE);
        } else {
            this.AddHeader("Content-Type", this.contentType);
        }
        if (accept != null) {
            this.AddHeader("Accept", this.accept);
        } else {
            this.AddHeader("Accept", "application/json");
        }
        this.AddHeader("Accept-Language", "en_US");

        if (affiliateId != null) {
            this.AddHeader("affiliateId", this.affiliateId);
        }

        // Add custom headers to request
        for (String key : this.customHeaders.keySet()) {
            con.setRequestProperty(key, customHeaders.get(key));
        }

        // Log request
        Logging.log();
        Logging.log("Request:");
        Logging.log("Url:\t" + url);
        Logging.log("Method:\t" + this.requestMethod.value);
        Map<String, List<String>> requestHeaderFields = con.getRequestProperties();
        for (String key : requestHeaderFields.keySet()) {
            for (String value : requestHeaderFields.get(key)) {
                if (key != null) {
                    Logging.log(String.format("Header\t%s:%s", new Object[]{key, value}));
                }
            }
        }
        Logging.log("Body:\t" + this.body);

        // Build post body
        if ((this.requestMethod == RequestMethod.Post || this.requestMethod == RequestMethod.Put) && (this.body != null)) {
            con.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(con.getOutputStream());
            if (this.body != null) {
                out.write(this.body.getBytes(Charset.forName("UTF-8")));
            }
            out.close();
            out.flush();
            out.close();
        }
        // Execute request
        try {
            httpResponse.code = con.getResponseCode();
        } catch (Exception e) {
        }
        // Get response
        BufferedReader in = null;
        try {
            if (httpResponse.code >= 400) {
                in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            } else {
                in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            httpResponse.body = response.toString();
        } catch (Exception e) {
        } finally {
            if (in != null) {
                in.close();
            }
        }
        if (httpResponse.body != null && httpResponse.body != "" && !httpResponse.body.equals("[]") && !httpResponse.body.startsWith("<html>")) {
            if (httpResponse.body.startsWith("[") && httpResponse.body.endsWith("]")) {
                String massagedBody = "{ \"testArray\":" + httpResponse.body + "}";
                httpResponse.json = new JSONObject(massagedBody);
            } else if (httpResponse.body.startsWith("{")) {
                httpResponse.json = new JSONObject(httpResponse.body);
            }
        }
        if (httpResponse.code != 200) {
            if (httpResponse.json != null) {
                httpResponse.errorMessage = httpResponse.json.optString("errorMessage");
            }
        }
        httpResponse.headers = con.getHeaderFields();

        // Log response
        Logging.log();
        Logging.log("Response:");
        Logging.log("Code:\t" + Integer.toString(httpResponse.code));
        Map<String, List<String>> responseHeaderFields = con.getHeaderFields();
        for (String key : responseHeaderFields.keySet()) {
            for (String value : responseHeaderFields.get(key)) {
                if (key != null) {
                    Logging.log(String.format("Header\t%s:%s", new Object[]{key, value}));
                }
            }
        }
        Logging.log("Body:\t" + httpResponse.body);
        return httpResponse;
    }


    public void AddHeader(String key, String value) {
        this.customHeaders.put(key, value);
    }

    // This is a naive array of TrustManagers used to trust all SSL certificates
    // that is used to simplify debugging
    TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
        }

        public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
        }
    }};
}

