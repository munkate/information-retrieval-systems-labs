package ru.irs.algorithm;

public interface Searchable {

    /**
     * Search substring in text
     * @param text
     * @param substring
     * @return start index of substring in text if text contains given substring, -1 otherwise
     */
    int search(String text, String substring);
}
