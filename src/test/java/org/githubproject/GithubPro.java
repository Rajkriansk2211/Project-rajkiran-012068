package org.githubproject;

import org.Gitprojectss.BaseClass;
import org.junit.Test;

public class GithubPro extends BaseClass {

	
	
	@Test
	public void test()  {
		launchBrowser3("chrome");
		implicitlyWait(10);
		urllaunch("https://www.facebook.com/");
	}

}
