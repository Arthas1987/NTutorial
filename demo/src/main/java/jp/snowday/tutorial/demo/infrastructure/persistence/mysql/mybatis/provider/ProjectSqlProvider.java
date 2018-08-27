package jp.snowday.tutorial.demo.infrastructure.persistence.mysql.mybatis.provider;

import jp.snowday.tutorial.demo.infrastructure.persistence.mysql.mybatis.entity.ProjectEntity;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;


public class ProjectSqlProvider {
    private static final String TABLE_NAME = "PROJECT";

    public String updateSqlExcludesNull(Map<String, Object> para) {
        ProjectEntity project = (ProjectEntity) para.get("entity");

        return new SQL() {{
            UPDATE(TABLE_NAME);
            if (project.getDeptId() != null) {
                SET("dept_id = '" + project.getDeptId() + "'");
            }

            if (project.getDifficulty() != null) {
                SET("difficulty = '" + project.getDifficulty() + "'");
            }

            if (project.getProjectNm() != null) {
                SET("project_nm = '" + project.getProjectNm() + "'");
            }

            SET("upd_tm = sysdate()");
            SET("version = version + 1");

            WHERE("project_id = " + project.getProjectId());
        }}.toString();
    }
}
