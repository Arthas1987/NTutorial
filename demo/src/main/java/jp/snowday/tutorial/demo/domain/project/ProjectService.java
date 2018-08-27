package jp.snowday.tutorial.demo.domain.project;

import jp.snowday.tutorial.demo.infrastructure.exception.OptimisticExclusiveException;
import jp.snowday.tutorial.demo.infrastructure.util.messsage.DomainMessageKeys;
import jp.snowday.tutorial.demo.infrastructure.util.messsage.InfraMessageKeys;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * プロジェクトのサービスクラス
 * @author zhangnan
 * @date 2018/8/19
 */
@Service
@AllArgsConstructor
public class ProjectService {
    /** プロジェクトのリポジトリ */
    private ProjectRepository projectRepository;

    /** メッセージソース*/
    private MessageSource messageSource;

    //================
    // メソッド

    /**
     * 登録されているプロジェクトを全部返却する
     * @return プロジェクトの集合
     */
    @Nonnull
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    /**
     * プロジェクト新規登録
     * @param name プロジェクト名
     * @param deptId 組織ID
     * @param difficulty 難易度（Null可能）
     */
    public void save(@Nonnull String name, @Nonnull Long deptId, @Nullable String difficulty) {

        validateDepartmentId(deptId);

        projectRepository.save(Project.registerNewProject(name, deptId, difficulty));
    }

    /**
     * IDでプロジェクトを取得 <br/>
     * <b>取得できない場合排他エラーでスローする</b>
     * @param id プロジェクトID
     * @return 取得したプロジェクト
     */
    @Nonnull
    public Project getProjectById(@Nonnull Long id) {
        Project prj = projectRepository.findById(id);

        // バリデーションはフロントでやる為、
        if (prj == null) {
            throw new OptimisticExclusiveException(
                    messageSource.getMessage(InfraMessageKeys.OPTIMISTIC_EXCLUSIVE_ERROR.getMessageKey()
                    ,null
                    ,Locale.JAPAN)
            );
        }

        return prj;
    }

    /**
     * IDでプロジェクトを削除
     * @param id プロジェクトID
     */
    public void deleteProjectById(@Nonnull Long id) {
        projectRepository.deleteById(id);
    }

    /**
     * プロジェクト難易度を変更する
     * @param id プロジェクトID
     * @param code 難易度コード
     */
    public void updateDifficulity(@Nonnull Long id, @Nonnull String code) {
        projectRepository.updateExcludesNull(Project.updateProject(id, code));
    }

    //================
    // 内部ビジネスロジック

    /**
     * 組織コードのバリデーション
     * DBに存在していない場合、IllegalArgumentException例外でスロー
     * @param deptId 組織コード
     */
    private void validateDepartmentId(@Nonnull Long deptId) {
        // 組織コードのバリデーション
        if (projectRepository.isDeptIdValid(deptId)) {
            return;
        }

        // お前はもう死んでいる
        // FIXME: 400 Bad Request にする
        throw new IllegalArgumentException(
                    messageSource.getMessage(
                             DomainMessageKeys.Project.ERROR_INVALID_DEPARTMENT_ID.getMessageKey()
                            ,Collections.singletonList(deptId).toArray()
                            ,Locale.JAPAN));
    }
}
