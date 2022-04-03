package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItem(item);
        }
    }

	private void updateItem(Item item) {
		updateItemQuality(item);
		updateItemSellIn(item);
		if (item.sellIn < 0) {
			processExpiredItem(item);
		}
	}

	private void updateItemQuality(Item item) {
		if (item.name.equals("Aged Brie")){
			increaseQuality(item);
		}
		else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")){
			increaseQuality(item);
			if (item.sellIn < 11) {
			   	increaseQuality(item);
		    }	
			if (item.sellIn < 6) {
			   	increaseQuality(item);
			}
		}
		else {
			if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
				decreaseQuality(item);
		    }
		}
	
	}

	private void updateItemSellIn(Item item) {
		if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
		    item.sellIn = item.sellIn - 1;
		}
	}
	
	private void processExpiredItem(Item item) {
		if (item.name.equals("Aged Brie")) {
		    increaseQuality(item);
		}
		else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
			item.quality = 0;
		} else if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
			decreaseQuality(item);
		}
	}
	
	private void increaseQuality(Item item) {
		if (item.quality < 50) {
			item.quality++;
		}
	}

	private void decreaseQuality(Item item) {
		if (item.quality > 0) {
			item.quality--;
		}
	}
	
}