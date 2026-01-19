package studentmanagement;


import java.util.*;
class person{
	private int id;
	private String name;
	person(int id , String name){
		this.id=id;
		this.name= name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
class Student extends person{
	static List<Student> stud = new ArrayList<>();
	
	private int mark;
	Student(int id, String name, int mark){
		super(id,name);
		this.mark= mark;
		
	}
	
	public String toString() {
		return " Id  : " +getId() +  " \n Name : " +getName() + " \n Mark  :"+mark;
	}
	public static void student(Scanner scan) {
		while(true) {
			System.out.println("Enter your choice \n 1. ADD \n 2. VIEW \n 3. SEARCH \n 4. DELETE \n 5.SORT \n 6. EXIT");
			int choice1= scan.nextInt();
			scan.nextLine();
			switch(choice1) {
			case 1:
				add(scan);
				break;
			case 2:
				view(scan);
				break;
			case 3:
				search(scan);
				break;
			case 4:
				delete(scan);
				break;
			case 5:
				sort(scan);
				break;
			case 6:
			    return;
				default:
					System.out.println("Invalid choice");
			}
		}
	}
	
	
	public static void add(Scanner scan) {
		System.out.println("Enter the student id");
		int id = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter the student name");
		String name = scan.nextLine();
		System.out.println("Enter the student mark");
		int mark = scan.nextInt();
		scan.nextLine();
		stud.add(new Student(id,name,mark));
		System.out.println("ADDED SUCCESSFULLY");
		
		
	}
	public static void view(Scanner scan) {
	      if(stud.isEmpty()) {
	    	  System.out.println("it is empty");
	      }
	      else {
	     
		for(Student s: stud) {
			System.out.println(s);
		}
	      }
	}
	public static void search(Scanner scan) {
		boolean found = false;
		System.out.println("Enter the id");
		int id = scan.nextInt();
		scan.nextLine();
		for(Student s:stud) {
			if(s.getId()==id) {
				System.out.println(s);
				found = true;
			}
		}
		if(!found) {
			System.out.println("The element is not found");
		}
	}
	public static void delete(Scanner scan) {
		System.out.println("Enter the student id");
		int id = scan.nextInt();
		scan.nextLine();
		boolean found = false;
		Iterator<Student> it = stud. iterator();
		while(it.hasNext()) {
			if(it.next().getId()== id) {
				it.remove();
				found = true;
				System.out.println("Element deleted successfully");
				break;
				
			}
		}
		if(!found) {
			System.out.println("No element here");
		}
		
	}
	public static void sort(Scanner scan) {
		Comparator<Student> com =  new Comparator<>() {
			public int compare(Student i , Student j) {
				if(i.getId()>j.getId()) {
					return 1;
					
				}
				else if(i.getId()<j.getId()) {
					return -1;
					
				}
				else {
					return 0;
				}
			
			}
		};
		Collections.sort(stud ,com);
		System.out.println(stud);
	}
	public static void exit() {
		System.out.println("Thanking You");
	}
	
	
}
class Admin extends person{
	static List<Admin> ad = new ArrayList<>();
	Admin( int id, String name ){
		super(id,name);
		
	}
	public static  void admin(Scanner scan) {
		while(true) {
			System.out.println("Enter you choice : \n 1.AddStudent \n 2.ViewStudent \n 3. SearchStudent \n 4.DeleteStudent \n 5.SortStudent \n 6.AddStaff \n 7.ViewStaff \n 8.SearnthStaff \n 9.DeleteStudent \n 10.SortStudent \n 11.Exit");
			int choice = scan.nextInt();
			scan.nextLine();
			switch(choice) {
			case 1:
				Student.add(scan);
				break;
			case 2:
				Student.view(scan);
			   break;
			case 3:
				Student.search(scan);
				break;
			case 4:
				Student.delete(scan);
				break;
			case 5:
				Student.sort(scan);
				break;
			case 6:
				staffadd(scan);
				break;
			case 7:
				viewstaff();
				break;
			case 8:
				searchstaff(scan);
				break;
			case 9:
				deletestaff(scan);
				break;
			case 10:
				sortstaff();
				break;
			case 11:
				Student.exit();
				return;
				default :
					System.out.println("Invalid method");
			}
		}
	}
	
	public static  void staffadd(Scanner scan)
	{
		System.out.println("Enter the staffID: ");
		int id = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter the student name :");
		String name = scan.nextLine();
		ad.add(new Admin(id, name));
		System.out.println("ADDED SUCCESSFULLY");
	}
	public static void viewstaff() {
		if(ad.isEmpty()) {
			System.out.println("There is no element");
		}
		else {
		for(Admin a:ad) {
			System.out.println(a);
		}
		}
	}
	public  static void searchstaff(Scanner scan) {
		boolean found = false;
		System.out.println("Enter the id");
		int id = scan.nextInt();
		scan.nextLine();
		for(Admin a: ad) {
			if(id==a.getId()) {
				System.out.println(a);
				found = true;
			}
		}
		if(!found) {
			System.out.println("The element is not found");
		}
		
	}
	public static  void deletestaff(Scanner scan) {
		System.out.println("Enter the id");
		int id = scan.nextInt();
		scan.nextLine();
		boolean found = false;
		Iterator <Admin> it = ad. iterator();
		while(it.hasNext()) {
			if(it.next().getId()==id) {
				it.remove();
				System.out.println("Element deleted successfully");
				found = true;
				break;
				
			}
		
			
		}
		if(!found) {
			System.out.println("the element is not found");
		}
	}
	public static void sortstaff() {
		Comparator<Admin> com= new Comparator<>() {
			public int compare(Admin i, Admin j) {
				if(i.getId()>j.getId()) {
					return 1;
					
				}else if(i.getId()<j.getId()) {
					return -1;
					
				}
				else {
					return 0;
				}
				
			}
		};
		Collections.sort(ad,com);
		System.out.println(ad);
	}
	public String toString() {
		return "Id   :"   +getId()+  " \nName   :"   +getName();
	}
}

public class Student1 {
    static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter your username : \n 1. Admin \n 2. Staff ");
		int role = scan.nextInt();
		scan.nextLine();
		if(role == 1)
		{
			System.out.println("Enter the password :");
			int password = scan.nextInt();
			scan.nextLine();
			if(password == 123)
			{
				Admin.admin(scan);
				
			}
			else
			{
				System.out.println("Please enter the correct password !");
			}
		}
		else if(role == 2)
		{
			System.out.println("Enter the password :");
			int password1 = scan.nextInt();
			scan.nextLine();
			if(password1 == 1234)
			{
				Student.student(scan);
			}
			else
			{
				System.out.println("Please enter the correct password !");
			}
		}
		else
		{
			System.out.println("Wrong username, Try again !");
		}
		
	}
	
}
