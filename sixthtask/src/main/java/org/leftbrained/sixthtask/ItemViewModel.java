package org.leftbrained.sixthtask;

import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

public class ItemViewModel {
    public List<Item> itemList = new ArrayList<>();

    public ItemViewModel(SharedPreferences prefs) {
        itemList.add(new Item("Без помощи США Украина может исчезнуть", 5, "https://www.gazeta.ru/politics/2024/02/10/18256351.shtml"));
        itemList.add(new Item("Собака загрызла насмерть своего хозяина в центре Москвы", 4, "https://t.me/ru2ch/103216"));
        itemList.add(new Item("Новая тестовая новость", 3, "https://www.gazeta.ru/sport/news/2024/02/10/22306687.shtml"));
        for (Item item : itemList) {
            Float rate = prefs.getFloat(item.link, 0);
            item.stars = Float.parseFloat(String.valueOf(rate));
        }
    }
}
