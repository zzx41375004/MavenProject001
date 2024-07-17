package interview.problems;

import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public Integer getMinDessertCnt(List<String> SList) {
        // show me your code
        //开始店
        for (int i = 0 ; i < SList.size() - 1; i++) {
            //几间店
            for (int k = 0 ; k < SList.size() - 1; k++) {
                String result = findNext(SList, k, i, SList.get(0));
                if (!result.contains("x")) {
                    return k;
                }
            }
        }
        return 0;
    }
    public String findNext(List<String> SList, int storeCount, int fromStore, String data) {
        int nStoreCount = storeCount - 1;
        String returnResult = "x";
        for (int i = fromStore; i < SList.size() - 1 - fromStore; i++) {
            char[] chars = data.toCharArray();
            for (int j = 0; j < SList.get(fromStore).length(); j++) {
                if ("O".equals(SList.get(fromStore).substring(j, j + 1))) {
                    chars[j] = SList.get(fromStore).charAt(j);
                }
            }
            String midData = chars.toString();
            if (storeCount > 0) {
                midData = findNext(SList, nStoreCount, fromStore + 1, midData);
            }
            //check
            if (storeCount == 0) {
                if (!midData.contains("x")) {
                    return midData;
                }
            }
        }
        return returnResult;
    }

    void init() {

        int N = sc.nextInt();
        int M = sc.nextInt();
        System.out.println(M);
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String s = sc.next();
            arr.add(s);
        }
        int ret = getMinDessertCnt(arr);
        System.out.println(ret);
    }

    public static void main(String[] args) {
        Main c = new Main();
        System.out.println("hello a");
        System.out.println("hello xba");
        c.init();
    }
}
