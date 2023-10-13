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
		List<String> commandHistory = new ArrayList<>(); // Create a list that stores strings 

		
		while (true) { // Infinite loop
			String command = scanner.nextLine(); // Get input from console as a string
			String output = ""; // A variable named output of type String

			
				commandHistory.add(command); // With each order we store in the list
			
			if (command.equals("exit")) {
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
				output = userName.toString();
			}

			else if (command.equals("userhome")) {

				String userHomeDirectory = System.getProperty("user.home");
				output = userHomeDirectory.toString();
			}

			else if (command.equals("os")) {

				String osName = System.getProperty("os.name"); // return operating system name
				String osVersion = System.getProperty("os.version"); // return operating system version
				output = osName.toString() + " (" + osVersion.toString() + ") ";
			
			}
			
			else if (command.equals("printenv")){

				System.out.print("Please enter the name of the environment variable: ");
				String variableToLookFor = scanner.nextLine(); // Thanks to the scanner, the name of the input variable can be retrieved
				
				Map<String, String> variablesEnv = System.getenv();  //System.getenv() returns a map that associates environment variable names (strings) with their corresponding values (also strings).
		
				if (variablesEnv.containsKey(variableToLookFor)) { //containsKey to check if the key (variable name) entered by the user exists in the Map (Map is key value collection )
					String value = variablesEnv.get(variableToLookFor);
					output = "The name of the environment variable " + variableToLookFor.toString() + " is : " + value.toString();
				} else {
					output = "The environment variable " + variableToLookFor.toString() + " was not found.";
				}
			}

			else if (command.startsWith("echo")){
				
				for (String historyCommand : commandHistory) {
					System.out.println(historyCommand);

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