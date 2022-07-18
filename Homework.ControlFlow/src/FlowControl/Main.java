package FlowControl;

/*
*   Write a method that calculates the factorial of an integer n (returns 1*2*…*n).
*   Write a method that calculates the nth Fibonacci number (f0 = 0, f1 = 1, fn = fn−1 + fn−2).
*   Write a method that return true if an integer n is a prime number.
*   Write a method that receives a char array and returns true if it represents a palindrome
*(a palindrome is a series of characters which reads the same forwards and backwards, ex alabala)
* */

public class Main {
    public static long Factorial(int n){
        long result=1;

        for(int i = 2;i<=n;i++){
            result*=i;
        }

        return result;
    }
    public static long Fibonacci(int nth){
        if(nth<=0){
            return 0;
        }

        if(nth==1){
            return 1;
        }

        long nth_1Element = 0,nth_2Element =1;

        for(int count = 2;count<=nth;count++){
            long nthElement = nth_1Element+nth_2Element;
            nth_1Element = nth_2Element;
            nth_2Element = nthElement;
        }

        return nth_2Element;
    }
    public static boolean isPrime(int n){
        if(n<2){
            return false;
        }
        int[] ciur = new int[n+1];
        ciur[0] = ciur[1] = 1;

        for(int i =2;i<=n;i++){
            for(int j = i+i;j<=n;j+=i){
                ciur[j] = 1;
            }
        }

        return ciur[n]==0;
    }

    public static boolean isPalindrome(String word){
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

    public static void main(String[] args) {
        int nrTeste = 10;
        //Test Factorial(n)
        System.out.println("=====[Teste Fectorial(n)]=====");
        for(int test = 0;test<=nrTeste;test++) {
            System.out.printf("Factorial(%d): %d\n", test, Factorial(test));
        }
        System.out.println();

        //Test Fibonacci(nth)
        System.out.println("=====[Teste Fibonacci(n)]=====");
        for(int test = 0;test<=nrTeste;test++) {
            System.out.printf("Fibonacci(%d): %d\n", test, Fibonacci(test));
        }
        System.out.println();

        //Test isPrime(nth)
        System.out.println("=====[Teste isPrime(n)]=====");
        for(int test = 0;test<=nrTeste;test++) {
            System.out.printf("isPrime(%d): %b\n", test, isPrime(test));
        }
        System.out.println();

        //Test isPalindrome(word)
        System.out.println("=====[Teste isPalindrome(word)]=====");
        String[] words = {"alabala","ceas","aia","Aba", "aboba", "aerian", "Afromorf", "Acolo", "Ala", "Alula", "Ama", "Ana", "se va zgâria", "Sandpit", "Arepera", "La o", "Aviva", "azuza", "EME", "voi ridica", "Umbla", "Caiac"};

        for(String word: words){
            System.out.printf("isPalindrome(%s): %b\n", word, isPalindrome(word.toLowerCase()));
        }

        System.out.println();

    }
}
