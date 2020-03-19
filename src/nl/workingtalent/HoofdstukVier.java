package nl.workingtalent;

class HoofdstukVier {
    public static void main(String[] args) {
        System.out.println("1. compareTo");
        String a = "boot";
        String b = "banaan";
        int outputCompareTo = a.compareTo(b);
        if (outputCompareTo > 0) {
            System.out.println(a + " komt inhet alfabet NA " + b);
        }
        else if (outputCompareTo < 0) {
            System.out.println(a + " komt inhet alfabet VOOR " + b);
        } else {
            System.out.println("Beide worden koemn op zelfde plek");
        }
        System.out.println("----------------------");
        System.out.println("2. split methode");

        String c = "test-string-voor-split";
        String[] output = c.split("-", 0);

        for (String word : output) {
            System.out.println(word);
        }

    }
}