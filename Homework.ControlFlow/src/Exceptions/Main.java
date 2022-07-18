package Exceptions;
/*   Write 4 methods where method1 calls method2, method2 calls method3 and method3 calls method4.
*    Create a new checked exception and have method4 throw it.
*    Method3 should not handle this exception (no try-catch block).
*    Method2 should handle the exception and wrap it in a new exception (create a new exception).
*    Method1 should have a try catch block and print the exception to the console (use printStackTrace() method)
*– we should see a “Caused by” message
*/
public class Main {
    public static void method1(){
        try {
            method2();
        } catch (PMCheckedException e) {
            e.printStackTrace();
        }
    }
    public static void method2() throws PMCheckedException {
        try {
            method3();
        } catch (PMCheckedException e) {
            throw new PMCheckedException("An exception exception was thrown in method2.",e);
        }
    }
    public static void method3() throws PMCheckedException{
        method4();
    }
    public static void method4() throws PMCheckedException {
        throw new PMCheckedException();
    }
    public static void main(String[] args) {
        method1();
    }
}
