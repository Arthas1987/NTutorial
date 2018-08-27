package jp.snowday.tutorial.demo.presentation.form;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.io.Serializable;

/**
 * @author zhangnan
 * @date 2018/08/26
 */
public class CreateProject implements Serializable {
    private static final long serialVersionUID = 2L;

    @JsonCreator
    public CreateProject(@JsonProperty("name") String name, @JsonProperty("deptId") Long deptId, @JsonProperty("difficultyCode") String difficultyCode) {
        this.name = name;
        this.deptId = deptId;
        this.difficultyCode = difficultyCode;
    }

    /** プロジェクト名 */
    @Getter
    private String name;

    /** 組織ID */
    @Getter
    private Long deptId;

    /** 難易度 */
    @Getter
    private String difficultyCode;
}
