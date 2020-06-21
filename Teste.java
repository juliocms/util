import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Teste {

    List<Integer> cellCompete(int[] states, int days)
    {
        List<Integer> result = new ArrayList<Integer>();
        if(states.length > 0) {
            for(int i = 0; i < states.length; i++) {
                int j = i;
                if(i == 0 ) {
                    if(states[j+1] == 0) {
                        for (int k = 0; k < days; k++) {
                            result.add(0);
                        }
                    } else {
                        for (int k = 0; k < days; k++) {
                            result.add(0);
                        }
                    }
                } else if (i == states.length - 1) {
                    if(states[j-1] == 0) {
                        for (int k = 0; k < days; k++) {
                            result.add(0);
                        }
                    } else {
                        for (int k = 0; k < days; k++) {
                            result.add(1);
                        }
                    }
                } else if(i > 0 && i < states.length) {
                    if(states[j-1] == states[j+1] ) {
                        for(int k = 0; k < days; k++){
                            result.add(0);
                        }
                    } else {
                        for(int k = 0; k < days; k++){
                            result.add(1);
                        }
                    }
                }
                i += days - 1;
            }
        }
        System.out.println(result);
        return result;
    }

    public int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

        public int generalizedGCD(int num, int[] arr)
    {
        int result = arr[0];
        for (int i = 1; i < num; i++){
            result = gcd(arr[i], result);

            if(result == 1)
            {
                return 1;
            }
        }
        return result;
    }

    public int numberAmazonTreasureTrucks(int rows, int column,
                                   List<List<Integer> > grid)
    {
        int result = 0;
        if(grid.size() > 0) {
            for(int i=0; i < rows; i++) {
                for(int j=0; j < column; j++) {
                    int k = j;
                    if(grid.get(i).get(j) == 1) {
                        if(grid.get(i).get(k + 1) == 1) {
                            result++;
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }


    public static void main(String[] argv) {
        Teste t = new Teste();

        List<String> words = new ArrayList<String>();
        words.add("Ruby");
        words.add("C");
        words.add("Python");
        words.add("Java");

        for(int i = 0; i < 3; ++i) {
            for (int j = i + 1; j < 4; ++j) {
                if (words.get(i).compareTo(words.get(j)) > 0) {

                    // swap words[i] with words[j[
                    String temp = words.get(i);
                    words.set(i, words.get(j));
                    words.set(j, temp);
                }
            }
        }

        System.out.println("In lexicographical order:");
        for(int i = 0; i < 4; i++) {
            System.out.println(words.get(i));
        }


        /*int[] vals = {1,1,1,0,0,1,0,0};
        t.cellCompete(vals, 1);
        int arr[] = { 2, 4, 6, 8, 16 };
        int n = arr.length;
        System.out.println(t.generalizedGCD(n, arr));*/
    }
}
