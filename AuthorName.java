package contentExtractors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class to extract the author's name from Google Scholar URL. 
 */

public class AuthorName {

	private String authorName = "";
	private String rawHTMLString;
	
	/**
	 * Constructor.
	 * @param cRawHTMLString
	 * 	a String containing the HTML contents from the Google Scholar URL.
	 */
	public AuthorName(String cRawHTMLString) {
		rawHTMLString = cRawHTMLString;
	}
	
	/**
	 * Extract the authors name from the given url input. 
	 * 
	 * @return
	 * 	a String that is the name of the author.
	 * @throws Exception
	 */

	public String extractAuthorsName() throws Exception{
		try {
			String reForAuthorExtraction =
					"<span id=\"cit-name-display\" "
							+ "class=\"cit-in-place-nohover\">(.*?)</span>";
			Pattern patternObject = Pattern.compile(reForAuthorExtraction);
			Matcher matcherObject = patternObject.matcher(rawHTMLString);

			while (matcherObject.find()) {
				authorName = authorName + matcherObject.group(1);
			}
		} catch (IllegalStateException| IndexOutOfBoundsException e) {
			throw new Exception();
		}
		return authorName;
	}
}
