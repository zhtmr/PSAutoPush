public class Solution {
    public String solution(String number, int k) {
        StringBuilder stack = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            char num = number.charAt(i);
            while (stack.length() > 0 && k > 0 && stack.charAt(stack.length() - 1) < num) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            stack.append(num);
        }
        // k가 남은 경우 뒤에서부터 제거
        return stack.substring(0, stack.length() - k);
    }
}
