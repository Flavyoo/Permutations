/* Name: Flavio Andrade
 * Date: March 29, 2017
 */

public class Permute {
	private int BILLION = 1000000000;
	private int N;
	static long count = 0;
	private char[] p = new char[27];

	// Initialize array with characters from A to Z.
	public Permute(int size) {
		N = size;
		//p[0] = (char) '*';
		int i = 0;
		for (char c = 'A'; c <= 'Z'; c++) { p[i++] = c; }
	}

	// Swap element at i with j.
	public void swap(int i, int j) {
		char temp = p[i];
		p[i] = p[j];
		p[j] = temp;
	}

	// Print out the permutations.
	public void printIt() {
		for (int i = 1; i < N + 1; i++) {
			System.out.print(String.valueOf(p[i]));
		}
		System.out.println();
	}


	public void permute1(int n, boolean print) {
	    if (n == 1) {
			count += 1;
			if (print) { printIt(); }
		}
	    for (int i = 1; i <= n; i++){
	      swap(i, n);
	      permute1(n-1, print);
	      swap(i, n);
	    }
	}

	public void permute2(int n, boolean print) {
	    if (n == 1){
	      if (print) { printIt(); }
	      return;
	    }
	    for (int i = 1; i <= n; i++){
	      permute2(n - 1, print);
	      swap((n & 0x01) == 1 ? 1 : i, n);
	    }
	}

	public void printOutPut(int alg, int n, double time) {
		System.out.format("%8d Permutations: Permute%1d, N = %1d, Time = %.6f\n",
		        count, alg, n, time / (BILLION));
	}

	public static void main(String[] args) {
		long time = 0;
		long initial = 0;
		// Algorithm to run, choose 1, 2, 3.
		int alg = Integer.parseInt(args[0]);
		// Length of the permutation.
		int n = Integer.parseInt(args[1]);
		// Take integer b, if b == 1, print, else, do not print
		int b = Integer.parseInt(args[2]);
		n = ((n < 2) || (n > 14)) ? 4 : n;
		Permute p = new Permute(n);
		// Checks which algorithm was called, calculates time, and prints result
		switch (alg) {
			case 1: alg = 1;
			    initial = System.nanoTime();
			    p.permute1(n, b == 1);
				time = System.nanoTime() - initial;
				p.printOutPut(alg, n, time);
                break;
			case 2: alg = 2;
			    initial = System.nanoTime();
			    p.permute2(n, b == 1);
				time = System.nanoTime() - initial;
				p.printOutPut(alg, n, time);
                break;
			default: alg = 2;
			    initial = System.nanoTime();
			    p.permute2(n, b == 1);
				time = System.nanoTime() - initial;
				p.printOutPut(alg, n, time);
				break;
		}
	}
}
