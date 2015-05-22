// utility to omit all words in a text as chunks of one or more words for cloze deletion
// for the open-source spaced repetition software Anki
// input from relative path src/input/in.txt

// intended for self use

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class AnkiWordOmitter {
	static final int SIZE = 3;

	public static void main(String[] args) throws IOException {

		Scanner scn = new Scanner(new FileReader("src/input/in.txt"));
		StringBuilder sourceBuilder = new StringBuilder();

		while(scn.hasNextLine()) {
			sourceBuilder.append(scn.nextLine());
		}

		//		Pattern pattern = Pattern.compile("\b(w+)\b");
		//		
		//		Matcher matcher = pattern.matcher(sourceBuilder.toString());
		//		StringBuilder resultBuilder = new StringBuilder();
		//		
		//		while (matcher.find()) {
		//			resultBuilder.append(matcher.group() + " ");
		//		}

		String source = new String(sourceBuilder);

		String[] words = source.split("\\s+");
		StringBuilder resultBuilder = new StringBuilder();
		int size = SIZE;
		int lastIndex;

		int i;
		int j;
		for (i = 0, j = 0; i+size-1 < words.length; i+=size, j++) {
			resultBuilder.append("{{c" + j + "::");
			for (int k = 0; k<size; k++) {
				resultBuilder.append(words[i+k] + " ");
			}
			resultBuilder.insert(resultBuilder.length()-1, "}}");
		}
		//		System.out.println("i: " + i);
		//		System.out.println("numOfWords: " + words.length);
		if (i < words.length) {
			//			System.out.println("inside if");
			resultBuilder.append("{{c" + (j+1) + "::");
			for (; i < words.length; i++) {
				resultBuilder.append(words[i] + " ");
			}
			resultBuilder.insert(resultBuilder.length()-1, "}}");
		}
		resultBuilder.deleteCharAt(resultBuilder.length()-1);

		System.out.print(resultBuilder.toString());
	}
}