/**
 * @author varunkashyap
 * File: mvc_servlet.java
 * Description: Controller servlet
 */

package projectJavaClasses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mvc_servlet")
public class mvc_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mvc_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//Declare variables
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String[] courses = request.getParameterValues("courses");
		List<String> coursesList= null;
		String employeeStatus = request.getParameter("status");
		String hotelFeeSelected = request.getParameter("hotelFee");
		String parkingFeeSelected = request.getParameter("parkingFee");
		String errorMessage = "";
		String nameErrorMessage = "invalid name entered. ";
		String emailErrorMessage = "invalid email entered. ";
		String coursesErrorMessage = "invalid courses entered. ";
		String statusErrorMessage = "invalid status entered. ";
		String parkingErrorMessage = "parking is already included in hotel fee. please uncheck. ";
		String courseCode = "";
		String nextCourse ="";
		Integer nameCheck = 0;
		Integer emailCheck = 0;
		Integer coursesCheck = 0;
		Integer numCourses = 0;
		Integer employeeStatusCheck = 0;
		Integer hotelFeeSelectedCheck = 0;
		Integer parkingFeeSelectedCheck = 0;
		Integer formCheck = 0;
		Integer resultCheck = 0;
		Double totalCost = 0.00;
		Double hotelFee = 185.00;
		Double parkingFee = 10.00;
		Double courseCost= 0.00;
		Double employeeCourseCost = 850.00;
		Double studentCourseCost = 1000.00;
		Double speakerCourseCost = 0.00;
		Double otherCourseCost = 1350.00;
		Pattern pattern = null;
		Matcher mat = null;
		
		//check which form the request came from
		if (request.getParameter("form").equals("Compute Seminar Costs")) {
			//create a new bean object
			Bean bean = new Bean();
			
			//set fees
			bean.setHotelFee(hotelFee);
			bean.setParkingFee(parkingFee);
			
			//check if name is empty or null, then save
			if(!name.isEmpty() && name != null) {
				bean.setName(name);
				nameCheck = 1;
				formCheck = 1;
			} else {
				formCheck = 0;
			}
			//check if email is empty or null, then save
			if(!email.isEmpty() && email!= null) {
				pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
				mat = pattern.matcher(email);

		        if(mat.matches()){
		            bean.setEmail(email);
		            emailCheck = 1;
		        }
		        
			} else {
				formCheck = 0;
			}
			//check if courses is empty or null, then save
			if(courses.length >0) {
				coursesList = new ArrayList(Arrays.asList(courses));
				bean.setCoursesList(coursesList);
				numCourses = courses.length;
				bean.setNumCourses(numCourses);
				coursesCheck = 1;
			} else {
				formCheck = 0;
			}
			//check if employee status is empty or null, then save
			if(!employeeStatus.isEmpty() && employeeStatus != null) {
				bean.setEmployeeStatus(employeeStatus);
				employeeStatusCheck = 1;
				if(employeeStatus.equals("JHUEmployee")) {
					courseCost = employeeCourseCost;
				} else if (employeeStatus.equals("JHUStudent")) {
					courseCost = studentCourseCost;
				} else if (employeeStatus.equals("Speaker")) {
					courseCost = speakerCourseCost;
				} else if (employeeStatus.equals("Other")) {
					courseCost = otherCourseCost;
				}
				bean.setCourseCost(courseCost);
			} else {
				formCheck = 0;
			}
			//check if hotel fee is empty or null, then save
			if(hotelFeeSelected != null) {
				hotelFeeSelectedCheck = 1;
				bean.setHotelFeeSelected(1);

			} else {
				bean.setHotelFeeSelected(0);
			}
			//check if parking fee is empty or null, then save
			if(parkingFeeSelected !=null) {
				if (hotelFeeSelectedCheck == 1) {
					bean.setParkingFee(0.00);
					bean.setParkingFeeSelected(1);
				} else {
					bean.setParkingFeeSelected(1);
					parkingFeeSelectedCheck = 1;
				}
			} else {
				bean.setParkingFeeSelected(0);
			}
			
			//calculate total cost
			if (formCheck == 1) {
				bean.setResultCheck(formCheck);
				//calculate total cost for employee
				totalCost = (courseCost * numCourses) + (hotelFee * hotelFeeSelectedCheck) + (parkingFee * parkingFeeSelectedCheck);
				bean.setTotalCost(totalCost);
				
			//generate error message
			} else {
				bean.setResultCheck(formCheck);
				if (nameCheck == 0) {
					errorMessage += nameErrorMessage;
				}
				if (emailCheck == 0) {
					errorMessage += emailErrorMessage;
				}
				if (coursesCheck == 0) {
					errorMessage += coursesErrorMessage;
				}
				if (employeeStatusCheck == 0) {
					errorMessage += statusErrorMessage;
				}
				if (employeeStatusCheck == 0) {
					errorMessage += statusErrorMessage;
				}
				if (parkingFeeSelectedCheck == 0) {
					errorMessage += parkingErrorMessage;
				}
			}
			
			session.setAttribute("bean", bean);
			RequestDispatcher rd = request.getRequestDispatcher("/results.jsp");
			rd.forward(request, response);
		}
		if (request.getParameter("form").equals("Edit Information")) {
			RequestDispatcher rd = request.getRequestDispatcher("/edit.jsp");
			rd.forward(request, response);
		}
		
		
		if (request.getParameter("form").equals("Remove")) {
			Bean bean = (Bean)session.getAttribute("bean");
			courseCode = request.getParameter("courseCode");
			Iterator<String> itr = bean.getCoursesList().iterator();
			while(itr.hasNext()) {
				nextCourse = itr.next();
				if (nextCourse.equals(courseCode)) {
					itr.remove();
					bean.setNumCourses(bean.getNumCourses() - 1);
				}
			}
			
			totalCost = (bean.getCourseCost() * bean.getNumCourses()) + (bean.getHotelFee() * bean.getHotelFeeSelected()) + (bean.getParkingFee() * bean.getParkingFeeSelected());
			bean.setTotalCost(totalCost);
			
			session.setAttribute("bean", bean);
			RequestDispatcher rd = request.getRequestDispatcher("/results.jsp");
			rd.forward(request, response);
		}
		
		//redirect from results.jsp back to index.html
		if (request.getParameter("form").equals("Back")) {
			response.sendRedirect("index.html");
		}
	}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
