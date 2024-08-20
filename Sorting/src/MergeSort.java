import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MergeSort {


    private static Comparable aux[];

    public  static void merge(Comparable [] input, int lo, int mid, int hi){

        int i = lo, j = mid+1;
        for (int k = lo; k<=hi; k++){
            aux[k] = input[k];
        }
        for (int k = lo; k <=hi; k++){
            if (i >mid) input[k] = aux[j++];
            else if (j >hi)  input[k] = aux[i++];
            else if ( aux[j].compareTo(aux[i])<=0) input[k]=aux[j++];
            else  input[k]=aux[i++];
        }
    }

    public static void sort (Comparable[] input, int lo, int hi ){
        if ( hi <= lo ) return;
        int mid = lo+ (hi-lo)/2;
        sort(input, lo, mid);
        sort(input, mid+1, hi);
        merge(input, lo, mid, hi);
    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the integers");
        Integer[] number =  Arrays.stream(br.readLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        aux = new Comparable[number.length];
        sort(number, 0, number.length-1);
        System.out.println(Arrays.toString(number));
    }
}
