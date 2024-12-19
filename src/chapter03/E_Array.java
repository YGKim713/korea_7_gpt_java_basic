package chapter03;

import java.util.ArrayList;

public class E_Array {
    public static void main(String[] args) {
        /*
            크기 10인 Arraylist를 생성, 1 ~ 10까지의 숫자를 추가한 뒤 출력
            : 반복문을 사용

            추가한 숫자 중 홀수만 제거하고 결과를 출력
            : 반복문과 조건문을 사용

            인덱스 3에 값 50을 삽입한 뒤 결과를 출력 arrayList
         */
        ArrayList<Integer> arrayList = new ArrayList<>(10);

        for (int i=0; i<10; i++){
            arrayList.add(i+1);
        }
        System.out.println("원본 리스트: "+ arrayList);
        // 원본 리스트: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

        // int length = arrayList.size(); // length = 10
        // for (int i=0; i<length; i++) >> 오류 발생!
        // > arrayList.size()를 따로 선언 후 for문에 넣으면 오류 발생!
        // >> 선언을 하게 되면 size값이 고정되는데, for문을 진행할 시 size값이 줄어들기 때문에(ArrayList의 동적 크기 특성) 충돌 발생
        for(int i=0; i<arrayList.size(); i++){
            // 리스트의 크기가 변동되기 때문에 크기값을 매번 동적으로 확인
            // : 인덱스 초과 오류 방지 (IndexOutOfBoundsException)

            // 홀수 조건
            if(arrayList.get(i)%2==1){
                arrayList.remove(i);

                // 요소를 삭제하고 난 후 인덱스 조정 (ArrayList의 경우 크기가 동적으로 변경)
                // cf) 인덱스 조정을 하지 않을 경우 정상 동작이 되지 않는 경우가 발생할 수 있음
                // : 연속된 요소를 제거할 때 (홀수가 연속될 경우)
                // arrayList = [1, 3, 5, 7, 9];
                // i = 0 일 때 arrayList.remove(0)
                // >> arrayList = [3, 5, 7, 9] 이고 i = 1 (for문의 증가연산)
                // >> 다음 회차에서는 (3을 건너뛰고) 5가 삭제
                // 따라서 요소를 삭제한 경우(홀수 제거) 인덱스 번호를 조정
                i--;
            }
        }
        System.out.println(arrayList);
        // [2, 4, 6, 8, 10]

        arrayList.add(3, 50);
        System.out.println(arrayList);
        // [2, 4, 6, 50, 8, 10]

    }
}
