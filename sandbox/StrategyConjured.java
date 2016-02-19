public class StrategyConjured implements StrategyItem{

    public void handle(Item item){
        if (item.quality > 0) {                    
            item.quality -= 2;
        }
     
        item.sellIn -= 1;            

        if (item.sellIn < 0) {
     
            if (item.quality > 0) {  
                item.quality -= 2;                           
            }
        }
    }
}
