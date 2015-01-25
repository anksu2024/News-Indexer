/**
 * AUTHOR : Ankit Sarraf
 * DATED  : January 25, 2015
 * ABOUT  : Enum that defines different {@link TokenFilter} types
 */

package edu.buffalo.cse.irf14.analysis;

public enum TokenFilterType {
	SYMBOL,			// Punctuations, Apostrophes, Hyphens
	DATE,			// yyyymmdd (Dates) HH:mm:ss (Time)
	NUMERIC,		// Any number that is not a date
	CAPITALIZATION,	// Rules for Camel Cased Words and Abbreviations
	STOPWORD,		// Standard Stop word list removed
	STEMMER,		// Replace the word with the stemmer version
	ACCENT,			// Accents, Diacritics => Corresponding English Characters
	SPECIALCHARS	// Anything that is not a number or an alphabet
};