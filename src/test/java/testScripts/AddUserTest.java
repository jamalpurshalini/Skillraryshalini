package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class AddUserTest extends BaseClass{
	
	@Test
	public void addUserTest() {
		SoftAssert soft=new SoftAssert();
		
		home.clickUsersTab();
		soft.assertTrue(users.getPageHeader().contains("Users"));
		users.clickNewButton();
		soft.assertEquals(addUser.getPageHeader(), "Add New User");
		
	
		Map<String, String> map=excel.readFromExcel("Add User");
		 
		addUser.setEmail(map.get("Email"));
		addUser.setPassword(map.get("Password"));
		addUser.setFirstName(map.get("Firstname"));
		addUser.setlastname(map.get("lastname"));
		addUser.setAddress(map.get("Address"));
		addUser.setContactInfo(map.get("Contact info"));
		addUser.uploadPhoto(map.get("photo"));
		
		addUser.clicksave();
		
		soft.assertEquals(users.getSuccessMessage(), "Success!");
		soft.assertAll();
				
	}
	

}
