package com.hmrc.shipley.technical;

public class BasketItem implements Item {

	private int unitCostInPence;
	private int qualifyingUnitsForDiscount;
	private int freeUnitsPerQualifying;

	public BasketItem(int costInPence, int qualifying, int free) {
		this.unitCostInPence = costInPence;
		this.qualifyingUnitsForDiscount = qualifying;
		this.freeUnitsPerQualifying = free;
	}

	@Override
	public int getTotalCostInPence(int numberOfItems) {
		// If no offers then each item is at unit cost
		if (this.qualifyingUnitsForDiscount < 2) {
			return numberOfItems * this.unitCostInPence;
		}
		else {
			int chargeableItems = numberOfItems - ((numberOfItems/this.qualifyingUnitsForDiscount) * this.freeUnitsPerQualifying);
			return chargeableItems * this.unitCostInPence;
		}
	}

}
