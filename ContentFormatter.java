package formatter;

import contentExtractors.AllCitations;
import contentExtractors.AuthorName;
import contentExtractors.CitationsAfter2009;
import contentExtractors.CoAuthors;
import contentExtractors.HtmlContents;
import contentExtractors.Publications;
import contentExtractors.TotalPaperCitation;

/**
 * Class to format collected information from URL.
 */

public class ContentFormatter {
	
	String rawHTMLString;
	String urlString;
	
	/**
	 * Constructor. 
	 * @param urlStringCommandLine
	 */

	public ContentFormatter(String urlStringCommandline) {
		urlString = urlStringCommandline;
	}
	
	/**
	 * 
	 * @return
	 * 	a String containing the first 6 formatted elements to be expected in 
	 * the output.
	 * @throws Exception
	 */
	public String formatContents() throws Exception {
		//get the HTML contents
		HtmlContents googleScholarParser = new HtmlContents(urlString);
		String rawHTMLString = googleScholarParser.getHTML();
		
		//create a new object to store String output
		StringBuilder output = new StringBuilder();

		//1. get author's name		
		AuthorName author = new AuthorName(rawHTMLString);
		output.append("1. Name of Author: \n	");
		output.append(author.extractAuthorsName());
		
		//2. get number of all citations
		AllCitations c = new AllCitations(rawHTMLString);
		output.append("\n2. Number of All Citations:\n	");
		output.append(c.extractNumOfAllCitations());
		
		//3. get number of i10-index citations after 2009
		CitationsAfter2009 citations = new CitationsAfter2009(rawHTMLString);
		output.append("\n3. Number of i10-index after 2009:\n	");
		output.append(citations.extractCitationsAfter2009());
		
		//4. Title of first 3 publications
		Publications p = new Publications(rawHTMLString);
		output.append("\n4. Title of the first 3 publications:\n	");
		int i = 0;
		for (String publ:p.extractFirstThreePublications()) {
			output.append(i+1 + "-   " + publ + "\n	");
			i = i+1;
		}
		
		//5. Total paper citation 
		TotalPaperCitation tpc = new TotalPaperCitation(rawHTMLString);
		output.append("\n5. Total paper citation (first 5 papers):\n	");
		output.append(tpc.extractTotalPaperCitations());
		
		//6. Total Co-Authors
		CoAuthors ca = new CoAuthors(rawHTMLString);
		output.append("\n6. Total Co-Authors:\n	");
		output.append(ca.extractCoAuthors().size());
	

		return output.toString();

	}
	
	
}
