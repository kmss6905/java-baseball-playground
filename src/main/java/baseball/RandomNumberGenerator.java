package baseball;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberGenerator {
  static public int generateRandomNumber() {
    ThreadLocalRandom localRandom = ThreadLocalRandom.current();
    return localRandom.nextInt(111, 1000);
  }
}
