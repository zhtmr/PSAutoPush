import java.util.*;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] MEDAL = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        int max = findMax(score);
        int[] scoreIdx = new int[max + 1];
        for (int i = 0; i < score.length; i++) {
            scoreIdx[score[i]] = i + 1;
        }

        String[] rank = new String[score.length];
        int num = 1;

        for (int i = max; i >= 0; i--) {
            if (scoreIdx[i] != 0) {
                int originalIdx = scoreIdx[i] - 1;
                if (num < 4) {
                    rank[originalIdx] = MEDAL[num - 1];
                } else {
                    rank[originalIdx] = String.valueOf(num);
                }
                num++;
            }

        }

        return rank;

    }

    int findMax(int[] score) {
        int max = 0;
        for (int i : score) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}