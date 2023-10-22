import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;
import java.io.File;




public class Cli {

    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // Listen to the standard input (console)
		System.out.print("> "); // Prompt
		
		while (true) { // Infinite loop

			String command = scanner.nextLine(); // Get input from console as a string

			
			CommandLine commande = new CommandLine(command);
			String commandName = commande.getCommandName();
			String argument = commande.getArguments();

			String jump =  System.getProperty("line.separator" ); // Create global variable for jump line
			String output = ""; // A variable named output of type String
			

			if (commandName.equals("exit") || commandName.equals("logout")) {
				break; // Forces exit of the while loop
			}

						
			else if (commandName.equals("date")) {
				LocalDate myObj = LocalDate.now(); // Create a date object
				output = myObj.toString(); // Display the current date
			}
			
			else if (commandName.equals("time")) {
				LocalTime myObj = LocalTime.now(); // Create a time object
				output = myObj.toString(); // Display the current time
			}
			else if (commandName.equals("datetime")) {
				LocalDateTime myObj = LocalDateTime.now(); // Create a date time object
				output = myObj.toString();// Display the current date time
			}

			else if (commandName.equals("useraccount")) {

			 	
				String userName = System.getProperty("user.name"); // getProperty use different arguments
				output = userName;
			}

			else if (commandName.equals("userhome")) {

				String userHomeDirectory = System.getProperty("user.home");
				output = userHomeDirectory;
			}

			else if (commandName.equals("os")) {

				String osName = System.getProperty("os.name"); // return operating system name
				String osVersion = System.getProperty("os.version"); // return operating system version
				output = osName + " ("  + osVersion + ") ";
			
			}
			
			else if (commandName.equals("printenv")) {

				
				if (commande.hasArgument()){
					String variableToLookFor = System.getenv(argument);
					output = variableToLookFor==null? "" : variableToLookFor;
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

					output = stringEditable.toString();
				}

			}


			else if (commandName.equals("echo") || commandName.equals("print") ){
				String[] commandArgs = command.split(" ");
				StringBuilder stringEditable = new StringBuilder(); // StringBuilders are like String objects, except that they can be modified.
				

                //If the array is equal to 1, it means that only the Echo command has been entered
                    for (int i = 1; i < commandArgs.length; i++) { //We start at i = 1 to ignore "echo" and we loop on all the elements of the array
						stringEditable.append(argument).append(" "); //append is as a concatenation
                    }
					output = stringEditable.toString(); // Allows you to turn the response into a string
			
			}		
			
			else if (commandName.equals("ls")) {

				

				if(commande.hasArgument()) {

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
								output = stringEditable.toString();

							}
					} else {
						output = "Not a directory";
					}
				} else {
					output = "Not a directory";
				}
			
		
			} else {
				// String concatenation
				output = "Command " + command + " not found.";
			}
			System.out.println(output); // Print with new line (ln)
			System.out.print("> "); // Prompt
		}
		scanner.close(); // Best practice, always close a stream when no more needed
		System.out.println("Bye!");
    }

}