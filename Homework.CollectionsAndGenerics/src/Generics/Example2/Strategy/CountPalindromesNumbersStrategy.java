package Generics.Example2.Strategy;

public class CountPalindromesNumbersStrategy<T> implements Strategy<T>{
    @Override
    public boolean test(T obj) {
        String word = obj.toString().toLowerCase();

        boolean isThisWordPalindrome = true;

        int wordLength = word.length();

        for(int i =0;i<wordLength/2;i++){
            if(word.charAt(i) != word.charAt(wordLength-i-1)){
                isThisWordPalindrome = false;
                break;
            }
        }

        return isThisWordPalindrome;
    }
}
