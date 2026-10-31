package ChatGpt;

public class System_Environment_Varilables {
	public static void main(String[] args) {
	String getenvUser = System.getenv("Java_test_USERNAME");
		String getenvPass = System.getenv("Java_test_PASS");
		System.out.println("System env username "+getenvUser);
		System.out.println("System env pass "+getenvPass);
		//	Java_test_USERNAME

	}
}
