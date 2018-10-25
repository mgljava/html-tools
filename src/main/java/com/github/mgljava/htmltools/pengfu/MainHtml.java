package com.github.mgljava.htmltools.pengfu;

import com.github.mgljava.htmltools.utils.HtmlParserUtils;
import com.github.mgljava.htmltools.utils.UrlUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainHtml {

  private static String rootHtmlUrl = "https://www.pengfu.com/xiaohua_";
  private static String className = "content-img clearfix pt10 relative";

  public static void main(String[] args) {
    /*for (int i = 1; i <= 50; i++) {
      String url = rootHtmlUrl + i + ".html";
      final String pageSource = UrlUtils.getPageSource(url, "UTF-8");
      final String bodies = HtmlParserUtils.getElement(pageSource, className);

      for (String body : bodies.split("---->")) {
        *//*System.out.println(body);
        System.out.println("-----------" + i + "------------");*//*
      }
    }*/
    System.out.println("*********************************************************");
    List<String> urls = new ArrayList<>();
    for (int i = 0; i <= 50; i++) {
      urls.add(rootHtmlUrl + i + ".html");
    }

    urls.stream()
        .parallel()
        .map(url -> UrlUtils.getPageSource(url, "UTF-8"))
        .map(txt -> HtmlParserUtils.getElement(txt, className))
        .flatMap(body -> Arrays.stream(body.split("---->")))
        .forEach(text -> {
          System.out.println(text);
          System.out.println("-----------------------");
        });

    System.out.println("*********************************************************");
    // 自定义线程池
    /*final Executor executor = Executors.newFixedThreadPool(Math.min(urls.size(), 100),
        runnable -> {
          Thread thread = new Thread(runnable);
          thread.setDaemon(true);
          return thread;
        });
    urls.stream()
        .map(url -> CompletableFuture.supplyAsync(() ->
            UrlUtils.getPageSource(url, "UTF-8"), executor))
        .map(txt -> {
          try {
            return HtmlParserUtils.getElement(txt.get(), className);
          } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
          }
          return "";
        })
        .flatMap(body -> Arrays.stream(body.split("---->")))
        .forEach(text -> {
          System.out.println(text);
          System.out.println("-----------------------");
        });*/
  }
}
