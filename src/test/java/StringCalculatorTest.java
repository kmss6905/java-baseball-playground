import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class StringCalculatorTest {
    StringCalculator stringCalculator;

    @BeforeEach
    void each() {
        stringCalculator = new StringCalculator();
    }

    @DisplayName("잘못된 산수식이 들어오면 예외를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "1 2 /",
            "* 10",
            "1 * 1 * 2 *",
            "5 & 2",
            "6 * 2 # 1"
    })
    void checkFormula(String values) {
        String[] elements = values.split("");
        assertThatThrownBy(() -> stringCalculator.validateFormula(elements))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 수식입니다.");
    }
}