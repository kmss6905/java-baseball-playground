import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.assertj.core.api.Assertions.*;

public class ObjectUtilStudyTest {

    @Test
    void isNullTest() {
        String[] values = new String[4];
        assertThat(Objects.isNull(values)).isFalse();
    }

    @Test
    void lengthTest() {
        String[] values = new String[4];
        assertThat(values[0]).isEqualTo(null);
        assertThat(values).isNotNull();
    }

    @Test
    void isDigit() {
        String value = "3";
        int parseInt = Integer.parseInt(value);
        assertThat(parseInt).isEqualTo(3);
    }

    @Test
    void shouldNotFormattingToInteger() {
        String value = "*";
        assertThatThrownBy(() -> Integer.parseInt(value))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("For input string: ");
    }
}
