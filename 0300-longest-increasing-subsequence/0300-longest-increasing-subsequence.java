class Solution {
    public int lengthOfLIS(int[] nums) {
       int[] lis = new int[nums.length];
        int length = 0;

        for (int num : nums) {
          int pos = Arrays.binarySearch(lis, 0, length, num);
          if (pos < 0) {
            pos = -(pos + 1);
          }
          lis[pos] = num;
          if (pos == length) {
            length++;
          }
        }
        return length;
    }
}