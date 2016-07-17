package org.mygroup.currencyconverter.core;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.mygroup.currencyconverter.enums.Currency;
import org.mygroup.currencyconverter.utils.CurrencyConverter;
import org.mygroup.currencyconverter.utils.Grouper;
import org.mygroup.currencyconverter.utils.ParseFile;

public class FundsDisplayApplication {

	private Grouper grouper;
	private CurrencyConverter converter;
	private ParseFile parser;
	private NumberFormat numFormat;

	public FundsDisplayApplication() {
		this.grouper = new Grouper();
		this.converter = new CurrencyConverter();
		this.parser = new ParseFile();
		this.numFormat = NumberFormat.getInstance(Locale.US);
		numFormat.setMaximumFractionDigits(2);
		numFormat.setMinimumFractionDigits(2);
	}

	public void display(String fileName) {
		List<String> lines = parser.parseLine(fileName);
		List<String[]> fields = parser.parseField(lines);

		Map<String, List<String[]>> groupedByCountry = grouper.groupByCountry(fields);
		Set<String> keySetA = groupedByCountry.keySet();

		for (String s : keySetA) {
			List<String[]> fieldList = groupedByCountry.get(s);
			Map<String, List<String[]>> groupedByCurrency = grouper.groupByRating(fieldList);
			Set<String> keySetB = groupedByCurrency.keySet();
			System.out.println("Region " + s + " :");
			for (String s2 : keySetB) {
				double total = 0.0;
				List<String[]> fieldList2 = groupedByCurrency.get(s2);
				for (String[] sa : fieldList2) {

					if (!sa[5].trim().isEmpty()) {
						total += converter.euroConvert(Currency.valueOf(sa[5]), Double.parseDouble(sa[6]));
					} else {
						total += Double.parseDouble(sa[6]);
					}

				}

				System.out.println("Rating " + s2 + " total in Euros is: " + numFormat.getCurrency().getSymbol()
						+ numFormat.format(total));

			}

		}
	}
}
