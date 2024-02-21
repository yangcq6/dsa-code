package com.yangcq.lovedsa.class01_intro;

// 斐波那契数列
// 0 1 2 3 4 5 6 7
// 0 1 1 2 3 5 8 13
public class TestFib {

    // O(2^n)
    public static int f1(int n) {
        if (n <= 1) return n;
        // 独立的方法调用，调用了2^n次,每次方法调用是O(1)
        return f1(n - 1) + f1(n - 2);
    }

    // O(n)
    public static int f2(int n) {
        if (n <= 1) return n;

        int a = 0, b = 1;
        // n-1次加法
        for (int i = 0; i < n - 1; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static int f3(int n) {
        if (n <= 1) return n;

        int a = 0, b = 1;
        // n-1次加法
        while (n-- > 1) {
            b = a + b;
            a = b - a;
        }
        return b;
    }

    public static void main(String[] args) {
        int n = 48;

        t4(16);

        Times.test("f3", () -> {
            System.out.printf("f(%d) = %d\n ", n, f3(n));
        });

        Times.test("f2", new Times.Task() {
            @Override
            public void execute() {
                System.out.printf("f2(%d) = %d\n", n, f2(n));
            }
        });

        Times.test("f1", new Times.Task() {
            @Override
            public void execute() {
                System.out.printf("f1(%d) = %d\n", n, f1(n));
            }
        });

    }


    public static void t1(int n) {
        // 1
        if (n > 15) System.out.println("a");
        else if (n > 10) System.out.println("b");
        else System.out.println("c");

        // 1 + 5 + 4 + 4 = 14
        for (int i = 0; i < 4; i++) {
            System.out.println("d");
        }

        // O(1)
    }

    public static void t2(int n) {
        // 1 + (n+1) + n + n
        // 3n+2
        for (int i = 0; i < n; i++) {
            System.out.println("a");
        }

        // O(n)
    }

    public static void t3(int n) {
        // 1 + (n+1) + n + n*(1 + (n+1) + n + n)
        // 2n+2 + n(3n+2)
        // 3n^2 + 4n + 2
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("a");
            }
        }

        // O(n^2)
    }

    public static void t4(int n) {
        // 看n能除以多少次2仍然大于0
        // n=16, n=8(1), n=4(2), n=2(3), n=1(4)
        // 次数=log2(n)
        while ((n = n / 2) > 0) {
            System.out.println("n = " + n);
        }

        // O(logn)
        // log2(n) = log2(9) * log9(n)
        // log5(n) = log5(9) * log9(n)
    }
}
