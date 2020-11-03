package WebApp.EasyLearn.repository;

import WebApp.EasyLearn.model.ExamStats;
import WebApp.EasyLearn.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserDetailRepository extends JpaRepository<UserDetail, Integer>, JpaSpecificationExecutor<UserDetail> {

    boolean existsByUserid(int userID);

    UserDetail findByUserid(int userID);
}
