package com.programmers.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PGS_L1_완주하지못한선수 {

	static String[] participant = { "leo", "kiki", "eden" };
	static String[] completion = { "eden", "kiki" };

	public static void main(String[] args) {
		System.out.println(solution(participant, completion));
	}

	public static String solution(String[] participant, String[] completion) {
		Arrays.sort(participant);
		Arrays.sort(completion);

		for (int i = 0; i < completion.length; i++) {
			if (!completion[i].equals(participant[i])) {
				return participant[i];
			}
		}

		return participant[participant.length - 1];
	}

	public static String solution2(String[] participant, String[] completion) {
		String answer = "";

		Map<String, Integer> map = new HashMap<>();
		for (String p : participant) {
			map.put(p, map.getOrDefault(p, 0) + 1);
		}
		for (String c : completion) {
			map.put(c, map.get(c) - 1);
		}
		for (String key : map.keySet()) {
			if (map.get(key) != 0) {
				answer = key;
			}
		}

		return answer;
	}
}
