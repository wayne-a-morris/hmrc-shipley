package com.hmrc.shipley.technical;

import java.util.Arrays;

public class CheckoutMain {

	public static void main(String[] args) {

		if (args.length > 0) {
			Checkout checkout = new BasketCheckout();
			checkout.setCost(CheckoutConstants.APPLE, CheckoutConstants.APPLE_COST_IN_PENCE);
			checkout.setCost(CheckoutConstants.ORANGE, CheckoutConstants.ORANGE_COST_IN_PENCE);

			System.out.println("Basket cost: " + checkout.total(Arrays.asList(args)));
		}
		else
			System.out.println("Please provide a list of space separated fruits e.g. \"Apple\" \"Orange\"");

	}

}
