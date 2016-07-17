package org.mygroup.currencyconverter.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;


public class GrouperTest {
	private Grouper grouper;
	private ParseFile pf;
	private List<String> lines;
	private List<String[]> fields;
	
	@Before
	public void setup(){
		grouper = new Grouper();
		pf = new ParseFile();
		lines = pf.parseLine("FILE.DAT");
		fields = pf.parseField(lines);
	}
	@Test
	public void testGroupByCountryMapReturnedSuccess() {
		
		assertFalse(grouper.groupByCountry(fields).isEmpty());
	}
	@Test
	public void testGroupByCountryMapContainsKeys(){
		assertTrue(8 == grouper.groupByCountry(fields).keySet().size());
	}
	@Test
	public void testGroupByCountryMapContainsValue(){
		List<String[]> countryGroup = grouper.groupByCountry(fields).get("London");
		assertFalse(countryGroup.isEmpty());
		for(String[] sa:countryGroup){
			assertTrue(7 == sa.length);
		}
	}
	@Test
	public void testGroupByCurrencyyMapReturnedSuccess() {
		
		assertFalse(grouper.groupByRating(fields).isEmpty());
	}
	@Test
	public void testGroupByCurrencyMapContainsKeys(){
		assertTrue(2 == grouper.groupByRating(fields).keySet().size());
		grouper.groupByRating(fields).keySet().forEach(System.out::println);
	}
	@Test
	public void testGroupByCurrencyMapContainsValue(){
		List<String[]> currencyGroup = grouper.groupByRating(fields).get("CHF");
		assertFalse(currencyGroup.isEmpty());
		for(String[] sa:currencyGroup){
			Stream.of(sa).forEach(System.out::println);
			assertTrue(7 == sa.length);
		}
	}
	

}
