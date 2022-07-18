package Collections;

import Collections.Objects.Point;
import Collections.Objects.Rectangle;
import Collections.Objects.Student;
import Collections.Objects.StudentWithID;

import java.util.*;
import java.util.stream.Collectors;

/*
Collectii:
Example 1: Generate 10 random numbers between 1 and 20, which require that the random numbers cannot be repeated
Example 2: Use Scanner to read a line of input from the keyboard, remove duplicate characters, and print out different characters // print result + duplicates
Example 3: Remove duplicate elements in the collection // given a list of student, remove duplicates

Example 4:Write a program to traverse(or iterate) HashSet
Example 5:Given an element write a program to check if element exists in ArrayList, HashSet (eg. class Stundent with name, grade and personalCode, given list of students check if the given student is present in the list)
Example 6: Write a program to iterate the HashMap
Example 7: Write a program to sort ArrayList using Comparable and Comparator
*/
public class Main {
    public static List<Integer> getRandomNumbers(){
        List<Integer> randomNumbers= new ArrayList<>();
        Random rnd = new Random();

        for(int i =0;i<10;i++) {
            int randomNumber = rnd.nextInt(1, 21);

            while(randomNumbers.contains(randomNumber)){
                randomNumber = rnd.nextInt(1, 21);
            }
            randomNumbers.add(randomNumber);
        }

        return randomNumbers;
    }//Example 1
    public static void checkDuplicatesFromInput(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input: ");
        String str = scanner.nextLine();

        List<Character> uniqueChars = new ArrayList<>();
        List<Character> duplicateChars = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        for(int i =0;i<str.length();i++){
            if(!uniqueChars.contains(str.charAt(i))){
                uniqueChars.add(str.charAt(i));
                result.append(str.charAt(i));
            }
            else if(!duplicateChars.contains(str.charAt(i))){
                duplicateChars.add(str.charAt(i));
            }
        }

        System.out.println("Result: "+result);
        System.out.println("Duplicate characters: "+duplicateChars);

    }//Example2
    public static List<Student> getUniqueStudentList(List<Student> students){
        List<Student> uniqueStudents = new ArrayList<>();

        students.forEach((student)->{
            if(!uniqueStudents.contains(student)){
                uniqueStudents.add(student);
            }
        });

        return uniqueStudents;
    }//Example3

    public static <T> void iterateThroughHashSet(HashSet<T> hashset){
        if(hashset.stream().findFirst().get() instanceof String){
            System.out.println("This method doesn't accept String type!");
            return;
        }
        System.out.println("Hashset of "+hashset.stream().findFirst().get().getClass().getSimpleName()+": ");
        hashset.forEach(System.out::println);
    }//Example4

    public static <T> boolean arrayListContains(Collection collection,T element){
        return collection.contains(element);
    }//Example5
    public static <K,V> void iterateThroughHashMap(HashMap<K,V> hashMap){
        System.out.println("HashMap: ");
        hashMap.keySet().forEach((key)-> System.out.println(key+": "+hashMap.get(key)));
    }//Example6
    public static void sortStudentArrayList(ArrayList<Student> students,Comparator<Student> comparator){
        if(comparator == null){
            Collections.sort(students);
        }else{
            students.sort(comparator);
        }
    }//Example7

    public static void main(String[] args) {
        //testExample1();
        //testExample2();
        //testExample3();
        //testExample4();
        //testExample5();
        //testExample6();
        testExample7();
    }

    private static void testExample7() {
        ArrayList<Student> students = generateStudentArrayList(false);
        System.out.println("Students unsorted: ");
        students.forEach(System.out::println);
        System.out.println();

        sortStudentArrayList(students,null);
        System.out.println("Students sorted using Comparable (sorting by grades): ");
        students.forEach(System.out::println);
        System.out.println();

        System.out.println("Students sorted using Comparator (sorting by lastname): ");
        sortStudentArrayList(students,(student1,student2)->{
            return student1.getLastname().compareTo(student2.getLastname());
        });
        students.forEach(System.out::println);
        System.out.println();

        System.out.println("Students sorted using Comparator (sorting by firstname): ");
        sortStudentArrayList(students,(student1,student2)->{
            return student1.getFirstname().compareTo(student2.getFirstname());
        });
        students.forEach(System.out::println);
        System.out.println();
    }

