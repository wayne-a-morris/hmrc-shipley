package com.hmrc.shipley.technical;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class BasketCheckoutTest {

	private static final String LEMON = "Lemon";

	private static BasketCheckout checkout;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		checkout = new BasketCheckout();
		checkout.setCost(CheckoutConstants.APPLE, CheckoutConstants.APPLE_COST_IN_PENCE);
		checkout.setCost(CheckoutConstants.ORANGE, CheckoutConstants.ORANGE_COST_IN_PENCE);
	}

	@Test
	public void testTotal_NoSoldItems() {
		List<String> basket = Arrays.asList(LEMON);
		assertEquals("£0.00",checkout.total(basket));
	}

	@Test
	public void testTotal_OneApple() {
		List<String> basket = Arrays.asList(CheckoutConstants.APPLE);
		assertEquals("£0.60",checkout.total(basket));
	}

	@Test
	public void testTotal_TwoApples() {
		List<String> basket = Arrays.asList(CheckoutConstants.APPLE,CheckoutConstants.APPLE);
		assertEquals("£1.20",checkout.total(basket));
	}

	@Test
	public void testTotal_OneOrange() {
		List<String> basket = Arrays.asList(CheckoutConstants.ORANGE);
		assertEquals("£0.25",checkout.total(basket));
	}

	@Test
	public void testTotal_TwoOranges() {
		List<String> basket = Arrays.asList(CheckoutConstants.ORANGE,CheckoutConstants.ORANGE);
		assertEquals("£0.50",checkout.total(basket));
	}

	@Test
	public void testTotal_ThreeMixedcaseApples() {
		List<String> basket = Arrays.asList("Apple","APPle","apple");
		assertEquals("£1.80",checkout.total(basket));
	}

	@Test
	public void testTotal_MixedBasket() {
		List<String> basket = Arrays.asList(
				CheckoutConstants.ORANGE,
				LEMON,
				CheckoutConstants.APPLE,
				CheckoutConstants.ORANGE,
				CheckoutConstants.APPLE);
		assertEquals("£1.70",checkout.total(basket));
	}

}
