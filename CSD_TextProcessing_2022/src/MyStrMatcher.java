
public class MyStrMatcher {

    public static int indexOf_BF(String S, String pattern) {
        int n = S.length();
        int m = pattern.length();
        int i, j;
        for (i = 0; i < n - m + 1; i++) {
            j = 0;
            while (j < m) {
                if (S.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
                j++;
                if (j == m) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static int lastIndexOf_BF(String S, String pattern) {
        int n = S.length();
        int m = pattern.length();
        int i, j;
        for (i = n - m; i >= 0; i--) {
            j = 0;
            while (j < m) {
                if (S.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
                j++;
                if (j == m) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static int[] computeFailKMP(char[] pattern) {
        int m = pattern.length;
        int[] fail = new int[m];
        fail[0] = 0;
        int j = 1;
        int k = 0;
        while (j < m) {
            if (pattern[j] == pattern[k]) {
                fail[j] = k + 1;
                k++;
            } else if (k > 0) {
                k = fail[k - 1];
            } else {
                fail[j] = 0;
            }
            j++;
        }
        return fail;
    }

    public static int indexOf_KMP(char S[], char p[]) {
        int n = S.length;
        int m = p.length;
        int[] prefixes = computeFailKMP(p);
        int j = 0;
        int k = 0;
        while (j < n) {
            if (S[j] == p[k]) {
                if (k == m - 1) {
                    return j - m + 1;
                }
            } else if (k > 0) {
                k = prefixes[k - 1];
            }
            j++;
            k++;
        }
        return -1;
    }

    public static int indexOf_KMP(String S, String pattern) {
        return indexOf_KMP(S.toCharArray(), pattern.toCharArray());
    }

    public static void printArray(int a[]) {
        for (int x : a) {
            System.out.print(x + ", ");
        }
    }

    public static void main(String[] args) {
        String S1 = "Jack! go away, and you, please do not go away tonight";
        String p1 = "go";
        String p2 = "away";
        int pos1 = indexOf_BF(S1, p1);
        int pos2 = indexOf_BF(S1, p2);
        int pos3 = lastIndexOf_BF(S1, p2);
        System.out.println("S1=" + S1);
        System.out.println("p1=" + p1);
        System.out.println("Index of p1 in S1: " + pos1);
        System.out.println("p2=" + p2);
        System.out.println("Index of p2 in S1: " + pos2);
        System.out.println("Last index of p2 in S1: " + pos3);

        String S2 = "bacbabababacaca";
        String pattern = "ababaca";
        int fail[] = computeFailKMP(pattern.toCharArray());
        System.out.println("S2:" + S2);
        System.out.println("Pattern:" + pattern);
        System.out.print("fail[] :");
        printArray(fail);
        System.out.println("\nPattern at position in S2:"
                + indexOf_KMP(S2, pattern));
    }
}
