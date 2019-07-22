package employeeApi_TestCases;

import static org.testng.Assert.assertEquals;

import org.apache.http.HttpRequest;
import org.apache.http.util.Asserts;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import employeeApi_Base.TestBase;
import employeeApi_Utilities.RestUtilis;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_Post_EmpRecord extends TestBase{
	RequestSpecification HttpRequest;
	Response response;

	String empName = RestUtilis.empName();
	String empSalary = RestUtilis.empSal();
	String empAge = RestUtilis.empAge();

	@BeforeClass
	void createEmp() throws InterruptedException {

		logger.info("***** Started TC003 ! ******");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();

		//Created data which we can send along with post request
		JSONObject reqparam = new JSONObject();
		reqparam.put("name",empName);
		reqparam.put("salary",empSalary);
		reqparam.put("age",empAge);


		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(reqparam.toJSONString());

		//Response object
		 response=httpRequest.request(Method.POST,"/create");

		Thread.sleep(5000);
	}
	
	@Test
	void checkResponseBody()
	{
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		Assert.assertEquals(responseBody.contains(empName), true);
		Assert.assertEquals(responseBody.contains(empSalary), true);
		Assert.assertEquals(responseBody.contains(empAge), true);
	}
	
	@Test
	void checkStatusCode()
	{
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode,200);
	}
	
	@Test
	void checkContentType() {
		String contenttype = response.header("Content-Type");
		Assert.assertEquals(contenttype, "text/html; charset=UTF-8");

	}  
	@Test
	void checkserverType() {
		String servertype = response.header("Server");
		Assert.assertEquals(servertype, "Apache");

	}  



	@AfterClass
	void tearDown()
	{
		logger.info("************ End of TC0003 ******");
	}

}


