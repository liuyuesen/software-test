
public class homework3 {
	 static void printPrimes(int n) {

		 int MAXPRIMES = 10000;
	        int curPrime; 
	        int numPrimes; 
	        boolean isPrime; 
	        int[] primes = new int[MAXPRIMES];

	        primes[0] = 2;
	        numPrimes = 1;
	        curPrime = 2;

	        while(numPrimes < n) {
	            curPrime++; 
	            isPrime = true;
	            for(int i = 0; i <= numPrimes; i++ ) {
	                if(isDvisible(primes[i],curPrime)) {
	                    isPrime = false;
	                    break;
	                }
	            }
	            if(isPrime) {
	                primes[numPrimes] = curPrime;
	                numPrimes++;
	            }

	        }
	        for(int i = 0; i < numPrimes; i++) {
	            System.out.println("Prime: " + primes[i] );
	        }
	}
	 
	private static boolean isDvisible (int prime,int curPrime) {
		if (prime%curPrime == 0) {
			return true;
		}
		else {
			return false;
		}
	}
}
