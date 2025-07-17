package practice.July172025.StreamsAPI;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsAPI {


    // group a list of strings by their lengths.
    static Map<Integer, List<String>> groupLengthOfString() {
        Map<Integer, List<String>> res = new HashMap<>();
        List<String> strings = List.of("Hello", "Hi", "World", "Bye");
        res = strings.stream()
                .collect(Collectors.groupingBy(s -> s.length()));
        return res;
    }

    // count the number of Strings in a list of strings
    static Map<String, Long> countStrings() {
        List<String> strings = List.of("Hello", "Hi", "World", "Bye", "World", "Hello", "Hello");
        return strings.stream()
                .map(s -> s.toLowerCase())
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
    }

    // count the number of characters in a string
    static Map<Character, Long> countCharacters() {
        String s = "HelloWorld";
        return s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }

    // find duplicates in a list
    static void findDuplicate() {
        List<Integer> list = List.of(1,2,3,4,5,6,1,2,3,1);
        Set<Integer> set = new HashSet<>();
        list.stream()
                .filter(i -> !set.add(i))
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        System.out.println(groupLengthOfString());
        System.out.println();
        System.out.println(countStrings());
        System.out.println(countCharacters());
        findDuplicate();
    }
}
