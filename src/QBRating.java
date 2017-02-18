import java.util.Scanner;

public class QBRating {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter touchdown passes, total yards, number of interceptions, completions, and number of passes attempted for a quaterback: ");
		double tDPasses = input.nextInt();
		double tYards = input.nextDouble();
		double interceptions = input.nextInt();
		double completions = input.nextInt();
		double numOfPasses = input.nextInt();
		double a = aVar(completions, numOfPasses);
		double b = bVar(tYards, numOfPasses);
		double c = cVar(tDPasses, numOfPasses);
		double d = dVar(interceptions, numOfPasses);
		double rating = qbRating(a, b, c, d);
		System.out.println("The quaterback's rating is " + rating);

	}
	public static double aVar (double comp, double att){
		double compRating = ((comp / att) - .3) / .2;
		if (compRating > 2.375){
			return compRating = 2.375;
		}
		else 
			return compRating;
	}
	public static double bVar (double yds, double att){
		double passPerYards = ((yds / att) - 3) * .25;
		if (passPerYards > 2.375){
			return passPerYards = 2.375;
		}
		else
			return passPerYards;
	}
	public static double cVar (double td, double att){
		double tdPerAttempts = (td / att) * 20;
		if (tdPerAttempts > 2.375){
			return tdPerAttempts = 2.375;
		}
		else
			return tdPerAttempts;
	}
	public static double dVar (double steals, double att){
		return (2.375 - ((steals / att) * 25));
	}
	public static double qbRating (double a, double b, double c, double d){
		return ((a + b + c + d) / 6) * 100;
	}

}
