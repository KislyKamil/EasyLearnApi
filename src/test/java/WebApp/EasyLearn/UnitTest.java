package WebApp.EasyLearn;


import WebApp.EasyLearn.model.WordModel;
import WebApp.EasyLearn.model.examModel.Question;
import WebApp.EasyLearn.util.LevelGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class UnitTest {


    @InjectMocks
    LevelGenerator generator;

    WordModel word;
    List<WordModel> list = new ArrayList<>();
    List<Question> questions = new ArrayList<>();


    @Test
    @DisplayName("Test case for validating words before download")
    public void wordsShouldAttachedToQuestion() {

        word = new WordModel(555, "test", "test", 15);
        list.add(word);
        questions.add(new Question(word.getId(), word.getEngword(), word.getPlword()));


        assertEquals(questions, generator.downloadWordsFromDB(list));

    }
}
