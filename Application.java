/**
 * 
 */
import java.util.Scanner;
/**
 * @author Hannes Nilsson
 */
public class Application {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scnr = new Scanner(System.in);
		StudentRoster roster = new StudentRoster();
		String search = "";
		
		int n = 0;
		while(n < 5) {
			int i = 0;
			System.out.println("Press 1 to enter student\nPress 2 to print roster\nPress 3 to do a student search\nPress 4 to read roster from disk\nPress 5 to quit program");
			i = scnr.nextInt();
			if (i == 1) {
				roster.addStudent(n);
				roster.writeDisk();
				i = 0;
				n++;
				}
			else if (i == 2) {
				System.out.print(roster.returnRoster());
				i = 0;
			}
			else if (i == 3) {
				System.out.println("Enter the name (First and last) of the student you want information from: ");
				scnr.nextLine();
				search = scnr.nextLine();
				roster.search(search);
			}
			else if(i == 4) {
				roster.readDisk(roster.studentsEntered());
				n = roster.studentsEntered();
			}
			else if (i == 5) {
				System.out.println("\nQuitting Program\n");
				System.exit(0);
			}
			else {
				
			}
		}
		int i = 0;
		while (i == 0) {
			System.out.println("Roster Full!\nPress 2 to print roster\nPress 3 to do a student search\nPress 4 to read roster from disk\nPress 5 to quit program");
			i = scnr.nextInt();
			if (i == 2) {
				System.out.print(roster.returnRoster());
				i = 0;
			}
			else if (i == 3) {
				System.out.println("Enter the name (First and last) of the student you want information from: ");
				scnr.nextLine();
				search = scnr.nextLine();
				roster.search(search);
				i = 0;
			}
			else if(i == 4) {
				roster.readDisk(roster.studentsEntered());
				i = 0;
			}
			else if (i == 5) {
				System.out.println("\nQuitting Program\n");
				System.exit(0);
			}
			else {
				i = 0;
			}
		}
		scnr.close();
	}

}
