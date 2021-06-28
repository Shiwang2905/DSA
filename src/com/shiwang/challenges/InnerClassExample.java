package com.shiwang.challenges;

public class InnerClassExample {

    int x=6;

    static class InnerClass{
        int y;

        void print(){
            System.out.println(new InnerClassExample().x+y);
        }

    }

}
