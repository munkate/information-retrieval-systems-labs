package ru.irs.algorithm;

public class KnutMorrisPrattSearch implements Searchable {

    @Override
    public int search(String text, String substring) {
        if (text == null || substring == null)
            return -1;

        int M = substring.length();
        int N = text.length();

        int[] lps = new int[M];
        int j = 0;

        computeLPSArray(substring, M, lps);

        int i = 0;
        while (i < N) {
            if (substring.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
               return i - j;
            } else if (i < N && substring.charAt(j) != text.charAt(i)) {

                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
        return -1;
    }

    private void computeLPSArray(String pat, int M, int[] lps) {
        int len = 0;
        int i = 1;
        lps[0] = 0;

        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
}