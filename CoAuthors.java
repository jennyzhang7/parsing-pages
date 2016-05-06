package contentExtractors;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoAuthors {
	

	private ArrayList<String> coauthors = new ArrayList<String>();
	private String rawHTMLString;
	
	/**
	 * Constructor.
	 * @param cRawHTMLString
	 * 	a String containing the HTML contents from the Google Scholar URL.
	 */
	public CoAuthors(String cRawHTMLString) {
		rawHTMLString = cRawHTMLString;
	}
	
	/**
	 * Extract the total co-authors from the given url input. 
	 * 
	 * @return
	 * 	.
	 * @throws Exception
	 */

	public ArrayList<String> extractCoAuthors() throws Exception{
		try {
			String reForAuthorExtraction = "<a class=\"cit-dark-link\" "
					+ "href=\"http://scholar.google.ca/citations\\?"
					+ "user=(.*?)&hl=en\" "
					+ "title=\"(.*?)\">(.*?)</a>";
			Pattern patternObject = Pattern.compile(reForAuthorExtraction);
			Matcher matcherObject = patternObject.matcher(rawHTMLString);

			while (matcherObject.find()) {
				coauthors.add(matcherObject.group(3));
			} 
		} catch (IllegalStateException| IndexOutOfBoundsException e) {
			throw new Exception();
		}
		return coauthors;
	}

}
