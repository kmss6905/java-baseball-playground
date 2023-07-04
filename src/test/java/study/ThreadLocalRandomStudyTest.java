package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.assertThat;

public class ThreadLocalRandomStudyTest {

  @Test
  @DisplayName("생성되는 난수는 100이상 1000미만의 정수이어야 한다.")
  void tt() {
    ThreadLocalRandom current = ThreadLocalRandom.current();
    int randomNumber = current.nextInt(100, 1000);
    assertThat(randomNumber).isBetween(100, 999);
  }
}
