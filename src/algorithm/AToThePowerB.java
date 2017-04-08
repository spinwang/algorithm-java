package algorithm;

/**
 * Created by spin on 2/15/17.
 */
public class AToThePowerB {

    public long power(int a, int b){
        if ( b == 0){
            return 1;
        }
        long halfPower = power(a, b/2);
        if (b % 2 == 0){
            return halfPower * halfPower;
        } else {
            return halfPower * halfPower * a;
        }
    }

    public static void main(String[] args){
        AToThePowerB solution = new AToThePowerB();

        Util.print(solution.power(2,0));
        Util.print(solution.power(2,3));
        Util.print(solution.power(0,10));
        Util.print(solution.power(-2,5));
    }
}
