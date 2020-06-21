public class MDC {
    //Algoritmo de Euclides iterativo para calcular MDC
    public static int mdc(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    //Calcula o MDC de uma lista de números
    public static int mdc(int[] numberList) {
        if (numberList.length < 2) {
            throw new IllegalArgumentException("A lista deve conter pelo menos dois números");
        }
        int mdcResultado = numberList[0];
        for (int i = 1; i < numberList.length; i++) {
            mdcResultado = mdc(mdcResultado, numberList[i]);
        }
        return mdcResultado;
    }

    //código de testes
    public static void main(String[] args) {
        System.out.println("MDC(2,3,4,5) = " + mdc(new int[]{2, 3, 4, 5}));
        System.out.println("MDC(1024, 4, 24, 12) = " + mdc(new int[]{1024, 4, 24, 12}));
        System.out.println("MDC(49, 14, 77, 63) = " + mdc(new int[]{49, 14, 77, 63}));
    }
}