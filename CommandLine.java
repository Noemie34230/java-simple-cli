

class CommandLine {

    private String commandName;
    private String argument;

    // constructor
   //  public CommandLine(){

   //  }

    public CommandLine(String command){
        String[] commandArgs = command.split(" ",2);
        this.commandName = commandArgs[0];
        this.argument = (commandArgs.length>1) ? commandArgs[1]: null ;

    }

     // getteurs

     public String getCommandName(){
        return commandName;
     }

     public String getArguments(){
        return argument;
     }

     //methode

     public boolean hasArgument(){
        return argument != null;
     }


}