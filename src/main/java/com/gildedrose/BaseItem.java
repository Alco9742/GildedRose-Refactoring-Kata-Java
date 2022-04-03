package com.gildedrose;

public class BaseItem {
	protected final Item item;
	
	public BaseItem(Item item) {
		this.item = item;
	}
	
    public static BaseItem create(Item item){
    	if (item.name.equals("Aged Brie")){
    		return new AgedBrieItem(item);
    	}
    	if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")){
    		return new BackstagePassItem(item);
    	}
    	if (item.name.equals("Sulfuras, Hand of Ragnaros")){
    		return new SulfurasItem(item);
    	}
    	return new BaseItem(item);
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
