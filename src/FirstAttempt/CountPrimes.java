package FirstAttempt;

import java.util.Arrays;

public class CountPrimes {

	// http://www.programcreek.com/2014/04/leetcode-count-primes-java/
	// Sieve of Eratosthenes: https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
	// count primes LESS THAN n
	public int countPrimes(int n) {
		if (n <= 2) return 0;
		
		boolean[] primes = new boolean[n];
		Arrays.fill(primes, true);
		for (int i = 0; i < 2; i++) {
			primes[i] = false;
		}
		
		for (int i = 2; i < n; i++) {
			if (primes[i]) {
				for (int times = 2; times * i < n; times++) {
					primes[times*i] = false;
				}
			}
		}
		
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (primes[i])
				count++;
		}
	 
		return count;
    }
}
