package test.org.springdoc.api.app68;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springdoc.core.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static test.org.springdoc.api.app68.FileUtils.getContent;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(properties = "springdoc.show-actuator=true")
@AutoConfigureMockMvc
public class SpringDocApp68Test {

    public static String className;

    @Autowired
    protected MockMvc mockMvc;

    @Test
    public void testApp1() throws Exception {
        mockMvc.perform(get(Constants.DEFAULT_API_DOCS_URL + "/stores"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.openapi", is("3.0.1")))
                .andExpect(content().json(getContent("results/app681.json"), true));
    }

    @Test
    public void testApp2() throws Exception {
        mockMvc.perform(get(Constants.DEFAULT_API_DOCS_URL + "/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.openapi", is("3.0.1")))
                .andExpect(content().json(getContent("results/app682.json"), true));
    }

    @Test
    public void testApp3() throws Exception {
        mockMvc.perform(get(Constants.DEFAULT_API_DOCS_URL + "/pets"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.openapi", is("3.0.1")))
                .andExpect(content().json(getContent("results/app683.json"), true));
    }

    @Test
    public void testApp4() throws Exception {
        mockMvc.perform(get(Constants.DEFAULT_API_DOCS_URL + "/groups test"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.openapi", is("3.0.1")))
                .andExpect(content().json(getContent("results/app684.json"), true));
    }

    @Test
    public void testActuator() throws Exception {
        mockMvc.perform(get(Constants.DEFAULT_API_DOCS_URL)).andExpect(status().isOk())
                .andExpect(jsonPath("$.openapi", is("3.0.1"))).andExpect(jsonPath("$.paths./actuator/info.get.operationId", containsString("handle"))).andExpect(jsonPath("$.paths./actuator/health.get.operationId", containsString("handle")));
    }
}
