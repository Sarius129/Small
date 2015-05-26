/**
 * Created by Sinan on 26.05.2015.
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

// convert text in html to unformatted text
public class HtmlToText {
    static final String INPUT = "Small/input/input.html";
    static final String OUTPUT = "Small/output/htmlout.txt";
    static final String ENCODING = StandardCharsets.UTF_8.name();

    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.parse(new File(INPUT), ENCODING);
        FileWriter writer = new FileWriter(OUTPUT);
        writer.write(doc.text());
        writer.close();
    }}

