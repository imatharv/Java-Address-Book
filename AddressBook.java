import java.util.*;
import java.io.*;
import java.lang.*;

public class AddressBook extends Function {
    public void displayOptions() {
        HashMap<String, ArrayList<Person>> addressBooks = new HashMap<String, ArrayList<Person>>();
        Scanner scanner = new Scanner(System.in);
        int option;
        int outerFlag = 0;
        while(outerFlag == 0) {
            System.out.println("Select from the following options:");
            System.out.println("1 for create new address book");
            System.out.println("2 for display all address books");
            System.out.println("3 for edit person details in address book");
            System.out.println("4 for delete an address book");
            System.out.println("5 for search in address books by city");
            System.out.println("6 for search in address books by state");
            System.out.println("7 for count contacts in address books by city");
            System.out.println("8 for count contacts in address books by state");
            System.out.println("0 for exit");
            System.out.println("Enter your choice: ");
            option = scanner.nextInt(); 
            switch(option) {
                case 1: 
                    System.out.println("Creating a new address book..");
                    System.out.println("Please provide the name for the address book: ");
                    scanner.nextLine();
                    String bookName = scanner.nextLine();
                    createBook(bookName, addressBooks);
                    break;

                case 2: 
                    System.out.println("Displaying all address book(s)..");
                    displayAllAddressBooks(addressBooks);
                    System.out.println("Name of address books you want view information in: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();

                    if(addressBooks.containsKey(name)) {
                        ArrayList<Person> records = addressBooks.get(name);
                    }
                    else {
                        System.out.println("Incorrect name entered.");
                        break;
                    }

                    displayAll(records);
                    break;

                case 3:
                    System.out.println("Editing records in the address book..");
                    System.out.println("Displaying all address books");
                    displayAllAddressBooks(addressBooks);
                    System.out.println("Select from the address books list,");
                    System.out.println("Name of address books you want to alter information in: ");
                    scanner.nextLine();
                    String addressBookName = scanner.nextLine();
                    if(addressBookCheck(addressBooks, addressBookName)!=1) {
                        System.out.println("No record(s) found.");
                        break;
                    }
                    
                    int choice;
                    int innerflag = 0;
                    while(innerflag == 0) {
                        System.out.println("Select from the following options:");
                        System.out.println("1 for add new person details in the address book");
                        System.out.println("2 for display list of persons in address book");
                        System.out.println("3 for edit person details in address book");
                        System.out.println("4 for delete a person in address book");
                        System.out.println("0 for exit");
                        System.out.println("Enter your choice: ");
                        choice = scanner.nextInt(); 
                        switch (choice) {
                            case 1:
                                scanner.nextLine();
                                System.out.println("Enter first name: ");
                                String var1 = scanner.nextLine();
                                System.out.println("Enter last name: ");
                                String var2 = scanner.nextLine();
                                System.out.println("Enter address: ");
                                String var3 = scanner.nextLine();
                                System.out.println("Enter city: ");
                                String var4 = scanner.nextLine();
                                System.out.println("Enter state: ");
                                String var5 = scanner.nextLine();
                                System.out.println("Enter pin: ");
                                String var6 = scanner.nextLine();
                                System.out.println("Enter phone no: ");
                                String var7 = scanner.nextLine();
                                addPerson(var1, var2, var3, var4, var5, var6, var7);
                                break;

                            case 2:
                                displayAll(records);
                                break;

                            case 3:
                                scanner.nextLine();
                                System.out.println("Enter first name: ");
                                String fn = scanner.nextLine();
                                System.out.println("Enter last name: ");
                                String ln = scanner.nextLine();

                                int index = findIndex(records, fn, ln);
                                if(index == -1) {
                                    System.out.println("Record not found!");
                                    break;
                                }

                                int ch = 0;
                                while(ch != 6) {
                                    System.out.println("Select from the following options for editing:");
                                    System.out.println("1 for edit address");
                                    System.out.println("2 for edit state");
                                    System.out.println("3 for edit city");
                                    System.out.println("4 for edit pin");
                                    System.out.println("5 for edit phone number");
                                    System.out.println("6 for exit");
                                    System.out.println("Enter choice your: ");

                                    ch = scanner.nextInt();
                                    scanner.nextLine();
                                    switch(ch) {
                                        case 1:
                                            System.out.println("Enter address: ");
                                            var3 = scanner.nextLine(); 
                                            editPerson(var3, "a", index);
                                            break;
                                        case 2:
                                            System.out.println("Enter state: ");
                                            var3 = scanner.nextLine(); 
                                            editPerson(var3, "s", index);
                                            break;
                                        case 3:
                                            System.out.println("Enter city: ");
                                            var3 = scanner.nextLine(); 
                                            editPerson(var3, "c", index);
                                            break;
                                        case 4:
                                            System.out.println("Enter pin: ");
                                            var6 = scanner.nextLine();
                                            editPerson(var6, "z", index);
                                            break;
                                        case 5:
                                            System.out.println("Enter phone no: ");
                                            var3 = scanner.nextLine(); 
                                            editPerson(var3, "p",index);
                                            break;
                                        case 6:
                                            System.out.println("Information edited successfully.");
                                            break;
                                        default:
                                            System.out.println("Invalid choice.");
                                            break;
                                    }
                                }
                                break;

                            case 4: 
                                scanner.nextLine();
                                System.out.println("Enter first name: ");
                                String first = scanner.nextLine();
                                System.out.println("Enter last name: ");
                                String last = scanner.nextLine();

                                int indx = findIndex(records, first, last);
                                if(indx == -1) {
                                    System.out.println("Record not found!");
                                    break;
                                }
                                deletePerson(first, last);
                                System.out.println("Record successfully deleted.");
                                break;

                            case 0:
                                innerflag = 1;
                                break;

                            default:
                                System.out.println("Invalid choice.");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Deleting the address book..");
                    System.out.println("Displaying all address books");
                    displayAllAddressBooks(addressBooks);
                    System.out.println("Select from the address books list,");
                    System.out.println("Name of address books you want to delete: ");
                    scanner.nextLine();
                    String addressBookNameD = scanner.nextLine();

                    break; 
                
                case 5: 
                    System.out.println("Searching by city..");
                    System.out.println("Name of address books you want to search information in: ");
                    scanner.nextLine();
                    String addressBookNameS = scanner.nextLine();
                    if(addressBookCheck(addressBooks, addressBookNameS)!=1) {
                        System.out.println("No record(s) found.");
                        break;
                    }
                    else {
                        List<Person> person = addressBooks.get(addressBookNameS);
                        viewByCity(person);
                        break;
                    }
                
                case 6: 
                    System.out.println("Searching by state..");
                    System.out.println("Name of address books you want to search information in: ");
                    scanner.nextLine();
                    String addressBookNamee = scanner.nextLine();
                    if(addressBookCheck(addressBooks, addressBookNamee)!=1) {
                        System.out.println("No record(s) found.");
                        break;
                    } 
                    else {
                        List<Person> person = addressBooks.get(addressBookNamee);
                        viewByState(person);
                        break;
                    } 

                case 7: 
                    System.out.println("Counting by city..");
                    System.out.println("Name of address books you want to count information in: ");
                    scanner.nextLine();
                    String addressBName = scanner.nextLine();
                    if(addressBookCheck(addressBooks, addressBName)!=1) {
                        System.out.println("No record(s) found.");
                        break;
                    } 
                    else {
                        List<Person> person = addressBooks.get(addressBName);
                        countByCity(person);
                        break;
                    }

                case 8: 
                    System.out.println("Counting by state..");
                    System.out.println("Name of address books you want to count information in: ");
                    scanner.nextLine();
                    String addressBkName = scanner.nextLine();
                    if(addressBookCheck(addressBooks, addressBkName)!=1) {
                        System.out.println("No record(s) found.");
                        break;
                    } 
                    else {
                        List<Person> person = addressBooks.get(addressBkName);
                        countByState(person);
                        break;
                    }          

                case 0:
                    outerFlag = 1;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("Welcome to the Address Book");
        AddressBook object = new AddressBook();
        object.displayOptions();
    }
}