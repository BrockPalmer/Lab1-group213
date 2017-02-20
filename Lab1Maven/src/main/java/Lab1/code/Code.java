package Lab1.code;

import java.util.Scanner;
import org.apache.poi.ss.formula.functions.*;

public class Code {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Years to Work: ");
		double YearstoWork = input.nextDouble();
		System.out.print("\n");

		System.out.print("Annual Return: ");
		double AnnualReturn = input.nextDouble();
		System.out.print("\n");

		while (AnnualReturn > 20 | AnnualReturn < 0) {
			System.out.print("Invalid Input, enter new value: ");
			AnnualReturn = input.nextDouble();
			System.out.print("\n");
		}

		System.out.print("Years Retired: ");
		double YearsRetired = input.nextDouble();
		System.out.print("\n");

		System.out.print("Annual Return Two: ");
		double AnnualReturnTwo = input.nextDouble();
		System.out.print("\n");

		while (AnnualReturnTwo > 3 | AnnualReturnTwo < 0) {
			System.out.print("Invalid Input, enter new value: ");
			AnnualReturnTwo = input.nextDouble();
			System.out.print("\n");
		}

		System.out.print("Required Income: ");
		double RequiredIncome = input.nextDouble();
		System.out.print("\n");

		System.out.print("Monthly SSI: ");
		double MonthlySSI = input.nextDouble();
		System.out.print("\n");

		input.close();
		double r = (AnnualReturnTwo / 100) / 12;
		double n = YearsRetired * 12;

		double f = 0;
		boolean t = false;
		double y = RequiredIncome - MonthlySSI;

		double r2 = (AnnualReturn / 100) / 12;
		double p = 0;
		
		p = FindPV(r, n, Math.abs(y)*-1,f, t);
		
		System.out.println(p);
		y = FindPMT(r2, YearstoWork*12, 0, p, t );
		
		System.out.printf("%.2f",Math.abs(y));
		
		

	}

	public static double FindPV(double r, double n, double y, double f, boolean t)
		{
			return FinanceLib.pv(r, n, y, f, t);
		}

	public static double FindPMT(double r, double n, double p, double f, boolean t)
	{
		return FinanceLib.pmt(r, n, p, f, t);
	}

}
