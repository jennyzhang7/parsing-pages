package driver;

import output.ConsoleOutput;
import output.FileOutput;

public class MyParser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String inputFiles[] = args[0].split(",");
		
	
		try { 
			if (!args[3].equals(null)) {
				FileOutput fo = new FileOutput(inputFiles, args[1]);
				try {
					fo.writeToFile();
				} catch (Exception e) {
					System.out.println("Bad input");
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			ConsoleOutput output = new ConsoleOutput(inputFiles);
			try {
				System.out.println(output.displayOutput());
			} catch (Exception e1) {
				System.out.println("Bad input");
			}
		}
	}
}
