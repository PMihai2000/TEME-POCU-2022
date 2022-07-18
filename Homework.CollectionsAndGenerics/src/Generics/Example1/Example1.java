//ex 1. Design a class that acts as a library for the following kinds of media: book, video, and newspaper.
//        Provide one version of the class that uses generics and one that does not. Feel free to use any additional APIs for storing and retrieving the media.
//public class Library {
//    private List resources = new ArrayList(); // no generics are user
//    public void addMedia( .. element) { // what should be the type of element in order to meet all three media types (book, video, and newspaper)
//        resource.add(element);
//    }
//    public Media retrieveLast() {
//        ..
//    }
//
//    /*how should book, video, and newspaper classes look like? What will they have in common? */
//}
package Generics.Example1;

import Generics.Example1.Media.Book;
import Generics.Example1.Media.Media;
import Generics.Example1.Media.Newspaper;
import Generics.Example1.Media.Video;

public class Example1 {
    public static void Main() {
        Video video1 = new Video("Doom gameplay - Part1 ",59.54f,"The first episode of Doom Ethernal on this channel!",null);
        Video video2 = new Video("Learning Brainfuck in 5 min ",5.00f,"A new video who teach its viewers how to code using Brainfuck in just 5 minutes!?!??",null);

        Book book1 = new Book("Poezii","Mihai Eminescu","Steaua Nordului",2004);
        Book book2 = new Book("Dream or reality","Marsel Abari","The shinny eye",2019);

        Newspaper newspaper1 = new Newspaper("Future hazards",null,"Sima's Pappers");
        Newspaper newspaper2 = new Newspaper("Why there will never be another Nobel prize?",null,"Chaotic News");

        testLibraryClass(video1, video2, book1, book2, newspaper1, newspaper2);
        System.out.println();
        testGenericLibraryClass(video1, video2, book1, book2, newspaper1, newspaper2);
        System.out.println();
    }

    private static void testLibraryClass(Video video1, Video video2, Book book1, Book book2, Newspaper newspaper1, Newspaper newspaper2) {
        //Testing Library class
        System.out.println("========Library class tests========");
        Library mediaLibrary = new Library();
        System.out.println("Insert new media piece...");
        mediaLibrary.addMedia(video1);
        System.out.println("Insert new media piece...");
        mediaLibrary.addMedia(video2);
        System.out.println("Insert new media piece...");
        mediaLibrary.addMedia(newspaper1);

        retrieveLastMediaPiece(mediaLibrary);
        System.out.println("Insert new media piece...");
        mediaLibrary.addMedia(newspaper2);
        retrieveLastMediaPiece(mediaLibrary);
        retrieveLastMediaPiece(mediaLibrary);
        retrieveLastMediaPiece(mediaLibrary);
        System.out.println("Insert new media piece...");
        mediaLibrary.addMedia(book1);
        System.out.println("Insert new media piece...");
        mediaLibrary.addMedia(book2);
        retrieveLastMediaPiece(mediaLibrary);
        retrieveLastMediaPiece(mediaLibrary);
        retrieveLastMediaPiece(mediaLibrary);
    }
    private static void testGenericLibraryClass(Video video1, Video video2, Book book1, Book book2, Newspaper newspaper1, Newspaper newspaper2) {
        //Testing GenericLibrary class
        System.out.println("========GenericLibrary class tests========");
        GenericLibrary<Media> mediaLibrary = new GenericLibrary<>();
        System.out.println("Insert new media piece...");
        mediaLibrary.addMedia(video1);
        System.out.println("Insert new media piece...");
        mediaLibrary.addMedia(video2);
        System.out.println("Insert new media piece...");
        mediaLibrary.addMedia(newspaper1);

        retrieveLastMediaPiece(mediaLibrary);
        System.out.println("Insert new media piece...");
        mediaLibrary.addMedia(newspaper2);
        retrieveLastMediaPiece(mediaLibrary);
        retrieveLastMediaPiece(mediaLibrary);
        retrieveLastMediaPiece(mediaLibrary);
        System.out.println("Insert new media piece...");
        mediaLibrary.addMedia(book1);
        System.out.println("Insert new media piece...");
        mediaLibrary.addMedia(book2);
        retrieveLastMediaPiece(mediaLibrary);
        retrieveLastMediaPiece(mediaLibrary);
        retrieveLastMediaPiece(mediaLibrary);
    }

    private static void retrieveLastMediaPiece(Library mediaLibrary) {
        System.out.println("Retrieve last media piece...");
        Media media = mediaLibrary.retrieveLast();
        System.out.println("Media piece retrieved: "+media);
    }
    private static void retrieveLastMediaPiece(GenericLibrary<?> mediaLibrary) {
        System.out.println("Retrieve last media piece...");
        Media media = mediaLibrary.retrieveLast();
        System.out.println("Media piece retrieved: "+media);
    }
}
