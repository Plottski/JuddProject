package com.example.JuddProject;

import com.sun.tools.javac.Main;
import jakarta.annotation.Resources;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
public class JuddProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(JuddProjectApplication.class, args);
	}
}
























































/*public static final String SearchUrl = "https://www.google.com/search";

	 throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the search term");
		String searchTerm = scanner.nextLine();
		String linkSearchTerm = searchTerm.replaceAll("\\s+","");
		System.out.println("Please enter the number of results. Example:5, 10, 20");
		int num = scanner.nextInt();
		scanner.close();

		String searchURL = SearchUrl + "?q="+linkSearchTerm+"&num="+num;
		System.out.println(searchURL);

		Document doc = Jsoup.connect(searchURL).userAgent("Mozilla/5.0").get();
		//System.out.println(doc.html());

		Elements results = doc.select("h3.r > a");

		ArrayList<String> hyperLinks = new ArrayList<>();



		for (Element result : results) {
			System.out.println(result);
			String linkHref = result.attr("href");
			System.out.println(linkHref);
			String linkText = result.text();
			System.out.println("Text::" + linkText + ", URL::" + linkHref.substring(6, linkHref.indexOf("&")));
			hyperLinks.add(linkText);
			System.out.println(hyperLinks);
			String daLink = linkHref;
			System.out.println(daLink);
			hyperLinks.add(daLink);
		}
		System.out.println(hyperLinks);


		SpringApplication.run(JuddProjectApplication.class, args);
	}
*/