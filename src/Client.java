class Client
{
	private final String ID;
	private String firstname;
	private String lastname;
	private int age;
	private String sex;
	private String address;

	public Client (String id, String fn, String ln, int a, String s, String add) {
		this.ID = id;
		firstname = fn;
		lastname = ln;
		age = a;
		sex = s;
		address = add;
	}

	public String getId() {
		return(ID);
	}

	public void setFirstName(String fname) {
		firstname = fname;
	}

	public String getFirstName() {
		return(firstname);
	}

	public void setLastName(String lname) {
		lastname = lname;
	}

	public String getLastName() {
		return(lastname);
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return(age);
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSex() {
		return(sex);
	}

	public void setAddress(String add) {
		address = add;
	}

	public String getAddress() {
		return(address);
	}

	public String toString() {
		return("ID: " + ID + ", Name: " + firstname + " " + lastname + ", Age: " + age + ", Sex: " + sex + ", Address: " + address);
	}

	public String getDetails() {
		return(ID + "@" + firstname + "@" + lastname + "@" + age + "@" + sex + "@" + address + "@client");
	}
}
