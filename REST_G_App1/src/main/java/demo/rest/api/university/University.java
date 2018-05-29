package demo.rest.api.university;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Simple REST Controller Class for demonstration of GET & PUT 
 * 
 * @author gauraw
 *
 */
@Path("/university")
public class University {
	
	/*
	 * Get Response in Html Format
	 * */
	@GET
	@Path("/info")
	@Produces(MediaType.TEXT_HTML)
	public String getHTMLUniversityInfo() {
		return "<html> " + "<title>" + "University Information" + "</title>" + " <body><h1>"
				+ "Name - Indian University" + "</h1>" + "</body>" + "</html>";
	}

	/*
	 * Get Response in Text Format
	 * */
	@GET
	@Path("/info/txt")
	@Produces(MediaType.TEXT_PLAIN)
	public String getUniversityInfo() {
		return "Name - Indian University";
	}

	/*
	 * Update Record. Accept Student Id as Path Paramater.
	 * 
	 * PUT method is used to update record.
	 * */
	@PUT
	@Path("/{studentRollNo}")
	@Produces(MediaType.TEXT_PLAIN)
	public String updateUniversityInfo(@PathParam("studentRollNo") String studentRollNo) {
		String msg;
		boolean isRecordUpdated = false;

		// code to update the student record

		if (isRecordUpdated) {
			msg = "University Record Updated for Student Roll No:" + studentRollNo;
		} else {
			msg = "University Record Update Failed for Student Roll No:" + studentRollNo;
		}
		return msg;
	}
	
	
	/*
	 * Accept Data as Path Parameter.
	 * 
	 * Path Parameter: Parameters are seperated from each other using a forward slash "/"
	 * 
	 * e.g: http://localhost:80800/REST_G_App1/api/university/23/45
	 * Here 23 & 45 are Student Roll number sent using "Path Parameter"
	 * Path Parameter always appear at end of the URL.
	 * Path Parameter can be accepted using @PathParam
	 * 
	 * 
	 * */
	@GET
	@Path("/{studentRollNo1}/{studentRollNo2}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getStudentInfoUSingPathParam(
			@PathParam("studentRollNo1") String studentRollNo1,
			@PathParam("studentRollNo2") String studentRollNo2)
	{
		return "You have sent two Student Roll No: "+studentRollNo1+ " & "+studentRollNo2;
	}
	
	
	/*
	 * Accept data using query parameter.
	 * 
	 * query parameters start after "?" Separated by "&"
	 * 
	 * e.g: http://localhost:80800/REST_G_App1/api/university/student/query?studentRollNo1=23&studentRollNo2=45
	 * 
	 * */
	//@Path("/{studentRollNo1}/{studentRollNo2}") - not required
	@Path("/student/query")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getStudentInfoUsingQueryParam(
			@QueryParam(value="studentRollNo1")  String studentRollNo1,
			@QueryParam("studentRollNo2") String studentRollNo2)
	{
		return "You have sent two Student Roll No : "+studentRollNo1+ " & "+studentRollNo2;
	}

	
	/*
	 * Accept Data using Matrix Parameter. Solution: Use @MatrixParam annotation.
	 * Matrix Parameter: Parameter seperated by ";" in url is known as matrix parameter.
	 * Matrix parameter can appear anywhere in the url.
	 * e.g: http://localhost:80800/REST_G_App1/api/university/student/matrix;studentRollNo1=23;studentRollNo2=45
	 * 
	 * http://localhost:80800/REST_G_App1/api/university;studentRollNo1=23/student/matrix;studentRollNo2=45 (Not implemented in jersey or other rest api implementation till date)
	 * 
	 * */
	@Path("/student/matrix")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getStudentInfoUsingMatrixParam(
			@MatrixParam("studentRollNo1") String studentRollNo1,
			@MatrixParam("studentRollNo2") String studentRollNo2)
	{
		return "You have sent me two Student Roll No "+studentRollNo1+ " & "+studentRollNo2;
	}
}