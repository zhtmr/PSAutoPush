class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] indexArr = new int[n][2];
        for (int i = 0; i < indexArr.length; i++) {
          indexArr[i][0] = intervals[i][0];
          indexArr[i][1] = i;
        }

        Arrays.sort(indexArr, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
          int end = intervals[i][1];
          int search = binarySearch(indexArr, end);
          result[i] = search;
        }

        return result;
      }

      private int binarySearch(int[][] indexArr, int end) {
        int left = 0, right = indexArr.length;
        while (left < right) {
          int mid = left + (right - left) / 2;
          int start = indexArr[mid][0];
          if (start < end) {
            left = mid + 1;
          } else {
            right = mid;
          }
        }
        return left < indexArr.length ? indexArr[left][1] : -1;
      }
    }
