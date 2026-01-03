package PS1;

import java.util.Scanner;

public class PS1Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		String input=sc.nextLine();
		
		PS1 ps1=new PS1();
		System.out.println(ps1.validateCode(input));
	}

}
