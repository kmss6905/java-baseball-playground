package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace('b', 'd');
        assertThat(actual).isEqualTo("adc");
    }
    @Test
    void splitTest() {
        String value1 = "1,2";
        String value2 = "1";
        String[] result1 = value1.split(",");
        String[] result2 = value2.split(",");
        assertThat(result1).contains("1", "2");
        assertThat(result2).containsExactly("1");
    }
}
