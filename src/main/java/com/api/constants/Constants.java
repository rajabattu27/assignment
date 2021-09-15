package com.api.constants;


import com.api.utils.BaseUrl;

public class Constants {

    public enum LogLevels {
        DEBUG, INFO,
    }

    public static StringBuilder output = new StringBuilder();
    public static final String URL_BASE = BaseUrl.getBaseUrl();
    public static final String CONTENT_TYPE = "application/x-www-form-urlencoded";

}
