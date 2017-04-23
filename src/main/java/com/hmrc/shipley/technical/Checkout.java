package com.hmrc.shipley.technical;

import java.util.List;

interface Checkout {

	void setCost(String item, Integer costInPence);

	String total(List<String> basket);
}
