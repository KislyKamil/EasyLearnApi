package WebApp.EasyLearn.controller;

import WebApp.EasyLearn.model.UserDetail;
import WebApp.EasyLearn.model.request.ExamSubmitRequest;
import WebApp.EasyLearn.model.request.TextResultsRequest;
import WebApp.EasyLearn.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TextWorkController extends BaseController {

    @Autowired
    private DetailService detailService;

    @PostMapping(path = "/api/Text/Results")
    public ResponseEntity<?> submitResults(@RequestBody TextResultsRequest request) {

        UserDetail newDetail = new UserDetail();
        UserDetail detail;

        if (!detailService.isUserExists(request.id)) {

            ifNoUserDetail(newDetail, request);

        } else {
            detail = detailService.getUserDetail(request.getId());
            detail.setPkt(detail.getPkt());
            detail.setTestamount(detail.getTestamount());
            detail.setTextdone(detail.getTextdone() + 1);

            detailService.addDetail(detail);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    private void ifNoUserDetail(UserDetail detail, TextResultsRequest request) {

        detail.setPkt(0);
        detail.setUserid(request.getId());
        detail.setTestamount(0);
        detail.setTextdone(1);

        detailService.addDetail(detail);
    }
}
