package main;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import UserProfile.UserProfile;
//import login.login;
import FilterTask.FilterTask;
import FilterTask1.FilterTask1;
import FilterTask2.FilterTask2;
import register.register;
import createTask.createTask;
//import editTask.editTask;
//import deleteTask.deleteTask;
import login.login;

public class main {

	private WebDriver driver;
	
	@BeforeTest
    public void setup() {
        System.setProperty("webdriver.edge.driver", "C:/tools/selenium/msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
		driver.get("http://localhost:5173/login");
    }
	
    @Test(dataProvider = "getData",priority = 1,enabled = false) 
    
    public void testRegister(String fullName, Integer phoneNumber, String email, String password, String path) {
        register registerObj = new register(driver);
        registerObj.Register(fullName, phoneNumber, email, password,path);
    }

    @Test(dataProvider = "getDataLogin",priority = 2,enabled = true)
    
    public void testLogin(String email, String password) {
        login loginObj = new login(driver);
        loginObj.Login(email, password,true);
    }
    
@Test(dataProvider = "TaskGenerate",priority = 3,enabled = false)
    
    public void testCreateTask(String title, String description) {
		createTask taskObj = new createTask(driver);
		taskObj.Task(title, description);
    }

//@Test(dataProvider = "TaskEdit",priority = 4,enabled = true)
//
//public void testEditTask(String title, String description) {
//	editTask etaskObj = new editTask(driver);
//	etaskObj.eTask(title, description);
//}

  @Test(priority = 5,enabled = true)
  
  public void testProfile() {
		UserProfile profileObj = new UserProfile(driver);
		profileObj.profile();
  }
    
  @Test(priority = 6,enabled = true)
  
  public void testFilter() {
	  FilterTask filterObj = new FilterTask(driver);
		filterObj.fTask();
  }
  
  @Test(priority = 7,enabled = true)
  
  public void testFilter1() {
	  FilterTask1 filterObj1 = new FilterTask1(driver);
		filterObj1.f1Task();
  }
  
  @Test(priority = 8,enabled = true)
  
  public void testFilter2() {
	  FilterTask2 filterObj2 = new FilterTask2(driver);
		filterObj2.f2Task();
  }

//  
//    @Test(priority = 3)
//    
//    public void movieBooking() {
//        login loginObj = new login(driver);
//        loginObj.Login("Test1@gmail.com", "Test@123",false);
//        
//        
//    }
    
    @DataProvider
	public Object[][]getDataLogin(){
		Object[][]obj=new Object[2][2];
		obj[0][0]="sarthak0117@gmail.com";
		obj[0][1]="12345678";
		obj[1][0]="pranavgupta7@gmail.com";
		obj[1][1]="12345678";
//		obj[2][0]="Thakur2003@gmail.com";
//		obj[2][1]="123";	
		return obj;
	}
    
    
    @DataProvider
	public Object[][]getData(){
		Object[][]obj=new Object[1][5];
		obj[0][0]="Sarthak";
		obj[0][1]=925566140;
		obj[0][2]="pranavgupta790@gmail.com";
		obj[0][3]="12345678";
		obj[0][4]="C:/Users/ROG/OneDrive/Pictures/Screenshots/Screenshot 2024-04-28 021627.png";
		return obj;
	}
    
    @DataProvider
	public Object[][]TaskGenerate(){
		Object[][]obj=new Object[3][2];
		obj[0][0]="HomeWork";
		obj[0][1]="Do Study!!";
		obj[1][0]="Games";
		obj[1][1]="Play Badminton!";
		obj[2][0]="Meal";
		obj[2][1]="Have Dinner";	
		return obj;
	}
    
	@AfterTest
	public void tearDown() {
		// Close the browser
		driver.quit();
	}
}