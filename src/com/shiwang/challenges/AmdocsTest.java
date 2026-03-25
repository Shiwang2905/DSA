package com.shiwang.challenges;

import java.util.*;

public class AmdocsTest {
    List<String> myArrayList;

    public AmdocsTest() {
        myArrayList = new ArrayList<>();
        Collections.synchronizedList(myArrayList);
    }

    public static void ex(String[] args) {
//        AmdocsTest amt= new AmdocsTest();
//        amt.myArrayList.add("shiwang");
//         amt.myArrayList.add("sk");
//         amt.myArrayList.add("anurag");
//         amt.myArrayList.add("harsh");

        List<String> myArrayList = new ArrayList<>();

        myArrayList.add("shiwang");
        myArrayList.add("sk");
        myArrayList.add("anurag");
        myArrayList.add("harsh");

        Collections.sort(myArrayList);
        String[] stringArray = new String[myArrayList.size()];
        stringArray = myArrayList.toArray(stringArray);

        int i = 0;
        while (i < stringArray.length) {
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

    public static void main(String[] args) {
        int[] arr = new int[]{9, 3, 9, 4};
        quickSort(arr, 0, 3);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high) {
        // code here
        if (low < high) {
            int pIndex = partition(arr, low, high);

            quickSort(arr, low, pIndex -1);
            quickSort(arr, pIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = low - 1;
        int j;
        for (j = low; j < high; j++) {
            if (pivot > arr[j]) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, j);
        return i + 1;
    }

    static void swap(int[] array, int from, int to) {
        int temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }
}
