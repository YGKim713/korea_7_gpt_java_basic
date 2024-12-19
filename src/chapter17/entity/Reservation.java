package chapter17.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
@Getter
public class Reservation {
    // 각 예약이 가지는 고유한 id값
    private final String reservationId;
    // 예약자 정보 >> 예약을 위해서는 사용자의 정보가 필요(로그인 필수)
    private final String userId;
    private final Date reservationTime; // 사용자에게 직접 예약 당시 시간을 받지않고, Date 로 생성

    // 초기값 설정
    // : 해당 예약의 활성화 상태를 저장
    // - true: 예약 완료
    // - false: 예약 취소
    private boolean isActive = true;

    public void cancel() {
        this.isActive = false;
    }

    @Override
    public String toString() {
        String isActiveMessage = isActive ? "예약 중" : "예약 취소";

        return "[예약 ID: " + reservationId + ", 사용자 ID: " + userId
                + ", 예약 일자: " + reservationTime + ", 예약 상태: " + isActive + "]";
    }
}
