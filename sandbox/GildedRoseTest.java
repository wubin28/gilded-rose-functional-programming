import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GildedRoseTest {

    @Test
    public void normal_item_quality_should_decrease_by_1_if_sellin_greater_than_0() {
        Item[] items = new Item[] { new Item("Normal item", 8, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Normal item", app.items[0].name);
        assertEquals(7, app.items[0].sellIn);
        assertEquals(9, app.items[0].quality);
    }

    @Test
    public void normal_item_quality_should_decrease_by_1_if_sellin_greater_than_0_using_functional_programming() {
          List<Item> items = Arrays.asList(
            new Item("Normal item", 1, 10),
            new Item("Normal item", 0, 10),
            new Item("Aged Brie", 2, 5),
            new Item("Backstage passes to a TAFKAL80ETC concert", 22, 35),
            new Item("Sulfuras, Hand of Ragnaros", 9, 80),
            new Item("Conjured", 12, 45)
        );

        Stream<Item> itemStream = items.stream()
            .filter(GildedRose.isNormalItem())
            .filter(GildedRose.isSellInGreaterThan0())
            .map(GildedRose.generateUpdatedNormalItems());

        List<Item> itemsUpdated = itemStream.collect(Collectors.toList());

        assertEquals(1, itemsUpdated.size());
        assertEquals(0, itemsUpdated.get(0).sellIn);
        assertEquals(9, itemsUpdated.get(0).quality);
    }

    @Test
    public void normal_item_quality_should_decrease_by_2_if_sellin_no_more_than_0() {
        Item[] items = new Item[] { new Item("Normal item", 0, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Normal item", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

    @Test
    public void normal_item_quality_should_decrease_by_2_if_sellin_no_more_than_0_using_functional_programming() {
          List<Item> items = Arrays.asList(
            new Item("Normal item new", 1, 10),
            new Item("Normal item old", 0, 9),
            new Item("Aged Brie", 2, 5),
            new Item("Backstage passes to a TAFKAL80ETC concert", 22, 35),
            new Item("Sulfuras, Hand of Ragnaros", 9, 80),
            new Item("Conjured", 12, 45)
        );

        Stream<Item> itemStream = items.stream()
            .filter(GildedRose.isNormalItem())
            .filter(GildedRose.isSellInNoMoreThan0())
            .map(GildedRose.generateUpdatedNormalItems());

        List<Item> itemsUpdated = itemStream.collect(Collectors.toList());

        assertEquals(1, itemsUpdated.size());
        assertEquals(-1, itemsUpdated.get(0).sellIn);
        assertEquals(7, itemsUpdated.get(0).quality);
    }

    @Test
    public void Aged_Brie_quality_should_increase_by_1_if_sellin_greater_than_0() {
        Item[] items = new Item[] { new Item("Aged Brie", 8, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(7, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    @Test
    public void Aged_Brie_quality_should_increase_by_1_if_sellin_greater_than_0_using_functional_programming() {
          List<Item> items = Arrays.asList(
            new Item("Normal item", 1, 10),
            new Item("Normal item", 0, 10),
            new Item("Aged Brie", 1, 5),
            new Item("Backstage passes to a TAFKAL80ETC concert", 22, 35),
            new Item("Sulfuras, Hand of Ragnaros", 9, 80),
            new Item("Conjured", 12, 45)
        );

        Stream<Item> itemStream = items.stream()
            .filter(GildedRose.isAgedBrie())
            .filter(GildedRose.isSellInGreaterThan0())
            .map(GildedRose.generateUpdatedAgedBrie());

        List<Item> itemsUpdated = itemStream.collect(Collectors.toList());

        assertEquals(1, itemsUpdated.size());
        assertEquals(0, itemsUpdated.get(0).sellIn);
        assertEquals(6, itemsUpdated.get(0).quality);
    }

    @Test
    public void Aged_Brie_quality_should_increase_by_2_if_sellin_no_more_than_0() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
    }

    @Test
    public void Aged_Brie_quality_should_increase_by_2_if_sellin_no_more_than_0_using_functional_programming() {
          List<Item> items = Arrays.asList(
            new Item("Normal item", 1, 10),
            new Item("Normal item", 0, 10),
            new Item("Aged Brie", 1, 5),
            new Item("Aged Brie", 0, 6),
            new Item("Backstage passes to a TAFKAL80ETC concert", 22, 35),
            new Item("Sulfuras, Hand of Ragnaros", 9, 80),
            new Item("Conjured", 12, 45)
        );

        Stream<Item> itemStream = items.stream()
            .filter(GildedRose.isAgedBrie())
            .filter(GildedRose.isSellInNoMoreThan0())
            .map(GildedRose.generateUpdatedAgedBrie());

        List<Item> itemsUpdated = itemStream.collect(Collectors.toList());

        assertEquals(1, itemsUpdated.size());
        assertEquals(-1, itemsUpdated.get(0).sellIn);
        assertEquals(8, itemsUpdated.get(0).quality);
    }

    @Test
    public void Sulfuras_quality_should_always_80_when_sellin_greater_than_0() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 1, 80) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(1, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    public void Sulfuras_quality_should_always_80_when_sellin_greater_than_0_using_functional_programming() {
          List<Item> items = Arrays.asList(
            new Item("Normal item", 1, 10),
            new Item("Normal item", 0, 10),
            new Item("Aged Brie", 1, 5),
            new Item("Aged Brie", 0, 6),
            new Item("Backstage passes to a TAFKAL80ETC concert", 22, 35),
            new Item("Sulfuras, Hand of Ragnaros", 2, 80),
            new Item("Conjured", 12, 45)
        );

        Stream<Item> itemStream = items.stream()
            .filter(GildedRose.isSulfuras())
            .filter(GildedRose.isSellInGreaterThan0())
            .map(GildedRose.generateUpdatedSulfuras());

        List<Item> itemsUpdated = itemStream.collect(Collectors.toList());

        System.out.println(itemsUpdated);
        assertEquals(1, itemsUpdated.size());
        assertEquals(2, itemsUpdated.get(0).sellIn);
        assertEquals(80, itemsUpdated.get(0).quality);
    }

    @Test
    public void Sulfuras_quality_should_always_80_when_sellin_no_more_than_0() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    public void Sulfuras_quality_should_always_80_when_sellin_no_more_than_0_using_functional_programming() {
          List<Item> items = Arrays.asList(
            new Item("Normal item", 1, 10),
            new Item("Normal item", 0, 10),
            new Item("Aged Brie", 1, 5),
            new Item("Aged Brie", 0, 6),
            new Item("Backstage passes to a TAFKAL80ETC concert", 22, 35),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Conjured", 12, 45)
        );

        Stream<Item> itemStream = items.stream()
            .filter(GildedRose.isSulfuras())
            .filter(GildedRose.isSellInNoMoreThan0())
            .map(GildedRose.generateUpdatedSulfuras());

        List<Item> itemsUpdated = itemStream.collect(Collectors.toList());

        assertEquals(1, itemsUpdated.size());
        assertEquals(0, itemsUpdated.get(0).sellIn);
        assertEquals(80, itemsUpdated.get(0).quality);
    }

    @Test
    public void Backstage_Passes_quality_should_equal_0_when_sellin_no_more_than_0() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -3, 30) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(-4, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void Backstage_Passes_quality_should_equal_0_when_sellin_no_more_than_0_using_functional_programming() {
          List<Item> items = Arrays.asList(
            new Item("Normal item", 1, 10),
            new Item("Normal item", 0, 10),
            new Item("Aged Brie", 1, 5),
            new Item("Aged Brie", 0, 6),
            new Item("Backstage passes to a TAFKAL80ETC concert", 0, 35),
            new Item("Backstage passes to a TAFKAL80ETC concert", 11, 34),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 33),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 32),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Conjured", 12, 45)
        );

        Stream<Item> itemStream = items.stream()
            .filter(GildedRose.isBackstagePasses())
            .filter(GildedRose.isSellInNoMoreThan0())
            .map(GildedRose.generateUpdatedBackstagePasses());

        List<Item> itemsUpdated = itemStream.collect(Collectors.toList());

        assertEquals(1, itemsUpdated.size());
        assertEquals(-1, itemsUpdated.get(0).sellIn);
        assertEquals(0, itemsUpdated.get(0).quality);
    }

    @Test
    public void Backstage_Passes_quality_should_increase_by_1_when_sellin_greater_than_10() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 22) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(10, app.items[0].sellIn);
        assertEquals(23, app.items[0].quality);
    }

    @Test
    public void Backstage_Passes_quality_should_increase_by_1_when_sellin_greater_than_10_using_functional_programming() {
          List<Item> items = Arrays.asList(
            new Item("Normal item", 1, 10),
            new Item("Normal item", 0, 10),
            new Item("Aged Brie", 1, 5),
            new Item("Aged Brie", 0, 6),
            new Item("Backstage passes to a TAFKAL80ETC concert", 0, 35),
            new Item("Backstage passes to a TAFKAL80ETC concert", 11, 34),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 33),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 32),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Conjured", 12, 45)
        );

        Stream<Item> itemStream = items.stream()
            .filter(GildedRose.isBackstagePasses())
            .filter(GildedRose.isSellInGreaterThan0())
            .map(GildedRose.generateUpdatedBackstagePasses());

        List<Item> itemsUpdated = itemStream.collect(Collectors.toList());

        assertEquals(1, itemsUpdated.size());
        assertEquals(10, itemsUpdated.get(0).sellIn);
        assertEquals(35, itemsUpdated.get(0).quality);
    }

    @Test
    public void Backstage_Passes_quality_should_increase_by_2_when_sellin_between_5_and_10() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 22) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(24, app.items[0].quality);
    }

    @Test
    public void Backstage_Passes_quality_should_increase_by_3_when_sellin_between_0_and_5() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 22) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(25, app.items[0].quality);
    }

    @Test
    public void Conjured_quality_should_decrease_by_2_when_sellin_greater_than_0() {
        Item[] items = new Item[] { new Item("Conjured", 5, 22) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Conjured", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(20, app.items[0].quality);
    }

    @Test
    public void Conjured_quality_should_decrease_by_4_when_no_more_than_0() {
        Item[] items = new Item[] { new Item("Conjured", -2, 22) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Conjured", app.items[0].name);
        assertEquals(-3, app.items[0].sellIn);
        assertEquals(18, app.items[0].quality);
    }




}