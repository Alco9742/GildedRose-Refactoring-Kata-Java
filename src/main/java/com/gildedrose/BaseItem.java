package com.gildedrose;

public class BaseItem {
	public static final int MINIMUM_QUALITY = 0;
	private static final int MAXIMUM_QUALITY = 50;
	
	protected final Item item;

	
	public BaseItem(Item item) {
		this.item = item;
	}
	
    public static BaseItem create(Item item){
    	if (item.name.equals(AgedBrieItem.NAME)){
    		return new AgedBrieItem(item);
    	}
    	if (item.name.equals(BackstagePassItem.NAME)){
    		return new BackstagePassItem(item);
    	}
    	if (item.name.equals(SulfurasItem.NAME)){
    		return new SulfurasItem(item);
    	}
    	if (item.name.startsWith(ConjuredItem.NAME)){
    		return new ConjuredItem(item);
    	}
    	return new BaseItem(item);
    }
    
	public void updateItem() {
		updateItemQuality();
		updateItemSellIn();
		if (isExpired()) {
			processExpiredItem();
		}
	}

	protected void updateItemQuality() {
		decreaseQuality();
	}

	protected void updateItemSellIn() {
		item.sellIn--;
	}
	
	protected void processExpiredItem() {
		decreaseQuality();
	}
	
	protected void increaseQuality() {
		if (item.quality < MAXIMUM_QUALITY) {
			item.quality++;
		}
	}

	protected void decreaseQuality() {
		if (item.quality > MINIMUM_QUALITY) {
			item.quality--;
		}
	}
	
	private boolean isExpired() {
		return item.sellIn < 0;
	}
}
