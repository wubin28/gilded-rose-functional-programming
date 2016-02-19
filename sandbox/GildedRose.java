import java.util.function.Predicate;
import java.util.function.Function;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            StrategyItem strategyItem = StrategyFactory.create(items[i].name);
            strategyItem.handle(items[i]);
        }
    }
 
    public static Predicate<Item> isNormalItem() {
        return item -> !item.name.equals("Aged Brie") && 
                    !item.name.equals("Sulfuras, Hand of Ragnaros") &&
                    !item.name.equals("Backstage passes to a TAFKAL80ETC concert") &&
                    !item.name.equals("Conjured");
    }

    public static Predicate<Item> isAgedBrie() {
        return item -> item.name.equals("Aged Brie");
    }

    public static Predicate<Item> isSellInGreaterThan0() {
        return item -> item.sellIn > 0;
    }

    public static Predicate<Item> isSellInNoMoreThan0() {
        return item -> item.sellIn <= 0;
    }

    public static Function<Item, Item> generateUpdatedNormalItems() {
        return item -> {
            int updatedQuality = 0;

            if (item.quality > 0) {                    
                updatedQuality = item.quality - 1;
            }

            int updatedSellIn = item.sellIn - 1;

            if (updatedSellIn < 0) {
         
                if (updatedQuality > 0) {  
                    updatedQuality = item.sellIn - 2;                           
                }
            }
            
            return new Item(item.name, updatedSellIn, updatedQuality);
        }
    }

    public static Function<Item, Item> generateAgedBrieForSellInGreaterThan0() {
        return item -> 
            new Item(item.name, item.sellIn - 1, item.quality + 1);
    }
}