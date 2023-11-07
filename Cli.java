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

            String output = executeCommand(commande);
            System.out.println(output);

            System.out.print("> ");
        }

        scanner.close();
        System.out.println("Bye!");
    }

    public static String executeCommand(CommandLine command) {
        String commandName = command.getCommandName();
        
        // Utilisez la classe Commands pour exécuter la commande appropriée
        // if (commandName.equals("exit") || commandName.equals("logout")) {
        //     return Commands.exit(command);
        // } else 
        if (commandName.equals("date")) {
            return Commands.date(command);
        } else if (commandName.equals("time")) {
            return Commands.time(command);
        } else if (commandName.equals("datetime")) {
            return Commands.datetime(command);
        } else if (commandName.equals("useraccount")) {
            return Commands.useraccount(command);
        } else if (commandName.equals("userhome")) {
            return Commands.userhome(command);
        } else if (commandName.equals("os")) {
            return Commands.os(command);
        } else if (commandName.equals("printenv")) {
            return Commands.printenv(command);
        } else if (commandName.equals("echo") || commandName.equals("print")) {
            return Commands.echo(command);
        } else if (commandName.equals("ls")) {
            return Commands.ls(command);
        } else if (commandName.equals("cat")) {
            return Commands.cat(command);
        } else {
            return "Command " + commandName + " not found.";
        }
    }
}


