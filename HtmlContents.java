package contentExtractors;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Class to get the HTML contents from the Google Scholar URL. 
 */
public class HtmlContents {
	String urlString;
	
	/**
	 * Constructor.
	 * @param urlStringC
	 * 	the URL of the Google Scholar website. 
	 */
	public HtmlContents(String urlStringC) {
		urlString = urlStringC;
	}
	
	
	/**
	 * Get the HTML code. 
	 * @return
	 * 	a String of HTML code.  
	 * @throws Exception
	 */

	public String getHTML() throws Exception {
		// create object to store html source text as it is being collected
		StringBuilder html = new StringBuilder();
		// open connection to given url
		URL url = new File(urlString).toURI().toURL();
		// create BufferedReader to buffer the given url's HTML source
		BufferedReader htmlbr =
				new BufferedReader(new InputStreamReader(url.openStream()));
		String line;
		// read each line of HTML code and store in StringBuilder
		while ((line = htmlbr.readLine()) != null) {
			html.append(line);
		}
		htmlbr.close();
		// convert StringBuilder into a String 
		String stringHtml = html.toString();
		
		// preprocess the string to replace all special chars
		stringHtml.replaceAll("&#39", "'");
		stringHtml.replaceAll("&#8208", "-");
		stringHtml.replaceAll("&#38", "&");
		
		return stringHtml;
	}

}
