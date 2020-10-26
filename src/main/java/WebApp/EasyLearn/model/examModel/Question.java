package WebApp.EasyLearn.model.examModel;

import lombok.Data;

@Data
public class Question {

    public int id;
    public String engWord;
    public String plWord;

    public Question(int id, String engWord, String plWord) {
        this.id = id;
        this.engWord = engWord;
        this.plWord = plWord;
    }

}