    private static void testExample6() {
        iterateThroughHashMap(generateStudentHashMap());
    }

    private static void testExample5() {
        List<Student> listStudents = generateStudentList(true);
        ArrayList<Student> arrayListStudents = generateStudentArrayList(false);
        HashSet<Point> hashSetPoints = generatePointHashSet(10);

        Student student1 = listStudents.get(3);
        Student student2 = new Student("Bran","Margis",9.0f);
        Point point1 = hashSetPoints.stream().findFirst().get();
        Point point2 = new Point(13f,-23f);

        System.out.println("listStudents: "+listStudents);
        System.out.println("arrayListStudents: "+arrayListStudents);
        System.out.println("hashSetPoints: "+hashSetPoints);
        System.out.println();

        System.out.println("listStudents contains "+student1+"? "+arrayListContains(listStudents,student1));
        System.out.println("listStudents contains "+student2+"? "+arrayListContains(listStudents,student2));
        System.out.println("arrayListStudents contains "+student1+"? "+arrayListContains(arrayListStudents,student1));
        System.out.println("arrayListStudents contains "+student2+"? "+arrayListContains(arrayListStudents,student2));
        System.out.println("hashSetPoints contains "+point1+"? "+arrayListContains(hashSetPoints,point1));
        System.out.println("hashSetPoints contains "+point2+"? "+arrayListContains(hashSetPoints,point2));
    }

    private static void testExample4() {
        iterateThroughHashSet(generateStudentHashSet(false));
        System.out.println();
        iterateThroughHashSet(generateStudentHashSet(true));
        System.out.println();
        iterateThroughHashSet(generatePointHashSet(7));
        System.out.println();
        iterateThroughHashSet(generateRectangleHashSet(5));
        System.out.println();
        HashSet<String> strings = new HashSet<>();
        strings.add("Briliant!");
        iterateThroughHashSet(strings);
        System.out.println();
    }
    private static void testExample1() {
        System.out.println("10 random numbers between 1 and 20: "+getRandomNumbers());
    }
    private static void testExample2() {
        checkDuplicatesFromInput();
    }
    private static void testExample3() {
        List<Student> studentsWithoutId = generateStudentList(false);
        List<Student> studentsWithId = generateStudentList(true);
        System.out.print("Initial students without ID:");
        for (Student student:studentsWithoutId) {
            System.out.println("- "+student);
        }
        System.out.println();

        System.out.println("Unique students without ID:");
        for (Student student:getUniqueStudentList(studentsWithoutId)) {
            System.out.println("- "+student);
        }
        System.out.println();

        System.out.println("Initial students with ID:");
        for (Student student:studentsWithId) {
            System.out.println("- "+student);
        }
        System.out.println();

        System.out.println("Unique students with ID:");
        for (Student student:getUniqueStudentList(studentsWithId)) {
            System.out.println("- "+student);
        }
        System.out.println();
    }


