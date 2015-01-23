/**
 * AUTHOR : Ankit Sarraf
 * DATED  : January 21, 2015
 * ABOUT  : Runner class. The real execution of the project
 */

package edu.buffalo.cse.irf14;

import java.io.File;

import edu.buffalo.cse.irf14.document.Document;
import edu.buffalo.cse.irf14.document.Parser;
import edu.buffalo.cse.irf14.document.ParserException;
import edu.buffalo.cse.irf14.index.IndexWriter;
import edu.buffalo.cse.irf14.index.IndexerException;

public class Runner {
	public Runner() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// The argument 1 indicates the Path of news dump
		String inputDir = args[0];

		// The argument 2 indicates the Path of the indexed files
		String indexDir = args[1];

		//more? idk! => PART OF STARTER CODE. DON'T KNOW WHAT IT REPRESENTS.

		// Reach the path on the news dump
		File inputDirectory = new File(inputDir);

		// Get list of all the directories (Categories) in input new dump path
		String [] catDirectories = inputDirectory.list();

		// This would store the path of each list of files in categories
		String [] files;

		// Will fetch each category directory
		File dir;

		// Some initial Declarations to be understood later
		Document d = null;
		IndexWriter writer = new IndexWriter(indexDir);

		try {
			// Iterate over each categories Directories)
			for (String cat : catDirectories) {
				// File.separator provides value dependant of the OS
				// For UNIX/ MAC it is '/'
				// For Windows it is '\\'
				dir = new File(inputDir + File.separator + cat);

				// List of files in current catergory directory
				files = dir.list();

				if (files == null) {
					// If the directory has no files move on to next category
					continue;
				}

				// Iterate for each file in the Category directory 
				for (String file : files) {
					try {
						// Parsing Starts
						d = Parser.parse(
								dir.getAbsolutePath() + File.separator + file);
						
						// TODO: We'll come to this later
						System.exit(0);
						writer.addDocument(d);
					} catch (ParserException pe) {
						System.out.println(pe.getMessage());
					}
				}
			}

			writer.close();
		} catch (IndexerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}