package com.gildedrose;

public class ConjuredItem extends BaseItem {
	public static final String NAME = "Conjured";
	
	public ConjuredItem(Item item) {
		super(item);
	}

	@Override
	protected void updateItemQuality(){
		decreaseQuality();
		decreaseQuality();
	}
}
