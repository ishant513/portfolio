package quiz3;
import java.util.*;

public class Gpacalc {

	public static void main(String[] args) {
		gpacalc();
	}
	
	public static void gpacalc() {
		Scanner scan = new Scanner(System.in);
		double gradetotal = 0;
		boolean sentinel = false;
		int index = 0;
		do {
			System.out.println("Is your class a weighted course?");
			String isWeighted = scan.next();
			if(isWeighted.equals("no")) {
				System.out.println("Enter one of your grades");
				String grade = scan.next();
				if(grade.equals("A")) {
					gradetotal += 4.0;
					index += 1;
				} else if(grade.equals("B")) {
					gradetotal += 3.0;
					index += 1;
				} else if(grade.equals("C")) {
					gradetotal += 2.0;
					index += 1;
				} else if(grade.equals("D")) {
					gradetotal += 1.0;
					index += 1;
				} else if(grade.equals("F")) {
					gradetotal += 0.0;
					index += 1;
				}
			}	else if(isWeighted.equals("yes")) {
				System.out.println("Enter one of your grades for your AP course");
				String apgrade = scan.next();
				if(apgrade.equals("A")) {
					gradetotal += 5.0;
					index += 1;
				} else if(apgrade.equals("B")) {
					gradetotal += 4.0;
					index += 1;
				} else if(apgrade.equals("C")) {
					gradetotal += 3.0;
					index += 1;
				} else if(apgrade.equals("D")) {
					gradetotal += 2.0;
					index += 1;
				} else if(apgrade.equals("F")) {
					gradetotal += 1.0;
					index += 1;
				}
			}
			System.out.println("Is that all?");
			String isDone = scan.next();
			if(isDone.equals("yes")) {
				sentinel = true;
			}
		} while(sentinel == false);
		double gpa = gradetotal / index;
		System.out.println("Your weighted gpa is: " + gpa);
		scan.close();
	}
}
