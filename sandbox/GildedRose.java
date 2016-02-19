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
 
    
}