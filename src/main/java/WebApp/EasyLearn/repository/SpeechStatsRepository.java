package WebApp.EasyLearn.repository;

import WebApp.EasyLearn.model.SpeechStatsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SpeechStatsRepository extends JpaRepository<SpeechStatsModel, Integer>, JpaSpecificationExecutor<SpeechStatsModel> {

    SpeechStatsModel findByUserid(int id);

    boolean existsByUserid(int userID);
}
