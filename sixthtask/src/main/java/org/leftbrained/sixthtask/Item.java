package org.leftbrained.sixthtask;

public class Item {
    public String name;
    public int stars;

    public String link;
    public Item(String name, int stars, String link) {
        this.link = link;
        this.name = name;
        this.stars = stars;
    }
}
