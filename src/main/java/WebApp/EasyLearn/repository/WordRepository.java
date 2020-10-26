package WebApp.EasyLearn.repository;

import WebApp.EasyLearn.model.WordModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface WordRepository extends JpaRepository<WordModel, Integer>, JpaSpecificationExecutor<WordModel> {




}
