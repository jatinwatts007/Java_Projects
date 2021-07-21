import java.util.Scanner;

public class email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private int mailBoxCapacity=500;
	private String alternateEmail;
	private int defaultLength=10;
	private String Email;
	
	public email(String firstName,String lastName) {
		this.firstName= firstName;
		this.lastName= lastName;
		this.department=setDepartment();
		//System.out.println("Your Department: "+ this.department);
		this.password = randomPassword(this.defaultLength);
		//System.out.println("Your Password: "+ this.password);
		this.Email = this.firstName + "." + this.lastName + "." + this.department + "@gmail.com";
	}
	
	private String setDepartment() {
		System.out.print("Department Code\nEnter the department\n1 for Sales\n2 for development\n3 for Accounting\n0 for none\nEnter code : ");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		if(id == 1 ) {
			return "sales";
		}else {
			if(id==2) {
				return "development";
			}else {
				if(id==3) {
					return "accounts";
				}else return "";
			}
		}
	}
	
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password = new char [length];
		for(int i=0;i<length;i++)
		{
			int rand = (int)(Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}

	public String getAlternateEmail() {
		return alternateEmail;
	}

	public void setAlternateEmail(String alternateEmail) {
		this.alternateEmail = alternateEmail;
	}

	public int getMailBoxCapacity() {
		return mailBoxCapacity;
	}

	public void setMailBoxCapacity(int mailBoxCapacity) {
		this.mailBoxCapacity = mailBoxCapacity;
	}
	
	public String showInfo()
	{
		return " FirstName: " + this.firstName +
				"\n LastName: " + this.lastName +
				"\n Department: " + this.department +
				"\n Email: " + this.Email +
				"\n Password: "+this.password +
				"\n MailBoxCapacity: "+this.mailBoxCapacity+"mb";
	}
	
	
	
}
