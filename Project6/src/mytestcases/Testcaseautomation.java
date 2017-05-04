package mytestcases;


import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class Testcaseautomation {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		
		
		
		selenium = new DefaultSelenium("localhost",4444,"*chrome","http://www.phptravels.net/");
		selenium.start();
		selenium.setSpeed("1500");
	}

	// User Login
	@Test
	public void testTestcase1a() throws Exception {
		selenium.open("/");
		selenium.click("link=My Account");
		selenium.click("link=Login");
		selenium.waitForPageToLoad("30000");
		selenium.type("name=username", "user@phptravels.com");
		selenium.type("name=password", "demouser");
		selenium.click("//button[@type='submit']");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=John");
		selenium.click("link=Logout");
		selenium.waitForPageToLoad("30000");
	}

	// user failed
	@Test
	public void testTest2() throws Exception {
		selenium.open("/");
		selenium.click("link=My Account");
		selenium.click("link=My Account");
		selenium.click("link=Login");
		selenium.click("link=Login");
		selenium.waitForPageToLoad("30000");
		selenium.type("name=username", "bangra1@abc.com");
		selenium.type("name=username", "bangra1@abc.com");
		selenium.type("name=password", "helloworld");
		selenium.type("name=password", "helloworld");
		selenium.click("//button[@type='submit']");
		selenium.click("//button[@type='submit']");
	}
	
	// admin success 
	@Test
	public void testTest3() throws Exception {
		selenium.open("/admin");
		selenium.type("name=email", "admin@phptravels.com");
		selenium.type("name=password", "demoadmin");
		selenium.click("//button[@type='submit']");
		selenium.waitForPageToLoad("30000");
	}

	//admin fail
	@Test
	public void testTest4() throws Exception {
		selenium.open("/admin");
		selenium.type("name=email", "admin@phptravels.com");
		selenium.type("name=password", "hello");
		selenium.click("//button[@type='submit']");
	}

	// supplier success 
	@Test
	public void testTest5() throws Exception {
		selenium.open("/supplier");
		selenium.type("name=email", "supplier@phptravels.com");
		selenium.type("name=password", "demosupplier");
		selenium.click("//button[@type='submit']");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Log Out");
		selenium.waitForPageToLoad("30000");
	}
	
	
	// supplier fail
	@Test
	public void testTest6() throws Exception {
		selenium.open("/supplier");
		selenium.type("name=email", "supplier@phptravels.com");
		selenium.type("name=password", "demo");
		selenium.click("//button[@type='submit']");
	}

	// user login and flight
	@Test
	public void testTest7() throws Exception {
		selenium.open("/login");
		selenium.type("name=username", "user@phptravels.com");
		selenium.type("name=password", "demouser");
		selenium.click("//button[@type='submit']");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Flights");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=flights-origin-whitelabel_en", "BWI");
		selenium.click("class=mewtwo-flights-origin-country");
		selenium.type("id=flights-destination-whitelabel_en", "MKE");
		selenium.click("class=mewtwo-flights-destination-country");
		selenium.click("css=button[type=\"submit\"]");
		selenium.click("link=John");
		selenium.click("link=Logout");
		selenium.waitForPageToLoad("30000");
	}
	
	// already logged in admin, add tour
	@Test
	public void testTest8() throws Exception {
		selenium.open("/admin/tours/");
		selenium.click("//ul[@id='social-sidebar-menu']/li[7]/a/i[2]");
		selenium.click("css=#Tours > li > a");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=button.btn.btn-success");
		selenium.waitForPageToLoad("30000");
		selenium.type("name=tourname", "Northern Lights");
		selenium.type("name=maxadult", "9");
		selenium.type("name=adultprice", "700");
		selenium.select("name=tourstars", "label=5");
		selenium.type("name=tourdays", "7");
		selenium.type("name=tournights", "6");
		selenium.type("name=tourtype", "189");
		selenium.select("id=isfeatured", "label=Yes");
		selenium.type("name=locations[]", "aurora");
		selenium.click("css=option[value=\"yes\"]");
		selenium.type("id=mapaddress", "auro");
		selenium.click("id=add");
	}
	
	// user logged in adding wishlist tour
	@Test
	public void testTest9() throws Exception {
		selenium.open("/account/");
		selenium.click("link=Tours");
		selenium.waitForPageToLoad("30000");
		selenium.click("//tr[2]/td/div/div[2]/div/div[2]/h4/a/b");
		selenium.waitForPageToLoad("30000");
		selenium.chooseOkOnNextConfirmation();
		selenium.click("css=span.wishtext");
	}
	
	// user already logged in and password changed
	@Test
	public void testTest10() throws Exception {
		selenium.open("/account/");
		selenium.click("link=My Profile");
		selenium.click("name=password");
		selenium.type("name=password", "helloworld");
		selenium.click("name=confirmpassword");
		selenium.type("name=confirmpassword", "helloworld");
		selenium.click("//form[@id='profilefrm']/div/div[3]/div[3]/button");
	}
	
	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
