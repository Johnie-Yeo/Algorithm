package Step3Sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ContactInfo {
	ArrayList<Person> person;
	Scanner kb;
	
	private void readFile() {
		String line;
		String []info;
		try {
			Scanner in = new Scanner(new File("Sample.txt"));
			person = new ArrayList<Person>();
			while(in.hasNextLine()) {
				line = in.nextLine();
				info = line.split("\\|");
				for(String tmp : info)
					tmp.trim();
				person.add(new Person(info[0], info[1], info[2], info[3], info[4], info[5]));
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("No File");
		}
	}
	private void printData() {
		for(Person p : person)
			System.out.println(p.toString());
	}
	private void sortData() {
		String by, comp;
		by = kb.next();
		if(!by.equals("by")) {
			System.out.println("Error");
			return;
		}
		comp = kb.next();
		if(comp.equals("name"))
			Collections.sort(person, Person.nameComparator);
		else if(comp.equals("company"))
			Collections.sort(person, Person.companyComparator);
		else if(comp.equals("address"))
			Collections.sort(person, Person.addressComparator);
		else if(comp.equals("zipcode"))
			Collections.sort(person, Person.zipcodeComparator);
		else if(comp.equals("phone"))
			Collections.sort(person, Person.phoneComparator);
		else if(comp.equals("email"))
			Collections.sort(person, Person.emailComparator);
		else {
			System.out.println("Error");
			return;
		}
	}
	private void processCommand() {
		String command;
		kb = new Scanner(System.in);
		while(true) {
			System.out.print("$ ");
			command = kb.next();
			if(command.equals("read"))
				readFile();
			else if(command.equals("sort"))
				sortData();
			else if(command.equals("print"))
				printData();
			else if(command.equals("exit"))
				break;
			else
				System.out.println("Wrong command");
		}
		kb.close();
	}
	
	
	public static void main(String[] args) {
		ContactInfo app = new ContactInfo();
		app.processCommand();
	}
}
