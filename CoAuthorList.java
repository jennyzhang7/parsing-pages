package formatter; 

import java.util.ArrayList;
import java.util.Collections;

import contentExtractors.CoAuthors;
import contentExtractors.HtmlContents;


public class CoAuthorList {
	
	String[] inputFiles;

	public CoAuthorList(String[] cInputFiles) {
		inputFiles = cInputFiles;
	}
	
	/**
	 * Get a list of sorted co-authors. 
	 * @return
	 * 	a String containing all co-authors sorted in alphabetical order. 
	 * @throws Exception
	 */
	
	public String getCoAuthorList() throws Exception {
		//create a collection to store co-author list
		ArrayList<String> coauthors = new ArrayList<String>();
		
		for (String file:inputFiles) {
			//get the HTML contents
			HtmlContents googleScholarParser = new HtmlContents(file);
			String rawHTMLString = googleScholarParser.getHTML();
			
			//create CoAuthor object and get ArrayList of co-authors
			CoAuthors ca = new CoAuthors(rawHTMLString);
			ArrayList<String> caArray = ca.extractCoAuthors();
			
			//add each author in caArray to set
			for (String author:caArray) {
				if (!coauthors.contains(author)) {
					coauthors.add(author);
				}	
			}
		}
		Collections.sort(coauthors);
		//put authors in a StringBuilder object
		StringBuilder output = new StringBuilder();
		output.append("\n7. Co-Author list sorted (Total: " 
				+ coauthors.size() + "):\n");
		for (String author:coauthors) {
			output.append(author + "\n");
		}
		return output.toString();
	}
}
