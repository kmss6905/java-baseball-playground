import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import 문자열계산기.StringCalculator;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    @DisplayName("문자열 수식이 들어오면 공백을 기준으로 문자를 파싱합니다.")
    void parse() {
        String value = "1 * 1 * 2";
        String[] result = stringCalculator.parse(value);
        assertThat(result).containsExactly("1", "*", "1", "*", "2");
    }


    @ParameterizedTest
    @CsvSource({
        "1 * 1 * 2,2",
        "1 * 1 / 1 * 4,4",
        "5 * 5 / 5,5"
    })
    @DisplayName("종합 테스트")
    void calculateTest(String value, int result) {
        assertThat(stringCalculator.calculate(value)).isEqualTo(result);
    }
}