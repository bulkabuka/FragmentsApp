package org.leftbrained.sixthtask;

import java.util.ArrayList;
import java.util.List;

public class ItemViewModel {
    public List<Item> itemList = new ArrayList<>();

    public ItemViewModel() {
        itemList.add(new Item("Без помощи США Украина может исчезнуть", 5, "https://t.me/ru2ch/103213"));
        itemList.add(new Item("Собака загрызла насмерть своего хозяина в центре Москвы", 4, "https://t.me/ru2ch/103216"));
    }
}
