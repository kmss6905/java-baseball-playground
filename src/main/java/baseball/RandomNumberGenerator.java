package baseball;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberGenerator {

  // 난수 번호를 생성
  static public int generateRandomNumber() {
    ThreadLocalRandom localRandom = ThreadLocalRandom.current();
    return localRandom.nextInt(111, 1000);
  }
}