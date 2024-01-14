import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases extends prameter {
	@BeforeTest
	public void MySetup() {
		driver.get(MyWebsite);
		driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void addtwoitmes() throws InterruptedException {
		login();
		Thread.sleep(3000);
		add("Backpack","Light");
		Thread.sleep(3000);
		logout();
			}
	
	@Test(priority = 2)
	public void addthreeitmes() throws InterruptedException {
		login();
		Thread.sleep(3000);
		add("Fleece","Bolt T-Shirt","Backpack");
		Thread.sleep(3000);
		logout();
			}
	@Test(priority = 3)
	public void addfouritmes() throws InterruptedException {
		login();
		Thread.sleep(3000);
		add("Backpack","Light","Bolt T-Shirt","Fleece");
			}
	
	@AfterTest
	public void MyPostTesting() {}
}