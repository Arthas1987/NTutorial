package jp.snowday.tutorial.demo.usecase;

import jp.snowday.tutorial.demo.domain.project.Project;
import jp.snowday.tutorial.demo.domain.project.ProjectService;
import jp.snowday.tutorial.demo.infrastructure.util.messsage.DomainMessageKeys;
import jp.snowday.tutorial.demo.presentation.form.CreateProject;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * プロジェクトユースケース
 * @author zhangnan
 * @date 2018/08/26
 */
@Service
@AllArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class ProjectUseCase {
    private ProjectService projectService;

    /** メッセージソース*/
    private MessageSource messageSource;

    /**
     * 全部のプロジェクトを取得する
     * @return プロジェクトリスト
     */
    @Nonnull
    public List<Project> getAllProjects() {
        return projectService.findAll();
    }

    /**
     * IDでプロジェクトを取得する
     * @param id プロジェクトIDと同じの文字列
     * @return プロジェクト
     */
    @Nonnull
    public Project getProjectById(@Nonnull String id) {
        Long projectId = Long.parseLong(id);
        return projectService.getProjectById(projectId);
    }

    /**
     * 新規でプロジェクトを作る
     * @param prj プロジェクト
     */
    public void createProject(@Nullable CreateProject prj) {
        if (prj == null) {
            throw new IllegalArgumentException(messageSource.getMessage(
                    DomainMessageKeys.Project.ERROR_INVALID_PROJECT_BODY.getMessageKey()
                    , null
                    , Locale.JAPAN));
        }

        projectService.save(prj.getName(), prj.getDeptId(), prj.getDifficultyCode());
    }

    /**
     * IDが指定されたプロジェクトを削除する
     * @param id プロジェクトID
     */
    public void deleteProject(@Nonnull String id) {
        Long projectId = Long.parseLong(id);

        projectService.deleteProjectById(projectId);
    }

    public void updateProjectDifficulty(@Nonnull String id, @Nonnull String difficulty) {
        Long projectId = Long.parseLong(id);
        projectService.updateDifficulity(projectId, difficulty);
    }
}
