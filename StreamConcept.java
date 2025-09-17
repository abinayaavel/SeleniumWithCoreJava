package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StreamConcept {

    public static void main(String[] args) {

    }

    // @Test
    public void streamFilter() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Abi");
        names.add("Anubala");
        names.add("Sanju");
        names.add("Prasan");
        names.add("Arun");

        names.stream().filter(s -> s.startsWith("A")).forEach(s -> System.out.println(s));
    }

    @Test
    public void streamMap() {

        // Stream.of("Abi", "Anubala", "Sanju", "Prasan", "Arun").filter(s ->
        // s.endsWith("a")).map(s -> s.toUpperCase()).forEach(s ->
        // System.out.println(s));

        ArrayList<String> names = new ArrayList<String>();
        names.add("kiki");
        names.add("bala");
        names.add("daya");
        names.add("yogi");
        names.add("shenbu");

        List<String> names1 = Arrays.asList("Abi", "Anubala", "Sanju", "Prasan", "Arun");
        Stream<String> newString = Stream.concat(names.stream(), names1.stream());
        boolean flag = newString.anyMatch(s -> s.equalsIgnoreCase("DAY55A"));

        System.out.println(flag);
        Assert.assertTrue(flag);
    }

}
