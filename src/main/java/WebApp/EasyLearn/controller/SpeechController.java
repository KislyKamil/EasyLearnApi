package WebApp.EasyLearn.controller;

import WebApp.EasyLearn.model.SpeechStatsModel;
import WebApp.EasyLearn.model.request.SpeechTestRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpeechController extends BaseController {

    @PostMapping(path = "/api/SpeechTestResult")
    public ResponseEntity<?> sendResults(@RequestBody SpeechTestRequest request) {

        SpeechStatsModel model = new SpeechStatsModel();

        if (speechStatsService.ifUserExists(request.getUserId())) {

            model = speechStatsService.findById(request.getUserId());
            model.setPoints(model.getPoints() + request.getPoints());
            model.setTotal(model.getTotal() + 6);

            speechStatsService.addStats(model);

            return ResponseEntity.ok("OK");
        }

        model.setPoints(request.getPoints());
        model.setTotal(6);
        model.setUserid(request.getUserId());

        speechStatsService.addStats(model);

        return ResponseEntity.ok("OK");
    }
}
