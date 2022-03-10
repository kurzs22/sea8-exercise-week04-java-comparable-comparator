# `Comparable<T>` vs. `Comparator<T>`
In this exercise we will create a way of sorting a product catalog using both the `Comparable<T>` interface as well as the `Comparator<T>` interface.

### Setting Up
- Create a fork of this repo on your own GitHub account.
- Clone your fork to your computer.
- Open the project in your preferred editor or IDE.
- ***For telekom users:** You first need to place your `gradle.properties` with the proxy configuration into the project directory.*
- You can now run the project using `.\gradlew.bat run` on Windows or `./gradlew run` on macOS and Linux.

### Excercise
In the project you will find a `CatalogItem` class which represents an item from a product catalog. These catalog items are provided in form of a csv file and already loaded into a list. Look at the `CatalogItem` class and familiarize with it's structure.

In the `Catalog` class we have a main method where the content of the CSV gets loaded into a list and is being displayed with the `printCatalog(...)` method. You don't have to touch the `printCatalog(...)` method, but you should use it to easily display the list after each sorting attempt.

Now, you can work on the following tasks:
1. Adapt the `CatalogItem` class to implement the `Comparable<T>` interface. You will notice that you have to supplement the `T` for the type you are comparing to, which should be `CatalogItem`. Come up with a ***natural sorting order*** and implement it in the `compareTo(...)` method that you are overriding from the interface. (You could, for example, sort by ID)
2. Try sorting the list of your now comparable `CatalogItem`s using the `Collections.sort(...)` method. Print out the result and see if your sorting worked.