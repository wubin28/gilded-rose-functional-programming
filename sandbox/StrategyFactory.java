public class StrategyFactory{
    public static StrategyItem create(String itemName){
        if(itemName.equals("Sulfuras, Hand of Ragnaros")){
           return new StrategySulfuras();  
        }

        if(itemName.equals("Aged Brie")){
           return new StrategyAgedBrie();  
        }

        if(itemName.equals("Backstage passes to a TAFKAL80ETC concert")){
           return new StrategyBackstage();  
        }

        if(itemName.equals("Conjured")){
           return new StrategyConjured();  
        }
        
        return new StrategyNormalItem();  
        
    }
}