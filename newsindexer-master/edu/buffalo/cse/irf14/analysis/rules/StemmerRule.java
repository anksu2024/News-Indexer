/**
 * AUTHOR : Ankit Sarraf
 * DATED  : February 25, 2015
 * ABOUT  : Stemmer
 */

package edu.buffalo.cse.irf14.analysis.rules;

import edu.buffalo.cse.irf14.analysis.TokenFilter;
import edu.buffalo.cse.irf14.analysis.TokenStream;
import edu.buffalo.cse.irf14.analysis.TokenizerException;

public class StemmerRule extends TokenFilter {
	public StemmerRule(TokenStream tokenStream) {
		super(tokenStream);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean increment() throws TokenizerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TokenStream getStream() {
		// TODO Auto-generated method stub
		return null;
	}
}