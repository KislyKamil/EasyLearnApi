package WebApp.EasyLearn.util;

import WebApp.EasyLearn.model.ExamStats;
import WebApp.EasyLearn.model.WordModel;
import WebApp.EasyLearn.model.examModel.Question;
import WebApp.EasyLearn.service.DetailService;
import WebApp.EasyLearn.service.ExamStatsService;
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

    @Autowired
    private ExamStatsService examStatsService;

    public List<Question> generateLevel(int testID, boolean isRandom, int userID) {

        Random rand = new Random();

        if (isRandom) {
            return downloadWordsFromDB(getWords(testID, rand, userID));
        }

        return downloadWordsFromDB(getWords(testID, rand));
    }


    public List<Question> downloadWordsFromDB(List<WordModel> words) {

        List<Question> keyWords = new ArrayList<>();

        for (WordModel w : words) {

            keyWords.add(new Question(w.getId(), w.getEngword(), w.getPlword()));
        }

        return keyWords;
    }

    private List<WordModel> getWords(int testID, Random rand) {

        int max = (testID + 1) * 20;
        int min = max - 19;
        if (max > wordService.getCount()) {
            max = (int) wordService.getCount();
            min = 1;
        }

        List<Integer> ids = new ArrayList<>();

        for (int i = 0; i < 12; i++) {

            int newRand = ThreadLocalRandom.current().nextInt(min, max + 1);


            if (ids.contains(newRand)) {

                while (ids.contains(newRand)) {
                    newRand = rand.nextInt((max - min) + 1) + min;
                }
            }

            ids.add(newRand);


        }
        return wordService.getWordsForExam(ids);

    }

    private List<WordModel> getWords(int testID, Random rand, int userID) {

        int max = (testID * 2) + 20;
        int min = max - 21;
        int diff = 12;
        List<Integer> ids = new ArrayList<>();


        if (getWordsToReviewIds(userID).size() == 12) {

            return wordService.getWordsForExam(getWordsToReviewIds(userID));
        }

        if (getWordsToReviewIds(userID).size() < 12) {

            diff = diff - getWordsToReviewIds(userID).size();
        }

        ids.addAll(getWordsToReviewIds(userID));

        for (int i = 0; i < diff; i++) {

            int newRand = ThreadLocalRandom.current().nextInt(min, max + 1);


            if (ids.contains(newRand)) {

                while (ids.contains(newRand)) {
                    newRand = rand.nextInt((max - min) + 1) + min;
                }
            }

            ids.add(newRand);


        }


        return wordService.getWordsForExam(ids);

    }


    private List<Integer> getWordsToReviewIds(int userID) {


        String wordsPoll = examStatsService.getStats(userID).getWords();
        String[] words = wordsPoll.split(",");


        List<Integer> ids = new ArrayList<>();

        for (String w : words) {
            if (!w.contains(" ")) {

                ids.add(wordService.
                        getWordsByName(w).
                        get(0).
                        getId());
            }
        }

        return ids;

    }
}
