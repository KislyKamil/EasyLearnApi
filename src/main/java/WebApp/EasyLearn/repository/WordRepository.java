package WebApp.EasyLearn.repository;

import WebApp.EasyLearn.model.WordModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface WordRepository extends JpaRepository<WordModel, Integer>, JpaSpecificationExecutor<WordModel> {

    List<WordModel> findAllByIdIn(List<Integer> ids);

}
