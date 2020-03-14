package officeHours.day_03_11_2020;

import java.util.*;

public class JavaMapOH {
    /*
    dequeue-double sided
    we can add and retrieve elements from dequeue from both
    sides(head,end)
     */
    public static void main(String[] args) {
        Deque<Integer> numbers=new ArrayDeque<>();
        numbers.addFirst(20);
        numbers.addFirst(30);
        numbers.addFirst(50);
        System.out.println(numbers);
        numbers.addLast(90);
        System.out.println(numbers);
        numbers.add(33);
        System.out.println(numbers);
        Integer num=numbers.pollFirst();//return and delete first element
        System.out.println(num);
        System.out.println(numbers);
        System.out.println(numbers.getLast()+" peek: "+numbers.peekLast());

        /*
        What collections you are using in your project?
        describe all different collections(List,Queue,Set)
        explain the difference between them

        List -> Arraylist most of the time , because I would usually just need
        to store some values
        I would use LikedList if I know I will need to manipulate my date
        (consistently add, remove,etc.)

        Set ->
         */

        HashMap<String,String> user1=new HashMap<>();
        user1.put("First Namme",null);
        user1.put("Last Name","Smith");
        user1.put("Account Number","A123465");
        user1.put("DOB","02.20.1980");

        System.out.println(user1);

        LinkedHashMap<String,String> user2=new LinkedHashMap<>();
        user2.put("First Name","John");
        user2.put("LastName",null);
        user2.put("Last Name","White");//will be overriden
        user2.put("account Number","A7532984");
        user2.put("DOB","12.02.1964");
        System.out.println(user2);
        HashMap<String,String> user3=new HashMap<>(user1);
        user2.put("Account Number", "A12337897");
        user2.put("DOB","12.08.1990");

        List<HashMap<String, String>> users=new ArrayList<>();
        //LinkedHasMap extends HashMap
        users.add(user1);
        users.add(user2);
        users.add(user3);
        //print account number for all users along with last name
        System.out.println("=====LIST====\n"+users);
        for(HashMap<String,String> user: users){
            System.out.println("Account Number: "+user.get("Account Number ")
                    +"| Last Name: "+user.get("Last Name"));

        }
        int i=1;
        for(HashMap<String,String> user: users){
            System.out.println("user "+i);
            Iterator<String> keys=user.keySet().iterator();
            while(keys.hasNext()){
                String key=keys.next();
                System.out.println(key+" : "+user.get(key));
            }
            i++;
        }
    }
}
