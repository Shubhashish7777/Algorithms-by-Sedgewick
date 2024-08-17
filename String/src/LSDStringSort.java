import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class LSDStringSort {

    public static void sort(String [] strings , int radix) {

        int  n = strings.length, w=strings[0].length();
        String aux[] = new String[n];
        for (int d = w-1; d>=0; d--){
            int [] count = new int[radix];
            int finalD = d;
            String[] finalStrings1 = strings;
            IntStream.range(0,n).forEach(i->count[finalStrings1[i].charAt(finalD)+1]++);
            Arrays.parallelPrefix(count, Integer::sum);
            String[] finalStrings = strings;
            IntStream.range(0, n).forEach(i -> aux[count[finalStrings[i].charAt(finalD)]++] = finalStrings[i]);
            strings=Arrays.copyOf(aux, aux.length);
        }
        System.out.println(Arrays.toString(strings));

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter word of same length");
        String[] strings =  Arrays.stream(br.readLine().split("\\s+")).toArray(String[]::new);
        sort(strings, 256);
        }
}

//TEST CASE:
//abc abd aie sjs shd abs dmk sad asa vcu wen sfs mzx qed