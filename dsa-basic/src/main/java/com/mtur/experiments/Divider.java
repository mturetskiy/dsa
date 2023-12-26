package com.mtur.experiments;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Divider {
    public int divide(int a, int b) {
        log.info("Dividing {} / {}", a, b);
        int res = 0;
        int tmp = a;
        while (tmp >= b) {
            tmp -= b;
            res++;
        }

        return res;
    }

    public int divideFast(int a, int b) {
        log.info("Fast dividing {} / {}", a, b);

        int res = divide(Math.abs(a), Math.abs(b), 1, Math.abs(b));
        if ((a < 0 && b > 0) || (b < 0 && a > 0)) {
            return - res;
        }

        return res;
    }

    private int divide(int a, int b, int cnt, int origB) {
        log.info("{}/{}, cnt={}", a, b, cnt);

        if (a >= b + b) {
            return divide(a, b + b, cnt + cnt, origB);
        } if (a >= b) { // start again from original B but now for the rest of A
            return cnt + divide(a - b, origB, 1, origB);
        }

        return 0; // cannot divide anymore
    }

}
