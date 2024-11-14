package com.example.JuddProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class JuddProjectApplication {

	public static final String SearchUrl = "https://www.google.com/search";

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the search term");
		String searchTerm = scanner.nextLine();
		System.out.println("Please enter the number of results. Example:5, 10, 20");
		int num = scanner.nextInt();
		scanner.close();

		String searchURL = SearchUrl + "?q="+searchTerm+"&num="+num;

		Document doc = Jsoup.connect(searchURL).userAgent("Mozilla/5.0").get();
		System.out.println(doc.html());

		Elements results = doc.select("h3.r > a");

		for (Element result : results) {
			String linkHref = result.attr("href");
			String linkText = result.text();
			System.out.println("Text::" + linkText + ", URL::" + linkHref.substring(6, linkHref.indexOf("&")));
		}

		SpringApplication.run(JuddProjectApplication.class, args);
	}

}
