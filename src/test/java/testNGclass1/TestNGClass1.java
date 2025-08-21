package testNGclass1;

import org.testng.annotations.Test;

/*
 1) Open app
 2)Login
 3)LogOut
 */



public class TestNGClass1 
{
	@Test(priority=1)
   void openapp()
   {
	   System.out.println("opend succesfuy...........");
   }
	@Test(priority=2)
   void login()
   {
	   System.out.println("Login succesfuy...........");
   }
	@Test(priority=3)
   void logout()
   {
	   System.out.println("Logout succesfuy...........");
   }
}

