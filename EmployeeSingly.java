import java.util.*;
import java.io.*;

interface Modify
{
	public void modifyID(int id,int eid);
}

class Arithmetic
{
	int bonus;
	int salary;
	int Yrs;
	/*Arithmetic()
	{
		this.bonus=;
		
	}*/
	
	public int Bonus(int sal,int yrs)
	{	
		if(yrs<=3)
		{
			return sal;
		}
		else if(yrs>3&&yrs<6)
		{
			sal=sal+5000;
		}
		else if(yrs>=6&&yrs<9)
		{
			sal=sal+10000;
		}
		else
		{
			sal=sal+25000;
		}
		return sal;
	}
	
	
}


class Employee extends Arithmetic implements Modify
{
	
	class node{
		int Eid;
		String name;
		String PName;
		int sal;
		int age;		
		node next;
		
		
		public node()
		{
			this.next=null;
								
		}
	}
	
	int size=0;
	node head=null;
	Arithmetic aobj=new Arithmetic();
	
	public void Insert(int eid,String name,String pname,int sal,int age,int yrs)
	{
		int newS=0;
		node newn=new node();
		
		newS=aobj.Bonus(sal, yrs);
		
		newn.Eid=eid;
		newn.name=name;
		newn.PName=pname;
		newn.sal=newS;
		newn.age=age;
		newn.next=null;
		boolean bret=false;
		node temp=head;
		
		
		if(head==null)
		{
			
			head=newn;
			
		}
		
		else if(head.next==null)
		{
			bret=ChkIDDuplicate(eid);
			if(bret==true)
			{
				return;
			}
			
			head.next=newn;
		}
		
		else
		{
			while(temp.next!=null)
			{
				temp=temp.next;
			}
			bret=ChkIDDuplicate(eid);
			if(bret==true)
			{
				return;
			}
			temp.next=newn;
						
		}
		size++;
	}
	
	public boolean ChkIDDuplicate(int id)
	{
		node temp=head;
		
		while(temp!=null)
			{
				if(temp.Eid==id)
				{
					System.out.println("Duplicate ID "+temp.Eid+ "found, you can't add this.");
					return true;
				}
				temp=temp.next;
			}
		
		return false;
	}
	
	public void Display()
	{
		node temp=head;
		
		if(head==null)
		{
			System.out.println("No Record found!, enter the records first.");
			
			return;
		}
		else
		{
			while(temp!=null)
			{
				System.out.println("Employee information is: \n");
				System.out.println("Id is: "+temp.Eid);
				System.out.println("Name is: "+temp.name);
				System.out.println("Project name is: "+temp.PName);
				System.out.println("Salary is: "+temp.sal);
				System.out.println("Age is: "+temp.age);
				System.out.println("");
				temp=temp.next;
			}
		}
	}
	
	public void DeleteByID(int eid)
	{
		node temp=head;
		node temp2=null;;
	
		if(head==null)
		{
			System.out.println("No records found ");
			return;
		}
		else
		{
			while(temp!=null)
			{
				if(temp.Eid==eid)
				{
					temp2.next=temp.next;
					temp=null;
					break;
				}
				temp2=temp;
				temp=temp.next;
			}
			
			
		}
		size--;
	}
	
	public void modifyID(int id,int eid)
	{
		
		node temp=head;
		if(head==null)
		{
			System.out.println("No records found ");
			return;
		}
		
		else
		{
			while(temp!=null)
			{
				if(temp.Eid==id)
				{
					
					temp.Eid=eid;
					System.out.println("Id updated Successfull..."+temp.Eid);
					break;
				}
				temp=temp.next;
			}
		}
		return;
		
		
	}
	
	
	public void DisplayByMaxSalary()
	{
		node temp=head;
		node temp2=null;
		int count=0;
		if(head==null)
		{
			System.out.println("No records found: ");
			return;
		}
		else
		{
			while(temp!=null)
			{
				if(temp.sal>50000)
				{
					System.out.println("Employee information is: \n");
					System.out.println("Id is: "+temp.Eid);
					System.out.println("Name is: "+temp.name);
					System.out.println("Project name is: "+temp.PName);
					System.out.println("Salary is: "+temp.sal);
					System.out.println("Age is: "+temp.age);
					System.out.println("");
					count++;
				}
				temp=temp.next;
			}
		}
		if(count==0)
		{
			System.out.println("no one above 50K");
		}
		else
		{
			System.out.println("No one above 50K Salary than "+count+" employees\n");
		}
		
		
		
	}
	public void DisplayByMinSalary()
	{
		node temp=head;
		
		int count=0;
		if(head==null)
		{
			System.out.println("No records found: ");
			return;
		}
		else
		{
			while(temp!=null)
			{
				if(temp.sal<50000)
				{
					System.out.println("Employee information is: \n");
					System.out.println("Id is: "+temp.Eid);
					System.out.println("Name is: "+temp.name);
					System.out.println("Project name is: "+temp.PName);
					System.out.println("Salary is: "+temp.sal);
					System.out.println("Age is: "+temp.age);
					System.out.println("");
					count++;
				}
				
				temp=temp.next;
			}
			
		}
		if(count==0)
		{
			System.out.println("no one below 50K+");
		}
		else
		{
			System.out.println("No one below 50K Salary than "+count+" employees\n");
		}
		
		
	}
	
