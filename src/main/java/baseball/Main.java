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
    int strikeCnt = 0;
    int ballCnt = 0;
    int number = RandomNumberGenerator.generateRandomNumber();
    System.out.println(number);
    while (true) {
      InputView inputView = new InputView();
      inputView.printNumberPrompt();
      String userInput = scanner.next();
      int[] arrNum = new int[3];
      for (int i = 0; i < 3; i++) {
        arrNum[i] = userInput.charAt(i) - '0';
      }

      String stringComputerRandomNumber = String.valueOf(number);
      int[] answerNumbers = new int[3];
      for (int i = 0; i < 3; i++) {
        answerNumbers[i] = stringComputerRandomNumber.charAt(i) - '0';
      }

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
      if (strikeCnt == 3) {
        System.out.println(strikeCnt+"스트라이크");
        break;
      }


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
