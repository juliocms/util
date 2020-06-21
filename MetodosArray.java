import java.util.*;
import java.util.stream.Collectors;

public class MetodosArray {

    public static void main(String[] argv) {
        List<Integer> ls = Arrays.asList(1, 0, 0, 1, 1, 0, 0, 5, 7, 7, 7, 2);
        List<String> ls2 = Arrays.asList("Milan", "london", "San Francisco", "Tokyo", "New Delhi");
        List<Integer> ls3 = Arrays.asList(10, 1, 0, 0, 1, 1, 0, 0, 5, 7, 7, 7, 2, 99, 88, 63, 34);
        List<String> ls4 = Arrays.asList("átila", "Milan", "london", "albÂnia", "bora-BORA", "San Francisco", "Tokyo", "New Delhi", "Zambia", "Ucrânia");
        List<Integer> ls5 = Arrays.asList(10, 1, 0, 0, 1, 1, 0, 7);

        MetodosArray ma = new MetodosArray();

        System.out.println("Inteiros Ordenados: " + ma.ordenaListaInteiros(ls));
        System.out.println("=========================================\n");
        System.out.println("String Ordenados: " + ma.ordeListaString(ls2));
        System.out.println("=========================================\n");
        System.out.println("Inteiros Ordenados Reversamente: " + ma.ordenaListaInteirosRerversa(ls3));
        System.out.println("=========================================\n");
        System.out.println("String Ordenados Reversamente Com Ignore Case: " + ma.ordenaListaStringRerversaComIgnoreCase(ls4));
        System.out.println("=========================================\n");
        System.out.println("String Ordenados Reversamente Sem Ignore Case: " + ma.ordenaListaStringRerversaSemIgnoreCase(ls4));
        System.out.println("=========================================\n");
        System.out.println("Valor Minimo da Lista " + ma.valorMinimoLista(ls5));
        System.out.println("=========================================\n");
        System.out.println("Valor Maximo da Lista " + ma.valorMaximoLista(ls5));
        System.out.println("=========================================\n");
        System.out.println("Soma Total dos valores da Lista " + ma.somaValoresLista(ls5));
        System.out.println("=========================================\n");
        System.out.println("Convesao de List para Array de Inteiros: ");
        Arrays.stream(ma.converteListToArrayInteger(ls5)).forEach(System.out::println);
        System.out.println("=========================================\n");
        System.out.println("Convesao de List para Array de String: ");
        Arrays.stream(ma.converteListToArrayString(ls4)).forEach(System.out::println);
        System.out.println("=========================================\n");
        ma.proximoAnteriorValorArray(ls5);
        System.out.println("=========================================\n");
        ma.inverteOrdemArray(ls5).forEach(System.out::println);
    }

    public List<Integer> ordenaListaInteiros(List<Integer> ls) {
        List<Integer> result = ls.stream().distinct().collect(Collectors.toList());
        result.sort(Integer::compareTo); // alternativamente pode utilizar  .sort(Comparator.naturalOrder());
         return result;
    }

    public List<String> ordeListaString(List<String> ls) {
        List<String> result = ls.stream().distinct().collect(Collectors.toList());
        ls.sort(String.CASE_INSENSITIVE_ORDER);
        return result;
    }

    public List<Integer> ordenaListaInteirosRerversa(List<Integer> ls) {
        List result = ls.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        return result;
    }

    public List<String> ordenaListaStringRerversaComIgnoreCase(List<String> ls) {
        Collections.sort(ls, Collections.reverseOrder(String::compareToIgnoreCase));
        return ls; //checar
    }

    public List<String> ordenaListaStringRerversaSemIgnoreCase(List<String> ls) {
        List result = ls.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList()); //SEM IGNORE CASE
        return result;
    }

    public Integer valorMinimoLista(List<Integer> ls) {
        return Collections.min(ls);
    }

    public Integer valorMaximoLista(List<Integer> ls) {
        return Collections.max(ls);
    }

    public Integer somaValoresLista(List<Integer> ls) {
        Integer[] array = converteListToArrayInteger(ls);
        return Arrays.stream(array)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public Integer[] converteListToArrayInteger(List<Integer> ls) {
        Integer[] array = ls.toArray(new Integer[0]);
        return array;
    }

    public String[] converteListToArrayString(List<String> ls) {
        String[] array = ls.toArray(new String[0]);
        return array;
    }

    public List<Integer> filtraArray(List<Integer> ls) {
        MetodosArray ma = new MetodosArray();
        int[] array = ls.stream().mapToInt(i->i).toArray();
        int[] evenArray = Arrays.stream(array)
                .filter(value -> value % 2 == 0)
                .toArray();
        return Arrays.stream(evenArray).boxed().collect(Collectors.toList());
    }

    public void proximoAnteriorValorArray(List<Integer> ls) {
        for(int i = 0; i < ls.size(); i++) {
            if(i < ls.size() - 1 && i > 0) {
                System.out.println("Corrente: " + ls.get(i));
                System.out.println("Anterior: " + ls.get(i - 1));
                System.out.println("Proximo: " + ls.get(i + 1));
            } else if (i == 0) {
                System.out.println("Corrente: " + ls.get(i));
                System.out.println("Proximo: " + ls.get(i + 1));
            } else if (i == ls.size() - 1) {
                System.out.println("Corrente: " + ls.get(i));
                System.out.println("Anterior: " + ls.get(i - 1));
            }
        }
    }

    public List<Integer> inverteOrdemArray(List<Integer> ls) {
        List<Integer> newArray = new ArrayList<Integer>();
        for(int i = ls.size() - 1; i >= 0; i--) {
            newArray.add(ls.get(i));
        }
        return newArray;
    }

}
