package LearnTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

	/*
	 * @Test(priority = 1) public void Login() { System.out.println("Login"); }
	 * 
	 * @Test(priority = 2) public void Navigate() { System.out.println("Navigate");}
	 * 
	 * @Test(priority = 3) public void Logout() { System.out.println("Logout"); }
	 */

	
	 @Test() 
	 public void Login() 
	 { 
		 System.out.println("Login"); 
		 Assert.assertEquals("Yogesh", "Nagarajan");
	 }
	 
	 @Test() 
	 public void Navigate() 
	 { 
		 System.out.println("Navigate");
		 
	 }
	  
	 @Test(dependsOnMethods={"Login","Navigate"}) 
	 public void Logout() 
	 { 
		 System.out.println("Logout"); 
		 
	 }
	 

}
