package com.kh.springreact.repository;

import com.kh.springreact.constant.ItemSellStatus;
import com.kh.springreact.entity.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
//@TestPropertySource(locations = "classpath:application-test.properties")
class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    @DisplayName("상품 저장 테스트")
    public void createItemTest(){
        Item item = new Item();
        item.setItemNum("Test Product");
        item.setPrice(10000);
        item.setItemDetail("Test Product Detail");
        item.setItemSellStatus(ItemSellStatus.SELL);
        item.setStockNumber(100);
        item.setRegTime(LocalDateTime.now());
        item.setUpdateTime(LocalDateTime.now());
        Item savedItem = itemRepository.save(item);
        System.out.println(savedItem.toString());
    }
    public void createItemList() {
        for (int i = 1; i <= 10; i++) {
            Item item = new Item();
            item.setItemNum("Test" + i);
            item.setPrice(10000 + i);
            item.setItemDetail("Test Detail" + i);
            item.setItemSellStatus(ItemSellStatus.SELL);
            item.setStockNumber(100);
            item.setRegTime(LocalDateTime.now());
            item.setUpdateTime(LocalDateTime.now());
            Item savedItem = itemRepository.save(item);
        }
    }
    @Test
    @DisplayName("상품명 조회 테스트")
    public void findByItemNumTest(){
        this.createItemList();
        List<Item> itemList = itemRepository.findByItemNum("Test product");
        for(Item item : itemList){
            System.out.println(item.toString());
        }
    }
}