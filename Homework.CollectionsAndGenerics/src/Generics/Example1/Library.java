package Generics.Example1;

import Generics.Example1.Media.Media;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List resources = new ArrayList(); // no generics are user
    public void addMedia( Media element) { // what should be the type of element in order to meet all three media types (book, video, and newspaper)
        resources.add(element);
    }
    public Media retrieveLast() {
        if(resources.isEmpty()){
            return null;
        }
        Media lastResource =  (Media)resources.get(resources.size()-1);
        resources.remove(lastResource);
        return lastResource;
    }

    /*how should book, video, and newspaper classes look like? What will they have in common? */
}

/*add the generics version */
