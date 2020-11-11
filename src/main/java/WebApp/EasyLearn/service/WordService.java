package WebApp.EasyLearn.service;

import WebApp.EasyLearn.model.WordModel;
import WebApp.EasyLearn.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WordService {

    @Autowired
    private WordRepository wordRepository;

    public List<WordModel> getWordsForExam(List<Integer> ids) {

        List<WordModel> wordList = wordRepository.findAllByIdIn(ids);

        return wordList;
    }

    public List<WordModel> getWordsByName(String word) {

        return wordRepository.findByengword(word);
    }
}
