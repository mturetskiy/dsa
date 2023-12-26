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
        return divide(a, b, 1, b);
    }

    private int divide(int a, int b, int cnt, int origB) {
        log.info("{}/{}, cnt={}", a, b, cnt);

        if (a > b + b) {
            return divide(a, b + b, cnt + cnt, origB);
        } if (a >= b) { // start again from original B but now for the rest of A
            return cnt + divide(a - b, origB, 1, origB);
        }

        return 0; // cannot divide anymore
    }

}
