public class Sin extends Unary{
	private SymbolicExpression arg;	
	
	public Sin(SymbolicExpression arg) {
		super(arg);
	}

	public String getName() {
 		return "sin";
	}
}