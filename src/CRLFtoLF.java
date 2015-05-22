import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;


public class CRLFtoLF {
	static final String IN = "src/input/in.txt";
	static final String OUT = "src/output/out.txt";

	public static void main(String[] args) throws IOException {
		FileReader inFile;
		FileWriter outFile;
		if (args.length > 0) {
			if (args.length == 2) {
				inFile = new FileReader(args[0]);
				outFile = new FileWriter(args[1]);
				replace(inFile, outFile);
			}
			else if (args.length == 1) {
				inFile = new FileReader(args[0]);
				outFile = new FileWriter(OUT);
				replace(inFile, outFile);
			}
			else {
				System.err.println("usage: CRLFtoLF [input_file] [output_file]");
			}
		}
		else {
			inFile = new FileReader(IN);
			outFile = new FileWriter(OUT);
			replace(inFile, outFile);
		}
	}
	
	static String replace(String crlfString) {
		Scanner scn = new Scanner(crlfString);
		StringBuilder resultBuilder = new StringBuilder();
		while(scn.hasNextLine()) resultBuilder.append(scn.nextLine() + "\n");
		return resultBuilder.toString();
	}
	
	static void replace(Reader in, Writer out) throws IOException {
		String line;
		BufferedReader br = new BufferedReader(in);
		while ((line = br.readLine()) != null) {
			out.write(line + "\n");
		}
	}

}
