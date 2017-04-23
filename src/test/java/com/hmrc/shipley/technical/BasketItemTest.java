package com.hmrc.shipley.technical;

import static org.junit.Assert.*;

import org.junit.Test;

public class BasketItemTest {

	private static Item item;

	@Test
	public void testGetTotalCostInPence_NoOffers() {
		item = new BasketItem(
				CheckoutConstants.APPLE_COST_IN_PENCE,
				1,
				CheckoutConstants.APPLE_FREE_COUNT);
		assertEquals(180,item.getTotalCostInPence(3));
	}

	@Test
	public void testGetTotalCostInPence_BuyOneGetOneFree() {
		item = new BasketItem(
				CheckoutConstants.APPLE_COST_IN_PENCE,
				2,
				CheckoutConstants.APPLE_FREE_COUNT);
		assertEquals(120,item.getTotalCostInPence(4));
	}

	@Test
	public void testGetTotalCostInPence_ThreeForPriceOfTwo() {
		item = new BasketItem(
				CheckoutConstants.APPLE_COST_IN_PENCE,
				3,
				CheckoutConstants.APPLE_FREE_COUNT);
		assertEquals(120,item.getTotalCostInPence(3));
	}

	@Test
	public void testGetTotalCostInPence_BuyFourGetTwoFree() {
		item = new BasketItem(
				CheckoutConstants.APPLE_COST_IN_PENCE,
				4,
				2);
		assertEquals(120,item.getTotalCostInPence(4));
	}

}
