package contentExtractors;

import java.util.ArrayList;

/**
 * AllCitations is a subclass of Citations. This class gets the number of all
 * all citations from the Google Scholar URL. 
 */
public class AllCitations extends Citations {

	/**
	 * Constructor. 
	 * @param cRawHTMLString
	 */
	public AllCitations(String cRawHTMLString) {
		super(cRawHTMLString);
	}
	
	/**
	 * Get the number of all citations by the author. 
	 * @return
	 * 	a String that is the number of all citations. 
	 * @throws Exception 
	 */
	public String extractNumOfAllCitations() throws Exception {
		Citations citation = new Citations(rawHTMLString); 
		ArrayList<String> citArray = citation.extractCitationInfo();
		
		return citArray.get(0);
	}
}
