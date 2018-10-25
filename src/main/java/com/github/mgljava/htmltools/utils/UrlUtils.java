package com.github.mgljava.htmltools.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class UrlUtils {

  public static String getPageSource(String pageUrl, String encoding) {

    StringBuilder stringBuilder = new StringBuilder();
    try {
      //构建一URL对象
      URL url = new URL(pageUrl);
      BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), encoding));
      String line;
      while ((line = in.readLine()) != null) {
        stringBuilder.append(line);
        stringBuilder.append("\n");
      }
      in.close();
    } catch (Exception e) {
      e.printStackTrace();
      return "";
    }
    return stringBuilder.toString();
  }
}
