public class Command extends SymbolicExpression{
	private String arg;	
	
	public Command(String arg) {
		super("Command", arg);
	}
}