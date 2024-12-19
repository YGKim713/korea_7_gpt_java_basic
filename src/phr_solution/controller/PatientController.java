package phr_solution.controller;

import phr_solution.dto.request.PatientRequestDto;
import phr_solution.dto.response.PatientResponseDto;
import phr_solution.service.PatientService;

import java.util.List;

public class PatientController {
    private PatientService service;

    public PatientController() {
        service = new PatientService();
    }

    // 환자 등록
    public void registerPatient(PatientRequestDto requestDto) {
        service.registerPatient(requestDto);
    }

    // 환자 정보 조회 (전체)
    public List<PatientResponseDto> getAllPatients() {
        List<PatientResponseDto> patients = service.listAllPatients();
        return patients;
    }

    // 환자 정보 조회 (단건)
    public PatientResponseDto getPatientById(long id) {
        PatientResponseDto patient = service.getPatientById(id);   // 메서드 이름이 service 와 controller 가 동일한데 괜찮나요?
        return patient;                                            // 네! 보통 이렇게 합니다.
    }

    // 환자 정보 수정
    public void updatePatient(long id, PatientRequestDto requestDto) {
        service.updatePatient(id, requestDto);
    }

    // 환자 정보 삭제
    public void deletePatient(long id) {
        service.deletePatient(id);
    }
}
