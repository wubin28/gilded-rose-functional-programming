public class StrategyNormalItem implements StrategyItem{

    public void handle(Item item){
        if (item.quality > 0) {                    
            item.quality -= 1;
        }

        item.sellIn -= 1;            

        if (item.sellIn < 0) {
     
            if (item.quality > 0) {  
                item.quality -= 1;                           
            }
        }
    }
}