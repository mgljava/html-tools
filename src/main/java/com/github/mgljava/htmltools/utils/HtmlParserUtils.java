package com.github.mgljava.htmltools.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Html解析器
 */
public class HtmlParserUtils {

  public static String getElement(String text, String className) {
    final Document document = Jsoup.parse(text);
    final Elements elements = document
        .getElementsByClass(className);
    StringBuilder sb = new StringBuilder();
    for (Element element : elements) {
      if (sb.length() != 0) {
        sb.append("\n");
      }
      sb.append(element.html());
      sb.append("---->");
    }
    return sb.toString();
  }
}
