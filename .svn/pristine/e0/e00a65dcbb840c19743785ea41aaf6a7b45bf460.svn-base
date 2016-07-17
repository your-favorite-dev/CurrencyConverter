package org.mygroup.currencyconverter.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ParseFileTest {
	private ParseFile pf;
	private String fileName = "FILE.DAT";
	
	@Before
	public void setup(){
		pf = new ParseFile();
	}
	@Test
	public void testParseLineReadsLineFromFile() {
		assertNotNull(pf.parseLine(fileName));
		assertFalse(pf.parseLine(fileName).isEmpty());
		assertTrue(pf.parseLine(fileName).size() > 0);
	}
	@Test
	public void testParseLineIgnoresHeader(){
		assertTrue(pf.parseLine(fileName).get(0).charAt(0) != 'C');
	}
	@Test
	public void testParseFieldsSuccess(){
		assertNotNull(pf.parseField(pf.parseLine(fileName)));
	}
	@Test
	public void testParseFieldsFail(){
		assertFalse(!pf.parseField(new ArrayList<String>()).isEmpty());
	}
	@Test
	public void testParseFieldParsesLinesCorrectly(){
		List<String[]> fieldsList = pf.parseField(pf.parseLine(fileName));
		for(String[] sa:fieldsList){
			assertTrue(7 == sa.length);
		}
		
	}

}
