public class HelloTest {
	
	public static void main(String[] args) {
    	if ( args == null || args.length< 1 ) {
			System.err.println("Argument required!");
			System.exit(1);
        }
  		var argument = args[0];
  		System.out.printf("Argument: %s%n", argument);
    }
}
