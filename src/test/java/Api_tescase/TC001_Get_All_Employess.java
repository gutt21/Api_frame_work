package Api_tescase;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Api_base.Test_base;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC001_Get_All_Employess  extends Test_base{





	@BeforeClass
	public void GetallEmployess() throws InterruptedException {

		logger.info("******* started TC001_Get_All_Employess ********");

		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
		http=RestAssured.given();
		respones=http.request(Method.GET,"/employees");

		Thread.sleep(3000);
	}

	@Test
	public void CheckresponesBody() {


		logger.info("******* Check the response of body ********");

		String name=respones.getBody().asString();
		logger.info("Response body==>"+name);
		Assert.assertTrue(name!=null);

	}

	@Test
	public void checkstatuscode() {

		logger.info("******** check status code **********");

		int code=respones.getStatusCode();
		logger.info("Status code==>"+code);//
		Assert.assertEquals(code, 200);



	}

	@Test
	public void check_Response_time() {

		logger.info("******* check response time *******");

		long time=respones.getTime();
		logger.info("response time is ==>"+time);

		if(time>2000) {
			logger.info("Resonse time is greater than 20000");
		}
		Assert.assertTrue(time>2000);		

	}


	@Test	
	public void check_statuc_line() {
		logger.info("******* check status line ******");
		String line=respones.getStatusLine();		
		logger.info("Response ststuc line==>"+line);
		Assert.assertEquals(line, "HTTP/1.1 200 OK");


	}


	@Test
	public void checkcontenttype() {
		logger.info("******** check content type *********");
		String contenttype=respones.header("Content-Type");
		logger.info("content type is ==>"+contenttype);
		Assert.assertEquals(contenttype, "application/json");

	}

	@Test
	public void checkservertype() {

		logger.info("******* check server type ********");
		String server=respones.header("Server");
		logger.info("server type is ==> "+server);
		Assert.assertEquals(server, "nginx/1.21.6");


	}


}
