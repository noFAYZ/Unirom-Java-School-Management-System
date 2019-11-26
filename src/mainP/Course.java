package mainP;

import java.util.ArrayList;
import java.util.Iterator;

public class Course {
	ArrayList<Student> students;
	ArrayList<Teacher> lecturers;

	public Integer id,CHrs,preReq,semester;
	public String CName,aTeacher,type,cCode;

	Course(){
		students=new ArrayList<Student>();
		lecturers=new ArrayList<Teacher>();
	}
	public Course( Integer id, String CName,String cCode, Integer CHrs, String aTeacher, Integer preReq, String type, Integer semester) {

		this.id = id;
		this.CName = CName;
		this.CHrs = CHrs;
		this.aTeacher = aTeacher;
		this.preReq = preReq;
		this.type = type;
		this.semester = semester;
		this.cCode=cCode;
	}


	public void setCName(String CName) {
		this.CName = CName;
	}

	public String getcCode() {
		return cCode;
	}

	public void setcCode(String cCode) {
		this.cCode = cCode;
	}

	public void addStudents(Student student){

		students.add(student);
	}
	public void assignteacher(Teacher lecturer){

		lecturers.add(lecturer);
	}
	public int getNStudents(){
		int co=students.size();
		return co;
	}
	public void getTeacher(){

		System.out.println("TEACHERS:");
		Iterator<Teacher> itr = lecturers.iterator();
		while (itr.hasNext()){
			System.out.println(itr.next().getname());
		}
	}
	public void courseinfo(){
		System.out.println(CName);
		System.out.println(students.size()); 
		getTeacher();
	}


	public void displayStudents(){

		System.out.println("STUDENTS:");
		Iterator<Student> itr = students.iterator();
		while (itr.hasNext()){
			System.out.println(itr.next().getname());
		}
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	public ArrayList<Teacher> getLecturers() {
		return lecturers;
	}

	public void setLecturers(ArrayList<Teacher> lecturers) {
		this.lecturers = lecturers;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCHrs() {
		return CHrs;
	}

	public void setCHrs(Integer CHrs) {
		this.CHrs = CHrs;
	}

	public Integer getPreReq() {
		return preReq;
	}

	public void setPreReq(Integer preReq) {
		this.preReq = preReq;
	}

	public Integer getSemester() {
		return semester;
	}

	public void setSemester(Integer semester) {
		this.semester = semester;
	}

	public String getCName() {
		return CName;
	}

	public void setcName(String cName) {
		this.CName = CName;
	}

	public String getaTeacher() {
		return aTeacher;
	}

	public void setaTeacher(String aTeacher) {
		this.aTeacher = aTeacher;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
