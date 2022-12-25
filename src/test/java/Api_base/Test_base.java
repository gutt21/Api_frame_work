package Api_base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeTest;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test_base {

	
	public static RequestSpecification http;
	public static Response respones;
	public static String emID="2";
	
	public Logger logger;
	
	
	@BeforeTest
	public void setup() {
		
		logger=Logger.getLogger("EmployeesRestAPi");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
		
		
		
	}
	
	
	
	
}
