package interview;

import interview.problems.LargeIntegerToPSTSeniorFormat;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargeIntegerToPSTSeniorFormatTest {

    @Test
    public void foo() {
        largeIntegerToPSTSeniorFormat("-827931258217389185912328374185123", "1", Arrays.asList(8, 1, 6, 4, 7));
    }

    private String largeIntegerToPSTSeniorFormat(String a, String b, List<Integer> gaps){
        if(StringUtils.isEmpty(a) || StringUtils.isEmpty(b) || CollectionUtils.isEmpty(gaps)){
            return null;
        }
        BigDecimal multiply = new BigDecimal(a).multiply(new BigDecimal(b));
        String s = multiply.toString();
        char[] chars = s.toCharArray();
        String result = "";
        int d = 0;
        int index = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            result = chars[i] + result;
            d++;
            if(d != gaps.get(index)){
                continue;
            }
            boolean skip = "-".equals(chars[0]) && i == 1;
            result = (i == 0 || skip) ? result : "," + result;
            d = 0;
            index++;
            if(index == gaps.size()){
                index = 0;
            }
        }
        return result;
    }

    // 将字符串逆序转换
    public String convertStr(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }

    public String toPSTFormat(String str, List<Integer> gap) {
        StringBuilder stringBuilder = new StringBuilder();
        int n = 1;
        // 计算每次需要插入逗号的间隔长度
        int len = gap.get(0);
        for (int i = 0; i < str.length(); i++) {
            stringBuilder.append(str.charAt(i));
            // 循环间隔顺序
            if (n >= gap.size()) n = 0;
            // 当当前string长度=需要插入的间隔长度时
            if (stringBuilder.length() == len) {
                stringBuilder.append(",");
                // 计算下一个插入的间隔长度
                len = len + 1 + gap.get(n);
                n++;
            }
        }
        return stringBuilder.toString();
    }

    @Test
    public void testLargeIntegerToPSTSeniorFormat() {
        List<String> num1 = new ArrayList<>(Arrays.asList(
                "231251239818351923941241",
                "290510293015901293019059102301",
                "1203912059012903108509180671029031",
                "1203910295102938197601294810283409128409185",
                "091239019501293012930129301285098120936701972039812097498175981374981076908137409817295861760103",
                "1231231451236512222222222222222222222223151261231200991512",
                "12093801290301297850127509172073091820398209185091709172094812085091270567102374129412" +
                        "031204709127340172057402173012907509175091872039809128312048012412" +
                        "1820380912740517501928340124830912",
                "2103901275097210983098210938917568937601982730987640984375092837409123876091238479123874891237681702384712034" +
                        "018740123874092318570123874012398570132740581325231",
                "1024701297569081783986704981082347832758173098479231876501923847032987601982347601893" +
                        "4793284793021578912347590123874019238750192387512361237129851241241" +
                        "12412851209857403987698437987019832749083275098172304893721087460139487501",
                "12947109867039809194870192873019287509847604857182934789327481237402380675183450123847983479843789515817234791389874081325712"
        ));
        List<String> num2 = new ArrayList<>(Arrays.asList(
                "97893875102903874092837401923875287018637018237019287054238475081",
                "382703198237016573899802749812740192387056987230917485372014892874012734812",
                "83970658017389274981237896701928734837120198457091327578703415701234817230472318907508127361",
                "78123740912387609817234012874012384738974098327601982370489372047812374091273051",
                "87087327401238750123987498137240182376000000000000000018237487132094781029837650913874012837" +
                        "401938987501723849712318275012839837984701238947912378498370491823750917230974083120123759123" +
                        "41207398765012734891732947910290749027318957901238749213875609172390578412374091237840123989807213",
                "7018327401237894523918765901327405172387650192387401293784092381570123750912387401293740912374" +
                        "123784970123678501237481230471023847012375871230847293876509389801740981237054981873407123" +
                        "17230958730823701283405671082340123847120374012834701238748312",
                "780270481723075893720498123076817029874012374012398765012374012387409832789789743987498012374981723" +
                        "3243812750128304273847012387501293980740182937401238974098750192873401238" +
                        "1239875019876051493845091832750913287409123740192374012938740129387501239851",
                "742389017490831898070658123098903287491327884917239579231876984789579832792378498327498712304123784" +
                        "12983796587493749372102893750132875423759847690847320148127305701235740123478123057912385701923781" +
                        "57102384701237580931275109328740128375098187698134759812734908712309579120375901723511239847019234",
                "389208937501982379473987409123874012387501283740129837409128375609189803470598123705987320498123",
                "87387010348120478312756019872394713298478937409817320984710298375609123874091238750192387540912398075012"
        ));
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(Arrays.asList(1, 2));
        arr.add(Arrays.asList(1, 2, 3, 4, 5));
        arr.add(Arrays.asList(5, 4, 3, 2, 1));
        arr.add(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        arr.add(Arrays.asList(2, 3, 3, 1, 8, 11, 7, 12, 9, 1));
        LargeIntegerToPSTSeniorFormat obj = new LargeIntegerToPSTSeniorFormat();
        int cnt = 0;
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < num1.size(); i++) {
            String a = num1.get(i);
            String b = num2.get(i);
            for (int j = 0; j < arr.size(); j++) {
                List<Integer> gaps = arr.get(j);
                String anwser = obj.go(a, b, gaps);
                String t = largeIntegerToPSTSeniorFormat(a, b, gaps);
                out.append(anwser);
                out.append("\n");
                out.append(t);
                out.append("\n\n");
                if (anwser.equals(t)) {
                    cnt += 1;
                }
            }
        }

        System.out.println("共10个测试用例，通过数量：" + cnt);
        System.out.println(out);
    }
}
