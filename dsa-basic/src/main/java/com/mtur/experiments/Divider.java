package com.mtur.experiments;

import lombok.extern.slf4j.Slf4j;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static java.lang.Math.abs;

@Slf4j
public class Divider {
    public int divide(int a, int b) {
        int res = 0;
        int tmp = a;
        while (tmp >= b) {
            tmp -= b;
            res++;
        }

        return res;
    }

    public int divideFast(int a, int b) {
        long res = divide(abs((long)a), abs((long)b), 1, abs((long)b));
        if ((a < 0 && b > 0) || (b < 0 && a > 0)) {
            res = - res;
        }

        if (res < MIN_VALUE) {
            return MIN_VALUE;
        } else if (res > MAX_VALUE) {
            return MAX_VALUE;
        }

        return (int)res;
    }

    private long divide(long a, long b, long cnt, long origB) {
        if (a >= b + b) {
            return divide(a, b + b, cnt + cnt, origB);
        } if (a >= b) { // start again from original B but now for the rest of A
            return cnt + divide(a - b, origB, 1, origB);
        }

        return 0; // cannot divide anymore
    }

}