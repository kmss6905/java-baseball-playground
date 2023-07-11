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
    // 스캐너 초기화
    Scanner scanner = new Scanner(System.in);

    // 게임의 결과를 전역변수 ?!?
    int strikeCnt = 0;
    int ballCnt = 0;

    // 컴퓨터 난수 생성
    int number = RandomNumberGenerator.generateRandomNumber();

    // 게임을 계속해서 반복한다.
    while (true) {

      // 입력 받기 전 설명 글 출력
      InputView inputView = new InputView();
      inputView.printNumberPrompt();

      // 사용자로부터 입력 받기
      String userInput = scanner.next();
      int[] arrNum = new int[3];
      for (int i = 0; i < 3; i++) {
        arrNum[i] = userInput.charAt(i) - '0';
      }

      // 컴퓨터 난수 생성
      String stringComputerRandomNumber = String.valueOf(number);
      int[] answerNumbers = new int[3];
      for (int i = 0; i < 3; i++) {
        answerNumbers[i] = stringComputerRandomNumber.charAt(i) - '0';
      }

      // 1. 사용자로부터 받은 번호와 컴퓨터 난수를 비교하여
      // 2. 스트라이크, 볼 카운트 저장
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

      // 게임 종료와 동시에 게임 결과를 출력함.
      // 1. 게임의 종료 조건, 게임의 종료 판단
      // 2. 게임의 결과 출력
      // 3. 게임 종료
      if (strikeCnt == 3) {
        System.out.println(strikeCnt+"스트라이크");
        break;
      }

      // 게임 결과 출력
      if (ballCnt != 0 || strikeCnt != 0) {
        if (ballCnt == 0) {
          System.out.println(strikeCnt+"스트라이크");
        }else if(strikeCnt == 0){
          System.out.println(ballCnt+"볼");
        }else{
          System.out.println(ballCnt+"볼"+strikeCnt+"스트라이크");
        }
      }else{
        System.out.println("3볼");
      }
      ballCnt = 0;
      strikeCnt = 0;
    }
  }
}
