package com.hmrc.shipley.technical;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class BasketCheckoutTest {

	private static final String LEMON = "Lemon";

	private static Checkout checkout;

	private static Item apple;
	private static Item orange;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		apple = new BasketItem(
				CheckoutConstants.APPLE_COST_IN_PENCE,
				CheckoutConstants.APPLE_QUALIFYING_COUNT,
				CheckoutConstants.APPLE_FREE_COUNT);
		orange = new BasketItem(
				CheckoutConstants.ORANGE_COST_IN_PENCE,
				CheckoutConstants.ORANGE_QUALIFYING_COUNT,
				CheckoutConstants.ORANGE_FREE_COUNT);
		checkout = new BasketCheckout();
		checkout.setSoldItem(CheckoutConstants.APPLE, apple);
		checkout.setSoldItem(CheckoutConstants.ORANGE, orange);
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
		assertEquals("£0.60",checkout.total(basket));
	}

	@Test
	public void testTotal_ThreeApples() {
		List<String> basket = Arrays.asList(
				CheckoutConstants.APPLE,
				CheckoutConstants.APPLE,
				CheckoutConstants.APPLE);
		assertEquals("£1.20",checkout.total(basket));
	}

	@Test
	public void testTotal_FourApples() {
		List<String> basket = Arrays.asList(
				CheckoutConstants.APPLE,
				CheckoutConstants.APPLE,
				CheckoutConstants.APPLE,
				CheckoutConstants.APPLE);
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
	public void testTotal_ThreeOranges() {
		List<String> basket = Arrays.asList(
				CheckoutConstants.ORANGE,
				CheckoutConstants.ORANGE,
				CheckoutConstants.ORANGE);
		assertEquals("£0.50",checkout.total(basket));
	}

	@Test
	public void testTotal_FourOranges() {
		List<String> basket = Arrays.asList(
				CheckoutConstants.ORANGE,
				CheckoutConstants.ORANGE,
				CheckoutConstants.ORANGE,
				CheckoutConstants.ORANGE);
		assertEquals("£0.75",checkout.total(basket));
	}

	@Test
	public void testTotal_ThreeMixedcaseApples() {
		List<String> basket = Arrays.asList("Apple","APPle","apple");
		assertEquals("£1.20",checkout.total(basket));
	}

	@Test
	public void testTotal_MixedBasket() {
		List<String> basket = Arrays.asList(
				CheckoutConstants.ORANGE,
				LEMON,
				CheckoutConstants.APPLE,
				CheckoutConstants.ORANGE,
				CheckoutConstants.APPLE);
		assertEquals("£1.10",checkout.total(basket));
	}

	// Test for when there is no offer on an item
	@Test
	public void testTotal_NoOfferOnApples() {
		Item apple = new BasketItem(
				CheckoutConstants.APPLE_COST_IN_PENCE,
				1,
				CheckoutConstants.APPLE_FREE_COUNT);
		Checkout checkout = new BasketCheckout();
		checkout.setSoldItem(CheckoutConstants.APPLE, apple);
		List<String> basket = Arrays.asList("Apple","APPle","apple");
		assertEquals("£1.80",checkout.total(basket));
	}
}
