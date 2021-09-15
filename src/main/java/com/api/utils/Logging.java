package com.api.utils;

import com.api.constants.Constants;
import org.testng.Reporter;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Logging {

    public static StringBuilder report = new StringBuilder();
    public static String logLevel = "debug";

    public static void log() {
        log(false);
    }

    public static void log(boolean aggregateLog) {
        log("", aggregateLog);
    }

    // Logs the message and stack trace for an exception
    public static void log(Exception e) {
        log(e, false);
    }

    public static void log(Exception e, boolean aggregateLog) {
        Logging.log(e.getMessage(), aggregateLog);
        // Convert stack trace to string for logging
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        Logging.log(sw.toString(), aggregateLog);
    }

    public static void logForcePrint(String message) {
        log(message, false, true);
    }

    public static void log(String message) {
        log(message, false);
    }

    public static void log(String message, boolean aggregateLog) {
        log(message, aggregateLog, false);
    }

    public static void log(String message, boolean aggregateLog, boolean forcePrint) {
        long id = Thread.currentThread().getId();
        // if the thread id is 1, we are almost certainly running on a single thread
        // logging the id is just noise in that case
        if (id != 1) {
            message = "Thread " + id + "\t" + message;
        }
        if (logLevel == null) {
            logLevel = Constants.LogLevels.INFO.toString();
        }
        // If loglevel is not set or is set to DEBUG only then print logs console
        if (logLevel == null || logLevel.equalsIgnoreCase(Constants.LogLevels.DEBUG.toString()) || forcePrint) {
            // Log to the console without HTML formatting
            System.out.println(message);
        }
        // append all logs to string builder and write it to text file at the end of
        // execution
        Constants.output.append(message + System.lineSeparator());
        if (!aggregateLog) {
            // Log to report with HTML formatting
            Reporter.log("<br>" + message, false);
        } else {
            // Add message to string builder
            report.append("<br>" + message);
        }
    }

    // Logs a message that is surrounded by empty lines
    public static void paddedLog(String message) {
        paddedLog(message, false);
    }

    public static void paddedLog(String message, boolean aggregateLog) {
        log();
        log(message, aggregateLog);
        log();
    }

    public static String outputLog() {
        return report.toString();
    }

    public static void clearReport() {
        report = new StringBuilder();
    }
}
