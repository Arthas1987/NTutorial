package jp.snowday.tutorial.demo.infrastructure.persistence.mysql.repository;

import jp.snowday.tutorial.demo.domain.project.Project;
import jp.snowday.tutorial.demo.domain.project.ProjectRepository;
import jp.snowday.tutorial.demo.infrastructure.persistence.mysql.mybatis.mapper.DepartmentMapper;
import jp.snowday.tutorial.demo.infrastructure.persistence.mysql.mybatis.mapper.ProjectMapper;
import jp.snowday.tutorial.demo.infrastructure.persistence.mysql.mybatis.translator.ProjectTranslator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

/**
 * プロジェクトリポジトリの実装
 * @author zhangnan
 * @date 2018/08/26
 */
@Repository
@AllArgsConstructor
public class ProjectRepositoryImpl implements ProjectRepository {

    /** プロジェクトMapperクラス */
    private ProjectMapper projectMapper;

    /** 組織のMapperクラス */
    private DepartmentMapper departmentMapper;

    /**
     * 全部プロジェクトを返却する
     *
     * @return 全部のプロジェクト
     */
    @Nonnull
    @Override
    public List<Project> findAll() {
        return ProjectTranslator.convertListToDomain(
                projectMapper.findAll()
        );
    }

    /**
     * IDをキーにして、プロジェクトを取得する
     *
     * @param id プロジェクトID
     * @return プロジェクト <br> 取得できない場合Null返す
     */
    @Nullable
    @Override
    public Project findById(@Nonnull Long id) {
        return ProjectTranslator.convertToDomain(projectMapper.findById(id));
    }

    /**
     * プロジェクトを新規登録し、登録されたプロジェクトを返す
     *
     * @param prj プロジェクト
     */
    @Override
    public void save(@Nonnull Project prj) {
        projectMapper.save(ProjectTranslator.convertToOrm(prj));
    }

    /**
     * Idを指定し、プロジェクトを削除する
     *
     * @param id プロジェクトID
     */
    @Override
    public void deleteById(@Nonnull Long id) {
        projectMapper.delete(id);
    }

    /**
     * プロジェクトを更新する
     * <b>Nullカラムは更新しない<b/>
     *
     * @param prj 更新するプロジェクトエンティティ
     */
    @Override
    public void updateExcludesNull(@Nonnull Project prj) {
        projectMapper.update(ProjectTranslator.convertToOrm(prj));
    }

    /**
     * プロジェクトの組織コードが存在しているかどうかをチェックする
     *
     * @param deptId 組織コード
     * @return true(組織コードが存在する) / false(組織コードが存在しない)
     */
    @Override
    public boolean isDeptIdValid(@Nonnull Long deptId) {
        return (departmentMapper.findById(deptId) != null);
    }
}
