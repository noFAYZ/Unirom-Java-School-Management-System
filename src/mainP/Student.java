package mainP;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Student implements person {
	ArrayList<Course> courses;
	String id, Fname,Lname,username,type,gender,address;
	LocalDate dob;
	Student(){
		courses=new ArrayList<Course>();
	}
	Student(String ids,String fnames,String lnames,String usernames,String types,String genders,LocalDate dobs,String addresss){
		this.id=ids;
		this.Fname=fnames;
		this.Lname=lnames;
		this.username=usernames;
		this.type=types;
		this.gender=genders;
		this.dob=dobs;
		this.address=addresss;
	}
	public void displayCourses(){

		Iterator<Course> itr = courses.iterator();
		while (itr.hasNext()){
			System.out.println(itr.next().CName);
		}
		
	}
	public String getID(){
		
		return id;
	}
	
	public void addCourse(Course course){

		courses.add(course);
	}


	@Override
	public String getname() {
		return this.Fname;
	}

	@Override
	public String gettype() {
		return type;
	}
}
