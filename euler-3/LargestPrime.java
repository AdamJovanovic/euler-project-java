import java.util.ArrayList;
import java.lang.Math;

public class LargestPrime {
	public static final long TARGET = 600851475143L;
	public static void main(String[] args) {
		long val;
		ArrayList<Long> myPrimes = GetPrimes(Math.round(Math.sqrt(LargestPrime.TARGET)));	
		/*for(int i=0; i<myPrimes.size(); i++) {
			System.out.println(myPrimes.get(i));
		}*/

		for(int i=myPrimes.size()-1; i >= 0; i--) {
			val = myPrimes.get(i);
			if(TARGET%val == 0) {
				System.out.println(val);
				break;
			}
		}
	}

	public static ArrayList<Long> GetPrimes(long limit) {
		//Use a prime sieve to return an ArrayList of all prime numbers from 2 to limit inclusive
		ArrayList<Long> myPrimes = new ArrayList<Long>();	
		myPrimes.add(2L);
		myPrimes.add(3L);
		
		boolean[] isComposite = new boolean[(int) (limit + 1)];
		
		int currPos = 0;
		long currVal = 0;
		long foundIndex = 0;
			
		System.out.println("size of myPrimes = " + myPrimes.size());
		System.out.println("size of myPrimes = " + myPrimes.lastIndexOf(limit));
		
		for (long i = 3; i <= limit; i += 2) {
			if (!isComposite[(int) i]) {
				myPrimes.add(i);
				for (long j = i * i; j <= limit; j += i) {
					isComposite[(int) j] = true;
				}
			}
		}

		return myPrimes;
	}
}
