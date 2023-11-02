import java.util.Scanner;

public class Cli {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");

        while (true) {
            String command = scanner.nextLine();
            CommandLine commande = new CommandLine(command);

            if (commande.getCommandName().equals("exit") || commande.getCommandName().equals("logout")) {
               
                break; // Forces exit of the while loop
            }

            String output = Commands.executeCommand(commande);
            System.out.println(output);

            System.out.print("> ");
        }

        scanner.close();
 		System.out.println("Bye!");
    }
}


