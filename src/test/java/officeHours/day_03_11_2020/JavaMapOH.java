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
        System.out.println(numbers); //50,30,20
        numbers.addLast(90);
        System.out.println(numbers); //50,30,20,90
        numbers.add(33);
        System.out.println(numbers); //50,30,20,90,33
        Integer num=numbers.pollFirst();//return and delete first element
        System.out.println(num);  //50
        System.out.println(numbers);  //30,20,90,33
        System.out.println(numbers.getLast()+" peek: "+numbers.peekLast());  //33 peek: 33

        /*
        What collections you are using in your project?
        describe all different collections(List,Queue,Set)
        explain the difference between them

        List -> Arraylist most of the time , because I would usually just need
        to store some values
        I would use LinkedList if I know I will need to manipulate my data
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
        user2.put("Account Number","A7532984");
        user2.put("DOB","12.02.1964");

        System.out.println(user2);

        HashMap<String,String> user3=new HashMap<>(user1);
        System.out.println(user3);

        user2.put("Account Number", "A12337897");
        user2.put("DOB","12.08.1990");

        System.out.println(user2);

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
