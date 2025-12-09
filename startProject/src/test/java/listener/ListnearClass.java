package listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnearClass implements ITestListener{

	public void onTestStart(ITestResult result) {
	   System.out.println("Test Start : "+ result.getName());
	  }

	 public void onTestSuccess(ITestResult result) {
	    System.out.println("Test pass : "+ result.getName());
	  }

	 
	 public void onTestFailure(ITestResult result) {
	    System.out.println("Test Fail: " +result.getName());
	  }

	  public void onTestSkipped(ITestResult result) {
		  System.out.println("Test skiped: "+ result.getName());
	  }

	  
	  public void onStart(ITestContext context) {
		  System.err.println("---------START-------");
	  }

	  /**
	   * Invoked after all the test methods belonging to the classes inside the &lt;test&gt; tag have
	   * run and all their Configuration methods have been called.
	   *
	   * @param context The test context
	   */
	  public void onFinish(ITestContext context) {
	  
	  System.out.println("---------finished----------");
	}
	
}
