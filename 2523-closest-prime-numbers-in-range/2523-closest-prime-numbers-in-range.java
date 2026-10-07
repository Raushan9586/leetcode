class Solution {
    public int[] closestPrimes(int left, int right) {
    int prev = -1;
    int num1 = -1;
    int num2 = -1;
    int minGap = Integer.MAX_VALUE;

    for (int i = left; i <= right; i++) {

        if (isPrime(i)) {

            if (prev != -1) {
                int gap = i - prev;

                if (gap < minGap) {
                minGap = gap;
                num1 = prev;
                num2 = i;

                }
            }
            prev = i;


        }
    }
    return new int[]{num1, num2};

    }
    private boolean isPrime(int n) {
        if (n < 2) {
        return false;
    }

    for (int i = 2; i * i <= n; i++) {
        if (n % i == 0) {
        return false;
        }
    }
    return true;
    
    }

}