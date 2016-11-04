/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdb2;

/**
 *
 * @author ADMIN
 */
import java.io.Serializable;

public class Student implements Serializable{
	private String studentNumber;
	private String firstName;
	private char middleInitial;
	private String lastName;
	private String course;
	private int yearLevel;
        private String crushName;
        private Course favoriteCourse;
	
	public Student(){}
	
	public Student(String studentNumber, String firstName, char middleInitial, String lastName, String course, int yearLevel, String crushName, Course favoriteCourse) {
		/*
                this.setStudentNumber(studentNumber);
		this.setFirstName(firstName);
		this.setMiddleInitial(middleInitial);
		this.setLastName(lastName);
		this.setCourse(course);
		this.setYearLevel(yearLevel);
                this.setCrushName(crushName);
                this.setFavoriteCourse(favoriteCourse);
                */
                
                this.studentNumber = studentNumber;
                this.firstName = firstName;
                this.middleInitial = middleInitial;
                this.lastName = lastName;
                this.course = course;
                this.yearLevel = yearLevel;
                this.crushName = crushName;
                this.favoriteCourse = favoriteCourse;
                
                
	}
        
        public String getCrushName() {
            return crushName;
        }

        public String getFavoriteCourse() {
            return favoriteCourse.getCourseCode();
        }
        
        
        public void setCrushName(String crushName) {
            this.crushName = crushName;
        }

        public void setFavoriteCourse(Course favoriteCourse) {
            this.favoriteCourse = favoriteCourse;
        }


	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setMiddleInitial(char middleInitial) {
		this.middleInitial = middleInitial;
	}

	public char getMiddleInitial() {
		return middleInitial;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getCourse() {
		return course;
	}

	public void setYearLevel(int yearLevel) {
		this.yearLevel = yearLevel;
	}

	public int getYearLevel() {
		return yearLevel;
	}
	
	public String toString() {
		String middle;
		if (middleInitial == (char)54321) { middle = "";}
		else {middle = String.valueOf(middleInitial);}
		return String.format("%s\n%s, %s %s\n%s\n%d\n", studentNumber, lastName, firstName, middle, course, yearLevel);
	}
	
}