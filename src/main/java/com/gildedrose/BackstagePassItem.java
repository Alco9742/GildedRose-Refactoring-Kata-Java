package com.gildedrose;

public class BackstagePassItem extends BaseItem {
	public static final String NAME = "Backstage passes to a TAFKAL80ETC concert";
	
	public BackstagePassItem(Item item) {
		super(item);
	}

	@Override
	protected void updateItemQuality(){
		increaseQuality();
		if (item.sellIn <= 10) {
		   	increaseQuality();
	    }	
		if (item.sellIn <= 5) {
		   	increaseQuality();
		}
	}
	
	@Override
	protected void processExpiredItem() {
		item.quality = MINIMUM_QUALITY;
	}
}
