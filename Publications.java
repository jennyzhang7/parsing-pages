package contentExtractors;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Publications {
	
	String rawHTMLString; 
	
	ArrayList<String> publicationArray = new ArrayList<String>();
	
	/**
	 * Constructor.
	 * @param cRawHTMLString
	 * 	a String containing the HTML contents from the Google Scholar URL.
	 */
	public Publications(String cRawHTMLString) {
		rawHTMLString = cRawHTMLString;
	}
	
	/**
	 * Extract the first three publications by the author.
	 * 
	 * @return
	 * 	an ArrayList that contains the name of the first three publications. 
	 * @throws Exception
	 */

	public ArrayList<String> extractFirstThreePublications() throws Exception {
		try {
			String reForExtraction = 
					"scholar.google.ca/citations\\?view_op=view_citation&"
					+ "hl=en&user=(.*?)&citation_for_view=(.*?):"
					+ "(.*?)\" class=\"cit-dark-large-link\">(.*?)</a>";
			Pattern patternObject = Pattern.compile(reForExtraction);
			Matcher matcherObject = patternObject.matcher(rawHTMLString);

			int i = 0;
			while (matcherObject.find() && i<3) {
				publicationArray.add(matcherObject.group(4));
				i++;
			} 
			
		} catch (IllegalStateException| IndexOutOfBoundsException e) {
			throw new Exception();
		}
		return publicationArray;
	}
}
