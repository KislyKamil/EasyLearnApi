package WebApp.EasyLearn.repository;

import WebApp.EasyLearn.model.ExamStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ExamStatsRepository extends JpaRepository<ExamStats, Integer>, JpaSpecificationExecutor<ExamStats> {

    boolean existsByUserid(int userID);

    ExamStats findByUserid(int userID);
}
