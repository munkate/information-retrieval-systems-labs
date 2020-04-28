package ru.irs.algorithm;

public class FiniteAutomataSearch implements Searchable{

    private static int NO_OF_CHARS = 256;

    @Override
    public int search(String text, String substring) {
        if (text == null || substring == null)
            return -1;

        int M = substring.length();
        int N = text.length();

        int[][] TF = new int[M + 1][NO_OF_CHARS];

        computeTF(substring.toCharArray(), M, TF);

        int i, state = 0;
        for (i = 0; i < N; i++) {
            state = TF[state][text.charAt(i)];
            if (state == M)
               return i - M + 1;
        }
        return -1;
    }

    private void computeTF(char[] pat, int M, int[][] TF) {
        for (int state = 0; state <= M; ++state)
            for (int x = 0; x < NO_OF_CHARS; ++x)
                TF[state][x] = getNextState(pat, M, state, x);
    }

    private int getNextState(char[] pat, int M, int state, int x) {

        if (state < M && x == pat[state])
            return state + 1;

        int ns, i;

        for (ns = state; ns > 0; ns--) {
            if (pat[ns - 1] == x) {
                for (i = 0; i < ns - 1; i++)
                    if (pat[i] != pat[state - ns + 1 + i])
                        break;
                if (i == ns - 1)
                    return ns;
            }
        }
        return 0;
    }
}