	public void DisplayByYoung()
	{
		node temp=head;
		
		int count=0;
		if(head==null)
		{
			System.out.println("No records found: ");
			return;
		}
		else
		{
			while(temp!=null)
			{
				if(temp.age<35)
				{
					System.out.println("Young Employee information is: \n");
					System.out.println("Id is: "+temp.Eid);
					System.out.println("Name is: "+temp.name);
					System.out.println("Project name is: "+temp.PName);
					System.out.println("Salary is: "+temp.sal);
					System.out.println("Age is: "+temp.age);
					System.out.println("");
					count++;
				}
				
				temp=temp.next;
			}
			
		}
		if(count==0)
		{
			System.out.println("no one young employees inn your company");
		}
		else
		{
			System.out.println("No one young employees than "+count+" employees\n");
		}
		
		
	}
	
	
	public int count()
	{
		if(head==null)
		{
			System.out.println("No records found....! Enter the records first.");
		}
	
		return size;
	}
	
}

public class EmployeeSingly {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		InputStreamReader iobj=new InputStreamReader(System.in);
		BufferedReader bobj=new BufferedReader(iobj);
		int i=0,n=0;
		int val1=0,pos=0,ID=0,mID=0;
		String name,pname;
		int sal=0,age=0,Yrs=0;
		
		Employee obj=new Employee();
		int ch1=0,ch=1;
		while(ch!=0)
		{
			System.out.println("1. Insert: ");
			System.out.println("2. Delete By ID: ");
			System.out.println("3. Display: ");
			System.out.println("4. Count: ");
			System.out.println("5. Display By Max Salary: ");
			System.out.println("6. Display By Min Salary: ");
			System.out.println("7. Display By Young Employees: ");
			System.out.println("8. Do You want any modification: ");
			ch1=sc.nextInt();
		
		
			switch(ch1)
			{
				case 1:
					System.out.println("How many employess u want to add: ");
					n=sc.nextInt();
					for(i=1;i<=n;i++)
					{
						System.out.println("Enter ID: ");
						ID=sc.nextInt();
						
						System.out.println("Enter employee name: ");
						name=bobj.readLine();
						System.out.println("Enter Project name: ");
						pname=bobj.readLine();
						
						System.out.println("Enter Salary: ");
						sal=sc.nextInt();
						System.out.println("Enter Age: ");
						age=sc.nextInt();
						
						System.out.println("How many yrs : ");
						Yrs=sc.nextInt();
						
						
						obj.Insert(ID,name,pname,sal,age,Yrs);
						
					}
					break;
				case 2:
					System.out.println("Enter ID to delete: ");
					ID=sc.nextInt();
					obj.DeleteByID(ID);
					
					break;
					
				case 3:
					obj.Display();
					break;
				case 4:
					int ret=0;
					ret=obj.count();
					System.out.println("Number of Employee is: "+ret);
					break;
					
				case 5:
				
					obj.DisplayByMaxSalary();
					break;
				case 6:
					obj.DisplayByMinSalary();
					break;
				
				case 7:
					obj.DisplayByYoung();
					break;
					
				case 8:
					System.out.println("Enter ID to update: ");
					mID=sc.nextInt();
					System.out.println("Enter ID on which rewrite: ");
					ID=sc.nextInt();
					
					obj.modifyID(ID,mID);
					break;
					
				default:
					System.out.println("Wrong choice: ");
					System.out.println("Do u want to continue: ");
					System.out.println("press 1-> continue   0-> exit: ");
			}
		}
		
	}

}
