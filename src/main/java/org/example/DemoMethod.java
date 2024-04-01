package org.example;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class DemoMethod {
    public static void main(String[] args) {
        boolean s1 = compareTwoStrings2("test java", null);
        boolean s2 = compareTwoStrings2(null, "test java");
        boolean s3 = compareTwoStrings2("TEST", "test");
        boolean s4 = compareTwoStrings2("test", "test");

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
    }

    // cach 1: dung StringUtils
    public static boolean compareTwoStrings1 (String s1, String s2) {
        return StringUtils.equals(s1, s2);
    }

    // cach 2: dung Object
    public static boolean compareTwoStrings2 (String s1, String s2) {
        return Objects.equals(s1, s2);
    }

    // cach 3: dung String
    public static boolean compareTwoStrings3 (String s1, String s2) {
        return s1.equals(s2);
    }
}



