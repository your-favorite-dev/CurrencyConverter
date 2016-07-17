package org.mygroup.currencyconverter.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseFile {

	public List<String> parseLine(String fileName) {
		List<String> lineList = new ArrayList<>();

		try (FileReader inputFile = new FileReader(fileName); 
				BufferedReader br = new BufferedReader(inputFile);) {

			lineList = new ArrayList<String>();
			br.readLine(); // ignores header

			while (br.ready()) {
				lineList.add(br.readLine());
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return lineList;

	}
	
	public List<String[]> parseField(List<String> lines){
		List<String[]> fieldsList = new ArrayList<>();
		for(String s:lines){
			String [] fields = s.split("\t");
			fieldsList.add(fields);
		}
		
		return fieldsList;
	}

}
