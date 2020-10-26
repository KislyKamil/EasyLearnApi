package WebApp.EasyLearn.model.examModel;

import lombok.Data;

import java.util.List;

@Data
public class Exam {

    private int userId;
    private List<Question> questions;

    //TODO fix this to questions
    public Exam(int id) {
        userId = id;
    }
}
