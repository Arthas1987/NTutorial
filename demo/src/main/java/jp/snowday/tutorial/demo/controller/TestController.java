package jp.snowday.tutorial.demo.controller;

import jp.snowday.tutorial.demo.entity.Project;
import jp.snowday.tutorial.demo.entity.User;
import jp.snowday.tutorial.demo.repository.ProjectRepository;
import jp.snowday.tutorial.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class TestController {
    UserRepository userRepository;
    ProjectRepository projectRepository;

    @RequestMapping("/hello")
    public String test() {
        return "Hello World!";
    }

    @GetMapping("/addTest")
    public User addTest() {
        User testUser = new User();
        testUser.setUsername("testUser");
        testUser.setEmail("test@test.com");
        testUser.setCreateTime(new Timestamp(System.currentTimeMillis()));
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        testUser.setPassword(passwordEncoder.encode("Test"));

        return userRepository.save(testUser);
    }

    @GetMapping("/projectTest")
    public Project projectTest() {
        Project prj = new Project();
        prj.setDEPT_ID(1);
        prj.setDifficulty("1");
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        prj.setINS_TM(ts);
        prj.setUPD_TM(ts);
        prj.setVersion(1);
        prj.setPROJECT_NM("Test");
        return projectRepository.save(prj);
    }

    @GetMapping("/getAll")
    public List<User> getAll() {
        Iterable<User> rst = userRepository.findAll();
        List<User> list = new ArrayList<>();
        rst.forEach(single ->list.add(single));
        return list;
    }
}
