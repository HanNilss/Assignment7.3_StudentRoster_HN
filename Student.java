/**
 * 
 */

/**
 * @author Hannes Nilsson
 */
public class Student {

		private String firstName;
		private String lastName;
		private Double gpa; 
		private String currAddress;
		private String homeAddress;
		private String phone;
		public boolean status;
		
		public Student() {
			status = false;
			firstName = "John";
			lastName = "Doe";
			gpa = 0.0;
			currAddress = "No Address";
			homeAddress = "No Address";
			phone = "(000)000-00-00";
		}
		
		public void setName (String fn, String ln) {
			firstName = fn;
			lastName = ln;
		}
		
		public String getFirst() {
			return firstName;
		}
		
		public String getLast() {
			return lastName;
		}
		
		public String getName() {
			return firstName+" "+lastName;
		}
		
		public void setGpa(Double grade) {
			gpa = grade;
		}
		
		public Double getGpa() {
			return gpa;
		}
		
		public void setCurrent (String ca) {
			currAddress = ca;
		}
		
		public String getCurrent () {
			return currAddress;
		}
		
		public void setHome (String ha) {
			homeAddress = ha;
		}
		
		public String getHome () {
			return homeAddress;
		}
		
		public void setPhone(String p) {
			phone = p;
		}
		
		public String getPhone() {
			return phone;
		}
		
		public void setStatus(boolean s) {
			status = s;
		}
		
		public boolean getStatus() {
			return status;
		}
		
		public String toString() {
			return getFirst()+"\n"+getLast()+"\n"+getGpa().toString()+"\n"+getCurrent()+"\n"+getHome()+"\n"+getPhone()+"\n\n";
		}
}
