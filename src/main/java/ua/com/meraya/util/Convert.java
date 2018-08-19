package ua.com.meraya.util;

import java.math.BigDecimal;

public final class Convert {
    private Convert() {
    }

    public static BigDecimal fromWei(BigDecimal number, int factor) {
        BigDecimal weiFactor = BigDecimal.TEN.pow(factor);
        return number.divide(weiFactor);
    }
}
