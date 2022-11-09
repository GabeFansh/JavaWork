package Assignment4;
import java.util.Hashtable;

/**
 *
 *
 * 1.
 *   The runtime for adding n items in a seperate-chaining hash table is o(1). The search for an item not on the table
 *   would be o(1) because the search time for a query for any item in a hash table, as long as all the items are spread
 *   uniformly, is o(1) so determining if an item is not in a hash table is just placing the item in the key and checking if
 *   the space on the hash table is empty.
 *
 *
 * 2.
 *   The run time for adding in an AVL tree is o(nlogn). The search for an item not in the tree would take o(logn). This is
 *   because when adding, there are n terms, and because an avl tree is always balanced, a search for an item would take o(logn)
 *   since it doesn't have to check the whole list to search.
 *
 *
 * 3.
 *   |Construction Time|   10^2   |   10^3  |   10^4   |   10^5   |    10^6   |
 *   |   Hash Table    |  172900  | 5731900 | 12141500 | 35371800 | 253341700 |
 *   |      Tree       | 2633900  | 1059600 | 7208400  | 15959400 | 99046400  |
 *
 *   |   Search Time   |   10^2   |   10^3  |   10^4   |   10^5   |    10^6   |
 *   |   Hash Table    |  38900   | 243600  | 2070300  | 11275400 | 20547500  |
 *   |      Tree       |  14800   |  10800  |  15100   |  22500   |    11900  |
 *
 *
 *
 * 4.
 *   These measurements are accurate to the conjectures that I had made in question 1. When comparing the times between the AVL tree,
 *   they match closely to o(logn). When looking at the values for the search on the hash table, they are all a specific constant time
 *   which is what the conjecture of o(1) is.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */


public class HashTreeTest {
    public static void main(String[] args) {

        AvlTree<Integer> newTree = new AvlTree<>();
        Hashtable<Integer, Integer> newHash = new Hashtable<>();

        int itemCount = 1000000;


        long treeStart = System.nanoTime();
        for(int i = 0; i <= itemCount; i++)
        {
            newTree.insert(i);
        }
        long treeEnd = System.nanoTime();

        long hashStart = System.nanoTime();
        for(int i = 0; i <= itemCount; i++)
        {
            newHash.put(i, i);
        }
        long hashEnd = System.nanoTime();

        long treeDeltTime = treeEnd - treeStart;
        long hashDeltTime = hashEnd - hashStart;

        System.out.println("Tree Construction Time: " + treeDeltTime + "\n" +
                "Hash Construction Time: " + hashDeltTime);

        treeStart = System.nanoTime();
        newTree.contains(itemCount + 1);
        treeEnd = System.nanoTime();
        treeDeltTime = treeEnd - treeStart;

        hashStart = System.nanoTime();
        newHash.contains(itemCount + 1);
        hashEnd = System.nanoTime();
        hashDeltTime = hashEnd - hashStart;

        System.out.println("Tree Search Time: " + treeDeltTime + "\n" +
                "Hash Search Time: " + hashDeltTime);







    }
}
