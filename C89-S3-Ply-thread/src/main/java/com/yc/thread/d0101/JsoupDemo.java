package com.yc.thread.d0101;

import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupDemo {
	
	public static void main(String[] args) throws IOException {
		
		String path = "http://www.jiushujie.com/";
		URL url = new URL(path);
		// 解析网路资源(包含下载)
		Document doc = Jsoup.parse(url, 3000);
		Elements es = doc.select(".book_list>ul>li");
		for(Element e : es) {
			System.out.println("--------------------------------------------");
			System.out.println(e.selectFirst("img").attr("title"));
			System.out.println(e.selectFirst("img").attr("src"));
			System.out.println(e.selectFirst("a[title]").text());
			System.out.println(e.selectFirst(".now_price").text());
			System.out.println(e.selectFirst(".origin_price").text());
		}
		
	}

}
