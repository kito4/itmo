import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TestClass {
    @Test
    void bigDecimalSetShouldContainElement() {
        Set<BigDecimal> bd = Arrays
                .stream(new String[]{"1", "1.5", "2", "2.5", "3"})
                .map(BigDecimal::new)
                .collect(Collectors.toSet());
        BigDecimal b = new BigDecimal("2");
        assert bd.contains(b);
    }
}
