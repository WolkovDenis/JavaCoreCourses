package generics;

import java.util.ArrayList;
import java.util.List;



public class ParametrizeClass {
    public static void main(String[] args) {
 /*
        Print<String> print = new Print<String>("text");
        Print<Integer> print2 = new Print<Integer>(7);
        print.PrintInfo();
        print2.PrintInfo();

 */
        Print<String> print = new Print<>("text", "test");
        ArrayList<String>arrayList= (ArrayList<String>) List.of("gfhdj","iuyt","poiu");
        print.PrintInfo();
        print.PrintFirstElement(arrayList);
    }
}

/*
 class Print<T> {
    T value;

    public Print(T value) {
        this.value = value;
    }

    public void PrintInfo() {
        System.out.println(value);
    }
}
*/
class Print<K> {
    K value;
    K value2;

    public Print(K value, K value2) {
        this.value = value;
        this.value2 = value2;
    }

    public void PrintInfo() {
        System.out.println(value);
        System.out.println(value2);
    }

    public void PrintFirstElement(ArrayList<K> arrayList) {
        for (K el : arrayList) {
            System.out.println(el);
        }
    }
}
