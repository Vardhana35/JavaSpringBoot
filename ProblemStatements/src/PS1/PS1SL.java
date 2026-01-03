package PS1;

import java.util.Scanner;

public class PS1SL {

	public String validateCode(String input) {
		String code = input.toUpperCase();

		// Length check
		if (!(code.length() == 8 || code.length() == 11)) {
			return "Input: " + input + " is not valid (Invalid length)";
		}

		// Institution code: first 4 alphabetic
		for (int i = 0; i < 4; i++) {
			if (!Character.isAlphabetic(code.charAt(i))) {
				return "Input: " + input + " is not valid (Institution Code must be alphabetic)";
			}
		}

		// Country code: next 2 alphabetic
		for (int i = 4; i < 6; i++) {
			if (!Character.isAlphabetic(code.charAt(i))) {
				return "Input: " + input + " is not valid (Country Code must be alphabetic)";
			}
		}

		// Location code: next 2 alphanumeric
		for (int i = 6; i < 8; i++) {
			if (!Character.isLetterOrDigit(code.charAt(i))) {
				return "Input: " + input + " is not valid (Location Code must be alphanumeric)";
			}
		}

		// Branch code: optional, only if length == 11
		if (code.length() == 11) {
			for (int i = 8; i < 11; i++) {
				if (!Character.isLetterOrDigit(code.charAt(i))) {
					return "Input: " + input + " is not valid (Branch Code must be alphanumeric)";
				}
			}
		}

		return input + " is valid";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		String input=sc.nextLine();
		
		PS1 ps1=new PS1();
		System.out.println(ps1.validateCode(input));
	}

}
