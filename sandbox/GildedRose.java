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

    public static Predicate<Item> isSellInGreaterThan0() {
        return item -> item.sellIn > 0;
    }

    public static Function<Item, Item> generateNormalItemsForSellInGreaterThan0() {
        return item -> 
            new Item(item.name, item.sellIn - 1, item.quality - 1);
    }

    public static Function<Item, Item> generateNormalItemsForSellInNoMoreThan0() {
        return item -> 
            new Item(item.name, item.sellIn - 1, item.quality - 2);
    }
}