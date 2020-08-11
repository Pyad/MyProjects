package com.inter.test;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Cclass extends Bclass{
	
	private static Logger Log = Logger.getLogger(Logger.class.getName());
	
	static Logger log = LogManager.getLogger(Cclass.class);
	
	public static void main(String args[])
	   {
		DOMConfigurator.configure("log4j.xml");
		log.star
		Cclass obj=new Cclass();
		obj.Maruti();
		System.out.println(obj.a);
//		obj.a;

	   }
	
	
	
	
	

}
