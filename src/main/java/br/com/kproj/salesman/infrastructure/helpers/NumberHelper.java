package br.com.kproj.salesman.infrastructure.helpers;


import java.math.BigDecimal;

public class NumberHelper {

    public static Boolean isNotNegativeNumber(BigDecimal base) {

        if (base == null) {
            return Boolean.FALSE;
        }

        return base.compareTo(BigDecimal.ZERO) == 0 || base.compareTo(BigDecimal.ZERO) > 0 ;
    }
}
