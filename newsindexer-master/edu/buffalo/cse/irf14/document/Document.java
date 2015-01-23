/**
 * AUTHOR : Ankit Sarraf
 * DATED  : January 22, 2015
 * ABOUT  : Wrapper class that holds {@link FieldNames} to value mapping
 */
package edu.buffalo.cse.irf14.document;

import java.util.HashMap;

public class Document {
	// TODO: Check this again for understanding the usage
	// Document is implemented in form of a HashMap
	// KEY: ?? & VALUE: ??
	private HashMap<FieldNames, String[]> map;
	
	// Default constructor
	public Document() {
		map = new HashMap<FieldNames, String[]>();
	}
	
	/**
	 * Method to set the field value for the given {@link FieldNames} field
	 * @param fn : The {@link FieldNames} to be set
	 * @param o : The value to be set to
	 */
	public void setField(FieldNames fieldNames, String ... o) {
		map.put(fieldNames, o);
	}
	
	/**
	 * Method to get the field value for a given {@link FieldNames} field
	 * @param fn : The field name to query
	 * @return The associated value, null if not found
	 */
	public String[] getField(FieldNames fieldNames) {
		return map.get(fieldNames);
	}
}