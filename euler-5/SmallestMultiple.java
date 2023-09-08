import java.util.ArrayList;

public class SmallestMultiple {
	public static final int limit = 20;
	public static void main(String[] args) {
		long testVal = 2520L;
		boolean allOnes = false;	
		boolean hasDivisors = false;
		int currFactor = 2;
	
		//The table method looks pretty good: https://en.wikipedia.org/wiki/Least_common_multiple#Using_the_table-method

		ArrayList<Integer> myFactors = new ArrayList<Integer>();
		int listOfNums[] = new int[20];
		for(int i=0; i<SmallestMultiple.limit; i++) {
			listOfNums[i] = i+1;
		}
		
		while(!allOnes) {
			System.out.println("Now at currVal of " + currFactor);
			allOnes = true;
			hasDivisors = false;
			
			for(int i=0; i<SmallestMultiple.limit; i++) {
				//PrintArray(listOfNums);
				if(listOfNums[i]%currFactor==0) {
					System.out.print("Number " + listOfNums[i] + " becomes ");
					listOfNums[i] = listOfNums[i]/currFactor;
					System.out.println(listOfNums[i]);
					hasDivisors = true;
				}
				if(listOfNums[i] != 1) {
					allOnes = false;
				}
			}	
			if(!hasDivisors) {
				currFactor = NextPrime(currFactor);
			} else {
				myFactors.add(currFactor);
			}
		}
		long solution = 1L;
		for(Integer i: myFactors) {
			solution = solution * i;
		}
		System.out.println(solution);
	}

	public static int NextPrime(int currVal) {
		int search = currVal+1;
		while(!IsPrime(search)) {
			search++;
		}
		return search;
	}

	public static boolean IsPrime(int val) {
		if(val==2) {
			return true;
		}
		for(int i=3; i<=2; i++) {
			if(val%i!=0){
				return false;
			}
		}
		return true;
	}
	
	public static void PrintArray(int[] aArray) {
		for(int i=0; i<aArray.length; i++) {
			System.out.println("Position " + i + ":" + aArray[i]);
		}
	}
}
