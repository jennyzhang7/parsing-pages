package output;

import formatter.CoAuthorList;
import formatter.ContentFormatter;

public class ConsoleOutput {

	String[] inputFiles;
	
	
	public ConsoleOutput(String[] cInputFiles) {

		inputFiles = cInputFiles;
	}
	
	/**
	 * @return
	 * 	the final formatted string to produce on the console. 
	 * @throws Exception
	 */

	public String displayOutput() throws Exception {
		StringBuilder finalContents = new StringBuilder();
		
		//add the formatted contents of each file to finalContents
		for (String inputFile:inputFiles) {
			ContentFormatter cf = new ContentFormatter(inputFile);
			finalContents.append(cf.formatContents());
		}
		
		//add co-author list to finalContents
		
		CoAuthorList cal = new CoAuthorList(inputFiles); 
		finalContents.append(cal.getCoAuthorList());
		
		//return the final string
		return finalContents.toString();
	}
}
