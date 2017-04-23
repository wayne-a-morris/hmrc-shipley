package com.hmrc.shipley.technical;

import java.util.Arrays;

public class CheckoutMain {

	public static void main(String[] args) {

		if (args.length > 0) {
			Item apple = new BasketItem(
					CheckoutConstants.APPLE_COST_IN_PENCE,
					CheckoutConstants.APPLE_QUALIFYING_COUNT,
					CheckoutConstants.APPLE_FREE_COUNT);
			Item orange = new BasketItem(
					CheckoutConstants.ORANGE_COST_IN_PENCE,
					CheckoutConstants.ORANGE_QUALIFYING_COUNT,
					CheckoutConstants.ORANGE_FREE_COUNT);
			Checkout checkout = new BasketCheckout();
			checkout.setSoldItem(CheckoutConstants.APPLE, apple);
			checkout.setSoldItem(CheckoutConstants.ORANGE, orange);

			System.out.println("Basket cost: " + checkout.total(Arrays.asList(args)));
		}
		else
			System.out.println("Please provide a list of space separated fruits e.g. \"Apple\" \"Orange\"");

	}

}
