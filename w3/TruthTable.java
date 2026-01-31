public class TruthTable {
    public static void main(String[] args) {
        for (int i = 1; i >= 0; i--) {
            for (int j = 1; j >= 0; j--) {
                System.out.println("A: " + toBoolean(i) + "; B: " + toBoolean(j) + "; A AND B: " + (toBoolean(i) && toBoolean(j)));
            }
        }
    }

    static boolean toBoolean(int nB) {
        return nB == 1;
    }
}