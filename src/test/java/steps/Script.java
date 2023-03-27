package steps;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Script 
{   
	WebDriver d1;
	
	@Given("Open the chrome browser and url of the applation")
	public void open_the_chrome_browser_and_url_of_the_applation()
	{
		   
   	 
		   System.setProperty("webdriver.chrome.driver","D:\\softwares\\chromedriver_win32\\chromedriver.exe");
	       d1 = new ChromeDriver();
	       d1.get("https://www.amazon.in/");
	       d1.manage().window().maximize();
	}

	@When("Enter valid username and valid userpassword & click on search option selection the phone & add to the cart")
	public void enter_valid_username_and_valid_userpassword_click_on_search_option_selection_the_phone_add_to_the_cart() throws InterruptedException, AWTException, IOException 
	{
		Thread.sleep(3000);
	       
	       d1.findElement(By.linkText("Sign in")).click();        //loginclick
	       
	       d1.findElement(By.id("ap_email")).sendKeys("9910305181");   //mobilenumberenterLogin
	       d1.findElement(By.id("continue")).click();       //continue
	       
	       d1.findElement(By.id("ap_password")).sendKeys("Quantum@25");           //loginPassword
	       d1.findElement(By.id("signInSubmit")).click();                //continue
	       
	       Thread.sleep(2000);
	       
	       d1.findElement(By.xpath("(//input[@id='twotabsearchtextbox'])[1]")).sendKeys("samsung fold");    //phoneSearch
	       
	       Robot r2 = new Robot();
	       Thread.sleep(2000);
	       r2.keyPress(KeyEvent.VK_DOWN);
	       r2.keyRelease(KeyEvent.VK_DOWN);
	       r2.keyPress(KeyEvent.VK_DOWN);
	       r2.keyRelease(KeyEvent.VK_DOWN);
	       r2.keyPress(KeyEvent.VK_ENTER);
	       r2.keyRelease(KeyEvent.VK_ENTER);
	       
	       
	       d1.findElement(By.linkText("Samsung Galaxy Z Fold4 5G (Graygreen, 12GB RAM, 512GB Storage) with No Cost EMI/Additional Exchange Offers")).click();    //selectphone
	       
	       
	       String w1 = d1.getTitle();                                             //w1kTitlekliyehai
	       Set<String> windows=d1.getWindowHandles();                             //handles
	       Iterator<String> iter=windows.iterator();                                  //iterator
	       String window1=iter.next();
	       String window2=iter.next();
	       d1.switchTo().window(window2);
	       String w2=d1.getTitle();
	       System.out.println(w1);
	       System.out.println(w2);
	       System.out.println(window1);
	       System.out.println(window2);
	       
	       
	       Thread.sleep(3000);
	       JavascriptExecutor js =(JavascriptExecutor) d1;           //scrolldownuse
	       js.executeScript("scroll(0,500)");
	       
	       
	       d1.findElement(By.id("a-autoid-12")).click();             //selectphonecolor
	       Thread.sleep(2000);
	       d1.findElement(By.id("add-to-cart-button")).click();      //addtocartphone
	       
	       

	       Robot r3 = new Robot();                                                                 //screenshoot
	       Dimension screenshoot_size= Toolkit.getDefaultToolkit().getScreenSize();
	       Rectangle rec = new Rectangle(screenshoot_size);
	       BufferedImage Source= r3.createScreenCapture(rec);
	       File destination = new File("C:\\Users\\NITIN YADAV\\Pictures\\screen1.png");
	       ImageIO.write(Source, "png", destination);
	      
	}

	@Then("successfully page open and phone show add-to-cart")
	public void successfully_page_open_and_phone_show_add_to_cart()
	{
	    System.out.println("succesfully page open & phone show add-to-cart");
	}

}
