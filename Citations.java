package contentExtractors;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A superclass that extracts citation indices information. Its subclasses are
 * AllCitations and CitationsAfter2009. 
 */
public class Citations {

	protected String rawHTMLString;
	private ArrayList<String> citationsArray = new ArrayList<String>();
	
	/**
	 * Constructor.
	 * @param cRawHTMLString
	 * 	a String containing the HTML contents from the Google Scholar URL.
	 */
	public Citations(String cRawHTMLString) {
		super();
		rawHTMLString = cRawHTMLString;
	}
	
	/**
	 * Extract the citation indices information from given URL. 
	 * 
	 * @return
	 * 	an arrayList containing all the extracted citation indices information. 
	 * @throws Exception
	 */

	public ArrayList<String> extractCitationInfo() throws Exception{
		try {
			
			String reForNumOfCitations =
					"<td class=\"cit-borderleft cit-data\">(.*?)</td>";
			Pattern patternObject = Pattern.compile(reForNumOfCitations);
			Matcher matcherObject = patternObject.matcher(rawHTMLString);

			while (matcherObject.find()) {
				citationsArray.add(matcherObject.group(1));
				
			}
		} catch (IllegalStateException| IndexOutOfBoundsException e) {
			throw new Exception();
			
		}
		return citationsArray;
	}
}
