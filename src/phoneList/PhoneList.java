package phoneList;

import java.util.ArrayList;
import java.util.Collections;

import java.util.Scanner;

/*
 * Phone List
 * 
 * You'll be using an ArrayList of Contact objects
 * to crate a digital address book.
 * 
 * You MUST
 *   - Use an ArrayList
 *   - Keep list in alphabetical order
 *   - Complete the 
 *   
 * You May
 *   - Add methods as you see fit
 *   - Change method parameters and return types
 *   
 * You May NOT
 *   - change the menu method
 *        unless you're changing what methods it calls
 * 
 */

public class PhoneList {

	/*
	 * Instance Variables
	 */
	private ArrayList<Contact> contacts = new ArrayList<Contact>();

	// Constructor
	public PhoneList() {

	}

	/*
	 * This should do the following (whatever order you feel is best) - ask the user
	 * for contact's name and number - create a new Contact object with that input -
	 * add that object to the phone list in alphabetical order Hint:
	 * compareTo(String other) - tell the user what the new contact is and that it's
	 * been added
	 */
	public void addContact() {

		String uName = getString("Name?");

		String uNumber = getString("Number?");
		// putting the contact in alphabetical order
		Contact xx = new Contact(uName, uNumber);
		int i = 0;
		boolean stop = false;
		boolean gone = false;
		if (contacts.size() != 0) {
			while (i < contacts.size() && !stop) {
				gone = true;
				System.out.println("works");
				if (contacts.get(i).getName().compareToIgnoreCase(xx.getName()) > 0) {
					contacts.add(i, xx);
					stop = true;
				}
				i++;
			}
		} else {
			contacts.add(xx);
		}
		if (false == stop && gone == true) {
			contacts.add(xx);
		}
	}

	/*
	 * This should do the following (whatever order you feel is best) - ask the user
	 * for the contact's name - search through the list for that contact - if the
	 * contact is not found tell the user and end the method - if the contact is
	 * found Remove the item from the list Print the contact's name and number Say
	 * that contact has been removed Remove the item from the list
	 * 
	 */
	public void removeContact() {

		String lookingFor = getString("Name of the contact to remove? ");
		// making a loop to look for the name in contacts
		boolean found = false;
		for (int i = 0; i < contacts.size(); i++) {
			if (lookingFor.equalsIgnoreCase(contacts.get(i).getName())) {
				System.out.println("removed: " + contacts.get(i).getName() + " " + contacts.get(i).getNumber());
				contacts.remove(i);
				found = true;
//stops loop imediatl;y
				break;

			}
		}
		//making it where if not found it prints this
		if (found = false) {
			System.out.println("Contact could not be found.");
		}

	}

	/*
	 * This should - Print all items in list - Must be headers for all columns -
	 * print in alphabetical order - print line of something to "box" the list
	 * Examples: ***************** ----------------- #################
	 */
	public void printList(ArrayList<Contact> contacts) {
		System.out.println();
		for (int i = 0; i < contacts.size(); i++) {
			System.out.println(contacts.get(i));
		}
	}

	/*
	 * GET FAMILIAR WITH THIS MENU!!!!
	 * 
	 * I will be asking you to create programs with menus. You may do them however
	 * you like. But here is an example of how to manage them.
	 * 
	 */
	public void menu() {

		int input = 0;

		String menu = "-----------------------\n" + "     Contacts Menu     \n" + "-----------------------\n"
				+ "  1 - Add Contact      \n" + "  2 - Remove Contact   \n" + "  3 - Print List       \n"
				+ "  4 - Quit             \n\n" + "Enter Choice: ";

		while (input != 4) { // keep looping till user want's to quit

			// try getting an input
			try {
				String inputString = getString("\n" + menu); // get input
				input = Integer.valueOf(inputString); // try converting to int
			} catch (Exception e) {
				// if bad input, set input to 0
				input = 0;
			}

			switch (input) {
			case 1:
				// handle menu line 1: Add Contact
				addContact();
				break;
			case 2:
				// handle menu line 2: Remove Contact
				removeContact();
				break;
			case 3:
				// handle menu line 3: Print List
				printList(contacts);
				break;
			case 4:
				// handle menu line 4: Quit
				System.out.println("\nGoodbye!");
				break;
			default:
				System.out.println("\nNot a valid input.\n" + "Please try again.");
			}

		}

	}

	public String getString(String str) {

		Scanner inKey = new Scanner(System.in);
		System.out.print(str); // notice it's NOT a print line. This way input is next to question.
		return inKey.nextLine();

	}

	public static void main(String[] args) {
		PhoneList app = new PhoneList();
		app.menu();
	}
}
