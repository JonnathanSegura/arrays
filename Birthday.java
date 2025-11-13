public class Birthday {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Birthday n trials");
            return;
        }
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int maxPeople = n + 1;
        int[] count = new int[maxPeople + 1];

        for (int t = 0; t < trials; t++) {
            boolean[] seen = new boolean[n];
            int people = 0;
            while (true) {
                int day = (int) (Math.random() * n);
                people++;
                if (seen[day]) {
                    count[people]++;
                    break;
                }
                seen[day] = true;
            }
        }

        int cum = 0;
        for (int i = 1; i <= maxPeople; i++) {
            cum += count[i];
            double frac = cum / (double) trials;
            System.out.printf("%d %d %.6f%n", i, count[i], frac);
            if (frac >= 0.5) {
                break;
            }
        }
    }
}