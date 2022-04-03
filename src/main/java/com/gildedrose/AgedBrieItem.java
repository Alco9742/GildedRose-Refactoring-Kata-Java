package com.gildedrose;

public class AgedBrieItem extends BaseItem {
	public static final String NAME = "Aged Brie";
	
	public AgedBrieItem(Item item) {
		super(item);
	}

	@Override
	protected void updateItemQuality(){
		increaseQuality();
	}
	
	@Override
	protected void processExpiredItem() {
	    increaseQuality();
	}
}
