package chapter17.service;

import chapter17.entity.Reservation;
import chapter17.repository.ReservationRepository;

import java.util.Date;
import java.util.List;

public class ReservationServiceImpl implements ReservationService {
//  private final ReservationRepository reservationRepository = new ReservationRepository();
    // 아래처럼 하는 것과 동일하나, 필드 의존성보다 생성자 의존성 주입을 권장(단계별로 메모리에 차근차근 담기기 위해)

    private final ReservationRepository reservationRepository;
    private final UserServiceImpl userServiceImpl;

    public ReservationServiceImpl(UserServiceImpl userServiceImpl) {
        this.reservationRepository = new ReservationRepository();
        this.userServiceImpl = userServiceImpl;
    }

    @Override
    public void createReservation(String reservationId, String userId) {
        if (userServiceImpl.isLoggedIn()) {
            Date reservationTime = new Date();
            Reservation newReservation = new Reservation(reservationId, userId, reservationTime);
            reservationRepository.save(newReservation);
            System.out.println("예약 완료: " + reservationTime);
        } else {
            System.out.println("로그인이 필요한 기능입니다.");
        }

    }

    @Override
    public List<Reservation> getReservationsByUserId(String userId) {
        List<Reservation> reservations = reservationRepository.findByUserId(userId);
        if (reservations.isEmpty()) {
            System.out.println(userId + " 님의 예약 내역이 없습니다.");
        }

        return reservations;
    }

    @Override
    public void cancelReservation(String reservationId) {
        reservationRepository.findById(reservationId).ifPresentOrElse(
                // reservationId 에 일치하는 예약이 존재 -> 삭제!
//              reservation -> reservation.cancel()
                Reservation::cancel
                , () -> System.out.println("해당 예약 ID를 찾을 수 없습니다."));
    }
}
