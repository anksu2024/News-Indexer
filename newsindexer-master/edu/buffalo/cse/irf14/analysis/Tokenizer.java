/**
 * AUTHOR : Ankit Sarraf
 * DATED  : February 23, 2015
 * ABOUT  : Class that converts a given string into a
 *          {@link TokenStream} instance
 */

package edu.buffalo.cse.irf14.analysis;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
	TokenStream tokenStream;
	String delimiter;

	/**
	 * Default constructor. Assumes tokens are whitespace delimited
	 */
	public Tokenizer() {
		delimiter = "\\s+";
		tokenStream = new TokenStream();
	}

	/**
	 * Overloaded constructor. Creates the tokenizer with the given delimiter
	 * @param delim : The delimiter to be used
	 */
	public Tokenizer(String delim) {
		delimiter = delim;
		tokenStream = new TokenStream();
	}

	/**
	 * Method to convert the given string into a TokenStream instance.
	 * This must only break it into tokens and initialize the stream.
	 * No other processing must be performed. Also the number of tokens
	 * would be determined by the string and the delimiter.
	 * So if the string were "hello world" with a whitespace delimited
	 * tokenizer, you would get two tokens in the stream. But for the same
	 * text used with lets say "~" as a delimiter would return just one
	 * token in the stream.
	 * @param str : The string to be consumed
	 * @return : The converted TokenStream as defined above
	 * @throws TokenizerException : In case any exception occurs during
	 * tokenization
	 */
	public TokenStream consume(String str) throws TokenizerException {
		String [] parts = str.split(delimiter);

		if(parts.length < 1) {
			return null;
		}

		List<Token> tokens = new ArrayList<Token>();
		for(String part : parts) {
			Token token = new Token();
			token.setTermText(part);

			tokens.add(token);
		}

		TokenStream tokenStream = new TokenStream();
		tokenStream.setTokens(tokens);
		return tokenStream;
	}
}