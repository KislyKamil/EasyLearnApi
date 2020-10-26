package WebApp.EasyLearn.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//TODO REMOVE PROBABLY
public class WordPulloooooToDELETE {


    private final Random rand = new Random();


    public List<Integer> seedPull(int scope) {
        List<Integer> wordPull = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            wordPull.add(rand.nextInt(scope));
        }

        return wordPull;
    }

}
