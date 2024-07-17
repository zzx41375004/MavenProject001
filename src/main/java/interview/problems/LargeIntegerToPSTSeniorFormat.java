package interview.problems;
import java.math.BigInteger;
import java.util.*;

public class LargeIntegerToPSTSeniorFormat {
    public Scanner sc = new Scanner(System.in);

    public String go(String a, String b, List<Integer>gaps) {
        BigInteger num1 = new BigInteger(a);
        BigInteger num2 = new BigInteger(b);
        BigInteger res = num1.multiply(num2);
        String s = res.toString();
        boolean isNeg = false;
        if (s.charAt(0) == '-') {
            isNeg = true;
            s = s.substring(1);
        }
        List<Integer> rules = gaps;
        int idx = 0;
        List<String> arr = new ArrayList<>();
        int ii = s.length();
        for (; ii >= rules.get(idx); ii -= rules.get(idx), idx = (idx + 1) % gaps.size()) {
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
        String a = "-827931258217389185912328374185123";
        String b = "1";
        String ret = go(a, b, Arrays.asList(8, 1, 6, 4, 7));
        System.out.println("ret = " + ret);
    }

    public static void main(String[] args) {
        LargeIntegerToPSTSeniorFormat obj = new LargeIntegerToPSTSeniorFormat();
        obj.init();
    }
}
