package com.balaji.core.utils;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase {
	
	
	
	
	@Test(retryAnalyzer=RetryTestcase.class)
	public void testcase1() {
		Assert.assertEquals(true, false);
	}
	
	

	@Test
	public void testcase2() {
		Assert.assertEquals(true, false);
	}
	
	
	
	
	

}
