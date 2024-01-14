import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class prameter {
	static WebDriver driver = new ChromeDriver();
	static String MyWebsite = "https://www.saucedemo.com";
	static String UserName = "standard_user";
	static String Password = "secret_sauce";

	static void login() {
		WebElement UserNameInput = driver.findElement(By.id("user-name"));
		WebElement PasswordInput = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.name("login-button"));
		UserNameInput.sendKeys(UserName);
		PasswordInput.sendKeys(Password);
		loginButton.click();
	}

	static void add(String... items) {
		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));
		List<WebElement> ProductsNames = driver.findElements(By.className("inventory_item_name"));
		for (int i = 0; i < ProductsNames.size(); i++) {
			String ProductName = ProductsNames.get(i).getText();
			if (Contain(ProductName, items))
				AddToCartButtons.get(i).click();
		}
	}

	private static boolean Contain(String str, String... subStrings) {
		for (String subString : subStrings) {
			if (str.contains(subString)) {
				return true;
			}
		}
		return false;
	}

	static void logout() throws InterruptedException {
		driver.findElement(By.id("react-burger-menu-btn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("reset_sidebar_link")).click();
		Thread.sleep(1000);
		driver.navigate().refresh();
		driver.findElement(By.id("react-burger-menu-btn")).click();
		Thread.sleep(1000);
        driver.findElement(By.id("logout_sidebar_link")).click();	
	}
}