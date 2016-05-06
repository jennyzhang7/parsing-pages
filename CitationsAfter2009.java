package contentExtractors;

import java.util.ArrayList;

/**
 * Returns the number of i10-index citations after 2009. 
 */
public class CitationsAfter2009 extends Citations {

	/**
	 * Constructor. 
	 * @param cRawHTMLString
	 */
	public CitationsAfter2009(String cRawHTMLString) {
		super(cRawHTMLString);
	}
	
	/**
	 * Get the number of all i10-index citations after 2009. 
	 * @return
	 * 	a String containing number of citations. 
	 * @throws Exception
	 */
	public String extractCitationsAfter2009() throws Exception {
		Citations citation = new Citations(rawHTMLString); 
		ArrayList<String> citArray = citation.extractCitationInfo();
		
		return citArray.get(5);
	}
}
