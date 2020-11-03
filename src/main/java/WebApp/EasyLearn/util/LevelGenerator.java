package WebApp.EasyLearn.util;

import WebApp.EasyLearn.model.WordModel;
import WebApp.EasyLearn.model.examModel.Question;
import WebApp.EasyLearn.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class LevelGenerator {

    @Autowired
    private WordService wordService;

    public List<Question> generateLevel(int testID) {

        Random rand = new Random();

        int max = testID * 20;
        int min = max - 19;

        List<Integer> ids = new ArrayList<>();

        for (int i = 0; i < 12; i++) {

            int newRand =  ThreadLocalRandom.current().nextInt(min, max + 1);


            if (ids.contains(newRand)) {

                while (ids.contains(newRand)) {
                    newRand = rand.nextInt((max - min) + 1) + min;
                }
            }

            ids.add(newRand);


        }
        System.out.println((ids));
        System.out.println(wordService.getWordsForExam(ids).size());

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
