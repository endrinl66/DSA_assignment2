import java.util.*;

public class Assignment2 {

    // isSorted(a, l, r): returns true iff a[l..r] is non-decreasing
    static boolean isSorted(int[] a, int l, int r) {
        if (l >= r) return true;                 // base case: 0 or 1 element
        if (a[l] > a[l + 1]) return false;       // out of order
        return isSorted(a, l + 1, r);            // recursive step
    }

    // hasSum(a, l, r, x): two-pointer recursion on sorted a[l..r]
    static boolean hasSum(int[] a, int l, int r, int x) {
        if (l >= r) return false;                // no pair possible
        int s = a[l] + a[r];
        if (s == x) return true;				// pair found
        if (s > x) return hasSum(a, l, r - 1, x); // sum greater than x move r to left
        return hasSum(a, l + 1, r, x);            // sum smaller than x move l to right
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Please Enter a Size or Zero to stop: ");
            int n = sc.nextInt();
            if (n == 0) { System.out.println("Good bye");
            
            break; }

            int[] a = new int[n];
            System.out.print("Please Enter an array of " + n + " elements: ");
            for (int i = 0; i < n; i++) a[i] = sc.nextInt(); // read array

            if (!isSorted(a, 0, n - 1)) {
                System.out.println("***** Error: the array must be sorted (non-decreasing).");
                continue;  // restart loop and ask again
            }

            System.out.print("Please Enter a single Integer: ");
            int x = sc.nextInt();

            System.out.println(
                hasSum(a, 0, n - 1, x)
                ? "Answer: Yes the array contains two numbers that add up to " + x + "."
                : "Answer: No the array does not contain two numbers that add up to " + x + "."
            );
        }
        sc.close();
    }
}
