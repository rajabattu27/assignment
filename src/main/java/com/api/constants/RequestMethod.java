package com.api.constants;

/**
 * This class contains the different HTTP methods
 */
public enum RequestMethod
{
    Get ("GET"),
    Delete ("DELETE"),
    Post ("POST"),
    Put ("PUT");
    
    public String value;
    private RequestMethod(String value) {
            this.value = value;
    }
}