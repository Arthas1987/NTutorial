# 6-2-1 詳細設計 - ProjectEntity

## Package

`jp.snowday.tutorial.demo.infrastructure.persistence.mysql.mybatis.entity.ProjectEntity`



## 責務

- PROJECTテーブルのORマッピング

## コード

```Java
package jp.snowday.tutorial.demo.infrastructure.persistence.mysql.mybatis.entity;

import jp.snowday.tutorial.demo.infrastructure.util.annotation.Column;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * プロジェクトテーブルのエンティティクラス
 * @author zhangnan
 * @date 2018/08/26
 */
public class ProjectEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    @Column(name = "project_id")
    private Long projectId;

    @Getter
    @Setter
    @Column(name = "project_nm")
    private String projectNm;

    @Getter
    @Setter
    @Column(name = "dept_id")
    private Long deptId;

    @Getter
    @Setter
    @Column(name = "difficulty")
    private String difficulty;

    @Getter
    @Setter
    @Column(name = "ins_tm")
    private Timestamp insTm;

    @Getter
    @Setter
    @Column(name = "upd_tm")
    private Timestamp updTm;

    @Getter
    @Setter
    @Column(name = "version")
    private Long version;
}

```

