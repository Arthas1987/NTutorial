package jp.snowday.tutorial.demo.domain.project;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

/**
 * プロジェクトのリポジトリ
 * @author zhangnan
 * @date 2018/8/19
 */
public interface ProjectRepository {
    /**
     * 全部プロジェクトを返却する
     * @return 全部のプロジェクト
     */
    @Nonnull
    List<Project> findAll();

    /**
     * IDをキーにして、プロジェクトを取得する
     * @param id プロジェクトID
     * @return プロジェクト <br> 取得できない場合Null返す
     */
    @Nullable
    Project findById(@Nonnull final Long id);

    /**
     * プロジェクトを新規登録し、登録されたプロジェクトを返す
     * @param prj プロジェクト
     */
    void save(@Nonnull final Project prj);

    /**
     * Idを指定し、プロジェクトを削除する
     * @param id プロジェクトID
s     */
    void deleteById(@Nonnull final Long id);

    /**
     * プロジェクトを更新する
     * @param prj 更新するプロジェクト
     */
    void update(@Nonnull final Project prj);
}
