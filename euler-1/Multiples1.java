public class Multiples1 {
	private static final int LIMIT = 1000;

	public static void main(String[] args) {
		int sum = 0;
		//Simple solution: Iterate all numbers and check if %3==0 or %5==0
		for(int i=0; i< LIMIT; i++) {
			if(i%3 ==0) {
				sum += i;
			} else if (i%5 == 0) {
				sum += i;
			}
		}
		System.out.println("Sum of 3/5 multiples from 1 to " + LIMIT + " = " + sum);
	}
}
