package jp.snowday.tutorial.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "PROJECT")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer PROJECT_ID;

    @Getter
    @Setter
    private String PROJECT_NM;

    @Getter
    @Setter
    private Integer DEPT_ID;

    @Getter
    @Setter
    private String difficulty;

    @Getter
    @Setter
    private Timestamp INS_TM;

    @Getter
    @Setter
    private Timestamp UPD_TM;

    @Getter
    @Setter
    private Integer version;
}
