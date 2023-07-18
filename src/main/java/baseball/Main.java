package baseball;

import baseball.view.InputView;

import java.util.Scanner;

/**
 * Input -> Logic -> Output
 * 입력 -> 입력 검증 -> Logic으로 위임 -> 결과를 Output 에 전달
 * Logic : 받은 입력 값을 컴퓨터가 생성한 난수 값과 비교 -> 계산 -> Output에 결과 전달
 * 결과를 받은 Output 은 결과 출력
 * (Model) -> Output
 */
public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int number = RandomNumberGenerator.generateRandomNumber();
    while (true) {
      InputView inputView = new InputView();
      inputView.printNumberPrompt();
      int[] userNumbers = getUserPromptNumber(scanner);
      int[] answerNumbers = createRandomNumber(number);


      // Result 에서는 결과(볼,스트라이크 갯수)가 담겨 있고
      // 이는 출력을 담당하는 메서드인 printGameResult 의 인자로 넘겨준다.
      Result result = getResult(userNumbers, answerNumbers);
      if (isAllStrike(result)) break;
      printGameResult(result);
    }
  }

  // 게임 결과를 출력한다
  private static void printGameResult(Result result) {
    if (result.ballCnt != 0 || result.strikeCnt != 0) {
      if (result.ballCnt == 0) {
        System.out.println(result.strikeCnt + "스트라이크");
      } else if (result.strikeCnt == 0) {
        System.out.println(result.ballCnt + "볼");
      } else {
        System.out.println(result.ballCnt + "볼" + result.strikeCnt + "스트라이크");
      }
    } else {
      System.out.println("3볼");
    }
  }

  // 문제점
  // 해당 함수는 하나의 역할만 하는 것이 아니라. 게임 종료 조건인 스크라이크 횟수 체크 뿐만 아니라, 관련된 프롬프트 문자열까지 출력하고 있다.
  private static boolean isAllStrike(Result result) {
    if (result.strikeCnt == 3) {
      System.out.println(result.strikeCnt + "스트라이크");
      return true;
    }
    return false;
  }

  private static Result getResult(int[] arrNum, int[] answerNumbers) {
    int strikeCnt = 0;
    int ballCnt = 0;
    for (int i = 0; i < arrNum.length; i++) {
      for (int j = 0; j < answerNumbers.length; j++) {
        if ((i == j) && arrNum[i] == answerNumbers[j]) {
          strikeCnt += 1;
        }
        if ((i != j) && answerNumbers[j] == arrNum[i]) {
          ballCnt += 1;
        }
      }
    }
    return new Result(strikeCnt, ballCnt);
  }

  private static class Result {
    public final int strikeCnt;
    public final int ballCnt;

    public Result(int strikeCnt, int ballCnt) {
      this.strikeCnt = strikeCnt;
      this.ballCnt = ballCnt;
    }
  }

  private static int[] createRandomNumber(int number) {
    String stringComputerRandomNumber = String.valueOf(number);
    int[] answerNumbers = new int[3];
    for (int i = 0; i < 3; i++) {
      answerNumbers[i] = stringComputerRandomNumber.charAt(i) - '0';
    }
    return answerNumbers;
  }

  private static int[] getUserPromptNumber(Scanner scanner) {
    int[] arrNum = new int[3];
    String userInput = scanner.next();
    for (int i = 0; i < 3; i++) {
      arrNum[i] = userInput.charAt(i) - '0';
    }
    return arrNum;
  }
}
