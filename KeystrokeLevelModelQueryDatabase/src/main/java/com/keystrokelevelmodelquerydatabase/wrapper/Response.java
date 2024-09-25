package com.keystrokelevelmodelquerydatabase.wrapper;

import java.util.HashMap;
import java.util.Map;

public class Response {

  public static Map<String, String> header() {
    Map<String, String> headers = new HashMap<>();
    headers.put("Content-Type", "application/json");
    headers.put("X-Custom-Header", "application/json");
    return headers;
  }

}
