package com.qa.TestCases;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class RuniCRATest {

	public static void main(String[] args)
	{
		TestNG Runner=new TestNG();
		List<String> files=new ArrayList<String>();
		files.add(System.getProperty("user.dir")+"\\testng.xml");
		Runner.setTestSuites(files);
		Runner.run();

	}

}
