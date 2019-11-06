package net.talaatharb.selenium;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Selenium Test application
 * 
 * @author mharb
 *
 */
public class SeleniumApplication {

	/**
	 * Wait time between actions
	 */
	private static final int WAIT_TIME = 750;

	/**
	 * Site URL to enter
	 */
	private static final String SITE_URL = "https://www.facebook.com";

	/**
	 * Logger
	 */
	private static final Logger LOGGER = Logger.getLogger(SeleniumApplication.class.getName());

	/**
	 * Main application entry point
	 * 
	 * @param args The arguments to the application
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		// Configure logger
		LOGGER.setLevel(Level.INFO);
		System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tF %1$tT] [%4$-7s] %5$s %n");

		// Creating web driver
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		final WebDriver webDriver = new ChromeDriver();
		LOGGER.info("Web driver created");

		// Opening web site
		webDriver.get(SITE_URL);
		LOGGER.info("Site: \"" + SITE_URL + "\" is open");

		webDriver.manage().window().maximize();
		LOGGER.info("Window maximized");
		Thread.sleep(WAIT_TIME);

		// Filling form details
		// First name
		final WebElement firstNameElement = webDriver.findElement(By.id("u_0_f"));
		firstNameElement.sendKeys("Test");
		LOGGER.info("First name entered");
		Thread.sleep(WAIT_TIME);

		// Last name
		final WebElement lastNameElement = webDriver.findElement(By.id("u_0_h"));
		lastNameElement.sendKeys("Test");
		LOGGER.info("Last name entered");
		Thread.sleep(WAIT_TIME);

		// Email
		final WebElement emailElement = webDriver.findElement(By.id("u_0_k"));
		emailElement.sendKeys("Test@test.com");
		LOGGER.info("Email entered");
		Thread.sleep(WAIT_TIME);

		// Repeated Email
		final WebElement repeatedEmailElement = webDriver.findElement(By.id("u_0_n"));
		repeatedEmailElement.sendKeys("Test@test.com");
		LOGGER.info("Repeated email entered");
		Thread.sleep(WAIT_TIME);

		// Password
		final WebElement passwordElement = webDriver.findElement(By.id("u_0_p"));
		passwordElement.sendKeys("Test");
		LOGGER.info("Password entered");
		Thread.sleep(WAIT_TIME);

		// Month
		final WebElement monthElement = webDriver.findElement(By.xpath("//*[@id=\"month\"]"));
		monthElement.click();
		monthElement.sendKeys("jjj");
		LOGGER.info("Month chosen");
		Thread.sleep(WAIT_TIME);
		monthElement.click();

		// Day
		final WebElement dayElement = webDriver.findElement(By.xpath("//*[@id=\"day\"]"));
		dayElement.click();
		dayElement.sendKeys("7");
		LOGGER.info("Day chosen");
		Thread.sleep(WAIT_TIME);
		dayElement.click();

		// Year
		final WebElement yearElement = webDriver.findElement(By.xpath("//*[@id=\"year\"]"));
		yearElement.click();
		yearElement.sendKeys("2");
		yearElement.click();
		yearElement.click();
		yearElement.sendKeys("111111111111");
		LOGGER.info("Year chosen");
		yearElement.click();
		Thread.sleep(WAIT_TIME);

		// Gender = male
		WebElement genderMaleElement;
		try {
			genderMaleElement = webDriver.findElement(By.xpath("//*[@id=\"u_0_a\"]"));
		} catch (final NoSuchElementException e) {
			LOGGER.warning("Failed to get gender by using alphabetic ID");
			genderMaleElement = webDriver.findElement(By.xpath("//*[@id=\"u_0_7\"]"));
			LOGGER.info("Trying numeric ID works");
		}
		genderMaleElement.click();
		LOGGER.info("Gender chosen");
		Thread.sleep(WAIT_TIME);

		// Sign up button
		final WebElement signUpElement = webDriver.findElement(By.id("u_0_w"));
		signUpElement.click();
		LOGGER.info("Sign up clicked");
		Thread.sleep(3000);

		// Quitting
		webDriver.quit();
		LOGGER.info("Web driver terminated");

		System.exit(0);
	}
}
