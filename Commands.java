import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Commands {
    

    public static String executeCommand(CommandLine command) {
        String commandName = command.getCommandName();
        String argument = command.getArguments();
        
        String jump =  System.getProperty("line.separator" ); // Create global variable for jump line


						
			if (commandName.equals("date")) {
				LocalDate myObj = LocalDate.now(); // Create a date object
				return myObj.toString(); // Display the current date
			}
			
			else if (commandName.equals("time")) {
				LocalTime myObj = LocalTime.now(); // Create a time object
				return myObj.toString(); // Display the current time
			}
			else if (commandName.equals("datetime")) {
				LocalDateTime myObj = LocalDateTime.now(); // Create a date time object
				return myObj.toString();// Display the current date time
			}

			else if (commandName.equals("useraccount")) {

			 	
				String userName = System.getProperty("user.name"); // getProperty use different arguments
				return userName;
			}

			else if (commandName.equals("userhome")) {

				String userHomeDirectory = System.getProperty("user.home");
				return userHomeDirectory;
			}

			else if (commandName.equals("os")) {

				String osName = System.getProperty("os.name"); // return operating system name
				String osVersion = System.getProperty("os.version"); // return operating system version
				return osName + " ("  + osVersion + ") ";
			
			}
			
			else if (commandName.equals("printenv")) {

				
				if (command.hasArgument()){
					String variableToLookFor = System.getenv(argument);
					return variableToLookFor==null? "" : variableToLookFor;
					// if(variableToLookFor==null){ 
					// 	output = "";
					// }else{
					// 	output = variableToLookFor;
					// }
				}else{
					
					Map<String, String> variablesEnv = System.getenv();
					StringBuilder stringEditable = new StringBuilder();

					for (String envName : variablesEnv.keySet()) { 
						
						stringEditable.append(envName).append("=").append(variablesEnv.get(envName)).append(jump);
					}

					return stringEditable.toString();
				}

			}


			else if (commandName.equals("echo") || commandName.equals("print") ){

                if (command.hasArgument()) {
                    String[] arguments = command.getArguments().split(" "); // Divise les arguments par espace
                    StringBuilder stringEditable = new StringBuilder();
            
                    for (String arg : arguments) {
                        stringEditable.append(arg).append(" ");
                    }
                   

                    return stringEditable.toString();
                } 
				
			
			}		
			
			else if (commandName.equals("ls")) {


                    if(command.hasArgument()) {

                    String directoryPath = argument; // commandArgs[1] is argument (the directory path)
                    File directory = new File(directoryPath); //Use package File and create a File objet using the directory path



                        if (directory.exists() && directory.isDirectory()) { // verification of the existence and if the directory path is directory
                            File[] filesAndDirectories = directory.listFiles(); // Create array for store File list
                                StringBuilder stringEditable = new StringBuilder();
                                if (filesAndDirectories != null) { // if files and directories is different null
                                    
                                    for (File fileOrDir : filesAndDirectories) { //for each files and directories get name files and directories and jump
                                        
                                        String listFilesAndDirectories = fileOrDir.getName();
    
                                        stringEditable.append(listFilesAndDirectories).append(jump); //append is as a concatenation
                                        
                
                                        // output += listFilesAndDirectories + jump; //Between each element there is a break
                                    }
                                    return stringEditable.toString();
    
                                }
                        } else {
                            return "Not a directory";
                        }
                    } else {
                        return "Not a directory";
                    }
		}	
		else if (commandName.equals("cat")) {
			           if (argument == null) {
                return "Please specify a path to a text file to read";
            }

            try {
                try (// Read the file content and add line numbers
				BufferedReader reader = new BufferedReader(new FileReader(argument))) {
					StringBuilder output = new StringBuilder();
					String line;
					int lineNumber = 1;

					while ((line = reader.readLine()) != null) {
					    output.append(lineNumber).append(". ").append(line).append(jump);
					    lineNumber++;
					}

					return output.toString();
				}
            } catch (IOException e) {
                return "Error reading file";
            }
			
			
				} else {
				// String concatenation
				return "Command " + commandName + " not found.";
			}
        return "";
        
    }
}

