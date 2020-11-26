package WebApp.EasyLearn.controller;

import WebApp.EasyLearn.model.response.DetailsResponse;
import WebApp.EasyLearn.service.DetailService;
import WebApp.EasyLearn.service.ExamStatsService;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetailsController extends BaseController {


    @Autowired
    private DetailService detailService;

    @GetMapping(path = "/api/Details/{id}")
    public ResponseEntity<?> requestExam(@PathVariable(value = "id") int id) {

        DetailsResponse response = new DetailsResponse();
        detailService.getUserDetail(id);

        if (!detailService.isUserExists(id)) {
            response.setTestAll(0);

        } else {
            response.setTestAll(detailService.getUserDetail(id).getTestamount());
        }


        if (!speechStatsService.ifUserExists(id)) {
            response.setSpeechAll(0);

            return ResponseEntity.ok(response);
        }

        response.setSpeechAll(speechStatsService.findByUserId(id).getTotal());

        return ResponseEntity.ok(response);
    }
}
