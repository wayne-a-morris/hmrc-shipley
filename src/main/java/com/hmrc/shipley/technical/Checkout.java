package com.hmrc.shipley.technical;

import java.util.List;

interface Checkout {

	void setSoldItem(String item, Item itemSold);

	String total(List<String> basket);
}
