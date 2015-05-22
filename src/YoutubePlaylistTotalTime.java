// a small utility to calculate the total duration of videos in a Youtube playlist
// using the Jsoup library for fetching and parsing

import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class YoutubePlaylistTotalTime {
	public static void main (String[] args) throws IOException {
		System.out.println("Please enter the URL of the playlist: ");
		Scanner scn = new Scanner(System.in);
		String adress = scn.nextLine(); // read the address from stdin
		System.out.println("Please wait...");
		
		Document doc = Jsoup.connect(adress).get();
		Elements times = doc.getElementsByClass("timestamp");
		
		int mins = 0, secs = 0;
		
		for (Element e : times) {
			String timeString = e.text();
//			System.out.println(timeString);
			int ind = timeString.indexOf(":");
			mins += Integer.parseInt(timeString.substring(0,ind));
			secs += Integer.parseInt(timeString.substring(ind+1));
		}
		
		mins += secs / 60;
		int sec = secs % 60;
		int hours = mins / 60;
		mins = mins % 60;
		

		System.out.println("Total Time: " + hours + ":" + mins + ":" + sec);
	}
}