package stepDefinitions;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.UsersPage;

public class AddUser {

	WebDriver driver=null;
	UsersPage userpage;
	String firstName="Rambabu";
	String lastName ="Sankoju";
	String cellPhone= "+156789678";
	String userName="novak";
	
	
	@SuppressWarnings("deprecation")
	@Before
	public void browserSetup() {
		
		String projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

	
	@Given("user open way2automation on browser")
	public void navige_wayToAutomation() {

		driver.get("http://www.way2automation.com/angularjs-protractor/webtables/");
		
	}
	

	@When("user click Add user button")
	public void Click_AddUser() {
		userpage=new UsersPage(driver);
		userpage.Click_AddUser();	
	}
	

	@And("enter first name and last name and username and cell phone")
	public void Enter_UserDetails() {
		userpage.Enter_UserDetails(firstName, lastName, firstName,cellPhone);

	}
	

	@And("select role and click save button")
	public void Select_Role() throws InterruptedException {
		userpage.Select_role();
		Thread.sleep(2000);
	}
	
	@Then("user added to the user records table")
	public void user_added_to_the_user_records_table() {
		int rows=driver.findElements(By.xpath("/html/body/table/tbody/tr")).size();

		for (int i=1;i<rows;i++) {

			String iLastname=driver.findElement(By.xpath("/html/body/table/tbody/tr["+i+"]/td[2]")).getText();
			if (iLastname.equals(lastName)) {
				System.out.println("new user "+ lastName +" added successfully");
				break;
			}
		}
	}
	
	
	  @When ("delete the user from table")
	  public void delete_User_Record() {
			int rows=driver.findElements(By.xpath("/html/body/table/tbody/tr")).size();

			for (int i=1;i<rows;i++) {

				String iLastname=driver.findElement(By.xpath("/html/body/table/tbody/tr["+i+"]/td[3]")).getText();
				System.out.println(iLastname);
				if (iLastname.equals(userName)) {
					driver.findElement(By.xpath("/html/body/table/tbody/tr["+i+"]/td[11]/button/i")).click();
					break;
				}
			}
			
			String iconfirmation=driver.findElement(By.xpath("/html/body/div[3]/div[1]/h3")).getText();
			
			if (iconfirmation.equals("Confirmation Dialog")) {
				driver.findElement(By.xpath("/html/body/div[3]/div[3]/button[2]")).click();
			}
		} 
	  
	  
	  @Then ("user record deleted from user table")
	  public boolean validate_deleted_User_In_Table() {
			int rows=driver.findElements(By.xpath("/html/body/table/tbody/tr")).size();
             boolean userdeleted=true;
			for (int i=1;i<rows;i++) {

				String iLastname=driver.findElement(By.xpath("/html/body/table/tbody/tr["+i+"]/td[3]")).getText();
				if (iLastname.equals(userName)) {
					userdeleted=false;
				}
			}
			
			return userdeleted;
	  }
}
