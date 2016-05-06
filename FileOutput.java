package output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


import output.ConsoleOutput;

public class FileOutput {
	String[] inputFiles;
	String fileName;
	
	public FileOutput(String[] cInputFiles, String cFileName) {
		inputFiles = cInputFiles;
		fileName = cFileName;
	}

	public void writeToFile() throws Exception {
		//get output String from ConsoleOutput
		ConsoleOutput co = new ConsoleOutput(inputFiles);
		String text = co.displayOutput();
		
		File dir = new File("../../");
		
		String filePathName = fileName;
		File tagFile = new File(dir, filePathName + ".txt");
		if (!tagFile.exists()) {
			tagFile.createNewFile();
		}
		
		//write to file
		FileWriter fileWriter = new FileWriter(tagFile.getName(),true);
	    BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
	    bufferWriter.write(text);
	    bufferWriter.close();
		
		
	}
}
