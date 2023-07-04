package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("난수 생성기 테스트")
class RandomNumberGeneratorTest {

  @Test
  @DisplayName("기능 1 - 111이상 1000미만의 난수를 형성한다.")
  void generateRandomNumber() {
    int randomNumber = RandomNumberGenerator.generateRandomNumber();
    assertThat(randomNumber).isBetween(111, 999);
  }
}