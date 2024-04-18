/**
 * 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;
/**
 * @author Hannes Nilsson
 */
public class StudentRoster {
	
	private Scanner scnr = new Scanner(System.in).useLocale(Locale.ROOT);
	private final int NR_STUDENTS = 5;
	private Student[] sAr;
	private String f;
	private String l;
	private Double gpa;
	private String grade;
	private String c;
	private String h;
	private String p;
	private String r;
	
	public StudentRoster() {
		sAr = new Student[NR_STUDENTS];
			for (int i = 0;i<NR_STUDENTS;i++) {
				sAr[i] = new Student();
			}
		}
	
	public void addStudent(int i) {
		
		System.out.println("Enter first name: ");
		f = scnr.next();
		System.out.println("Enter last name: ");	
		l = scnr.next();
		sAr[i].setName(f,l); 
		
		System.out.println("Enter grade point average: ");
		
		try {
			gpa = scnr.nextDouble();
			sAr[i].setGpa(gpa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Not a number. Please enter a number for grade point average: ");
			gpa = scnr.nextDouble();
		}
		sAr[i].setGpa(gpa);
		
		System.out.println("Enter current address: ");
		scnr.nextLine();
		c = scnr.nextLine();
		System.out.println("Enter home address: ");
		h = scnr.nextLine();
		sAr[i].setCurrent(c);
		sAr[i].setHome(h);
		
		System.out.println("Enter phone number: ");
		p = scnr.nextLine();
		sAr[i].setPhone(p);
		
		System.out.println("Successfully added student "+sAr[i].getName()+"!");
		
		sAr[i].setStatus(true);
	}
	
	public String roster() {
		r = "";
		Integer n = 0;
		
		for (int i = 0;i<NR_STUDENTS;i++) {
			if (sAr[i].status == true) {
				 n++;
				}
			if (sAr[i].status == true) {
			 r += sAr[i].toString();
			}
		}

		return n.toString()+"\n"+r;
	}
	
	public String returnRoster() {
		String r = "";
		for (int i = 0;i<studentsEntered();i++) {
			if (sAr[i].getStatus() == true) {
			r += "Name: "+sAr[i].getName()+"\n"+"gpa: "+sAr[i].getGpa().toString()+"\n"+"Current address: "+sAr[i].getCurrent()+"\n"+"Home address: "+sAr[i].getHome()+"\n"+"Phone number: "+sAr[i].getPhone()+"\n\n";
			}
		}
		return r;
	}
	
	public void search(String s) {
		int val = 0;
		for (int i = 0;i<NR_STUDENTS;i++) {
			 if (sAr[i].getName().equals(s)) {
				 System.out.println("Name: "+sAr[i].getName()+"\n"+"gpa: "+sAr[i].getGpa().toString()+"\n"+"Current address: "+sAr[i].getCurrent()+"\n"+"Home address: "+sAr[i].getHome()+"\n"+"Phone number: "+sAr[i].getPhone()+"\n");
				 val = 1;
			 }
		}
		if (val == 0) {
			System.out.println("Student not found");
		}
	}
	
	public void readDisk(int n) {
		Scanner scnr;
		
		File file = new File("rosterOutput.txt");
		try {
			scnr = new Scanner(file);
			for (int i = 0;i<n;i++) {
				scnr.nextLine();
				f = scnr.nextLine();
				l = scnr.nextLine();;
				grade = scnr.nextLine();
				c = scnr.nextLine();
				h = scnr.nextLine();
				p = scnr.nextLine();
				gpa = Double.parseDouble(grade);
				sAr[i].setName(f, l);
				sAr[i].setGpa(gpa);
				sAr[i].setCurrent(c);
				sAr[i].setHome(h);
				sAr[i].setPhone(p);
				sAr[i].setStatus(true);
			}
			System.out.println("Successfully loaded roster from disk!\n");
			scnr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("An error occured");
		}
	}
	
	public int studentsEntered() {
		int n = 0;
		Scanner scnr;
		
		File file = new File("rosterOutput.txt");
		try {
			scnr = new Scanner(file);
			n = scnr.nextInt();
			scnr.close();
			return n;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return n;
	}
	
	public void writeDisk() {
			
		File file = new File("rosterOutput.txt");
		
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("Error. File not created");
				}
			}
			
			PrintWriter print;
			try {
				print = new PrintWriter(file);
				print.printf(roster());
				print.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		
	} 
}
