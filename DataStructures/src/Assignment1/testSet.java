package Assignment1;

import java.util.Scanner;

public class testSet {
    public static void main(String[] args) {

        Set<Integer> newSet1 = new Set<>();

        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter 5 integers: \n");

        for (int i = 0; i <5; i++){
            newSet1.add(scan.nextInt());
        }
        System.out.println(newSet1);

        System.out.println("Please enter an integer to remove: \n");
        newSet1.remove(scan.nextInt());
        System.out.println(newSet1);

        System.out.println("Please type an integer to check if it is in the set: \n");
        boolean inList = newSet1.membership(scan.nextInt());
        System.out.println("The integer is in the set: " + inList);






    }
}
