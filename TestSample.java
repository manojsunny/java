import java.util.*;

public class TestSample {


	public static void main(String[] args) {
	
		generateMessage();

		add(45,5412);
	
	}


	public static void generateMessage() {	

		Date date = new Date();

		System.out.println(date);
	}

	public static void add(int a, int b) {	

		System.out.println("Addition : "+((a+b)));

		int a=10;

		int b=20;
	}
}