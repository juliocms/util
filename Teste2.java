import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Teste2 {

    public static void main(String[] argv) {
        List<List<Integer>> grid = new ArrayList<List<Integer>>();

        Integer row1[] = new Integer[] { 1, 0, 0, 1, 1, 0, 0};
        Integer row2[] = new Integer[] { 0, 1, 0, 0, 0, 0, 0};
        Integer row3[] = new Integer[] { 0, 0, 1, 0, 0, 0, 0};
        Integer row4[] = new Integer[] { 0, 0, 0, 1, 0, 0, 0};
        Integer row5[] = new Integer[] { 0, 1, 1, 0, 1, 0, 0};
        Integer row6[] = new Integer[] { 0, 0, 0, 0, 1, 1, 0};
        Integer row7[] = new Integer[] { 0, 0, 0, 0, 0, 0, 1};

        grid.add(Arrays.asList(row1));
        grid.add(Arrays.asList(row2));
        grid.add(Arrays.asList(row3));
        grid.add(Arrays.asList(row4));
        grid.add(Arrays.asList(row5));
        grid.add(Arrays.asList(row6));
        grid.add(Arrays.asList(row7));

        List<Integer> temp = new ArrayList<Integer>();
        int sumLine = 0, sumColumn = 0;

        for(int s = 0; s < grid.size(); s++) {
            for (int r = 0; r < grid.get(s).size(); r++) {
                //Comparacao entre a coluna atual e a proxima coluna
                int c = r;
                c++;
                //for (c += 1; c < grid.get(s).size(); c++) {
                    if(grid.get(s).get(r).equals(1) && c < grid.get(s).size() &&
                            grid.get(s).get(r).equals(grid.get(s).get(c))) {
                        sumLine++;
                      //O else abaixo checa se ultrapassoua a quantidade colunas, ou seja, se está na ultima coluna
                    } else if(grid.get(s).get(r).equals(1) && c == grid.get(s).size() &&
                            grid.get(s).get(r).equals(grid.get(s).get(c-2))) {
                        sumLine++;
                    }
                //}

                //Comparacao entre o conjunto de dados corrente e o proximo conjunto de dados. Essa comparacao é para valores transversos
                int ns = s+1;
                int nr = r+1;

                if(grid.get(s).get(r).equals(1) && ns < grid.size() && nr < grid.get(s).size()) {
                    if (grid.get(s).get(r).equals(grid.get(ns).get(nr))) {
                        sumColumn++;
                    }
                  //O else abaixo checa se ultrapassoua a quantidade linhas, ou seja, se está na ultima linha
                } else if(grid.get(s).get(r).equals(1) && ns == grid.size() && nr == grid.get(s).size()) {
                    sumColumn++;
                }
            }
        }
        System.out.println("Total Line     " + sumLine);
        System.out.println("Total Column + " + sumColumn);
        int total = sumLine + sumColumn;
        System.out.println("             -----");
        System.out.println("Total          " + total);





        List<Integer> sourceList = Arrays.asList(45, 55, 0, 0, 46, 0, 39, 0, 0, 0);

        final Integer[] lastNonZero = new Integer[1]; // stream has no state, so we need a final field to store it
        List<Integer> resultList = sourceList.stream()
                .peek(integer -> {
                    if (integer != 0) {
                        lastNonZero[0] = integer;
                    }
                })
                .map(integer -> lastNonZero[0])
                .collect(Collectors.toList());

        System.out.println(sourceList); // still the same
        System.out.println(resultList);
    }
}
