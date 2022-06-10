package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UsersPage {
	
	WebDriver driver;
	
	By btn_addUser = By.xpath("/html/body/table/thead/tr[2]/td/button");
	By el_firstName = By.name("FirstName");
	By el_lastName = By.name("LastName");
	By el_userName = By.name("UserName");
	By el_cellPhone = By.name("Mobilephone");
	By drpd_role = By.xpath("/html/body/div[3]/div[2]/form/table/tbody/tr[6]/td[2]/select/option[3]");
	By btn_close = By.xpath("/html/body/div[3]/div[3]/button[1]");
	By btn_save = By.xpath("/html/body/div[3]/div[3]/button[2]");
	
	public UsersPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void Click_AddUser() {
		driver.findElement(btn_addUser).click();
	}
	
	public void Enter_UserDetails(String firstName, String lastName, String userName, String cellPhone) {
		driver.findElement(el_firstName).sendKeys(firstName);
		driver.findElement(el_lastName).sendKeys(lastName);
		driver.findElement(el_userName).sendKeys(userName);
		driver.findElement(el_cellPhone).sendKeys(cellPhone);
	}
	
	public void Select_role() {
		driver.findElement(drpd_role).click();
		driver.findElement(btn_save).click();
	}

}
