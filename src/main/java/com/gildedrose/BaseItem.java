package com.gildedrose;

public class BaseItem {
	protected final Item item;
	
	public BaseItem(Item item) {
		this.item = item;
	}
	
    public static BaseItem create(Item item){
    	switch(item.name) {
    		case AgedBrieItem.NAME:
    			return new AgedBrieItem(item);
    		case BackstagePassItem.NAME:
    			return new BackstagePassItem(item);
    		case SulfurasItem.NAME:
    			return new SulfurasItem(item);
    		default:
    			return new BaseItem(item);
    	}
    }
    
	public void updateItem() {
		updateItemQuality();
		updateItemSellIn();
		if (item.sellIn < 0) {
			processExpiredItem();
		}
	}

	protected void updateItemQuality() {
		decreaseQuality();
	}

	protected void updateItemSellIn() {
		item.sellIn = item.sellIn - 1;
	}
	
	protected void processExpiredItem() {
		decreaseQuality();
	}
	
	protected void increaseQuality() {
		if (item.quality < 50) {
			item.quality++;
		}
	}

	protected void decreaseQuality() {
		if (item.quality > 0) {
			item.quality--;
		}
	}
}
