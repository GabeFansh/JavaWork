package Assignment2;

public class testMTF {
    public static void main(String[] args){
        mtf<Integer> myMTF = new mtf<Integer>();
        for (int i=1; i<=10; i++){myMTF.push(i);}
        System.out.println(myMTF);
        // checking that repetitions are removed
        for (int i=1; i<=10; i++){myMTF.push(i);}
        System.out.println(myMTF);
        // checking both outcomes of boolean functions
        System.out.println("The structure contains 5: "+myMTF.contains(5));
        System.out.println("The structure is empty: "+myMTF.isEmpty());
        while(!myMTF.isEmpty()){myMTF.pop();}
        System.out.println("The structure contains 5: "+myMTF.contains(5));
        System.out.println("The structure is empty: "+myMTF.isEmpty());
    }
}
