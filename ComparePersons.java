package com.work;

import java.util.Comparator;

class ComparePersons implements Comparator<Person> {
    @Override
    public int compare(Person object1, Person object2) {
        return object1.getFname().compareTo(object2.getFname());
    }
}