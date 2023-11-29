// General object to manipulate files (read, write, create)
// Author: Victor Pottier
// Note: some methods are not used in the project

package epicTest;

import java.io.BufferedWriter; 
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;


/**
 * General file management tool able to perform basic opertations on files such as reading and writing.
 * Also allows to create files or getting all the files from a specified directory.
 */
public class FileManager {
	
	/**
	 * Creates an empty file at the specified path. Possibility to specify the file extension as the second parameter if necessary.
	 * @param filepath i.e. the path of the new file to be created
	 * @param fileExtension i.e. the extension of the newly created file
	 */
	public static void createFile(String filepath) {//creates account file
		// Creates a new file at the specified path if file doesn't already exist.
		// TODO: automatically create directories if they do not exist.
		try {
			File file = new File(filepath);
			
			if (!file.createNewFile()) {

				System.out.println(filepath + " already exists!");
			}
		}
		
		catch (IOException e) {
			System.out.println("Error: file couldn't be created");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Returns a list of files contained in the specified directory represented as a File[] array
	 * @param directoryPath i.e. the path of the directory to be listed
	 * @return All the files (represented as File objects) which are in the specified folder
	 */
	public static File[] lsDirectory(String directoryPath) {//finds location of account file
		File directory = new File(directoryPath);
		if (directory.exists() && directory.isDirectory()) {
			return directory.listFiles();
		}
		
		else {
			System.out.println("Error: " + directoryPath + " is not an existing directory.");
			System.out.println("lsDirectory(" + directoryPath + ") will therefore return an empty array.");
			return null;
		}
	}

	/**
	 * Clears the 4 last characters of a string so that the .txt extension disappears.
	 * Example: clearTxtExtension("hello.txt") -> "hello"
	 * @param originalFilename i.e. the file name with .txt extension at the end
	 * @return The file name without the .txt extension
	 */
	public static String clearFileExtension(String originalFilename, int extensionLength) {//clears txt extensions
		if (originalFilename.length() <= extensionLength) {
			return originalFilename;
		}
		
		String formattedName = "";

		for (int i =0; i < originalFilename.length() - 1 - extensionLength; i++) {
			formattedName += originalFilename.charAt(i);
		}
		return formattedName;
	}
	
	
	
	/**
	 * Writes the specified string in the specified file. WARNING: writing in a non-empty file deletes all its previous content!!!
	 * To append the new content at the end of the file without deleting its previous content, set parameter shouldAppend to true.
	 * @param filepath i.e. path of the file to be written
	 * @param content i.e. what should be written in the file
	 * @param shouldAppend i.e. setting append mode on or not.
	 */
	public static void writeFile(String filepath, String content) {//writes account info, updates score//removes previous content
		// Writes the specified string in the file
		// WARNING: writing in a non-empty file deletes all its previous content!!!
		try {
			FileWriter writer = new FileWriter(filepath);
			writer.write(content);
			writer.close();
		}
		
		catch (IOException e) {
			System.out.println("Error: couldn't write on file");
			e.printStackTrace();
		}
	}
	
	/**
	 * Writes the specified string in the specified file. WARNING: writing in a non-empty file deletes all its previous content!!!
	 * To append the new content at the end of the file without deleting its previous content, set parameter shouldAppend to true.
	 * @param filepath i.e. path of the file to be written
	 * @param content i.e. what should be written in the file
	 * @param shouldAppend i.e. setting append mode on or not.
	 */
	public static void writeFile(String filepath, String content, boolean shouldAppend) {//adds at the end
		// Adds an option to add the content at the end of the file without having to delete all the previous file content.
		try {
			File openedFile = new File(filepath);
			if (shouldAppend) {
				FileWriter writer = new FileWriter(openedFile, true);
				BufferedWriter adaptedWriter = new BufferedWriter(writer);
				adaptedWriter.write(content);
				adaptedWriter.close();
			}
			else {
				FileWriter writer = new FileWriter(openedFile, false);
				writer.write(content);
				writer.close();
			}
		}
		
		catch (IOException e) {
			System.out.println("Error: couldn't write on file");
			e.printStackTrace();
		}
	}
	
}