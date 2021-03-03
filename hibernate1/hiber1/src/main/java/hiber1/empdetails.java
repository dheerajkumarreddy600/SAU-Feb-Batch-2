package hiber1;




public class empdetails {
	
	private int id;
	 private int salary ,age;
	    private String firstName, lastName, designation,dob;
	    
				
		public int getSalary() {
			return salary;
		}
		public void setSalary(int salary) {
			this.salary = salary;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getDesignation() {
			return designation;
		}
		public void setDesignation(String designation) {
			this.designation = designation;
		}
		public String getDob() {
			return dob;
		}
		public void setDob(String dob) {
			this.dob = dob;
		}
		@Override
		public String toString() {
			return "empdetails [salary=" + salary + ", id=" + id + ", age=" + age + ", firstName=" + firstName
					+ ", lastName=" + lastName + ", designation=" + designation + ", dob=" + dob + "]";
		}
	    
}
