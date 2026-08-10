class Solution {
    public double myPow(double x, int n) {
        /*
        approach 1: loop from 0 to n, and multiply x to itself to get x^n
            - if given n is negative, return 1/x^n
        time: O(n)

        appraoch 2: 2^6 -> (2^3)^2 => recurse the power function with x and n/2 until it cannot be broken down further
            -> and square the result
            -> if n is odd, multiply x with the result
            - give n is negative, return 1/result
        time: each recursion call halves the n -> n/2 -> n/4 => O(logn)
        */

        long ln = n;
        double res = pow(x, Math.abs(ln));
        return n<0 ? 1/res : res;
    }

    private double pow(double x, long n) {

        if(n == 0) return 1;

        double half = pow(x, n/2);
        double result = half * half;

        if(n % 2 != 0) result *= x;

        return result;
    }
}
