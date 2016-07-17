package org.mygroup.currencyconverter.core;

import org.junit.Before;
import org.junit.Test;

public class FundsDisplayApplicationTest {
	private FundsDisplayApplication fda;
	private String fileName = "FILE.DAT";
	
	@Before
	public void setupBeforeTests(){
		fda = new FundsDisplayApplication();
	}
	@Test
	public void testDipsplaySuccess() {
		fda.display(fileName);
	}

}
