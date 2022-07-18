//ex 2. Write a generic method to count the number of elements in a collection that have a specific property (for example, odd integers, prime numbers, palindromes)
//        hint: countIf(collection, strategy)//generic types - the strategy will be what we want to count
//        (for example, odd integers, prime numbers, palindromes)
//
//public interface Strategy<T> { // this is how the strategy will look like
//    public boolean test(T obj);
//}
//
////you have to add an implementation for the strategy for example CountOddNumbersStrategy for Integer type
////in a main method test your count method
package Generics.Example2;

import Generics.Example2.Strategy.CountOddNumbersStrategy;
import Generics.Example2.Strategy.CountPalindromesNumbersStrategy;
import Generics.Example2.Strategy.CountPrimeNumbersStrategy;
import Generics.Example2.Strategy.Strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Example2 {
    public static<T> long countIf(Collection<T> collection, Strategy<T> strategy){
        return collection.stream().filter(strategy::test).count();
    }
    public static void Main() {
        List<Integer> integers = IntStream.range(0,40).boxed().toList();
        System.out.println("Integer list: "+integers);
        System.out.println("- count prime numbers:" +countIf(integers,new CountPrimeNumbersStrategy<>()));
        System.out.println("- count odd numbers:" +countIf(integers,new CountOddNumbersStrategy<>()));

        List<String> words = Arrays.stream(new String[]{"alabala","ceas","aia","Aba", "aboba", "aerian", "Afromorf", "Acolo", "Ala", "Alula", "Ama", "Ana", "se va zgâria", "Sandpit", "Arepera", "La o", "Aviva", "azuza", "EME", "voi ridica", "Umbla", "Caiac"}).toList();
        System.out.println("String list: "+words);
        System.out.println("- count palindromes:" +countIf(words,new CountPalindromesNumbersStrategy<>()));


    }


}
