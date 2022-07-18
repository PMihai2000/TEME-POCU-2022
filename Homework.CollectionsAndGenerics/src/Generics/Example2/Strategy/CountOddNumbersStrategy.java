package Generics.Example2.Strategy;

public class CountOddNumbersStrategy<T> implements Strategy<T>{
    @Override
    public boolean test(T obj) {
        if(obj instanceof Integer){
            return (Integer)obj%2==1;
        }
        if(obj instanceof Long){
            return (Long)obj%2==1;
        }
        return false;
    }
}
