package employeeApi_Utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtilis {
	public static String empName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("Ridha"+generatedString);
	}
	public static String empSal() {
		String generatedString = RandomStringUtils.randomAlphanumeric(5);
		return (generatedString);
	}
	public static String empAge() {
		String generatedString = RandomStringUtils.randomAlphanumeric(2);
		return (generatedString);
	}

}
