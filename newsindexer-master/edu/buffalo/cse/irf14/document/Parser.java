/**
 * AUTHOR : Ankit Sarraf
 * DATED  : January 22, 2015
 * ABOUT  : Class that parses a given file into a Document
 */

package edu.buffalo.cse.irf14.document;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Parser {
	/**
	 * Static method to parse the given file into the Document object
	 * @param filename : The fully qualified filename to be parsed
	 * @return The parsed and fully loaded Document object
	 * @throws ParserException In case any error occurs during parsing
	 */
	public static Document parse(String fileName) throws ParserException {
		if(fileName == null || 
				fileName.equals("")) {
			throw new ParserException();
		}

		try {
			// Open the file referred to by fileName
			BufferedReader reader = 
					new BufferedReader(new FileReader(fileName));

			// String to store Meta Data of the File. Refer FieldNames.java
			String [] metadata = new String [8];

			int tempIndex1 = fileName.lastIndexOf('/');
			metadata[0] = fileName.substring(tempIndex1 + 1);

			int tempIndex0 = fileName.lastIndexOf('/', tempIndex1 - 1);
			metadata[1] = fileName.substring(tempIndex0 + 1, tempIndex1);

			// Check the switch case to know more
			int counter = 0;

			// Pattern to check if text is about Place and Date 
			Pattern pattern = Pattern.compile(
					"[[A-Za-z.-]+, ]+[a-zA-Z]+[ ]+[0-9]{1,2}[ ]{0,1}-.*");

			// Pattern to check Place and NewsDate Format
			Pattern initialPattern = Pattern.compile(
					"[[A-Za-z.-]+, ]+[a-zA-Z]+[ ]+[0-9]{1,2}[ ]{0,1}-");


			// Boolean again to indicate initial reading of file after Author
			boolean firstEntry = true;

			// Read the file line wise
			String line;
			while((line = reader.readLine()) != null) {
				line = line.trim();

				if(line.equals("")) {
					// If it is an empty string
					continue;
				}

				// Parse the Current Line
				switch(counter) {
				case 0:
					// Title
					metadata[2] = line;
					counter++;
					break;
				case 1:
					// Author and AuthorOrg
					if(line.startsWith("<AUTHOR>")) {
						// Remove the XML Tags (http://bit.do/XMLRemover)
						line = line.replaceAll("<[^>]+>", "").trim();

						// Fetch the Author Related Data
						String [] authorData = line.split(",");

						if(authorData.length < 2) {
							if(authorData[0].startsWith("BY") ||
									authorData[0].startsWith("by") ||
									authorData[0].startsWith("By") ||
									authorData[0].startsWith("bY")) {
								metadata[3] = authorData[0].trim().substring(3);
							} else {
								metadata[4] = line.split(",")[0].trim();
							}
						} else {

							// Procure Authors from given line
							metadata[3] = line.split(",")[0].trim().substring(3);

							// Obtain the AuthorOrg from current line
							metadata[4] = line.split(",")[1].trim();
						}
						continue;
					}

					if(firstEntry) {
						if(!pattern.matcher(line).matches()) {
							throw new ParserException();
						}

						int contentStartIndex = 0;

						while(!initialPattern.matcher(
								line.subSequence(0, 
										(contentStartIndex + 1))).matches()) {
							contentStartIndex = 
									line.indexOf('-', contentStartIndex + 1);
						}

						int lastOccuranceOfComma = line.lastIndexOf(
								',', contentStartIndex);

						if(lastOccuranceOfComma == -1) {
							// Comma missing between Place and NewsDate
							String [] placeDateString = 
									line.substring(0, contentStartIndex - 1).
									trim().split("\\s+");

							// Last 2 items denote the Date
							int lenPD = placeDateString.length;
							metadata[5] = "";
							for(int i = 0 ; i < lenPD - 2 ; i++) {
								metadata[5] = metadata[5].concat(" " + placeDateString[i]).trim();
							}

							metadata[6] = placeDateString[lenPD - 2].concat(
									" " + placeDateString[lenPD - 1]);
						} else {
							metadata[5] = line.substring(0, lastOccuranceOfComma);
							metadata[6] = line.substring(lastOccuranceOfComma + 2, contentStartIndex - 1);
						}

						try {
							metadata[7] = line.substring(contentStartIndex + 2);
						} catch(StringIndexOutOfBoundsException e) {
							metadata[7] = "";
						}
					} else {
						try {
							metadata[7] = metadata[7].concat(" " + line);
						} catch(Exception e) {
							System.out.println(fileName);
							System.out.println(line);
						}
					}
					firstEntry = false;
				}
			}

			reader.close();

			Document document = new Document();
			document.setField(FieldNames.FILEID, metadata[0]);
			document.setField(FieldNames.CATEGORY, metadata[1]);
			document.setField(FieldNames.TITLE, metadata[2]);
			document.setField(FieldNames.AUTHOR, metadata[3]);
			document.setField(FieldNames.AUTHORORG, metadata[4]);
			document.setField(FieldNames.PLACE, metadata[5]);
			document.setField(FieldNames.NEWSDATE, metadata[6]);
			document.setField(FieldNames.CONTENT, metadata[7]);
			return document;
		} catch(FileNotFoundException e) {
			throw new ParserException();
		} catch (IOException e) {
			System.out.println("Error while reading the file: " + fileName);
		}
		return null;
	}
}