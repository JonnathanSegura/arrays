public class ThueMorse {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java ThueMorse n");
            return;
        }
        int n = Integer.parseInt(args[0]);

        boolean[] t = new boolean[n];
        for (int i = 0; i < n; i++) {
            int x = i;
            int ones = 0;
            while (x != 0) {
                x &= x - 1;
                ones++;
            }
            t[i] = (ones & 1) == 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (t[i] == t[j]) {
                    System.out.print("+");
                } else {
                    System.out.print("-");
                }
                if (j < n - 1) {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}