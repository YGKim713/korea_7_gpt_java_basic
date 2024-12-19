package phr_solution.repository;

import phr_solution.entity.HealthRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RecordRepository {
    private List<HealthRecord> records = new ArrayList<>();
    private static final RecordRepository instance = new RecordRepository();

    private RecordRepository() {} // 생성자를 통해서는 인스턴스화 되지 않고,
                                  // getInstance 로만 인스턴스화 되게끔 하기 위한 문장

    public static RecordRepository getInstance() {
        return instance;
    }

    public void save(HealthRecord record) {
        records.add(record);
    }

    public List<HealthRecord> findAll() {
        return new ArrayList<>(records);
    }

    public Optional<HealthRecord> findById(Long id) {
        return records.stream()
                .filter(record -> record.getId().equals(id))
                .findFirst();
    }

    public void delete(HealthRecord healthRecord) {
        records.remove(healthRecord);
    }
}
