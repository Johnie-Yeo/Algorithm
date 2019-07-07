package Step3Sorting;

import java.util.Comparator;

public class Person {
	private String name;
	private String company;
	private String address;
	private String zipcode;
	private String phone;
	private String email;
	
	public Person(String name, String company, String address,
					String zipcode, String phone, String email ) {
		this.name = name;
		this.company = company;
		this.address = address;
		this.zipcode = zipcode;
		this.phone = phone;
		this.email = email;
	}
	public String toString() {
		String result = name +
						"\n\tCompany: " + company +
						"\n\tAddress: " + address +
						"\n\tZipcode: " + zipcode +
						"\n\tPhones : " + phone +
						"\n\tEmal   : " + email;
		return result;				
	}
	public static Comparator<Person> nameComparator = new Comparator<Person>() {
		public int compare(Person p1, Person p2) {
			return p1.name.compareTo(p2.name);
		}
	};
	public static Comparator<Person> companyComparator = new Comparator<Person>() {
		public int compare(Person p1, Person p2) {
			return p1.company.compareTo(p2.company);
		}
	};
	public static Comparator<Person> addressComparator = new Comparator<Person>() {
		public int compare(Person p1, Person p2) {
			return p1.address.compareTo(p2.address);
		}
	};
	public static Comparator<Person> zipcodeComparator = new Comparator<Person>() {
		public int compare(Person p1, Person p2) {
			return p1.zipcode.compareTo(p2.zipcode);
		}
	};
	public static Comparator<Person> phoneComparator = new Comparator<Person>() {
		public int compare(Person p1, Person p2) {
			return p1.phone.compareTo(p2.phone);
		}
	};
	public static Comparator<Person> emailComparator = new Comparator<Person>() {
		public int compare(Person p1, Person p2) {
			return p1.email.compareTo(p2.email);
		}
	};
}
