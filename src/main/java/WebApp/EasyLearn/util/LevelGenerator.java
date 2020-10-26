package WebApp.EasyLearn.util;

import WebApp.EasyLearn.model.WordModel;
import WebApp.EasyLearn.model.examModel.Question;
import WebApp.EasyLearn.service.WordService;
import org.springframework.expression.spel.ast.QualifiedIdentifier;

import java.util.ArrayList;
import java.util.List;

public class LevelGenerator {

    WordService wordService = new WordService();

    public List<Question> generateLevel(int testID) {

        int scope = testID * 12;
        List<Integer> ids = new ArrayList<>();

        for (int i = 0; i < 12; i++) {

            ids.add((int) (Math.random() * scope + (scope - 12)));
        }

        return downloadWordsFromDB(wordService.getWordsForExam(ids));
    }


    private List<Question> downloadWordsFromDB(List<WordModel> words) {

        List<Question> keyWords = new ArrayList<>();

        for (WordModel w : words) {

            keyWords.add(new Question(w.getId(), w.getEngword(), w.getPlword()));
        }

        return keyWords;
    }
}
