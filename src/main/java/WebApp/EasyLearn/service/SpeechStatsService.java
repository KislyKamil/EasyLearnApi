package WebApp.EasyLearn.service;


import WebApp.EasyLearn.model.SpeechStatsModel;
import WebApp.EasyLearn.repository.SpeechStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SpeechStatsService {

    @Autowired
    private SpeechStatsRepository speechStatsRepository;


    public void addStats(SpeechStatsModel model) {

        speechStatsRepository.save(model);
    }

    public SpeechStatsModel findById(int id) {
        return speechStatsRepository.findByUserid(id);
    }

    public boolean ifUserExists(int id) {
        return speechStatsRepository.existsByUserid(id);
    }


}
