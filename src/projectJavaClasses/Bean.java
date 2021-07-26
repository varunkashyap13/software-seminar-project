/**
 * @author varunkashyap
 * File: Bean.java
 * Description: Model bean
 */
package projectJavaClasses;

import java.io.Serializable;
import java.util.List;

public class Bean implements Serializable{
	public Bean() {
	}

	private String name;
	private String email;
	private List<String> coursesList;
	private String employeeStatus;
	private String errorMessage;
	private Integer hotelFeeSelected;
	private Integer parkingFeeSelected;
	private Integer numCourses;
	private Integer resultCheck;
	private Double totalCost;
	private Double courseCost;
	private Double hotelFee;
	private Double parkingFee;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<String> getCoursesList() {
		return coursesList;
	}
	public void setCoursesList(List<String> coursesList) {
		this.coursesList = coursesList;
	}
	public String getEmployeeStatus() {
		return employeeStatus;
	}
	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}
	public Integer getHotelFeeSelected() {
		return hotelFeeSelected;
	}
	public void setHotelFeeSelected(Integer hotelFeeSelected) {
		this.hotelFeeSelected = hotelFeeSelected;
	}
	public Integer getParkingFeeSelected() {
		return parkingFeeSelected;
	}
	public void setParkingFeeSelected(Integer parkingFeeSelected) {
		this.parkingFeeSelected = parkingFeeSelected;
	}

	public Double getHotelFee() {
		return hotelFee;
	}
	public void setHotelFee(Double hotelFee) {
		this.hotelFee = hotelFee;
	}
	public Double getParkingFee() {
		return parkingFee;
	}
	public void setParkingFee(Double parkingFee) {
		this.parkingFee = parkingFee;
	}

	public Integer getNumCourses() {
		return numCourses;
	}
	public void setNumCourses(Integer numCourses) {
		this.numCourses = numCourses;
	}
	public Double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public Integer getResultCheck() {
		return resultCheck;
	}
	public void setResultCheck(Integer resultCheck) {
		this.resultCheck = resultCheck;
	}
	public Double getCourseCost() {
		return courseCost;
	}
	public void setCourseCost(Double courseCost) {
		this.courseCost = courseCost;
	}
}
