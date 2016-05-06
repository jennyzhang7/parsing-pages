package contentExtractors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TotalPaperCitation {
	
	private String rawHTMLString;
	
	/**
	 * Constructor.
	 * @param cRawHTMLString
	 * 	a String containing the HTML contents from the Google Scholar URL.
	 */
	public TotalPaperCitation(String cRawHTMLString) {
		rawHTMLString = cRawHTMLString;
	}
	
	/**
	 * Extract the number of paper citations. 
	 * 
	 * @return
	 * 	an int that is the number of paper citations. 
	 * @throws Exception
	 */

	public int extractTotalPaperCitations() throws Exception{
		int totalCitations = 0;
		try {
			String reForPaperExtraction = 
					
					"<a class=\"cit-dark-link\" "
					+ "href=\"http://scholar.google.ca/scholar\\?oi=bibs&"
					+ "hl=en&cites=([0-9]+)\">(.*?)</a>";
			Pattern patternObject = Pattern.compile(reForPaperExtraction);
			Matcher matcherObject = patternObject.matcher(rawHTMLString);

			int i = 0;
			while (matcherObject.find() && i<5) {
				totalCitations = totalCitations + 
						Integer.valueOf(matcherObject.group(2));
				i++;
			} 
		} catch (IllegalStateException| IndexOutOfBoundsException e) {
			throw new Exception();
		}
		return totalCitations;
	}

}
