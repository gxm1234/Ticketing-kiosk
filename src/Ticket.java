

import java.text.DecimalFormat;
/**
 * This class is used for formatting the information of tickets
 * @author Administrator
 *
 */
public class Ticket {
	private String MovieName;
	private int MovieNumber;
	private String Time;
	private int TimeNumber;
	private int ScreenNumber;
	private int Child;
	private int Adult;
	private int Senior;
	private int Student;
	private int StudentID[];
	private String SeatSelect[];

	/**
	 * Constructor
	 */
	public Ticket()
	{
		this.Adult = 0;
		this.Child = 0;
		this.Senior = 0;
		this.Student = 0;
		this.TimeNumber = 0;
		this.MovieNumber = 0;
	}

	/**
	 * Getter of movie name
	 * @return the name of the movie have been chosen
	 */
	public String getMovieName() {
		return MovieName;
	}
	
    /**
     * Setter of movie name
     * @param movieName (the name of the movie have been chosen)
     */
	public void setMovieName(String movieName) {
		MovieName = movieName;
	}

	/**
	 * Getter of time number
	 * @return (The number(similar to ID) of time have been chosen)
	 */
	public int getTimeNumber() {
		return TimeNumber;
	}

	/**
	 * Setter of time
	 * @param time (the show time have been chosen)
	 */
	public void setTime(String time) {
		Time = time;
	}
	
	/**
	 * Getter of time
	 * @return the show time have been chosen
	 */
	public String getTime() {
		return Time;
	}

	/**
	 * Setter of time number
	 * @param timeNumber (The number(similar to ID) of time have been chosen)
	 */
	public void setTimeNumber(int timeNumber) {
		TimeNumber = timeNumber;
	}

	/**
	 * Getter of screen number
	 * @return the number of screen have been chosen
	 */
	public int getScreenNumber() {
		return ScreenNumber;
	}

	/**
	 * Setter of screen number
	 * @param screenNumber (the number of screen have been chosen)
	 */
	public void setScreenNumber(int screenNumber) {
		ScreenNumber = screenNumber;
	}

	/**
	 * Getter of child ticket number
	 * @return the number of child ticket have been chosen
	 */
	public int getChild() {
		return Child;
	}
	
	/**
	 * Setter of child ticket number
	 * @param child (the number of child ticket have been chosen)
	 */
	public void setChild(int child) {
		Child = child;
	}

	/**
	 * Getter of adult ticket number
	 * @return the number of adult ticket have been chosen
	 */
	public int getAdult() {
		return Adult;
	}

	/**
	 * Setter of adult ticket number
	 * @param adult (the number of adult ticket have been chosen)
	 */
	public void setAdult(int adult) {
		Adult = adult;
	}

	/**
	 * Getter of senior ticket number
	 * @return the number of senior ticket have been chosen
	 */
	public int getSenior() {
		return Senior;
	}

	/**
	 * Setter of senior ticket number
	 * @param senior (the number of senior ticket have been chosen)
	 */
	public void setSenior(int senior) {
		Senior = senior;
	}

	/**
	 * Getter of student ticket number
	 * @return the number of student ticket have been chosen
	 */
	public int getStudent() {
		return Student;
	}

	/**
	 * Setter of student ticket number
	 * @param student (the number of student ticket have been chosen)
	 */
	public void setStudent(int student) {
		Student = student;
	}

	/**
	 * Getter of student IDs
	 * @return the student IDs that have been typed in
	 */
	public int[] getStudentID() {
		return StudentID;
	}
	
	/**
	 * Setter of student IDs
	 * @param studentID (the student IDs that have been typed in)
	 */
	public void setStudentID(int studentID[]) {
		StudentID = studentID;
	}

	/**
	 * Getter of seats information
	 * @return the seats have been chosen
	 */
	public String[] getSeatSelect() {
		return SeatSelect;
	}

	/**
	 * Setter of seats information
	 * @param seatSelect (the seats have been chosen)
	 */
	public void setSeatSelect(String seatSelect[]) {
		SeatSelect = seatSelect;
	}
	
	/**
	 * Getter of total ticket numbers
	 * @return total number of tickets that have been chosen
	 */
	public int getTotalNumber(){
		int number;
		number = Adult + Child + Student + Senior;
		return number;
	}
	
	/**
	 * Getter of price
	 * @return the total price of tickets that have been chosen
	 */
	public String getPrice(){
		double price;
		DecimalFormat df = new DecimalFormat("######0.00");
		price = 16.0*(double)Adult + 16.0*0.5*(double)Child + 16.0*0.2*(double)Senior + 16.0*0.15*(double)Student;
		return df.format(price);
	}

	/**
	 * Getter of Movie ID
	 * @return the ID of movie that have been chosen
	 */
	public int getMovieNumber() {
		return MovieNumber;
	}

	/**
	 * Setter of Movie ID
	 * @param movieNumber (the ID of movie that have been chosen)
	 */
	public void setMovieNumber(int movieNumber) {
		MovieNumber = movieNumber;
	}
}