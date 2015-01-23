/**
 * AUTHOR : Ankit Sarraf
 * DATED  : January 22, 2015
 * ABOUT  : This is an enumeration that defines the different field names
 */
package edu.buffalo.cse.irf14.document;

public enum FieldNames {
	FILEID,			// Unique identifier of document (Filename)
	CATEGORY,		// Category to which document belongs (Sub Directory Name)
	TITLE,			// Title of Document (Usually the first line Capitalized)
	AUTHOR,			// Author of Document (Optional present in <AUTHOR> tag)
	AUTHORORG,		// Author's organization (Also contained in <AUTHOR> tag)
	PLACE,			// Present as first word in news text (Just after <AUTHOR>)
	NEWSDATE,		// Date on which news was reported (Formatted as MMMMM dd)
	CONTENT			// Actual News content (Rest of article without metadata)
};