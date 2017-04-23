package com.hmrc.shipley.technical;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BasketCheckout implements Checkout {

	Map<String, Integer> itemsSold = new HashMap<String,Integer>();

	@Override
	public void setCost(String item, Integer costInPence) {
		itemsSold.put(item, costInPence);
	}

	protected Integer getCost(String item) {
		return itemsSold.get(item);
	}

	@Override
	public String total(List<String> basket) {

		// Only deal with items sold
		List<String> soldItems = basket.stream()
				.map(item -> item.toUpperCase())
				.filter(item -> itemsSold.containsKey(item))
				.collect(Collectors.toList());

		// Calculate cost in pounds
		Integer total = 0;
		for (String item : soldItems) {
			total = total + itemsSold.get(item);
		}
		StringBuilder sb = new StringBuilder("£");
		sb.append(total/100).append(".").append(total%100 < 10 ? "0" : "").append(total%100);
		return sb.toString();
	}

}
