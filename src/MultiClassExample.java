public class MultiClassExample {
	
	public static void main(String[] args) {
        Name name = new Name("Ola", "Nordmann");
  		System.out.printf("Name is: %s %n", name.getFullName());
    }
}

 public class Name {
    
    public final String firstName;
    public final String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName() {
        return String.join(" ", this.firstName, this.lastName);
    }
}
