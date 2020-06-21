public class MMC {
    //Algoritmo de Euclides iterativo
    private static int mdc(int a, int b){
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    //Algoritmo do MMC
    private static int mmc(int a, int b){
        return a * (b / mdc(a, b));
    }
    //Testes
    public static void main(String[] args) {
        System.out.println("MMC");
        System.out.printf("mmc(30, 60) = %d\n", mmc(30, 60));
        System.out.printf("mmc(60, 100) = %d\n", mmc(60, 100));
        System.out.printf("mmc(36, 14) = %d\n", mmc(36, 14));
        System.out.printf("mmc(2, 3) = %d\n", mmc(2, 3));
    }
}