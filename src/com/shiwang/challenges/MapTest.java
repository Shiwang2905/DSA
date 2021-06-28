package com.shiwang.challenges;

import java.util.*;

public class MapTest {

    public static void main(String[] args) {

        List<Integer> myArray= new ArrayList<>();

        for(int i=10; i>=1; i--){
            myArray.add(i);
        }

        Set<Integer> set= new TreeSet<>(myArray);

        set.forEach(System.out::println);
//        Map<Integer, String> myMap = new HashMap<>();
//
//        myMap.put(1,"shiwang");
//        myMap.put(2,"Kumar");
//        myMap.put(3,"Anurag");
//        myMap.put(4,"Devi");
//
//        for(Map.Entry m: myMap.entrySet()){
//            if(m.getValue().equals("shiwang"))
//                System.out.println(m.getKey());
//            break;
//        }
//
//        for(Integer i: myMap.keySet()){
//            System.out.println(myMap.get(i));
//        }


    }
}
