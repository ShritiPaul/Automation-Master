package StepDefinition;

import java.util.List;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {

	WebDriver driver;

	@Given("^I enter an invalid postal code as \"(.*?)\"$")
	public void i_enter_an_invali_postal_code_as(String arg1) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shriti\\Desktop\\Software\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.just-eat.co.uk/");
		driver.findElement(By.name("postcode")).sendKeys(arg1);

	}

	@When("^I try to search for restaurants$")
	public void i_try_to_search_for_restaurants() throws Throwable {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Then("^I should see an error message$")
	public void i_should_see_an_error_message() throws Throwable {
		String errormessage = driver.findElement(By.xpath("//div[@id='errorMessage']")).getText();
		if (errormessage.contains("Please enter a full, valid postcode")) {
			System.out.println("Valid error message is displayed upon entering wrong postal code");
		}

		driver.close();
	}

	@Given("^I want food in \"(.*?)\"$")
	public void i_want_food_in(String arg1) throws Throwable {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.just-eat.co.uk/");
		driver.findElement(By.name("postcode")).sendKeys("AR51 1AA");

	}

	@When("^I search for restaurants$")
	public void i_search_for_restaurants() throws Throwable {

		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

	@Then("^I should see some restaurants in the area$")
	public void i_should_see_some_restaurants_in_the_area() throws Throwable {
		String areacode = driver.findElement(By.xpath("(//span[@class='c-contentHeader-subTitle'])[1]")).getText();
		List<WebElement> noOfRestaurants = driver
				.findElements(By.xpath("//div[@data-test-id='openrestaurants']//section"));
		if ((noOfRestaurants.size() != 0) && (areacode.contains("AR51 1AA"))) {
			System.out.println(noOfRestaurants.size() + " open restaurants found in the area");
			driver.close();
		}
	}

	@Given("^I enter a valid postal code in the search box$")
	public void i_enter_a_valid_postal_code_in_the_search_box() throws Throwable {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.just-eat.co.uk/");
		driver.navigate().back();
		driver.findElement(By.name("postcode")).sendKeys("AR51 1AA");
	}

	@When("^I press ENTER key$")
	public void i_press_ENTER_key() throws Throwable {
		driver.findElement(By.xpath("//button[@type='submit']")).sendKeys(Keys.ENTER);

	}

}
