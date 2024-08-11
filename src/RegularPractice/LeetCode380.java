package RegularPractice;

import java.util.*;

/*380. Insert Delete GetRandom O(1)
* Implement the RandomizedSet class:
RandomizedSet() Initializes the RandomizedSet object.
bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
You must implement the functions of the class such that each function works in average O(1) time complexity.
Example 1:
Input
["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
[[], [1], [2], [2], [], [1], [2], []]
Output
[null, true, false, true, 2, true, false, 2]
Explanation
RandomizedSet randomizedSet = new RandomizedSet();
randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
randomizedSet.insert(2); // 2 was already in the set, so return false.
randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
Constraints:
-231 <= val <= 231 - 1
At most 2 * 105 calls will be made to insert, remove, and getRandom.
There will be at least one element in the data structure when getRandom is called.
* */
class RandomizedSet {
    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random rand;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        int lastElement = list.get(list.size() - 1);

        list.set(index, lastElement);
        map.put(lastElement, index);

        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

public class LeetCode380 {
    public static void main(String[] args) {
        // Initialize the RandomizedSet object.
        RandomizedSet randomizedSet = new RandomizedSet();

        // Test inserting elements.
        System.out.println(randomizedSet.insert(1)); // Inserts 1, should return true.
        System.out.println(randomizedSet.insert(2)); // Inserts 2, should return true.
        System.out.println(randomizedSet.insert(2)); // Tries to insert 2 again, should return false.

        // Test removing elements.
        System.out.println(randomizedSet.remove(2)); // Removes 2, should return true.
        System.out.println(randomizedSet.remove(2)); // Tries to remove 2 again, should return false.

        // Test inserting a removed element.
        System.out.println(randomizedSet.insert(2)); // Inserts 2 again, should return true.

        // Test getRandom
        System.out.println("Random element: " + randomizedSet.getRandom()); // Should return either 1 or 2.

        // Removing the remaining elements.
        System.out.println(randomizedSet.remove(1)); // Removes 1, should return true.
        System.out.println(randomizedSet.remove(2)); // Removes 2, should return true.

        // Test inserting more elements
        System.out.println(randomizedSet.insert(3)); // Inserts 3, should return true.
        System.out.println(randomizedSet.insert(4)); // Inserts 4, should return true.
        System.out.println(randomizedSet.insert(5)); // Inserts 5, should return true.

        // Test getRandom multiple times
        System.out.println("Random element: " + randomizedSet.getRandom()); // Should return 3, 4, or 5.
        System.out.println("Random element: " + randomizedSet.getRandom()); // Should return 3, 4, or 5.
        System.out.println("Random element: " + randomizedSet.getRandom()); // Should return 3, 4, or 5.
    }
}
