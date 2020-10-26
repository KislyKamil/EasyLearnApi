package WebApp.EasyLearn.service;

import WebApp.EasyLearn.model.WordModel;
import WebApp.EasyLearn.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordService {

    @Autowired
    private static WordRepository wordRepository;

    public static List<WordModel> getWordsForExam(List<Integer> ids) {

        List<WordModel> wordList = wordRepository.findAllById(ids);


        return wordList;

    }
}
