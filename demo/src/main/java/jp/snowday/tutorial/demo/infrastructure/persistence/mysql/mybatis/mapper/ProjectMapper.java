package jp.snowday.tutorial.demo.infrastructure.persistence.mysql.mybatis.mapper;

import jp.snowday.tutorial.demo.infrastructure.persistence.mysql.mybatis.entity.ProjectEntity;
import jp.snowday.tutorial.demo.infrastructure.persistence.mysql.mybatis.provider.ProjectSqlProvider;
import org.apache.ibatis.annotations.*;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

/**
 * プロジェクトのMapper
 * @author zhangnan
 * @date 2018/08/26
 */
@Mapper
public interface ProjectMapper {

    /** テーブルにある全データを取得する
     * @return プロジェクト一覧
     */
    @Results(value = {
        @Result(id=true, column="project_id", property="projectId")
            ,@Result(column="project_nm", property="projectNm")
            ,@Result(column="dept_id", property="deptId")
            ,@Result(column="difficulty", property="difficulty")
    })
    @Nonnull
    @Select("SELECT project_id, project_nm, dept_id, difficulty FROM PROJECT")
    List<ProjectEntity> findAll();

    /** プロジェクトID指定で、プロジェクトを取得する
     * <p> 取得できない場合、nullを返す</p>
     * @param id プロジェクトID
     * @return プロジェクト
     */
    @Results(value = {
            @Result(id=true, column="project_id", property="projectId")
            ,@Result(column="project_nm", property="projectNm")
            ,@Result(column="dept_id", property="deptId")
            ,@Result(column="difficulty", property="difficulty")
    })
    @Nullable
    @Select("SELECT project_id, project_nm, dept_id, difficulty FROM PROJECT WHERE project_id = #{id}")
    ProjectEntity findById(@Nonnull @Param("id") Long id);

    /**
     * プロジェクトを保存する
     * @param prj　プロジェクト
     */
    @Insert("INSERT INTO PROJECT (PROJECT_NM, DEPT_ID, DIFFICULTY, INS_TM, UPD_TM, VERSION) VALUES (#{projectNm}, #{deptId}, #{difficulty}, sysdate(), sysdate(), '0')")
    void save(ProjectEntity prj);

    /**
     * 指定されたIDでプロジェクトを削除する
     * @param id プロジェクトID
     */
    @Delete("DELETE FROM PROJECT WHERE project_id = #{id}")
    void delete(@Nonnull @Param("id") Long id);

    /**
     * nullではないカラムを更新する
     * @param entity 更新対象エンティティ
     */
    @UpdateProvider(type = ProjectSqlProvider.class, method = "updateSqlExcludesNull")
    void update(@Nonnull @Param("entity") ProjectEntity entity);

}
