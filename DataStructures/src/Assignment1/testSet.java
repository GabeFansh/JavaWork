package Assignment1;

public class testSet {
    public static void main(String[] args) {

        Set<Integer> newSet1 = new Set<>();

        newSet1.add(10);
        newSet1.add(12);
        newSet1.add(10);
        newSet1.add(13);
        System.out.println(newSet1);
        newSet1.remove(10);
        newSet1.remove(12);
        System.out.println(newSet1);
        boolean inSet = newSet1.membership(13);
        System.out.println(inSet);





    }
}
