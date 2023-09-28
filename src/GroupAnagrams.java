// 10.2
// Group Anagrams: Write a method to sort an array of strings so that
// all the anagrams are next to each other.

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String str : strs) {
            // Sort the characters of the string to create a unique key for anagrams.
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            // Check if the sorted string is already in the map.
            // If it's not, create a new list for it.
            if (!anagramGroups.containsKey(sortedStr)) {
                anagramGroups.put(sortedStr, new ArrayList<>());
            }

            // Add the original string to the corresponding anagram group.
            anagramGroups.get(sortedStr).add(str);
        }

        // Collect the grouped anagrams into a list of lists.
        return new ArrayList<>(anagramGroups.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);

        // Print the grouped anagrams
        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}
