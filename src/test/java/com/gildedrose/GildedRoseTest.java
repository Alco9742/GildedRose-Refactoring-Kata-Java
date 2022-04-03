package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        GildedRose app = testItem("foo", 0 , 0);
        assertEquals("foo", app.items[0].name);
    }
 
    @Test
    void sellByDatePassedDegradeDouble() {
    	//Once the sell by date has passed, Quality degrades twice as fast
    	GildedRose app = testItem("Any", 0, 20);
		assertEquals(18, app.items[0].quality);
    }
    
    
    @Test
    void sellByDateNotPassedDegradeSingle() {
    	//If the sell by date hasn't passed yet, degrade single
    	GildedRose app = testItem("Any", 5, 20);
		assertEquals(19, app.items[0].quality);
    }
    
	@Test
	public void qualityNotNegative() {
		//The Quality of an item is never negative
		GildedRose app = testItem("Any", 0, 0);
		assertEquals(0, app.items[0].quality);
	}
	
	@Test
	public void agedBrieImprovesInQuality() {
		// "Aged Brie" actually increases in Quality the older it gets
		GildedRose app = testItem("Aged Brie", 0, 6);
		assertEquals(8, app.items[0].quality);
	}

	@Test
	public void qualityNotOver50() {
		//The Quality of an item is never more than 50
		GildedRose app = testItem("Aged Brie", 0, 50);
		assertEquals(50, app.items[0].quality);
	}

	@Test
	public void sulfurasDoesntDecreaseInQuality() {
		//"Sulfuras", being a legendary item, never has to be sold or decreases in Quality
		GildedRose app = testItem("Sulfuras, Hand of Ragnaros", 0, 80);
		assertEquals(80, app.items[0].quality);
	}
    

	@Test
	public void backstageQualityIncreases() {
		//"Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
		GildedRose app = testItem("Backstage passes to a TAFKAL80ETC concert", 50, 40);
		assertEquals(41, app.items[0].quality);
	}

	@Test
	public void backstageQualityIncreasesDoubleWhen10Days() {
		//Quality increases by 2 when there are 10 days or less
		GildedRose app = testItem("Backstage passes to a TAFKAL80ETC concert", 9, 40);
		assertEquals(42, app.items[0].quality);
	}

	@Test
	public void backstageQualityIncreasesTripleWhen5Days() {
		//and by 3 when there are 5 days or less
		GildedRose app = testItem("Backstage passes to a TAFKAL80ETC concert", 4, 40);
		assertEquals(43, app.items[0].quality);
	}
    
	@Test
	public void backstageQualityDropsToZeroAfterConcert() {
		//Quality drops to 0 after the concert
		GildedRose app = testItem("Backstage passes to a TAFKAL80ETC concert", 0, 40);
		assertEquals(0, app.items[0].quality);
	}
	
	@Test
	public void sulfurasSellInDoesntChange() {
		//"Sulfuras", being a legendary item, never has to be sold or decreases in Quality
		GildedRose app = testItem("Sulfuras, Hand of Ragnaros", 100, 80);
		assertEquals(100, app.items[0].sellIn);
	}
	
	@Test
	public void otherItemsSellInDoesChange() {
		//"Sulfuras", being a legendary item, never has to be sold or decreases in Quality
		GildedRose app = testItem("Item", 100, 80);
		assertEquals(99, app.items[0].sellIn);
	}
	
    private GildedRose testItem(String item, Integer sellIn, Integer quality) {
    	Item[] items = new Item[] { new Item(item, sellIn, quality) };
    	GildedRose app = new GildedRose(items);
    	app.updateQuality();
    	return app;
    }

}
