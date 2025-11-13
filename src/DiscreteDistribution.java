public class DiscreteDistribution {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java DiscreteDistribution m a1 a2 ... an");
            return;
        }
        int m = Integer.parseInt(args[0]);
        int n = args.length - 1;
        int[] a = new int[n + 1];
        int[] s = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(args[i]);
            if (a[i] < 0) {
                throw new IllegalArgumentException("weights must be nonnegative");
            }
            long tmp = (long) s[i - 1] + (long) a[i];
            if (tmp > Integer.MAX_VALUE) {
                throw new IllegalArgumentException("sum too large");
            }
            s[i] = s[i - 1] + a[i];
        }
        if (s[n] == 0) {
            return;
        }

        for (int t = 0; t < m; t++) {
            int r = (int) (Math.random() * s[n]);
            int lo = 1;
            int hi = n;
            int ans = n;
            while (lo <= hi) {
                int mid = (lo + hi) >>> 1;
                if (s[mid] > r) {
                    ans = mid;
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            System.out.print(ans);
            if (t < m - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
