package com.work;

import java.util.Comparator;

public class CompareCity implements Comparator<Person> {
    @Override
    public int compare(Person object1, Person object2) {
        return object1.getCity().compareTo(object2.getCity());
    } 
}
