package jp.snowday.tutorial.demo.infrastructure.persistence.mysql.mybatis.entity;


import jp.snowday.tutorial.demo.infrastructure.util.annotation.Column;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * DEPT(組織)のエンティティクラス
 * @author zhangnan
 * @date 2018/08/26
 */
public class DepartmentEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    @Column(name = "dept_id")
    private Long deptId;

    @Getter
    @Setter
    @Column(name = "nm")
    private String deptName;
}
