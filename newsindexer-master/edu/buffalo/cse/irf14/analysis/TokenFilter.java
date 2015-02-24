/**
 * AUTHOR : Ankit Sarraf
 * DATED  : January 25, 2015
 * ABOUT  : The abstract class that you must extend when implementing your 
 *          TokenFilter rule implementations.
 *          Apart from the inherited Analyzer methods, we would use the 
 *          inherited constructor (as defined here) to test your code.
 */

package edu.buffalo.cse.irf14.analysis;

public abstract class TokenFilter implements Analyzer {
	protected TokenStream tokenStream;

	/**
	 * Default constructor, creates an instance over the given
	 * TokenStream
	 * @param stream : The given TokenStream instance
	 */

	public TokenFilter(TokenStream tokenStream) {
		this.tokenStream = tokenStream;
	}
}