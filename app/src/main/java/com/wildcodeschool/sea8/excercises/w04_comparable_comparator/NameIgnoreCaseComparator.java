package com.wildcodeschool.sea8.excercises.w04_comparable_comparator;

import java.util.Comparator;

public class NameIgnoreCaseComparator implements Comparator<CatalogItem> {
    public int compare(CatalogItem o1, CatalogItem o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
    }
}
