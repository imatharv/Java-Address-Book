import java.util.*;
import java.io.*;
import java.lang.*;

public class Function {

    ArrayList<Person> records = new ArrayList<Person>();
    HashMap<String, ArrayList<Person>> addressBooks = new HashMap<String, ArrayList<Person>>();

    //PersonOprations
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
    public void deletePerson(String fname, String lname) {
        int size = records.size();
        for (int i=0; i<size; i++) {
            String f = records.get(i).getFname();
            String l = records.get(i).getLname();
            if(f.equals(fname) && l.equals(lname)) {
                records.remove(i);
                break;
            }
        }
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

    //AddressBookOperations
    public void createBook(String bookName, HashMap<String, ArrayList<Person>> addressBooks) {
        if(addressBooks.containsKey(bookName)) {
            System.out.println("Address book with the same name already exist.");
            System.out.println("Provide different name: ");
            bookName = scanner.nextLine();
            addressBookCheck(bookName);
        }
        else
            addressBooks.put(bookName, new ArrayList<Person>());
    }
    public void displayAddressBooks(HashMap<String, ArrayList<Person>> addressBooks) {
        boolean is_Empty=addressBooks.isEmpty();
        if(is_Empty == true) {
            System.out.println("No record(s) found.");
            break;
        }
        else {
            System.out.println(addressBooks);
            System.out.println();
        }
    }
    public int addressBookCheck(HashMap<String, ArrayList<Person>> addressBooks, String addressBookName) {
        if(addressBooks.containsKey(addressBookName))
            return 1;
        else
            return 0;
    }
    public void editAddressBook(HashMap<String, ArrayList<Person>> addressBooks, String addressBookName) {
        ArrayList<Person> records = addressBooks.get(addressBookName);
    }
}