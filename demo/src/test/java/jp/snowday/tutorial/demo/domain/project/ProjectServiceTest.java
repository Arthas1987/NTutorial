package jp.snowday.tutorial.demo.domain.project;

import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import jp.snowday.tutorial.test.FlatXmlDataSetLoader;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@TestPropertySource(locations = {"classpath:application-test.properties"})
@Transactional
@WebAppConfiguration
@DbUnitConfiguration(dataSetLoader = FlatXmlDataSetLoader.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionDbUnitTestExecutionListener.class })
public class ProjectServiceTest {
    @Autowired
    ProjectService projectService;

    private static final String DATA_SET_1 = "1.xml";

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    @DatabaseSetup(DATA_SET_1)
    public void findAll() {
        Assert.assertNotNull(projectService);
        List<Project> projectList = projectService.findAll();

        Assert.assertFalse(projectList.isEmpty());
        try {
            FlatXmlDataSet dataSets
                    = (FlatXmlDataSet) new FlatXmlDataSetLoader().loadDataSet(this.getClass(), DATA_SET_1);
            Assert.assertEquals(projectList.size(),
                    dataSets.getTable("PROJECT").getRowCount());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void save() {
    }

    @Test
    public void getProjectById() {
    }

    @Test
    public void deleteProjectById() {
    }

    @Test
    public void updateDifficulity() {
    }
}