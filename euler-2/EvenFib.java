public class EvenFib {
	public static final int LIMIT = 4000000;
	public int a;
	public int b;
	public static void main(String[] args) {
		EvenFib val = new EvenFib();
		val.a = 1;
		val.b = 2;
		int sum = 2;
		int evenCounter = 1;
		// Given https://math.stackexchange.com/questions/2386804/proof-that-every-third-fibonacci-number-is-even
		// Every third fibonacci value is even. We just need to count the iterations.
		while(val.b < EvenFib.LIMIT) {
			val.NextFib();
			System.out.println(val.b);
			if(evenCounter == 3) {
				sum += val.b;
				System.out.println("Add value: " + val.b);
				evenCounter = 1;
			} else {
				evenCounter += 1;
			}
		}
		System.out.println("Sum of even Fibonacci numbers below " + EvenFib.LIMIT + " is equal to " + sum);
	}

	public int NextFib() {
		int temp = b;
		b = a + b;
		a = temp;

		return b;
	}
}
