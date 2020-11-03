package WebApp.EasyLearn.service;

import WebApp.EasyLearn.model.ExamStats;
import WebApp.EasyLearn.model.UserDetail;
import WebApp.EasyLearn.repository.ExamStatsRepository;
import WebApp.EasyLearn.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamStatsService {

    @Autowired
    private ExamStatsRepository examStatsRepository;

    public void addStats(ExamStats stats) {

        examStatsRepository.save(stats);
    }


    public boolean isStatsExists(int userID) {

        return examStatsRepository.existsByUserid(userID);
    }

    public ExamStats getStats(int userID) {

        return examStatsRepository.findByUserid(userID);
    }

}
