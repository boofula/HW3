/*
 * *** Will Bales / 002 ***
 *
 * This java file contains several simple tree problems that need to be
 * codified. These routines  must use the TreeMap and TreeSet library
 * classes from the Java Collection Framework.
 *
 */

import java.util.*;

public class TreeProblems {

  /**
   * Method different()
   *
   * Given two TreeSets of integers, return a TreeSet containing all elements 
   * that are NOT in both sets. In other words, return a TreeSet of all the
   * elements that are in one set but not the other.
   */
  
  public static Set<Integer> different(Set<Integer> setA, Set<Integer> setB) {
    // Create a new TreeSet to store the symmetric differece of setA and setB
    Set<Integer> symmetricDiffAB = new TreeSet<Integer>(setA);
    // Add all elements of setB to symmetricDiffAB
    symmetricDiffAB.addAll(setB);


    // Create a new TreeSet to store the intersection of setA and setB
    Set<Integer> intersectionAB = new TreeSet<Integer>(setA);
    // Retain only the elements that are in both setA and setB
    intersectionAB.retainAll(setB);

    // Removes all elements that are in the intersection to get the symmetric difference of setA and setB
    symmetricDiffAB.removeAll(intersectionAB);

    // Return the symmetric difference
    return symmetricDiffAB;
  }


  /**
   * Method removeEven()
   *
   * Given a treeMap with the key as an integer, and the value as a String,
   * remove all <key, value> pairs where the key is even. 
   */

  public static void removeEven(Map<Integer, String> treeMap) {

    // Create an iterator to iterate through the keys of the treeMap
    Iterator<Integer> iteratorForRemoveEvens = treeMap.keySet().iterator();

    // Iterate through the keys of the treeMap
    while (iteratorForRemoveEvens.hasNext()) {
      // Get the next key
      Integer key = iteratorForRemoveEvens.next();
      // If the key is even, remove the <key, value> pair
      if (key % 2 == 0) {
        iteratorForRemoveEvens.remove();
      }
    }
  }


  /**
   * Method treesEqual()
   *
   * Given two treeMaps, each with the key as an integer, and the value as a String,
   * return a boolean value indicating if the two trees are equal or not.
   */

  public boolean treesEqual(Map<Integer, String> tree1,Map<Integer, String> tree2 ) {
    // Initialize a boolean to store the result of the comparison
    boolean isTreeEqual = true;

    // Initialize a boolean to determine if the comparison should continue
    boolean continueChecking = true;

    // If the two trees are not the same size, they are not equal and thus isTreeEqual is false
    if (tree1.size() != tree2.size()) {
      isTreeEqual = false;
    } else {
      // Create an iterator to iterate through the keys of tree1
      Iterator<Integer> iteratorForTree1 = tree1.keySet().iterator();

      // Iterate through the keys of tree1
      while (iteratorForTree1.hasNext() && continueChecking) {

        // Get the next key
        Integer key = iteratorForTree1.next();
        if (!tree2.containsKey(key)) {

          // If the key is not in tree2, the trees are not equal and thus isTreeEqual is false
          isTreeEqual = false;
          continueChecking = false;
        } else {
          // If the key is in tree2, compare the values of the two trees
          if (!tree1.get(key).equals(tree2.get(key))) {

            // If the values are not equal, the trees are not equal and thus isTreeEqual is false
            isTreeEqual = false;
            continueChecking = false;
          }
        }
      }
    }

    return isTreeEqual;
  }

} // end treeProblems class
