package com.gildedrose;

public class BackstagePassItem extends BaseItem {

	public BackstagePassItem(Item item) {
		super(item);
	}

	@Override
	protected void updateItemQuality(){
		increaseQuality();
		if (item.sellIn < 11) {
		   	increaseQuality();
	    }	
		if (item.sellIn < 6) {
		   	increaseQuality();
		}
	}
	
	@Override
	protected void processExpiredItem() {
		item.quality = 0;
	}
}
