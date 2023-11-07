// les méthodes disponibles de Java

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
// import java.io.BufferedReader;
import java.io.File;
// import java.io.FileReader;
// import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Commands {


	String jump = System.getProperty("line.separator"); // Create global variable for jump line

// create method of class Commands
	public static String date(CommandLine command) {
			LocalDate myObj = LocalDate.now(); // Create a date object
			return myObj.toString(); // Display the current date
	}

	public static String time(CommandLine command) {
	
			LocalTime myObj = LocalTime.now(); // Create a time object
			return myObj.toString();
	}

	public static String datetime(CommandLine command) {
			LocalDateTime myObj = LocalDateTime.now(); // Create a date time object
			return myObj.toString();// Display the current date time
		}

	public static String useraccount(CommandLine command) {
		String userName = System.getProperty("user.name"); // getProperty use different arguments
		return userName;
	}

	public static String userhome(CommandLine command) {
		String userHomeDirectory = System.getProperty("user.home");
		return userHomeDirectory;
	}

	public static String os(CommandLine command) {
		String osName = System.getProperty("os.name"); // return operating system name
		String osVersion = System.getProperty("os.version"); // return operating system version
		return osName + " (" + osVersion + ") ";

	}

	public static String printenv(CommandLine command) {
		String argument = command.getArguments();
		if (command.hasArgument()) {
			String variableToLookFor = System.getenv(argument);
			return variableToLookFor == null ? "" : variableToLookFor;
			// if(variableToLookFor==null){
			// output = "";
			// }else{
			// output = variableToLookFor;
			// }
		} else {

			Map<String, String> variablesEnv = System.getenv();
			StringBuilder stringEditable = new StringBuilder();

			for (String envName : variablesEnv.keySet()) {
				String jump = System.getProperty("line.separator"); 
				stringEditable.append(envName).append("=").append(variablesEnv.get(envName)).append(jump);
			}

			return stringEditable.toString();
		}

	}

	public static String echo(CommandLine command){
		String jump = System.getProperty("line.separator");
		if (command.hasArgument()) {
			String[] arguments = command.getArguments().split(" "); // Divise les arguments par espace
			StringBuilder stringEditable = new StringBuilder();

			for (String arg : arguments) {
				stringEditable.append(arg).append(" ");
			}

			return stringEditable.toString();
		}
		return jump;

	}

	public static String ls(CommandLine command){
		String argument = command.getArguments();
		if (command.hasArgument()) {

			String directoryPath = argument; // commandArgs[1] is argument (the directory path)
			File directory = new File(directoryPath); // Use package File and create a File objet using the
														// directory path

			if (directory.exists() && directory.isDirectory()) { // verification of the existence and if the
																	// directory path is directory
				File[] filesAndDirectories = directory.listFiles(); // Create array for store File list
				StringBuilder stringEditable = new StringBuilder();
				if (filesAndDirectories != null) { // if files and directories is different null

					for (File fileOrDir : filesAndDirectories) { // for each files and directories get name files
																	// and directories and jump

						String listFilesAndDirectories = fileOrDir.getName();

						stringEditable.append(listFilesAndDirectories).append(System.getProperty("line.separator")); // append is as a concatenation

						// output += listFilesAndDirectories + jump; //Between each element there is a
						// break
					}
					return stringEditable.toString();

				}
			} else {
				return "Not a directory";
			}
		} else {
			return "Not a directory";
		}
		return argument;
	}
		
	public static String cat(CommandLine command){
		String argument = command.getArguments();
		if (argument == null) {
			return "Please specify a path to a text file to read";
		}

		try {
			StringBuilder output = new StringBuilder();
			
			int lineNumber = 1;
		 	Path path = Paths.get(argument);
      		List<String> contentLists = Files.readAllLines(path);

			for (String contentList : contentLists) { 

				String jump = System.getProperty("line.separator"); 

				output.append(lineNumber++).append(". ").append(contentList).append(jump); // append is as a concatenation

			}
			return output.toString();

		//  (BufferedReader reader = new BufferedReader(new FileReader(argument))) {
				// Read the file content and add line numbers
			 
			// StringBuilder output = new StringBuilder();
			// String line;
			// int lineNumber = 1;

			// while ((line = reader.readLine()) != null) {
			// 	String jump = System.getProperty("line.separator"); 
			// 	output.append(lineNumber).append(". ").append(line).append(jump);
			// 	lineNumber++;
			// }

			// return output.toString();

		} catch (Exception e) {
			return "Error reading file";
		}
		

	}
 }
