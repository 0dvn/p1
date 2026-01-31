class PriceCalculator {
    public static void main(String[] args) {
        int AGE = 19;
        double BASE_PRICE = 20;
        boolean IS_STUDENT = true;

        System.out.println("AGE: " + AGE);

        if (AGE < 6) { // special case for newborns (0-5)
            System.out.println("PRICE: 0");
        } else if (AGE < 15) { // (6-14)
            System.out.println("PRICE: " + ninetyNinenify(BASE_PRICE / 2));
        } else if (
            IS_STUDENT && AGE < 30 ||
            AGE < 22 ||
            AGE > 54
        ) { // students and young people
            System.out.println("PRICE: " + ninetyNinenify(BASE_PRICE * 3 / 4));
        } else {
            System.out.println("PRICE: " + ninetyNinenify(BASE_PRICE));
        }
    }

    static double ninetyNinenify(double price) {
        return Math.round(price) - 0.01;
    }
}