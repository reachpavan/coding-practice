package org.codingpractice.cheatsheet;

import java.util.HashMap;
import java.util.Map;

public class MapExamples {
    //https://github.com/winterbe/java8-tutorial#maps
  public static void main(String[] args) {

    Map<Integer, String> map = new HashMap<>();

    // putIfAbsent
    for (int i = 0; i < 10; i++) {
      map.putIfAbsent(i, "val" + i);
    }
    map.forEach((id, val) -> System.out.println(val));

    // computeIfPresent
    map.computeIfPresent(3, (num, val) -> val + num);
    map.get(3); // val33

    map.computeIfPresent(9, (num, val) -> null);
    map.containsKey(9); // false

    // computeIfAbsent
    map.computeIfAbsent(23, key -> "val" + key);
    map.get(23); // val23
    map.containsKey(23); // true

    map.computeIfAbsent(3, key -> "bam");
    map.get(3); // val33

    // getOrDefault
    map.getOrDefault(42, "not found"); // not found

    // merge
    // if the specified key is not already associated with a value or is
    //     * associated with null, associates it with the given non-null value.
    //     * Otherwise, replaces the associated value with the results of the given
    //     * remapping function, or removes if the result is {@code null}.
    map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
    map.get(9); // val9, no merging done since key doesn't exist yet, lambda not called

    map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
    map.get(9); // val9concat
  }
}
