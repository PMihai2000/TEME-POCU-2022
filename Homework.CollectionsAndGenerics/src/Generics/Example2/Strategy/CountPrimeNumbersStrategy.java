package Generics.Example2.Strategy;

public class CountPrimeNumbersStrategy<T> implements Strategy<T>{
    @Override
    public boolean test(T obj) {
        if(obj instanceof Integer) {
            int n = (int)obj;
            if (n < 2) {
                return false;
            }
            int[] ciur = new int[n + 1];
            ciur[0] = ciur[1] = 1;

            for (int i = 2; i <= n; i++) {
                for (int j = i + i; j <= n; j += i) {
                    ciur[j] = 1;
                }
            }

            return ciur[n] == 0;
        }
        return false;
    }
}

