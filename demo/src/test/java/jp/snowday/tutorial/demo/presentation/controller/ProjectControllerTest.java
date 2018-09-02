package jp.snowday.tutorial.demo.presentation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import jp.snowday.tutorial.demo.domain.project.Project;
import jp.snowday.tutorial.demo.domain.project.ProjectService;
import jp.snowday.tutorial.test.FlatXmlDataSetLoader;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import static org.hamcrest.core.IsEqual.equalTo;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@TestPropertySource(locations = {"classpath:application-test.properties"})
@Transactional
@WebAppConfiguration
@DbUnitConfiguration(dataSetLoader = FlatXmlDataSetLoader.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionDbUnitTestExecutionListener.class })
public class ProjectControllerTest {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder;

    private static final String DATA_SET_1 = "1.xml";

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    @DatabaseSetup(DATA_SET_1)
    public void getAllProjects() {

        try {
            List<Project> projectList = projectService.findAll();
            ObjectMapper mapper = jackson2ObjectMapperBuilder.build();
            String jsonInString = mapper.writeValueAsString(projectList);

            mvc.perform(MockMvcRequestBuilders.get("/projects/")
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().string(equalTo(jsonInString)));

        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void getProjectById() {
    }

    @Test
    public void createNewProject() {
    }

    @Test
    public void deleteProjectById() {
    }

    @Test
    public void updateProjectDifficulty() {
    }
}