import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class StringCalculatorTest {

    @DisplayName("잘못된 산수식이 들어오면 예외를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "1 2 /",
            "* 10",
            "1 * 1 * 2 *"})
    void checkFormula(String values) {
        String[] elements = values.split("");
        StringCalculator stringCalculator = new StringCalculator();
        Assertions.assertThatThrownBy(() -> stringCalculator.validateFormula(elements))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 수식입니다.");
    }
}