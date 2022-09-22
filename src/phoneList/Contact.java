package phoneList;

/*
 * This contains info for a single contact
 * 
 * Parameters Needed to Store
 *   - Contact's Name
 *   - Contact's Phone Number
 *   
 * Needed Methods
 *   - Constructor(s)
 *   - getter methods
 *   - Setter methods not necessary unless Constructor
 *        initialize variables.
 *   - Override toString() so that Contact can
 *        be printed as part of a list.
 * 
 */



public class Contact {
	//the two data points that will be in the contact
	private String name;
	private String number;
	
	//making my constructor
	public Contact(String nameSent,String numberSent) {
		this.name = nameSent;
		this.number = numberSent;
	}
	
	//making getters
	public String getName() {
		return name;
	}
	public String getNumber() {
		return number;
	}
	//making it so I can do to string
	public String toString() {
		
		return name +"-"+ number ;
	}
	
	
	

}
	
