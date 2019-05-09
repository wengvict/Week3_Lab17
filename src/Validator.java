import java.util.Scanner;

public class Validator {
	
	// prevents user from picking menu option thats <1 and >3
	public static int getMenuInt(Scanner sc, int min, int max) {
		int i = sc.nextInt();
		boolean isValid = false;
		while (isValid == false) {
			if (i >= min && i <= max) {
				isValid = true; 
			} else {
				isValid = false;
				System.out.print("Please choose a number from the menu: ");
				i = sc.nextInt();
			}
		}
		return i;
	}
	
}