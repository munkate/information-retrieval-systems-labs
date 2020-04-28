package ru.irs.algorithm;

public class BoyerMooreSearch implements Searchable {

    private static int NO_OF_CHARS = 256;

    @Override
    public int search(String text, String substring) {
        if (text == null || substring == null)
            return -1;

        int m = substring.length();
        int n = text.length();

        int[] badchar = new int[NO_OF_CHARS];

        badCharHeuristic(substring.toCharArray(), m, badchar);

        int shift = 0;

        while (shift <= (n - m)) {
            int j = m - 1;

            while (j >= 0 && substring.charAt(j) == text.charAt(shift + j))
                j--;

            if (j < 0) {
               return shift;
            } else
                shift += max(1, j - badchar[text.charAt(shift + j)]);
        }
        return -1;
    }

    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    private void badCharHeuristic(char[] str, int size, int[] badchar) {

        for (int i = 0; i < NO_OF_CHARS; i++)
            badchar[i] = -1;

        for (int i = 0; i < size; i++)
            badchar[(int) str[i]] = i;
    }
}
