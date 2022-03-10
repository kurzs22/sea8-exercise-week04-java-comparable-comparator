package com.wildcodeschool.sea8.excercises.w04_comparable_comparator;

import java.util.Comparator;

public class CategoryAndPriceAndIdComparator implements Comparator<CatalogItem> {
    public int compare(CatalogItem o1, CatalogItem o2) {
        int category = o1.getCategory().compareTo(o2.getCategory());
        if (category == 0) {
            int price = o1.getPrice().compareTo(o2.getPrice());
            if (price == 0) {
                int id = Integer.compare(o1.getID(), o2.getID());
                return id;
            } else return price;
        } else return category;
    }
    
}
