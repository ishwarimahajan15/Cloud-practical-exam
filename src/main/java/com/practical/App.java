package com.practical;

public class App {
    public static String greeting(String name) {
        if (name == null || name.isBlank()) {
            return "Hello, Jenkins!";
        }
        return "Hello, " + name + "!";
    }

    public static void main(String[] args) {
        String name = args.length > 0 ? args[0] : "";
        System.out.println(greeting(name));
    }
}
