public class Log extends Unary{
	private SymbolicExpression arg;
	
	public Log(SymbolicExpression arg) {
		super(arg);
	}

	public String getName() {
 		return "log";
	}
}