package Api_utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class Restutils {

	
	
	public String empname() {
		String name=RandomStringUtils.randomAlphabetic(5);
		return 	("akash"+name);
	}
	
	
	public String empsalary() {
		String salary=RandomStringUtils.randomNumeric(8);
		return salary;
	}
	
	
	public String empage() {
		String age=RandomStringUtils.randomNumeric(2);
		return age;
	}
	
	
	
	
	
}
