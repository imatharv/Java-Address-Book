import java.util.*;
import java.io.*;
import java.lang.*;

public class Function {

    ArrayList<Person> records = new ArrayList<Person>();

    public void addPerson(String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber){
        Person personObj = new Person(firstName, lastName, phoneNumber, address, city, state, zip);
        int result = personObj.findPhoneNo(records,phoneNumber);
        if (result != -1) {
            System.out.println("The address book already has details with " + phoneNumber + " this phone number.");
        } else {
            records.add(personObj);
            System.out.println();
            System.out.println("Information added successfully.\n");
        }
    }
    public static int findIndex(ArrayList<Person> records, String fname, String lname) {
        for(int i=0; i<records.size(); i++) {
            String f = records.get(i).getFname();
            String l = records.get(i).getLname();
            if( f.equals(fname) && l.equals(lname) ) {
                return i;
            }
        }
        return -1;
    }
    public void editPerson(String value, String option, int index){
        Person personObj = records.get(index);
        if(option == "a") {
            personObj.setAddress(value);
        } else if(option == "c") {
            personObj.setCity(value);
        } else if(option == "s") {
            personObj.setState(value);
        } else if(option == "p") {
            personObj.setPhoneNumber(value);
        } else if(option == "z") {
            personObj.setPin(value);
        }
        records.set(index, personObj);
    }
    public void displayAll(ArrayList<Person> arr) {
        boolean isEmpty = arr.isEmpty();
        if(isEmpty == true) {
            System.out.println("No record(s) found \n");
        } else {
            System.out.println(arr);
            System.out.println();
        }	
    }
}