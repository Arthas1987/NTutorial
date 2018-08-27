package jp.snowday.tutorial.demo.infrastructure.persistence.mysql.mybatis.translator;

import jp.snowday.tutorial.demo.domain.project.Project;
import jp.snowday.tutorial.demo.infrastructure.persistence.mysql.mybatis.entity.ProjectEntity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/**
 * ProjectのORMエンティティクラスからProjectドメインオブジェクトへの変換クラス
 * @author zhangnan
 * @date 2018/08/26
 *
 */
public final class ProjectTranslator {
    /**
     * エンティティ　→　ドメインオブジェクト
     * @param entity エンティティ
     * @return ドメインオブジェクト
     */
    @Nullable
    public static Project convertToDomain(@Nullable ProjectEntity entity) {
        if (entity == null) {
            return null;
        }
        return createProject(entity);
    }

    /** Disable New */
    private ProjectTranslator() {

    }

    /**
     * ドメインオブジェクト →　エンティティ
     * <p> Null項目あっても設定する</p>
     * @param domain ドメインオブジェクト
     * @return エンティティ
     */
    @Nonnull
    public static ProjectEntity convertToOrm(@Nonnull Project domain) {
        return createProjectEntity(domain);
    }

    @Nonnull
    public static List<Project> convertListToDomain(@Nonnull List<ProjectEntity> entityList) {
        List<Project> targetList = new ArrayList<Project>();

        entityList.forEach(
                entity -> targetList.add(createProject(entity))
        );

        return targetList;
    }

    @Nonnull
    public static List<ProjectEntity> convertListToEntity(@Nonnull List<Project> domainList) {
        List<ProjectEntity> targetList = new ArrayList<ProjectEntity>();

        domainList.forEach(
                domain -> targetList.add(createProjectEntity(domain))
        );

        return targetList;
    }

    //===============
    //Private Zone

    /**
     * エンティティ　→　ドメインオブジェクト
     * @param entity エンティティ
     * @return ドメインオブジェクト
     */
    @Nonnull
    private static Project createProject(@Nonnull ProjectEntity entity) {
        return new Project(entity.getProjectId()
                ,entity.getProjectNm()
                ,entity.getDeptId()
                ,entity.getDifficulty());
    }

    /**
     * ドメインオブジェクト →　エンティティ
     * <p> Null項目あっても設定する</p>
     * @param domain ドメインオブジェクト
     * @return エンティティ
     */
    @Nonnull
    private static ProjectEntity createProjectEntity(@Nonnull Project domain) {
        ProjectEntity entity = new ProjectEntity();
        entity.setProjectId(domain.getId());
        entity.setProjectNm(domain.getName());
        entity.setDeptId(domain.getDeptId());
        entity.setDifficulty(domain.getDifficulty().getCode());

        return entity;
    }
}
