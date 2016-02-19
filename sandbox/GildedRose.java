import java.util.function.Predicate;

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
}