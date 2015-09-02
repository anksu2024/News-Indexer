/**
 * AUTHOR : Ankit Sarraf
 * DATED  : February 25, 2015
 * ABOUT  : Special Character Rule
 */

package edu.buffalo.cse.irf14.analysis.rules;

import edu.buffalo.cse.irf14.analysis.TokenFilter;
import edu.buffalo.cse.irf14.analysis.TokenStream;
import edu.buffalo.cse.irf14.analysis.TokenizerException;

public class SpecialCharRule extends TokenFilter {
	public SpecialCharRule(TokenStream tokenStream) {
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
		return tokenStream;
	}
}