package com.shiwang.dsabootcamp.datastructures;

public class TrickQuestions {

    public static void main(String[] args) {

//        A c = new C();
//        c.foo();

//        Integer a = 127;
//        Integer b = 127;
//
//        Integer c = 128;
//        Integer d = 128;
//
//        System.out.println(a == b);
//        System.out.println(c == d);

        AA b = new BB();
        b.aa();
    }

    static class AA {
        public AA(){
            aa();
        }

        void aa(){
            System.out.println("from AA");
        }
    }

    static class BB extends AA {
         int x = 10;
        String name = "BB class";

        void aa(){
            System.out.println(x);
            System.out.println(name);
        }
    }

    interface A {

        default void foo() {
            System.out.println("From A");
        }
    }

    interface B {

        default void foo() {
            System.out.println("From B");
        }
    }

    static class C implements A, B {

        @Override
        public void foo() {
            B.super.foo();
        }
    }


}
