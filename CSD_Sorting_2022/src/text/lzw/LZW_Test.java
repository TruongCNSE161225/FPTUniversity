package text.lzw;

import java.util.ArrayList;

public class LZW_Test {

    public static void main(String[] args) {
        LZW_Coder coder = new LZW_Coder();
        LZW_Decoder decoder = new LZW_Decoder();
        //Test 1//
        String src = "AABAABBCCACC", initDictStr = "ABC";
        ArrayList<Integer> zippedData = coder.zip(initDictStr, src);
        System.out.println("Test 1 src: " + src);
        System.out.println("Zipped data:\n" + zippedData);
        System.out.println("\nNumber of codewords:" + zippedData.size());
        String unzippedStr = decoder.unzip(initDictStr, zippedData);
        System.out.println("After unzipping: " + unzippedStr + "\n\n");
        //Test 2//
        src = "LZW starts out with a dictionary of 256 characters\n (in the case of 8 bits) and uses those as the \"standard\" character set.\nIt then reads data 8 bits at a time (e.g., 't', 'r', etc.) and encodes \n the data as the number that represents its index in the dictionary.\nEverytime it comes across a new substring (say, \"tr\")\n";
        System.out.println("Test 2 src: " + src + "\nLength: " + src.length());
        zippedData = coder.zip(src);
        System.out.println("Zipped data:\n" + zippedData);
        System.out.println("\nNunber of codewords:" + zippedData.size());
        unzippedStr = decoder.unzip(zippedData);
        System.out.println("After unzipping:\n\n" + unzippedStr);
    }
}
