// utility to get the source of a web page and save it to a file using the Jsoup library
// default saving location and filename: src/output/htmlOutput.html

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class HtmlGet {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		String adress = scn.nextLine().trim();
		String htmlText = "";

		try {
			Document doc = Jsoup.connect(adress).get();
			htmlText = doc.outerHtml();
		}
		catch (IOException e) {
			System.err.println("Error fetching the page.");
			e.printStackTrace();
		}

		try  {
			FileWriter fw = new FileWriter("src/output/htmlOutput.html");
			fw.write(htmlText);
			fw.close();
		}
		catch (IOException e) {
			System.err.println("An I/O error occurred while trying to write the file.");
			e.printStackTrace();
		}
	}
}