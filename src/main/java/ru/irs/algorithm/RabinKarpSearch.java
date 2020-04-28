package ru.irs.algorithm;

public class RabinKarpSearch implements Searchable {

    private static final int ALPHABET_POWER = 256;
    private static final int PRIME = 11;

    @Override
    public int search(String text, String substring) {
        if (text == null || substring == null)
            return -1;

        int patternLength = substring.length();
        int textSize = text.length();
        int i, j;
        int patternHash = 0;
        int textHash = 0;
        int h = 1;

        for (i = 0; i < patternLength - 1; i++)
            h = (h * ALPHABET_POWER) % PRIME;

        for (i = 0; i < patternLength; i++) {
            patternHash = (ALPHABET_POWER * patternHash + substring.charAt(i)) % PRIME;
            textHash = (ALPHABET_POWER * textHash + text.charAt(i)) % PRIME;
        }

        for (i = 0; i <= textSize - patternLength; i++) {

            if (patternHash == textHash) {
                for (j = 0; j < patternLength; j++) {
                    if (text.charAt(i + j) != substring.charAt(j))
                        break;
                }
                if (j == patternLength)
                    return i;
            }

            if (i < textSize - patternLength) {
                textHash = (ALPHABET_POWER * (textHash - text.charAt(i) * h) + text.charAt(i + patternLength)) % PRIME;
                if (textHash < 0)
                    textHash = (textHash + PRIME);
            }
        }
        return -1;
    }

}
