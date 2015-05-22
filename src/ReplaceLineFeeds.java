import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


class ReplaceLineFeeds {
	static String inFile = "src/input/in.txt";
	static String outFile = "src/output/out.txt";
	
	public static void main(String[] args) throws IOException {
		
		if (args.length > 2) {
			System.err.println("Usage: ReplaceLineFeeds [input file] [output file]");
		}
		else if (args.length == 2) {
			inFile = args[0];
			outFile = args[1];
		}
		else if (args.length == 1) {
			inFile = args[0];
		}
		
		BufferedReader in = new BufferedReader(new FileReader(inFile));
		BufferedWriter out = new BufferedWriter(new FileWriter(outFile));
		
		String line;
		while((line = in.readLine()) != null) {
			out.write(line);
		}
		in.close();
		out.close();
	}
}