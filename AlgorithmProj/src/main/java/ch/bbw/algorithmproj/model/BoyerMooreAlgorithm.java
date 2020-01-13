package ch.bbw.algorithmproj.model;

import java.util.ArrayList;
import java.util.List;

public class BoyerMooreAlgorithm {

	static int NO_OF_CHARS = 256;

	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	private static void badCharHeuristic(char[] str, int size, int badchar[]) {
		int i;

		for (i = 0; i < NO_OF_CHARS; i++) {
			badchar[i] = -1;
		}

		for (i = 0; i < size; i++) {
			badchar[(int) str[i]] = i;
		}
	}

	public static List<Integer> search(char txt[], char pat[]) {
		int m = pat.length;
		int n = txt.length;
		ArrayList<Integer> results = new ArrayList<Integer>();

		int badchar[] = new int[NO_OF_CHARS];

		badCharHeuristic(pat, m, badchar);

		int s = 0; 
		while (s <= (n - m)) {
			int j = m - 1;
			
			while (j >= 0 && pat[j] == txt[s + j]) {
				j--;
			}
			
			if (j < 0) {
				results.add(s);
				s += (s + m < n) ? m - badchar[txt[s + m]] : 1;
			} else {
				s += max(1, j - badchar[txt[s + j]]);
			}
		}

		return results;
	}
}
