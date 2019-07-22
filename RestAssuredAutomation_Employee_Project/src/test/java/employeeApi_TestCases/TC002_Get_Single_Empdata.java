package employeeApi_TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import employeeApi_Base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC002_Get_Single_Empdata extends TestBase {

	@BeforeClass
	void getsingleEmployees() throws InterruptedException
	{
		logger.info("***** Started TC002 ! ******");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET,"/employee/"+empID);
		Thread.sleep(3);

	}
	@Test
	void checkResponseBody() {
		String responseBody = response.getBody().asString();
		String responseBody1 = response.getBody().asString();
		System.out.println("Body is : "+responseBody1);
		Assert.assertEquals(responseBody.contains(empID),true);
	}

	@Test
	void checkStatusCode() {
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);;

	}

	@Test
	void checkResponseTime() {
		long responsetime = response.getTime();
		Assert.assertTrue(responsetime<6000);

	}  


}
