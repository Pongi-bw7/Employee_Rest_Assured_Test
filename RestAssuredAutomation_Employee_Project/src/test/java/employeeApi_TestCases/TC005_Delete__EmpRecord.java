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
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_Delete__EmpRecord extends TestBase{
	RequestSpecification HttpRequest;
	Response response;

	

	@BeforeClass
	void deleteEmp() throws InterruptedException {

		logger.info("***** Started TC005 ! ******");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET,"/employees");
		

		//Created data which we can send along with post request
		JsonPath jsonPathEvaluator = response.jsonPath();
		
		String empID = jsonPathEvaluator.get("[0].id");

		 response=httpRequest.request(Method.DELETE,"/delete/"+empID);

		Thread.sleep(3);
	}
	
	@Test
	void checkResponseBody()
	{
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		Assert.assertEquals(responseBody.contains("successfully! deleted Records"), true);

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


