package Generics.Example1;

import Generics.Example1.Media.Media;

import java.util.ArrayList;
import java.util.List;

public class GenericLibrary<T extends Media> {
    private List<T> resources = new ArrayList();
    public void addMedia( T element) {
        resources.add(element);
    }
    public T retrieveLast() {
        if(resources.isEmpty()){
            return null;
        }
        T lastResource =  resources.get(resources.size()-1);
        resources.remove(lastResource);
        return lastResource;
    }

}