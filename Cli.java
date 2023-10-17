import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;



public class Cli {

    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // Listen to the standard input (console)
		System.out.print("> "); // Prompt

		
		while (true) { // Infinite loop
			
			String command = scanner.nextLine(); // Get input from console as a string
			String[] commandArgs = command.split(" ",2); // This code split string in two parts depending on the separator
			
			String output = ""; // A variable named output of type String
			
			if (command.equals("exit") || command.equals("logout")) {
				break; // Forces exit of the while loop
			}

						
			else if (command.equals("date")) {
				LocalDate myObj = LocalDate.now(); // Create a date object
				output = myObj.toString(); // Display the current date
			}
			else if (command.equals("time")) {
				LocalTime myObj = LocalTime.now(); // Create a time object
				output = myObj.toString(); // Display the current time
			}
			else if (command.equals("datetime")) {
				LocalDateTime myObj = LocalDateTime.now(); // Create a date time object
				output = myObj.toString();// Display the current date time
			}

			else if (command.equals("useraccount")) {

			 	
				String userName = System.getProperty("user.name"); // getProperty use different arguments
				output = userName;
			}

			else if (command.equals("userhome")) {

				String userHomeDirectory = System.getProperty("user.home");
				output = userHomeDirectory;
			}

			else if (command.equals("os")) {

				String osName = System.getProperty("os.name"); // return operating system name
				String osVersion = System.getProperty("os.version"); // return operating system version
				output = osName + " ("  + osVersion + ") ";
			
			}
			
			else if (commandArgs[0].equals("printenv")) {

				
				
				if (commandArgs.length > 1){
					String variableToLookFor = System.getenv(commandArgs[1]);
					if(variableToLookFor==null){
					output = "avec arguments";
					}else{
						output = variableToLookFor;
					}
				}else{
					
					Map<String, String> variablesEnv = System.getenv();
					output = variablesEnv.toString().replace(';', '\n' );
				}

			}


			else if (commandArgs[0].equals("echo") || commandArgs[0].equals("print") ){
				
                //If the array is equal to 1, it means that only the Echo command has been entered
                    for (int i = 1; i < commandArgs.length; i++) { //We start at i = 1 to ignore "echo" and we loop on all the elements of the array
                        output += commandArgs[i] + " "; //Between each element there is a space
                    }
                
				
		
			} else {
				// String concatenation
				output = "Command '" + command + "' not found.";
			}
			System.out.println(output); // Print with new line (ln)
			System.out.print("> "); // Prompt
		}
		scanner.close(); // Best practice, always close a stream when no more needed
		System.out.println("Bye!");
    }

}