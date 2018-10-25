package com.google.challenges;

public class Answer {
    public static String answer(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z')
            c = (char)((int)('z' - c + 'a'));
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
    // Your code goes here.

}

