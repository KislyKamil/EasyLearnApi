package WebApp.EasyLearn.controller;

import WebApp.EasyLearn.model.ExamStats;
import WebApp.EasyLearn.model.User;
import WebApp.EasyLearn.model.UserDetail;
import WebApp.EasyLearn.model.examModel.Exam;
import WebApp.EasyLearn.model.request.ExamRequest;
import WebApp.EasyLearn.model.request.ExamSubmitRequest;
import WebApp.EasyLearn.model.response.ExamResponse;
import WebApp.EasyLearn.service.DetailService;
import WebApp.EasyLearn.service.ExamStatsService;
import WebApp.EasyLearn.service.UserService;
import WebApp.EasyLearn.util.LevelGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class ExamController extends BaseController {

    private Exam exam;
    private ExamResponse response;
    private UserDetail detail;
    private ExamStats stats;

    @Autowired
    private LevelGenerator levelGenerator;

    @Autowired
    private DetailService detailService;

    @Autowired
    private ExamStatsService examStatsService;


    @PostMapping(path = "/api/Exam/New")
    public ResponseEntity<?> requestExam(@RequestBody ExamRequest request) {


        if (request.testID == 1) {

            exam = new Exam(request.userID, levelGenerator.generateLevel(request.testID));
        }

        response = new ExamResponse();
        response.setExam(exam);

        return ResponseEntity.ok(response);
    }

    @PostMapping(path = "/api/Exam/Submit")
    private ResponseEntity<?> submitExam(@RequestBody ExamSubmitRequest request) {

        detail = new UserDetail();
        stats = new ExamStats();

        if (!detailService.isUserExists(request.getUserId())) {

            ifNoUserDetail(detail, request);


        }

        if (!examStatsService.isStatsExists(request.getUserId())) {

            ifNoStats(stats, request);

            return ResponseEntity.ok("Request submitted");
        }


        detail = detailService.getUserDetail(request.getUserId());
        detail.setPkt(detail.getPkt() + request.getPoints());
        detail.setTestamount(detail.getTestamount() + 1);


        stats = examStatsService.getStats(request.getUserId());
        stats.setWords(request.getWrongAnswers());

        detailService.addDetail(detail);
        examStatsService.addStats(stats);


        return ResponseEntity.ok("Request submitted");
    }

    @RequestMapping(path = "/api/Exam/Redo")
    private ResponseEntity<?> redoExam() {

        return ResponseEntity.ok("TODO");
    }

    @RequestMapping(path = "/api/Exam/Generate")
    private ResponseEntity<?> generatedExam() {

        return ResponseEntity.ok("TODO");
    }


    private void ifNoUserDetail(UserDetail detail, ExamSubmitRequest request) {

        detail.setPkt(request.getPoints());
        detail.setUserid(request.getUserId());
        detail.setTestamount(request.getTestCount());

        detailService.addDetail(detail);
    }

    private void ifNoStats(ExamStats stats, ExamSubmitRequest request) {

        stats.setUserid(request.getUserId());
        stats.setWords(request.getWrongAnswers());

        examStatsService.addStats(stats);

    }

}
