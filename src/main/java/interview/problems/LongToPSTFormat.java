package interview.problems;
import java.util.*;

public class LongToPSTFormat {
    public Scanner sc = new Scanner(System.in);

    public String go(long a, long b) {
        String s = Long.toString(a - b);
        boolean isNeg = false;
        if (s.charAt(0) == '-') {
            isNeg = true;
            s = s.substring(1);
        }
        List<Integer> rules = new ArrayList<>(Arrays.asList(3, 1, 2));
        int idx = 0;
        List<String> arr = new ArrayList<>();
        int ii = s.length();
        for (; ii >= rules.get(idx); ii -= rules.get(idx), idx = (idx + 1) % 3) {
            int n = rules.get(idx);
            arr.add(s.substring(ii - n, ii));
        }
        if (ii > 0) {
            arr.add(s.substring(0, ii));
        }
        String ret = isNeg ? "-" : "";
        for (int i = arr.size() - 1; i >= 0 ; i--) {
            ret += arr.get(i);
            if (i != 0) {
                ret += ',';
            }
        }

        return ret;
    }

    void init() {
        Long a = -1111111111111L;
        Long b = 2L;
        System.out.println(a - b);
        String ret = go(a, b);
        System.out.println("ret = " + ret);
    }

    public static void main(String[] args) {
        LongToPSTFormat obj = new LongToPSTFormat();
        obj.init();
    }
}
