package com.qa.TestCases;

public class Static 
{
  	static int k;
  	
	static void x()
	{
		k=500;
		System.out.println(k);
	}
	
	void y() throws CloneNotSupportedException
	{
		x();
		k=80;
		System.out.println(k);
		System.out.println(super.clone());
	}
	public static void main(String[] args)
	{
		x();
		Static s=new Static();
		try
		{
		   s.y();
		}
		catch(Exception e)
		{
			
		}
		
	}
	
}
