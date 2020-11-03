package WebApp.EasyLearn.model.request;

import lombok.Data;

@Data
public class ExamSubmitRequest {

    int userId;
    int testCount;
    int points;
    String wrongAnswers;
}
