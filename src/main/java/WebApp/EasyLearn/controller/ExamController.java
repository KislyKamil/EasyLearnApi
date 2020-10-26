package WebApp.EasyLearn.controller;

import WebApp.EasyLearn.model.examModel.Exam;
import WebApp.EasyLearn.model.response.ExamResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExamController extends BaseController {

    private Exam exam;
    private ExamResponse response;


    @RequestMapping(path = "/api/Exam/")
    private ResponseEntity<?> requestExam(@RequestParam(required = true) int usr) {


        exam = new Exam(usr);

        response = new ExamResponse();
        return ResponseEntity.ok(response);
    }

    @RequestMapping(path = "/api/Exam/Submit")
    private ResponseEntity<?> submitExam() {

        return ResponseEntity.ok("TODO");
    }

    @RequestMapping(path = "/api/ExamRedo")
    private ResponseEntity<?> redoExam() {

        return ResponseEntity.ok("TODO");
    }
}
