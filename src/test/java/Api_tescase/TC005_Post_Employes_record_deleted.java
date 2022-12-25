package Api_tescase;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Api_base.Test_base;
import Api_utilities.Restutils;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class TC005_Post_Employes_record_deleted extends Test_base {

	
	

	Restutils uti=new Restutils();
	String empname=uti.empname();
	String empsalary=uti.empsalary();
	String empage=uti.empage();



	@BeforeClass
	public void GetallEmployess() throws InterruptedException {

		logger.info("******* TC004_Post_Employes_record_updated ********");

		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
		http=RestAssured.given();

		respones=http.request(Method.GET,"/employees");


		JsonPath ob=respones.jsonPath();

		//capture id
		String empid=ob.get("[0].id");

		respones=http.request(Method.DELETE,"/delete/"+empid);

		Thread.sleep(3000);
	}


	@Test
	public void checkResponsebody() {
		logger.info("*********check response body *********");
		String body=respones.getBody().asString();
		logger.info("body name ==> "+empname);
		Assert.assertEquals(body.contains("successfully! deleted Records"), true);

	}

	@Test
	public void checkStatuscode() {
		logger.info("********check Status code **********");
		int code=respones.getStatusCode();
		logger.info("Status code ==> "+code);
		Assert.assertEquals(code, 200);

	}
	@Test
	public void  checkStatusline() {
		logger.info("******* check Status line *********");
		String line=respones.getStatusLine();
		logger.info("Status line ==> "+line);
		Assert.assertEquals(line, "HTTP/1.1 200 OK");


	}

	@Test
	public void checkContentType() {
		logger.info("******** check content type **********");
		String type=respones.header("Content-Type");
		logger.info("content type ==> "+type );
		Assert.assertEquals(type, "application/json");

	}



	@Test
	public void all_headers(){
		Headers header=respones.headers();
		for(Header hd:header) {
			logger.info(hd.getName()+" ==> "+hd.getValue());
		}

	}

	@Test
	public void check_server_type(){
		logger.info("******** check server type *******");
		String server=respones.header("Server");
		logger.info("server type ==> "+server);
		Assert.assertEquals(server, "Apache");


	}


	@Test
	public void check_content_length() {
		logger.info("check content length *******");
		String length=respones.header("Content-Length");
		logger.info("content length ==> "+length);
		if(Integer.parseInt(length)<2000) {
			logger.info("content length is less then 2000");
		}
		
		Assert.assertTrue(Integer.parseInt(length)<2000);
		
	
	}

	
	
	@Test
	public void tear_down() {
		logger.info("******** TC004_Post_Employes_record_updated close ********");
	}

	
	
	
	
	
}
