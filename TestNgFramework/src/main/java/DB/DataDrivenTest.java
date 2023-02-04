package DB;

import org.testng.annotations.DataProvider;

public class DataDrivenTest {
	
	@DataProvider(name="logIn")
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { 1, "a" },
	      new Object[] { 2, "b" },
	    };
	  }
	

}
