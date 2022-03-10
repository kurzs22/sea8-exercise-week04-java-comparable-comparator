package com.wildcodeschool.sea8.excercises.w04_comparable_comparator;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Catalog {
    // File containing our catalog
    public static final File CATALOG_FILE = new File("src/main/resources/catalog.csv");
    public static void main(String[] args) {
        // First we are reading the CSV file and turn the data inside into a list containing our catalog items.
        List<CatalogItem> catalog = new ArrayList<CatalogItem>();
        try {
            List<String> lines = Files.readAllLines(CATALOG_FILE.toPath());
            lines.remove(0);
            String[] splitLine;
            for (String line : lines) {
                splitLine = line.split(",");
                catalog.add(new CatalogItem(Integer.parseInt(splitLine[0]), splitLine[1], new BigDecimal(splitLine[2]), splitLine[3]));
            }
        } catch (IOException e) {
            System.err.println("File could not be read.");
            e.printStackTrace();
            return;
        } catch (NumberFormatException e) {
            System.err.println("Catalog CSV is corrupted.");
            e.printStackTrace();
            return;
        }
        // After the catalog is loaded, we randomly scramble the ordering of the list.
        // Note that we are seeding the random shuffling so that we always get the same
        // result on consecutive executions with the same data.
        Collections.shuffle(catalog, new Random(20220310));

        // Next we have a look at the data.
        printCatalog(catalog);

        // TASK AREA START

        // Try sorting the list of your now comparable CatalogItems using the Collections.sort(...) method.
        System.out.println("\n## Sort by ID (natural sorting order)");
        Collections.sort(catalog);
        printCatalog(catalog);

        // Try out whether your comparator works using Collections.sort(<someCollection>, <someComparator>) 
        System.out.println("\n## Sort by Price (with Collections.sort)");
        Collections.sort(catalog, new PriceComparator());
        printCatalog(catalog);

        // or directly using the lists sort(<someComparator>) method.
        System.out.println("\n## Sort by Price (with sort method of list)");
        catalog.sort(new PriceComparator());
        printCatalog(catalog);

        // Now come up with at least two other ways of sorting the catalog and try them out in the same fashion as the previous steps.
        System.out.println("\n## Sort by Name (ignore case)");
        catalog.sort(new NameIgnoreCaseComparator());
        printCatalog(catalog);

        System.out.println("\n## Sort by Category, Price and ID");
        catalog.sort(new CategoryAndPriceAndIdComparator());
        printCatalog(catalog);

        // TASK AREA END
    }

    /**
     * Utility method to print the catalog in a table view.
     * @param catalog The catalog list to display.
     */
    private static void printCatalog(List<CatalogItem> catalog) {
        System.out.println("\nID\tName\t\tPrice\tCategory");
        catalog.forEach((item) -> System.out.println(item.getID() + "\t" + item.getName() + ((item.getName().length() > 8) ? "\t" : "\t\t") + item.getPrice().toString() + "\t" + item.getCategory()));
    }
}
