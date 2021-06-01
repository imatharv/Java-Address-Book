package com.work;

import java.util.Comparator;

public class CompareZip implements Comparator<Person> {
    @Override
    public int compare(Person object1, Person object2) {
        return object1.getPin().compareTo(object2.getPin());
    }
}
