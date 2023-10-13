import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;


public class Cli {

    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // Listen to the standard input (console)
		System.out.print("> "); // Prompt
		while (true) { // Infinite loop
			String command = scanner.nextLine(); // Get input from console as a string
			String output = ""; // A variable named output of type String
			if (command.equals("exit")) {
				break; // Forces exit of the while loop
			}
			if (command.equals("date")) {
				LocalDate myObj = LocalDate.now(); // Create a date object
				System.out.println(myObj); // Display the current date
			}
			if (command.equals("time")) {
				LocalTime myObj = LocalTime.now(); // Create a time object
				System.out.println(myObj); // Display the current time
			}
			if (command.equals("datetime")) {
				LocalDateTime myObj = LocalDateTime.now(); // Create a date time object
				System.out.println(myObj); // Display the current date time
			}

			if (command.equals("useraccount")) {

			 	
				String userName = System.getProperty("user.name"); // getProperty use different arguments
				System.out.println(userName);
			}

			if (command.equals("userhome")) {

				String userHomeDirectory = System.getProperty("user.home");
				System.out.println(userHomeDirectory);
			}

			if (command.equals("os")) {

				String osName = System.getProperty("os.name"); // return operating system name
				String osVersion = System.getProperty("os.version"); // return operating system version
				System.out.println(osName + " (" + osVersion + ") ");
			
			}
			
			if (command.equals("printenv")){

				System.out.print("Please enter the name of the environment variable: ");
				String variableToLookFor = scanner.nextLine(); // Thanks to the scanner, the name of the input variable can be retrieved
				
				Map<String, String> variablesEnv = System.getenv();  //System.getenv() returns a map that associates environment variable names (strings) with their corresponding values (also strings).
		
				if (variablesEnv.containsKey(variableToLookFor)) { //containsKey to check if the key (variable name) entered by the user exists in the Map (Map is key value collection )
					String value = variablesEnv.get(variableToLookFor);
					System.out.println("The name of the environment variable " + variableToLookFor + " is : " + value);
				} else {
					System.out.println("The environment variable " + variableToLookFor + " was not found.");
				}
			}

			if (command.equals("echo")){
				
				System.out.print("Please enter your text :");
				String userText = scanner.nextLine();

				System.out.println(userText);
        
				
		
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