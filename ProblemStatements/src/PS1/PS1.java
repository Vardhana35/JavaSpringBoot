package PS1;

public class PS1 {

	public String validateCode(String input) {
		String code = input.toUpperCase();
		if (Length_Check(code) && Inst_Check(code) && Cntry_Check(code) && Loc_Check(code) && Branch_Check(code)) {
			return input + " is valid";
		}
		return "Input: " + input + " is not valid";
	}

	public boolean Inst_Check(String code) {
		for (int i = 0; i < 4; i++) {
			if (!Character.isAlphabetic(code.charAt(i))) {
				System.out.println("Institution Code must be alphabetic");
				return false;
			}
		}
		return true;
	}

	public boolean Cntry_Check(String code) {
		for (int i = 4; i < 6; i++) {
			if (!Character.isAlphabetic(code.charAt(i))) {
				System.out.println("Country Code must be alphabetic");
				return false;
			}
		}
		return true;
	}

	public boolean Loc_Check(String code) {
		for (int i = 6; i < 8; i++) {
			if (!Character.isLetterOrDigit(code.charAt(i))) {
				System.out.println("Location code contains invalid characters");
				return false;
			}
		}
		return true;
	}

	public boolean Branch_Check(String code) {
		if (code.length() == 8)
			return true; // no branch
		if (code.length() == 11) {
			for (int i = 8; i < 11; i++) {
				if (!Character.isLetterOrDigit(code.charAt(i))) {
					System.out.println("Branch code contains invalid characters");
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public boolean Length_Check(String code) {
		if (code.length() == 8 || code.length() == 11)
			return true;
		System.out.println("Invalid length");
		return false;
	}
}
