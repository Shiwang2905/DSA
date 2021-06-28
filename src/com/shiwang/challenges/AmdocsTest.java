package com.shiwang.challenges;

import java.util.*;

public class AmdocsTest {
    List<String> myArrayList;
    public AmdocsTest(){
        myArrayList=new ArrayList<>();
        Collections.synchronizedList(myArrayList);
    }
     public static void main(String[] args) {
//        AmdocsTest amt= new AmdocsTest();
//        amt.myArrayList.add("shiwang");
//         amt.myArrayList.add("sk");
//         amt.myArrayList.add("anurag");
//         amt.myArrayList.add("harsh");

         List<String> myArrayList= new ArrayList<>();

         myArrayList.add("shiwang");
         myArrayList.add("sk");
         myArrayList.add("anurag");
         myArrayList.add("harsh");

         Collections.sort(myArrayList);
        String[] stringArray= new String[myArrayList.size()];
                stringArray= myArrayList.toArray(stringArray);

        int i=0;
        while(i<stringArray.length){
            System.out.println(stringArray[i]);
            i++;
        }

//         Set<String> mytree= new TreeSet();
//             mytree.add("shiwang");
//             mytree.add("divya");
//             mytree.add("anil");
//             boolean status=mytree.add("shiwang");
//
//         Iterator itr= mytree.iterator();
//
//         while(itr.hasNext()){
//             System.out.println(itr.next());
//         }
//
//         System.out.println(status);



    }
}
