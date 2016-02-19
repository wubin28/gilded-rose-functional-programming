public class StrategyNormalItem implements StrategyItem{

    public void handle(Item item){
        calculateQualityBeforeDecreasingSellIn(item);
        decreaseSellIn(item);
        calculateQualityAfterDecreasingSellIn(item);
    }

    protected void calculateQualityBeforeDecreasingSellIn(Item item) {
        if (item.quality > 0) {                    
            item.quality -= 1;
        }
    }

    protected void decreaseSellIn(Item item) {
        item.sellIn -= 1;            
    }

    protected void calculateQualityAfterDecreasingSellIn(Item item) {
        if (item.sellIn < 0) {
     
            if (item.quality > 0) {  
                item.quality -= 1;                           
            }
        }
    }
}