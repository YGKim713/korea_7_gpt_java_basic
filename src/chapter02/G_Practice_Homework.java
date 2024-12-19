package chapter02;
/*
- 삼각형 모양의 별(*) 출력 (중첩 for 사용)
        --- (1) ---
        *****
        ****
        ***
        **
        *
        --- (2) ---
        *****
         ****
          ***
           **
            *
 */
public class G_Practice_Homework {
    public static void main(String[] args) {
        System.out.println("문제 풀이 도전~!");
        System.out.println("--- (1) ---");
        for(int i=0; i<5; i++){

            for(int j=0; j<5-i; j++){

                System.out.print("*");

            }
            System.out.println();
        }

        System.out.println("--- (2) ---");
        for(int i=0; i<5; i++) {

            for(int j=0; j<i; j++){
                System.out.print(" ");
            }
            for(int k=0; k<5-i; k++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("야호~ 정답! 참 잘했어요~");

        System.out.println();
        System.out.println("=== 강사님 풀이 ===");
        // --- (1) ---
        System.out.println("--- (1) ---");

        // 줄의 순서: 1, 2, 3, 4, 5
        // 별의 개수: 5, 4, 3, 2, 1

        int height = 5; // 별의 높이를 고정값 5로 설정

        // 첫 번째 for문: 줄(row)을 제어 (5줄 출력)
        for (int i = height; i >= 1; i--){

            // 두 번째 for문: 각 줄에 별을 출력
            for(int j = 1; j <= i; j++) {
                System.out.print("*"); // 별 출력
            }
            System.out.println(); // 줄 바꿈
        }
        System.out.println();
        // --- (2) ---
        System.out.println("--- (2) ---");
        // int height = 5; // 별의 높이를 고정값 5로 설정

        // 첫 번째 for문: 줄(row)을 제어 - 5줄 출력
        for (int i = height; i >= 1; i--) {
            // i는 5, 4, 3, 2, 1 -> height - i = 0, 1, 2, 3, 4

            // 두 번째 for문: 줄의 시작 부분에 공백을 추가 (오른쪽 정렬)
            // - 0, 1, 2, 3, 4
            for (int j = 1; j <= height - i; j++) {
                System.out.print(" "); // 공백 출력
            }

            // 세 번째 for문: 별을 추가
            // - 5, 4, 3, 2, 1
            for (int k = 1; k <= i; k++) {
                System.out.print("*"); // 별 출력
            }

            System.out.println(); // 줄 바꿈
        }
    }
}
