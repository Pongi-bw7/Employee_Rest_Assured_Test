package employeeApi_Base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;


import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {

	public static RequestSpecification httpRequest;
	public static Response response;
	public String empID = "33229";
	
	public Logger logger;
	
	@BeforeClass
	public void setup() {
		logger=Logger.getLogger("EmployeesRestAPI");
		PropertyConfigurator.configure("C:\\Users\\Pongiyammal\\Office\\Study\\Selenium\\eclipse-workspace\\RestAssuredAutomation_Employee_Project\\Logs\\Log4j.properties");
		logger.setLevel(Level.DEBUG);
	}
	

}
