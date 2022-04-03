package com.gildedrose;

public class BaseItem {
	private final Item item;
	
	public BaseItem(Item item) {
		this.item = item;
	}
	
    static BaseItem create(Item item){
    	return new BaseItem(item);
    }
    
	public void updateItem() {
		updateItemQuality();
		updateItemSellIn();
		if (item.sellIn < 0) {
			processExpiredItem();
		}
	}

	private void updateItemQuality() {
		if (item.name.equals("Aged Brie")){
			increaseQuality();
		}
		else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")){
			increaseQuality();
			if (item.sellIn < 11) {
			   	increaseQuality();
		    }	
			if (item.sellIn < 6) {
			   	increaseQuality();
			}
		}
		else {
			if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
				decreaseQuality();
		    }
		}
	
	}

	private void updateItemSellIn() {
		if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
		    item.sellIn = item.sellIn - 1;
		}
	}
	
	private void processExpiredItem() {
		if (item.name.equals("Aged Brie")) {
		    increaseQuality();
		}
		else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
			item.quality = 0;
		} else if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
			decreaseQuality();
		}
	}
	
	private void increaseQuality() {
		if (item.quality < 50) {
			item.quality++;
		}
	}

	private void decreaseQuality() {
		if (item.quality > 0) {
			item.quality--;
		}
	}
}
