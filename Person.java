import java.util.*;
import java.io.*;
import java.lang.*;

public class Person {
    private final String firstName; // Can't be edited so private and final
    private final String lastName; // Can't be edited so private and final
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private String zip;

    public Person(String firstName, String lastName, String phoneNumber, String address, String city, String state, String zip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getFname() {
        return this.firstName;
    }

    public String getLname() {
        return this.lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPin() {
        return zip;
    }

    public void setPin(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return '\n'+ "First name: " + firstName +'\n'+ "Last name: " + lastName +'\n'+ "Phone number: " + phoneNumber +'\n'+ "Address: " + address +'\n'+ "City: " + city +'\n'+ "State: " + state +'\n'+ "zip: " + zip ;
    }

    public static int findPhoneNo(ArrayList<Person> records, String phoneNumber) {
        for(int i=0; i<records.size(); i++) {
            if(records.get(i).getPhoneNumber().equals(phoneNumber)) {
                return i;
            }
        }
        return -1;
    }
}