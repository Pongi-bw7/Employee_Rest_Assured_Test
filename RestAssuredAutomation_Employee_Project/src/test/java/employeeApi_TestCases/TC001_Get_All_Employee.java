package employeeApi_TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import employeeApi_Base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC001_Get_All_Employee extends TestBase {

	@BeforeClass
	void getAllEmployees() throws InterruptedException
	{
		logger.info("***** Started TC001 ******");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET,"/employees");
		Thread.sleep(3);

	}
	@Test
	void checkResponseBody() {
		logger.info("******* checking response body *****");
		String responseBody = response.getBody().asString();
		//logger.info("Response body --- >" +responseBody);
		Assert.assertTrue(responseBody!=null);
	}

	@Test
	void checkStatusCode() {
		logger.info("******* checking staus code *****");
		int statuscode = response.getStatusCode();
		logger.info("status code --- >" +statuscode);
		Assert.assertEquals(statuscode, 200);;

	}

	@Test
	void checkResponseTime() {
		logger.info("******* checking response time *****");
		long responsetime = response.getTime();
		logger.info("response time  --- >" +responsetime);

		if(responsetime>2000)
			logger.warn("Response is greater the 2000");
		Assert.assertTrue(responsetime<5000);

	}  
	@Test
	void checkstatusLine() {
		logger.info("******* checking status line  *****");
		String statusline = response.getStatusLine();
		logger.info("response time  --- >" +statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");

	}  
	@Test
	void checkContentType() {
		logger.info("******* checking content type    *****");
		String contenttype = response.getContentType();
		logger.info("response ontent type  --- >" +contenttype);
		Assert.assertEquals(contenttype, "text/html; charset=UTF-8");

	}  
	@Test
	void checkserverType() {
		logger.info("******* checking server type    *****");
		String servertype = response.header("Server");
		logger.info("server type  --- >" +servertype);
		Assert.assertEquals(servertype, "Apache");

	}  

	@Test
	void checkcontentencoding() {
		logger.info("******* checking content encoding    *****");
		String contentencoding = response.header("Content-Encoding");
		logger.info("content encoding  --- >" +contentencoding);
		Assert.assertEquals(contentencoding, "gzip");

	} 
	/*
	 * @Test void checkcontentLength() {
	 * logger.info("******* checking content Length *****"); String contentLength =
	 * response.header("Content-Length"); logger.info("response time  --- >"
	 * +contentLength);
	 * 
	 * if(Integer.parseInt(contentLength)<100)
	 * logger.warn("contetn length is less than 100");
	 * Assert.assertTrue(Integer.parseInt(contentLength)>100);
	 * 
	 * }
	 */

	@Test
	void checkCookies() {
		logger.info("******* checking Cookies  *****");
		String cookie = response.getCookie("PHPSESSID");
		logger.info("cookie type  --- >" +cookie);
		//Assert.assertEquals(cookie, "");

	}  
	@AfterClass
	void tearDown()
	{
		logger.info("************ End of TC0001 ******");
	}


}
