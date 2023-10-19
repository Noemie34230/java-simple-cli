import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.io.File;


public class Cli {

    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // Listen to the standard input (console)
		System.out.print("> "); // Prompt

		
		while (true) { // Infinite loop
			
			String command = scanner.nextLine(); // Get input from console as a string
			String[] commandArgs = command.split(" ",2); // This code split string in two parts depending on the separator
			// commandArgs[0] is command and commandArgs[1] is argument
			String jump =  System.getProperty("line.separator" ); // Create global variable for jump line
			String output = ""; // A variable named output of type String
			

			if (commandArgs[0].equals("exit") || commandArgs[0].equals("logout")) {
				break; // Forces exit of the while loop
			}

						
			else if (commandArgs[0].equals("date")) {
				LocalDate myObj = LocalDate.now(); // Create a date object
				output = myObj.toString(); // Display the current date
			}
			else if (command.equals("time")) {
				LocalTime myObj = LocalTime.now(); // Create a time object
				output = myObj.toString(); // Display the current time
			}
			else if (commandArgs[0].equals("datetime")) {
				LocalDateTime myObj = LocalDateTime.now(); // Create a date time object
				output = myObj.toString();// Display the current date time
			}

			else if (commandArgs[0].equals("useraccount")) {

			 	
				String userName = System.getProperty("user.name"); // getProperty use different arguments
				output = userName;
			}

			else if (commandArgs[0].equals("userhome")) {

				String userHomeDirectory = System.getProperty("user.home");
				output = userHomeDirectory;
			}

			else if (commandArgs[0].equals("os")) {

				String osName = System.getProperty("os.name"); // return operating system name
				String osVersion = System.getProperty("os.version"); // return operating system version
				output = osName + " ("  + osVersion + ") ";
			
			}
			
			else if (commandArgs[0].equals("printenv")) {

				
				
				if (commandArgs.length > 1){
					String variableToLookFor = System.getenv(commandArgs[1]);
					if(variableToLookFor==null){
						output = "";
					}else{
						output = variableToLookFor;
					}
				}else{
					
					Map<String, String> variablesEnv = System.getenv();
					

					for (String envName : variablesEnv.keySet()) { 
						
						output += envName + " = " + variablesEnv.get(envName) + "\n"; 
						
					} 
				}

			}


			else if (commandArgs[0].equals("echo") || commandArgs[0].equals("print") ){
				
                //If the array is equal to 1, it means that only the Echo command has been entered
                    for (int i = 1; i < commandArgs.length; i++) { //We start at i = 1 to ignore "echo" and we loop on all the elements of the array
                        output += commandArgs[i] + " "; //Between each element there is a space
                    }
                
			
			}		
			
			else if (commandArgs[0].equals("ls")) {

				if(commandArgs.length > 1) {

					String directoryPath = commandArgs[1]; // commandArgs[1] is argument (the directory path)

					File directory = new File(directoryPath); //Use package File and create a File objet using the directory path
					
					if (directory.exists() && directory.isDirectory()) { // verification of the existence and if the directory path is directory
							File[] filesAndDirectories = directory.listFiles(); // Create array for store File list

							if (filesAndDirectories != null) { // if files and directories is different null
								for (File fileOrDir : filesAndDirectories) { //for each files and directories get name files and directories and jump
									
									String listFilesAndDirectories = fileOrDir.getName();
									
									String[] arrayListFilesDirectories = listFilesAndDirectories.split(" ");


									for (int i = 0; i < arrayListFilesDirectories.length; i++) {
										output += arrayListFilesDirectories[i] + jump; //Between each element there is a break
									}
											
									
									
								}
							}
						} else {
							output = "Not a directory";
						}
				} else {
					output = "Not a directory";
				}
			
		
			} else {
				// String concatenation
				output = "Command '" + commandArgs[0] + "' not found.";
			}
			System.out.println(output); // Print with new line (ln)
			System.out.print("> "); // Prompt
		}
		scanner.close(); // Best practice, always close a stream when no more needed
		System.out.println("Bye!");
    }

}