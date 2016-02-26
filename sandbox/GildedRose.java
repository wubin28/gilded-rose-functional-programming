import java.util.function.Predicate;
import java.util.function.Function;
import java.util.List;
import java.util.stream.Collectors;

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

    public static Function<Item, Item> generateUpdatedNormalItem() {
        return item -> {
            int updatedQuality = item.quality;

            if (item.quality > 0) {                    
                updatedQuality = item.quality - 1;
            }

            int updatedSellIn = item.sellIn - 1;

            if (updatedSellIn < 0) {
         
                if (updatedQuality > 0) {  
                    updatedQuality = item.quality - 2;                           
                }
            }
            
            return new Item(item.name, updatedSellIn, updatedQuality);
        };
    }

    public static Function<Item, Item> generateUpdatedAgedBrie() {
        return item -> {
            int updatedQuality = item.quality;

            if (item.quality < 50) {                    
                updatedQuality = item.quality + 1;
            }

            int updatedSellIn = item.sellIn - 1;

            if (updatedSellIn < 0) {
         
                if (updatedQuality < 50) {  
                    updatedQuality = item.quality + 2;                           
                }
            }

            return new Item(item.name, updatedSellIn, updatedQuality);
        };
    }

    public static Function<Item, Item> generateUpdatedSulfuras() {
        return item -> item;
    }

    public static Function<Item, Item> generateUpdatedBackstagePasses() {
        return item -> {
            int updatedQuality = item.quality;

            if (item.quality < 50) {                    
                updatedQuality = item.quality + 1;
                if (item.sellIn < 11) {
                    if (item.quality < 50) {
                    updatedQuality = item.quality + 2;
                    }
                }
                if (item.sellIn < 6) {
                    if (item.quality < 50) {
                    updatedQuality = item.quality + 3;
                    }
                }
            }

            int updatedSellIn = item.sellIn - 1;

            if (updatedSellIn < 0) {
                updatedQuality = 0;
            }

            return new Item(item.name, updatedSellIn, updatedQuality);
        };
    }

    public static Function<Item, Item> generateUpdatedConjured() {
        return item -> {
            int updatedQuality = item.quality;

            if (item.quality > 0) {                    
                updatedQuality = item.quality - 2;
            }

            int updatedSellIn = item.sellIn - 1;

            if (updatedSellIn < 0) {
                if (updatedQuality > 0) {  
                    updatedQuality = item.quality - 4;
                }
            }

            return new Item(item.name, updatedSellIn, updatedQuality);
        };
    }

    public static List<Item> updateItemsQualityAndSellIn(
            List<Item> items, Predicate<Item> itemTypeFilter, 
            Predicate<Item> sellInFilter,
            Function<Item,Item> updateQualityAndSellIn) {
        return items.stream()
            .filter(itemTypeFilter)
            .filter(sellInFilter)
            .map(updateQualityAndSellIn)
            .collect(Collectors.toList());
    }
}