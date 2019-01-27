package financialapp;

import java.util.Scanner;

public class Finapp{


	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your investment amount:");
		double investmentAmount = scan.nextDouble();
		System.out.println("Enter your annual interest rate:");
		double AnnualInterestRate = scan.nextDouble();
		double monthlyInterestRate = AnnualInterestRate/12/100;
		System.out.println("Enter years");
		int years = scan.nextInt();
		System.out.println("Years:			Future Value");
		futureInvestmentValue(investmentAmount, monthlyInterestRate, years);
		scan.close();
	}
	
	public static void futureInvestmentValue(double investmentAmount, double monthlyInterestRate, int years){
		for(int i=1;i<=years*12;i++){
			investmentAmount += investmentAmount*monthlyInterestRate;
			if(i%12 == 0) {
				System.out.println(i/12+"			"+investmentAmount);
			}
		}
	}
}
