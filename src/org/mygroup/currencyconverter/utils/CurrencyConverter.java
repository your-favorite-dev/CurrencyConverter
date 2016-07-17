package org.mygroup.currencyconverter.utils;

import org.mygroup.currencyconverter.enums.Currency;

public class CurrencyConverter {
	
	public double euroConvert(Currency currency, double ammount){
		double total = currency.getConversion() * ammount;

		return total/Currency.EUR.getConversion();
	}
}
