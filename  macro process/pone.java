import java.util.*;
import java.io.*;



public class pone {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        PrintWriter out_pass1 = new PrintWriter(new FileWriter("output.txt"), true);
        PrintWriter out_mnt = new PrintWriter(new FileWriter("mnt.txt"), true);
        PrintWriter out_mdt = new PrintWriter(new FileWriter("mdt.txt"));

        String s;
        boolean processingMacroDef = false, prcessMacroName = false;

        while ((s = input.readLine()) != null) {
            String arr_tokens[] = tokenizeString(s, " ")
        }
    }

    static String[] tokenizeString(String s, String seperator) {
        StringTokenizer st = new StringTokenizer(s, seperator, false);
        String tokens[] = new String[st.countTokens()];
        for (int i = 0; i < st.countTokens(); i++) {
            tokens[i] = st.nextToken();
        }

        return tokens;
    }

}
