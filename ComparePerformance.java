/*
This class is tests the values of N that are 8, 9, 10.
The time for each value of N is computed m times. M is a variable that takes
in the number of times to test each value of N. Higher values of N are not
tested because the time will increase by m times the time it takes to permute N,
for N > 10. If this result is 'A' for each N > 10, add all these 'A's
for the total time.
The program only prints the time of each run, if the interval of testing is <= 5,
otherwise, computation time will be too expensive.
*/
public class ComparePerformance {
	public static void main(String[] args) {
		long time = 0;
		long initial = 0;
		double perm1average = 0.0;
		double perm3average = 0.0;
		// Interval of comparison argument
		int m = Integer.parseInt(args[0]);
		int j = 0;
		int[] ns = {8, 9, 10};
		Permute p = new Permute(ns[j]);
        System.out.format("%nTesting for M = %d%n%n", m);
		System.out.println("Permutation method 3.");
		for (int i = 1; i <= m; i++) {
			// Test permutation method 3;
			initial = System.nanoTime();
			p.permute2(ns[j], false);
			time = System.nanoTime() - initial;
			perm3average += time;
			if (m <= 5) { p.printOutPut(3, ns[j], time); }
			if (i == m) {
				i = 1;
				j++;
				if (j == ns.length) {
					j = 0;
					break;
				}
			}
		}
		perm3average = perm3average / 1000000000.0;
		double average3 = perm3average / m * 3;
		System.out.printf("Permutation Three average time = %.6f%n", average3);
		System.out.printf("Permutation Three total time = %.6f%n", perm3average);

		System.out.println("Permutation method 1.");
		for (int i = 1; i <= m; i++) {
			// Test permutation method 1;
			initial = System.nanoTime();
			p.permute1(ns[j], false);
			time = System.nanoTime() - initial;
			perm1average += time;
			if (m <= 5) { p.printOutPut(1, ns[j], time); }
			if (i == m) {
				i = 1;
				j++;
				if (j == ns.length) {
					j = 0;
					break;
				}
			}
		}
		System.out.println();
		perm1average = perm1average / 1000000000.0;
		double average1 = perm1average / m * 3;
		System.out.printf("Permutation One total time = %.6f%n", perm1average);
		System.out.printf("Permutation One average time = %.6f%n", average1);
		double percentFaster = (average1 / average3) * 100.0;
		System.out.printf("For this test, Permutation Three is %.2f percent faster"
		        + " than Permutation 1.%n%n", percentFaster);
     }
 }
