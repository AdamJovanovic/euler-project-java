public class SumSquareDifference {

    public static void main(String args[]) {

        Long sum_of_sq;
        Long sq_of_sum;
        Long diff;
        Long prevDiff = 0L;

        for(int i=0; i<=100; i++) {
            sum_of_sq = SumOfSquares(i);
            sq_of_sum = SquareOfSum(i);
            diff = sum_of_sq - sq_of_sum;
            System.out.println("[" + i + "]Sum=" + sum_of_sq + "\t\tSquare=" + sq_of_sum + "\t\tDiff=" + (diff) + "\t\tAdditional=" + (diff-prevDiff));
            prevDiff = diff;
        }

    }

    public static Long SumOfSquares(int val) {
        if(val == 0) {
            return 0L;
        }
        Long sum = 0L;
        for(Long i=1L; i<=val; i++) {
            sum += i*i;
        }

        return sum;
    }

    public static Long SquareOfSum(int val) {
        if(val == 0) {
            return 0L;
        }
        Long ret = 0L;
        for(Long i=1L; i<=val; i++) {
            ret += i;
        }
        return ret*ret;
    }
}