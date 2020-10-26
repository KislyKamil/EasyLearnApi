package WebApp.EasyLearn.controller;

import WebApp.EasyLearn.model.examModel.Exam;
import WebApp.EasyLearn.model.request.ExamRequest;
import WebApp.EasyLearn.model.response.ExamResponse;
import WebApp.EasyLearn.util.LevelGenerator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExamController extends BaseController {

    private Exam exam;
    private ExamResponse response;
    private final LevelGenerator levelGenerator = new LevelGenerator();


    @PostMapping(path = "/api/Exam/")
    private ResponseEntity<?> requestExam(@RequestParam ExamRequest request) {


        exam = new Exam(request.userID, levelGenerator.generateLevel(request.testID));

        response = new ExamResponse();
        response.setExam(exam);

        return ResponseEntity.ok(response);
    }

    @RequestMapping(path = "/api/Exam/Submit")
    private ResponseEntity<?> submitExam() {

        //TODO MAKE THIS LATER 
        return ResponseEntity.ok(response);
    }

    @RequestMapping(path = "/api/ExamRedo")
    private ResponseEntity<?> redoExam() {

        return ResponseEntity.ok("TODO");
    }
}
