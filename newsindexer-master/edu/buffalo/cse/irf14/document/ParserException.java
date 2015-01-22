/**
 * AUTHOR : ANKIT SARRAF
 * DATED  : January 21, 2014
 * ABOUT  : Generic wrapper exception class for parsing exceptions
 */

package edu.buffalo.cse.irf14.document;

public class ParserException extends Exception {
	private static final long serialVersionUID = 4691717901217832517L;
	
	public String getMessage() {
		return "Some Parser Exception";
	}
}