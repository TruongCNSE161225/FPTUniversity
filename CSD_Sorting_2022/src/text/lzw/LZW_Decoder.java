package text.lzw;

import java.util.Hashtable;
import java.util.ArrayList;

public class LZW_Decoder {

    Hashtable<Integer, String> dict = null;
    String unzippedStr = null;
    int code = 0;
    String initDicStr = null;

    public LZW_Decoder() {
    }

    private void initDict() {
        dict = new Hashtable();
        if (initDicStr == null) {
            for (int i = 0; i < 256; i++) {
                dict.put(i, "" + (char) i);
            }
            code = 256;
        } else {
            int L = initDicStr.length();
            for (int i = 0; i < L; i++) {
                dict.put(i, "" + initDicStr.charAt(i));
            }
            code = L;
        }
    }

    private void putToDict(String newSubStr) {
        dict.put(code++, newSubStr);
    }

    private void addOutput(String subStr) {
        unzippedStr += subStr;
    }

    private String decode(ArrayList<Integer> zippedCodes) {
        unzippedStr = "";
        int curCode;
        char ch;
        curCode = zippedCodes.get(0);
        String curTrans = dict.get(curCode);
        addOutput(curTrans);
        String nextTrans;
        for (int i = 1; i < zippedCodes.size(); i++) {
            curCode = zippedCodes.get(i);
            nextTrans = dict.get(curCode);
            addOutput(nextTrans);
            ch = nextTrans.charAt(0);
            String newSubStr = curTrans + ch;
            putToDict(newSubStr);
            curTrans = nextTrans;
        }
        return unzippedStr;
    }

    public String unzip(ArrayList<Integer> zippedCodes) {
        this.initDicStr = null;
        initDict();
        return decode(zippedCodes);
    }

    public String unzip(String initDictStr, ArrayList<Integer> zippedCodes) {
        this.initDicStr = initDictStr;
        initDict();
        return decode(zippedCodes);
    }
}
