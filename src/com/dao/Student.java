package com.dao;

// TODO: Auto-generated Javadoc
/**
 * The Class Student.
 *
 * @date 2020年7月2日
 * @author linyuju
 * @version v1.0
 */
public class Student {

	/** The name. */
	public String name;
	
	/** The id. */
	public String id;
	
	/** The major. */
	public String major;
	
	/** The grade. */
	public String grade;
	
	/** The school. */
	public String school;
	
	/** The password. */
	public String password;

	/**
	 * Instantiates a new student.
	 */
	public Student() {
	}

	/**
	 * Instantiates a new student.
	 *
	 * @param name the name
	 * @param id the id
	 * @param major the major
	 * @param grade the grade
	 * @param school the school
	 * @param password the password
	 */
	public Student(String name, String id, String major, String grade, String school, String password) {
		super();
		this.name = name;
		this.id = id;
		this.major = major;
		this.grade = grade;
		this.school = school;
		this.password = password;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the major.
	 *
	 * @return the major
	 */
	public String getMajor() {
		return major;
	}

	/**
	 * Sets the major.
	 *
	 * @param major the new major
	 */
	public void setMajor(String major) {
		this.major = major;
	}

	/**
	 * Gets the grade.
	 *
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * Sets the grade.
	 *
	 * @param grade the new grade
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * Gets the school.
	 *
	 * @return the school
	 */
	public String getSchool() {
		return school;
	}

	/**
	 * Sets the school.
	 *
	 * @param school the new school
	 */
	public void setSchool(String school) {
		this.school = school;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
	    /* (非 Javadoc)
	    * 
	    * 
	    * @return
	    * @see java.lang.Object#toString()
	    */
	    
	public String toString() {
		return "姓名：" + this.name + "，学号：" + this.id + "，专业" + this.major + "，班级：" + this.grade + "，学校" + this.school;
	}
}