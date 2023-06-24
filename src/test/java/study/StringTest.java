package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace('b', 'd');
        assertThat(actual).isEqualTo("adc");
    }
    @Test
    @DisplayName("문자열이 주어지면, 쉼표(,)를 기준으로 배열을 만든다.")
    void splitTest() {
        String value1 = "1,2";
        String value2 = "1";
        String[] result1 = value1.split(",");
        String[] result2 = value2.split(",");
        assertThat(result1).contains("1", "2");
        assertThat(result2).containsExactly("1");
    }

    @Test
    @DisplayName("문자열이 주어지면, 양쪽 소괄호를 제거한다.")
    void removeBracket() {
        String value = "(1,2)";
        String result = value.substring(1, value.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    // 위치 값을 벗어난 다 => 현재 주어진 문자 인덱스 경계값을 넣어 확인한다.
    @Test
    @DisplayName("특정 위치의 문자를 가져올 때, 위칙 값을 벗어나면 StringIndexOutOfBoundsException 반환")
    void test() {
        String value = "abc";
        assertThatThrownBy(() -> value.charAt(value.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: ");
    }
}
