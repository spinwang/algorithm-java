package algorithm;

/**
 * Created by spin on 2/15/17.
 */
public class Fibonacci {

    public long fibonacci(int k){
        if ( k < 0) {
            return 0;
        } else if ( k == 1 || k == 0) {
            return k;
        }

        long i = 2;
        long minus2 = 0;
        long minus1 = 1;
        long result = minus1 + minus2;
        while (i <= k){
            long newMinus1 = minus2 + minus1;
            minus2 = minus1;
            minus1 = newMinus1;

            result = newMinus1;
            i++;
        }

        return result;
    }

    private static void print(long number) {
        System.out.println(number);
    }

    public static void main(String[] args){

        Fibonacci solution = new Fibonacci();

        print(solution.fibonacci(0));
        print(solution.fibonacci(1));
        print(solution.fibonacci(2));
        print(solution.fibonacci(3));
        print(solution.fibonacci(6));
        print(solution.fibonacci(10000));

    }
}