    public static ArrayList<Student> generateStudentArrayList(boolean withId){
        Random rnd = new Random();
        ArrayList<Student> students = new ArrayList<>();

        if(withId) {
            students.add(new StudentWithID(1, "Malvin", "Keresi", rnd.nextInt(50, 101) / 10f));
            students.add(new StudentWithID(2, "Rick", "Keresi", rnd.nextInt(50, 101) / 10f));
            students.add(new StudentWithID(2, "Rick", "Keresi", rnd.nextInt(50, 101) / 10f));
            students.add(new StudentWithID(3, "Ionel", "George", rnd.nextInt(50, 101) / 10f));
            students.add(new StudentWithID(4, "Apostol", "Ionela", rnd.nextInt(50, 101) / 10f));
            students.add(new StudentWithID(5, "Mohamed", "Azazi", rnd.nextInt(50, 101) / 10f));
            students.add(new StudentWithID(5, "Mohamed", "Azazi", rnd.nextInt(50, 101) / 10f));
            students.add(new StudentWithID(6, "Shin", "Ki", rnd.nextInt(50, 101) / 10f));
            students.add(new StudentWithID(7, "Navel", "Charlie", rnd.nextInt(50, 101) / 10f));
        }else {
            students.add(new Student("Malvin", "Keresi", rnd.nextInt(50, 101) / 10f));
            students.add(new Student("Malvin", "Keresi", rnd.nextInt(50, 101) / 10f));
            students.add(new Student("Rick", "Keresi", rnd.nextInt(50, 101) / 10f));
            students.add(new Student("Ionel", "George", rnd.nextInt(50, 101) / 10f));
            students.add(new Student("Apostol", "Ionela", rnd.nextInt(50, 101) / 10f));
            students.add(new Student("Mohamed", "Azazi", rnd.nextInt(50, 101) / 10f));
            students.add(new Student("Shin", "Ki", 8.8f));
            students.add(new Student("Shin", "Ki", 8.8f));
            students.add(new Student("Navel", "Charlie", rnd.nextInt(50, 101) / 10f));
        }

        return students;
    }
    public static List<Student> generateStudentList(boolean withId){
        Random rnd = new Random();
        List<Student> students = new ArrayList<>();

        if(withId) {
            students.add(new StudentWithID(1, "Malvin", "Keresi", rnd.nextInt(50, 101) / 10f));
            students.add(new StudentWithID(2, "Rick", "Keresi", rnd.nextInt(50, 101) / 10f));
            students.add(new StudentWithID(2, "Rick", "Keresi", rnd.nextInt(50, 101) / 10f));
            students.add(new StudentWithID(3, "Ionel", "George", rnd.nextInt(50, 101) / 10f));
            students.add(new StudentWithID(4, "Apostol", "Ionela", rnd.nextInt(50, 101) / 10f));
            students.add(new StudentWithID(5, "Mohamed", "Azazi", rnd.nextInt(50, 101) / 10f));
            students.add(new StudentWithID(5, "Mohamed", "Azazi", rnd.nextInt(50, 101) / 10f));
            students.add(new StudentWithID(6, "Shin", "Ki", rnd.nextInt(50, 101) / 10f));
            students.add(new StudentWithID(7, "Navel", "Charlie", rnd.nextInt(50, 101) / 10f));
        }else {
            students.add(new Student("Malvin", "Keresi", rnd.nextInt(50, 101) / 10f));
            students.add(new Student("Malvin", "Keresi", rnd.nextInt(50, 101) / 10f));
            students.add(new Student("Rick", "Keresi", rnd.nextInt(50, 101) / 10f));
            students.add(new Student("Ionel", "George", rnd.nextInt(50, 101) / 10f));
            students.add(new Student("Apostol", "Ionela", rnd.nextInt(50, 101) / 10f));
            students.add(new Student("Mohamed", "Azazi", rnd.nextInt(50, 101) / 10f));
            students.add(new Student("Shin", "Ki", 8.8f));
            students.add(new Student("Shin", "Ki", 8.8f));
            students.add(new Student("Navel", "Charlie", rnd.nextInt(50, 101) / 10f));
        }

        return students;
    }
    public static HashSet<Student> generateStudentHashSet(boolean withId){
        return (HashSet)generateStudentList(withId).stream().collect(Collectors.toSet());


    }
    public static HashSet<Point> generatePointHashSet(int size){
        Random rnd = new Random();

        HashSet<Point> points = new HashSet<Point>();

        size= Math.abs(size);

        for(int i=0;i<size;i++){
            points.add(new Point(rnd.nextFloat(), rnd.nextFloat()));
        }

        return points;
    }

    public static HashSet<Rectangle> generateRectangleHashSet(int size){
        Random rnd = new Random();

        HashSet<Rectangle> rectangles = new HashSet<Rectangle>();

        size= Math.abs(size);

        for(int i=0;i<size;i++){
            rectangles.add(new Rectangle(
                    new Point(rnd.nextFloat(),rnd.nextFloat()),
                    rnd.nextFloat()*rnd.nextInt(1,30), rnd.nextFloat()*rnd.nextInt(1,30))
                    );
        }

        return rectangles;
    }

    public static HashMap<Integer,Student> generateStudentHashMap(){
        HashMap<Integer,Student> students = new HashMap<>();

        generateStudentHashSet(true).stream().forEach((student)->{
            StudentWithID tmpStudent = (StudentWithID) student;
            students.put(tmpStudent.getPersonalCode(),student);
        });

        return students;
    }


}