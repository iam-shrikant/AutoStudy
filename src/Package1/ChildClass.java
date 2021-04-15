package Package1;

public class ChildClass extends BaseClass {
	
	public void loadUrl() {
		driver.get("https://www.facebook.com/");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChildClass c = new ChildClass();
		c.setEnvDriver();
		c.loadUrl();
	}

}
