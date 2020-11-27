package WebApp.EasyLearn;

import WebApp.EasyLearn.controller.DetailsController;
import WebApp.EasyLearn.controller.ExamController;
import WebApp.EasyLearn.model.ExamStats;
import WebApp.EasyLearn.model.User;
import WebApp.EasyLearn.model.request.ExamSubmitRequest;
import WebApp.EasyLearn.model.response.DetailsResponse;
import WebApp.EasyLearn.repository.UserDetailRepository;
import WebApp.EasyLearn.service.DetailService;
import WebApp.EasyLearn.service.ExamStatsService;
import WebApp.EasyLearn.util.JwtUtil;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest
public class IntegrationTest {


    @Autowired
    DetailsController detailsController;

    MockMvc mockMvc;


    @BeforeEach
    public void init() {
        mockMvc = standaloneSetup(detailsController).build();
    }

    @Test
    public void isDetailControllerOk() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/Details/{id}", 32)
        )
                .andExpect(status().isOk());
    }
}
