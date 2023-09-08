public class LargestPalindrome {
	public static final int LIMIT = 999;
	public static void main(String[] args) {
		System.out.println("99299 is palindrome: " + IsPalindrome(99299));	
		System.out.println("1 is palindrome: " + IsPalindrome(1));	
		System.out.println("103 is palindrome: " + IsPalindrome(103));	
		System.out.println("4223 is palindrome: " + IsPalindrome(4223));	
		System.out.println("4224 is palindrome: " + IsPalindrome(4224));	
		System.out.println("423324 is palindrome: " + IsPalindrome(423324));	

		//Largest palindrome number made from multiplying 2 numbers up to 999.
		int largestPalindrome = 0;
		int curr = 0;
		for(int i=LargestPalindrome.LIMIT; i>10; i--) {
			System.out.println("Current value: " + i);
			for(int j=LargestPalindrome.LIMIT; j>10; j--) {
				curr = i*j;
				if ( IsPalindrome(curr) ){
					largestPalindrome = curr > largestPalindrome ? curr : largestPalindrome;
				}
			}
		}

		System.out.println("Largest value: " + largestPalindrome);
		
		

	}
	
	public static boolean IsPalindrome(int num) {
		int ind = 0;
		int[] array = new int[6]; // Assuming 999x999 is the maximum
		
		while (num != 0) {
			array[ind] = num % 10;
			num /= 10;
			ind++;
		}
		
		for (int i=0; i<ind; i++) {
			if(array[i] != array[ind-i-1]) {
				return false;
			}
		}

		return true;
		
	}
}
