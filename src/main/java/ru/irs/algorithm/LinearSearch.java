package ru.irs.algorithm;

public class LinearSearch implements Searchable{

    @Override
    public int search(String text, String substring) {
        if (text == null || substring == null)
            return -1;

        int M = substring.length();
        int N = text.length();

        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++)
                if (text.charAt(i + j) != substring.charAt(j))
                    break;
            if (j == M)
                return i;
        }
        return -1;
    }

}
