package com.mohibur.mongocrud.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fruit {
    private String name;
    private String category;

    public static List<Fruit> getFruits() {
        List<Fruit> fruits = Arrays.asList(
                new Fruit("Ackee", "Exotic Fruit"),
                new Fruit("Apple", "Pome Fruit"),
                new Fruit("Apricot", "Stone Fruit"),
                new Fruit("Avocado", "Berry Fruit"),
                new Fruit("Banana", "Berry Fruit"),
                new Fruit("Barberry", "Berry Fruit"),
                new Fruit("Bilberry", "Berry Fruit"),
                new Fruit("Black Cherry", "Stone Fruit"),
                new Fruit("Black Plum", "Stone Fruit"),
                new Fruit("Blackberry", "Aggregate Fruit"),
                new Fruit("Blackcurrant", "Berry Fruit"),
                new Fruit("Blood Orange", "Citrus Fruit"),
                new Fruit("Blueberry", "Berry Fruit"),
                new Fruit("Boysenberry", "Aggregate Fruit"),
                new Fruit("Breadfruit", "Multiple Fruit"),
                new Fruit("Buddha's Hand", "Citrus Fruit"),
                new Fruit("Calamansi", "Citrus Fruit"),
                new Fruit("Canistel", "Exotic Fruit"),
                new Fruit("Cantaloupe", "Melon"),
                new Fruit("Carambola", "Exotic Fruit"),
                new Fruit("Carissa", "Berry Fruit"),
                new Fruit("Cherimoya", "Exotic Fruit"),
                new Fruit("Cherry", "Stone Fruit"),
                new Fruit("Chinese Bayberry", "Berry Fruit"),
                new Fruit("Citron", "Citrus Fruit"),
                new Fruit("Clementine", "Citrus Fruit"),
                new Fruit("Coconut", "Nut Fruit"),
                new Fruit("Cornelian Cherry", "Berry Fruit"),
                new Fruit("Cranberry", "Berry Fruit"),
                new Fruit("Cucumber", "Fruit Vegetable"),
                new Fruit("Currant", "Berry Fruit"),
                new Fruit("Custard Apple", "Exotic Fruit"),
                new Fruit("Date", "Stone Fruit"),
                new Fruit("Dragonfruit", "Exotic Fruit"),
                new Fruit("Duku", "Exotic Fruit"),
                new Fruit("Durian", "Exotic Fruit"),
                new Fruit("Eggfruit", "Exotic Fruit"),
                new Fruit("Elderberry", "Berry Fruit"),
                new Fruit("Feijoa", "Exotic Fruit"),
                new Fruit("Fig", "Multiple Fruit"),
                new Fruit("Gac", "Exotic Fruit"),
                new Fruit("Gooseberry", "Berry Fruit"),
                new Fruit("Goumi", "Berry Fruit"),
                new Fruit("Grape", "Berry Fruit"),
                new Fruit("Grapefruit", "Citrus Fruit"),
                new Fruit("Guava", "Exotic Fruit"),
                new Fruit("Honeydew", "Melon"),
                new Fruit("Huckleberry", "Berry Fruit"),
                new Fruit("Imbe", "Exotic Fruit"),
                new Fruit("Indian Gooseberry", "Exotic Fruit"),
                new Fruit("Jaboticaba", "Exotic Fruit"),
                new Fruit("Jackfruit", "Exotic Fruit"),
                new Fruit("Jackfruit", "Multiple Fruit"),
                new Fruit("Jambul", "Berry Fruit"),
                new Fruit("Jostaberry", "Berry Fruit"),
                new Fruit("Jujube", "Stone Fruit"),
                new Fruit("Kiwi", "Exotic Fruit"),
                new Fruit("Kiwi", "Exotic Fruit"),
                new Fruit("Kumquat", "Citrus Fruit"),
                new Fruit("Kumquat", "Citrus Fruit"),
                new Fruit("Lemon", "Citrus Fruit"),
                new Fruit("Lime", "Citrus Fruit"),
                new Fruit("Lime", "Citrus Fruit"),
                new Fruit("Longan", "Exotic Fruit"),
                new Fruit("Longan", "Exotic Fruit"),
                new Fruit("Loquat", "Stone Fruit"),
                new Fruit("Lychee", "Exotic Fruit"),
                new Fruit("Lychee", "Exotic Fruit"),
                new Fruit("Mandarin", "Citrus Fruit"),
                new Fruit("Mango", "Exotic Fruit"),
                new Fruit("Mangosteen", "Exotic Fruit"),
                new Fruit("Mulberry", "Multiple Fruit"),
                new Fruit("Nectarine", "Stone Fruit"),
                new Fruit("Orange", "Citrus Fruit"),
                new Fruit("Papaya", "Exotic Fruit"),
                new Fruit("Passionfruit", "Exotic Fruit"),
                new Fruit("Peach", "Stone Fruit"),
                new Fruit("Pear", "Pome Fruit"),
                new Fruit("Persimmon", "Berry Fruit"),
                new Fruit("Pineapple", "Exotic Fruit"),
                new Fruit("Plum", "Stone Fruit"),
                new Fruit("Pomegranate", "Berry Fruit"),
                new Fruit("Pomelo", "Citrus Fruit"),
                new Fruit("Quince", "Pome Fruit"),
                new Fruit("Raspberry", "Aggregate Fruit"),
                new Fruit("Redcurrant", "Berry Fruit"),
                new Fruit("Rhubarb", "Vegetable Fruit"),
                new Fruit("Salak", "Exotic Fruit"),
                new Fruit("Satsuma", "Citrus Fruit"),
                new Fruit("Starfruit", "Carambola Fruit"),
                new Fruit("Tangerine", "Citrus Fruit"),
                new Fruit("Ugli Fruit", "Citrus Fruit"),
                new Fruit("Watermelon", "Melon"),
                new Fruit("White Currant", "Berry Fruit"),
                new Fruit("White Peach", "Stone Fruit"),
                new Fruit("White Sapote", "Exotic Fruit"),
                new Fruit("Wild Strawberry", "Aggregate Fruit"),
                new Fruit("Yellow Passion Fruit", "Exotic Fruit"),
                new Fruit("Yellow Watermelon", "Melon"),
                new Fruit("Yuzu", "Citrus Fruit"));
        return fruits;
    }

}
