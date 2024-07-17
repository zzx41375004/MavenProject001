package interview;

import static org.mockito.Mockito.*;

import interview.problems.LongToPSTFormat;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongToPSTFormatTest {

    private String foo(Long a, Long b) {
        return "hello world";
    }


    private String longToPSTFormat(Long a, Long b) {
        Long l = a - b;
        String convert = convertStr(l.toString());
        System.out.println("convertL="+convert);
        String s = toPSTFormat(convert);
        // 删去最后的，
        if(',' == s.charAt(s.length()-1)){
            s = s.substring(0, s.length() - 1);
        }
        System.out.println("toPST="+s);
        String result = convertStr(s);
        return result;
    }

    public String convertStr(String str){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=str.length()-1; i>=0; i--){
            stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }

    public String toPSTFormat(String str){
        // 处理-
       // boolean flag = false;
       // if(str.contains("-")) {
       //     str = str.substring(0, str.length() - 1);
       //     flag = true;
       // }

        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> gap = new ArrayList<>();
        gap.add(3); gap.add(1); gap.add(2);
        int n = 1;
        int len = gap.get(0);
        for(int i=0; i<str.length(); i++){
            stringBuilder.append(str.charAt(i));
            if(n >= gap.size()) n=0;
            if(stringBuilder.length() == len){
                stringBuilder.append(",");
                len = len + 1 + gap.get(n);
                n++;
            }
        }
//        if(flag) stringBuilder.append("-");
        return stringBuilder.toString();
    }

    // private String longToPSTFormat(Long a, Long b) {
    //     // 计算差值
    //     long diff = a - b;
    //     String diffStr = String.valueOf(diff);
    //
    //
    //
    //     // 初始化间隔序列
    //     int[] intervals = {3, 1, 2};
    //     int currentIntervalIndex = 0;
    //
    //     // 转换为字符串，并处理负号
    //     boolean isNegative = false;
    //     if (diff < 0) {
    //         isNegative = true;
    //         diffStr = diffStr.substring(1);// 去除负号
    //     }
    //
    //     // 分割并构建字符串
    //     StringBuilder result = new StringBuilder(diffStr);
    //     if (isNegative) {
    //         // 若为负数，则在结果字符前添加负号
    //         result.insert(0, '-');
    //     }
    //
    //     // 逆序遍历字符串
    //     for (int i = diffStr.length(), groupIndex = 0; i > 0; i--, groupIndex++) {
    //         if (groupIndex == intervals[currentIntervalIndex]) {
    //             // 这里需要判断下结果是否为负数，负数字符串长度需加1
    //             result.insert(diff < 0 ? i + 1 : i, ',');
    //             // 重置计数器
    //             groupIndex = 0;
    //             currentIntervalIndex = (currentIntervalIndex + 1) % intervals.length;
    //         }
    //     }
    //     return result.toString();
    // }

    @Test
    public void testLongToPSTFormat() {
        List<Long> arr = new ArrayList<>(Arrays.asList(
                11111111111111L,
                82123512394123L,
                -123151234L,
                12315412341L,
                -31258123L,
                312541238L,
                -299999231L,
                123L,
                -2319L,
                2L,
                -1L,
                512382L,
                -23581231234851L,
                931512314L,
                -12376124L,
                -2139512385L,
                31L,
                -231L,
                -2512L,
                231523L
        ));
        LongToPSTFormat obj = new LongToPSTFormat();
        int cnt = 0;
        StringBuilder out = new StringBuilder();
        for (Long s : arr) {
            String anwser = obj.go(s, 0);
            String t = longToPSTFormat(s, 0L);
            out.append(anwser);
            out.append("\n");
            out.append(t);
            out.append("\n\n");
            if (anwser.equals(t)) {
                cnt += 1;
            }
        }

        System.out.println("共20个测试用例，通过数量：" + cnt);
        System.out.println(out);
    }


    @Test
    public void testMock() {
        LongToPSTFormat longToPSTFormat = mock(LongToPSTFormat.class);
        when(longToPSTFormat.go(anyLong(), anyLong())).thenAnswer(para -> {
            Long a = para.getArgument(0);
            Long b = para.getArgument(1);
            return foo(a, b);
        });
        String ret = longToPSTFormat.go(12312, 123);
        System.out.println(ret);
    }
}
