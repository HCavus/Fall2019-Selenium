package officeHours.day_03_19_2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionFramework {
   /*
    Array:
    built into the language, lowest level data structure
    Sizeis fixed, can not be changed once it 's created
    can store primitives and objects

    Collection Framework:
    Interfaces: Iterable--> Collection -->(List, Set,Queue)
                Map -->(SortedMap)
     Implementations:
                List -->ArrayList,LinkedList
                    Ordered(indexed) Collection,may contain duplicate


                Set -->HashSet,LinkedHashSet,
                    SortedSet -->TreeSet
                    Store unique value, no duplicate allowed
                    HashSet--default choice, it just keep it unique, no insertion order, no index
                    LinkedHashSet--unique+insertion order
                    TreeSet--unique + sorted
               =>IQ: Deciding unique value in the HashSet is hot interview topic:
                Its easy for Numbers and String
                and yet it's slightly

                Queue -->ArrayDeque, PriorityQueue
                        FIFO:First in First out
                        LIFO:Last in first out

                Map -->HashMap, LinkedHashMap, HashTable
                    SortMap -->TreeMap

                   Key-Value pair
                   key is unique-no duplicate
     Algorithm:
    */
   public static void main(String[] args) {
       /*
       Lets assume you are searching for iphone on amazon
       many search results came in
       I want you to store all the price element on the result page
       meantime, I want you to store all the price next into a List
       We can use findElement and getText together
       it will give us a List,String> that contains prices
       but we want to get List <Double>

        */

      // String price="100.99";
      // double priceNum=Double.parseDouble(price);
      // System.out.println("priceNum = " + priceNum);

       List<String> priceLstStr=new ArrayList<>(Arrays.asList("99.99","149.99","79.99","149.99","299.99","599.99"));
       priceLstStr.add("999.99");
       System.out.println("priceLstStr: "+priceLstStr);
       ///but we want to get List<Double>
       List<Double> prices=new ArrayList<>();
       for (String each : priceLstStr) {
           prices.add(Double.parseDouble(each));

       }
       System.out.println("prices in double: "+prices);

       //how do I get max price,min,average

       //remove items above average

       //get the unique prices
   }
}
