package WebApp.EasyLearn.model.examModel;

import lombok.Data;

import java.util.List;

@Data
public class Exam {

    private int userId;
    private List<Question> questions;


    public Exam(int id, List<Question> keyWords) {
        userId = id;
        questions = keyWords;
    }
}
