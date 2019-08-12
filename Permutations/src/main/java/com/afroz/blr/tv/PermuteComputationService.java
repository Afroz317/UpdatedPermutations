package com.afroz.blr.tv;

import java.util.Arrays;

import org.json.JSONArray;
import org.springframework.stereotype.Service;

@Service
public class PermuteComputationService {

	 JSONArray permutationsList = new JSONArray();

	public JSONArray addStrings(String name) {
		char str[] = name.toCharArray();
		int n = str.length;
		Arrays.sort(str);
		findPermutations(str, 0, n);
		return permutationsList;
	}
	
	boolean shouldSwap(char str[], int start, int curr) {
		for (int i = start; i < curr; i++) {
			if (str[i] == str[curr]) {
				return false;
			}
		}
		return true;
	}
	  
	void findPermutations(char str[], int index, int n) {
		if (index >= n) {
			permutationsList.put(new String(str));
			return;
		}

		for (int i = index; i < n; i++) {
			boolean check = shouldSwap(str, index, i);
			if (check) {
				swap(str, index, i);
				findPermutations(str, index + 1, n);
				swap(str, index, i);
			}
		}
	}
	  
	void swap(char[] str, int i, int j) {
		char c = str[i];
		str[i] = str[j];
		str[j] = c;
	}

}
