package com.hmrc.shipley.technical;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BasketCheckout implements Checkout {

	Map<String, Item> itemsSold = new HashMap<String,Item>();

	@Override
	public void setSoldItem(String item, Item basketItem) {
		itemsSold.put(item, basketItem);
	}

	@Override
	public String total(List<String> basket) {

		// Only deal with items sold
		List<String> soldItems = basket.stream()
				.map(item -> item.toUpperCase())
				.filter(item -> itemsSold.containsKey(item))
				.collect(Collectors.toList());

		Set<String> itemName = itemsSold.keySet();
		Map<String,Integer> itemQuantity = new HashMap<String,Integer>();

		// Calculate total cost in pence
		Integer total = 0;
		for (String item: itemName) {
			int itemCount = filterList(soldItems,item).size();
			total = total + itemsSold.get(item).getTotalCostInPence(itemCount);
		}

		// Return total cost in pounds as a String
		StringBuilder sb = new StringBuilder("£");
		sb.append(total/100).append(".").append(total%100 < 10 ? "0" : "").append(total%100);
		return sb.toString();
	}

	private List<String> filterList(List<String> list, String keep) {
		return list.stream().filter(entry -> entry.equalsIgnoreCase(keep)).collect(Collectors.toList());
	}
}
