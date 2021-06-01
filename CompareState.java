package com.work;

import java.util.Comparator;

public class CompareState implements Comparator<Person> {
    @Override
    public int compare(Person object1, Person object2) {
        return object1.getState().compareTo(object2.getState());
    }
}
