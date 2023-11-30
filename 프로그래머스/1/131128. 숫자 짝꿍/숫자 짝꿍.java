import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public String solution(String X, String Y) {
           String answer = "";
            ArrayList<Integer> nums = new ArrayList<>();


            String[] XcharArray = X.split("");
            String[] YcharArray = Y.split("");
            List<String> xList = Arrays.stream(XcharArray).collect(Collectors.toList());
            List<String> yList = Arrays.stream(YcharArray).collect(Collectors.toList());

            int count = 0;

            //    "5525"	"1255"


            for (int i = 0; i <= 9; i++) {
                count = commonCount(xList, yList, String.valueOf(i));
                if(count > 0) {
                    for (int j = 0; j < count; j++) {
                            nums.add(i);
                    }
                }
            }


            if(nums.isEmpty()) {
                answer = "-1";
                return answer;
            }


           if(nums.stream().allMatch(e -> e.equals(0))) {
                answer = "0";
                return answer;
            }

            answer = nums.stream()
                    .sorted(Comparator.reverseOrder())
                    .map(Object::toString)
                    .collect(Collectors.joining());
            return answer;


        }

        public int commonCount(List<String> xList, List<String> yList, String s) {
            long xcount = xList.stream().filter(e -> e.equals(s)).count();
            long ycount = yList.stream().filter(e -> e.equals(s)).count();
            return (int) Math.min(xcount,ycount);
        }

    }
