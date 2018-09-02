# 6-2-1 詳細設計 - ProjectMapper

## Package

`jp.snowday.tutorial.demo.infrastructure.persistence.mysql.mybatis.mapper.ProjectMapper`

## 責務

- Mybatisの機能を利用し、DBアクセスする `interface`
- Mybatisについては下記の[リンク](https://qiita.com/yu_eguchi/items/5bdda6f6ee7baf441870)参照

## クラスアノテーション

- `@Mapper`

## Method Signature

```Java
@Results(value = {
        @Result(id=true, column="project_id", property="projectId")
            ,@Result(column="project_nm", property="projectNm")
            ,@Result(column="dept_id", property="deptId")
            ,@Result(column="difficulty", property="difficulty")
    })
    @Select("SELECT project_id, project_nm, dept_id, difficulty FROM PROJECT")
    List<ProjectEntity> findAll();
```

