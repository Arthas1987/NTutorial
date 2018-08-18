package jp.snowday.tutorial.demo.domain.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

/**
 * プロジェクトのサービスクラス
 * @author zhangnan
 * @date 2018/8/19
 */
@Service
public class ProjectService {
    /** プロジェクトのリポジトリ */
    @Autowired
    private ProjectRepository projectRepository;

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
     * @param code 難易度（Null可能）
     */
    public void save(@Nonnull String name, @Nonnull Long deptId, @Nullable String code) {
        projectRepository.save(Project.registerNewProject(name, deptId, code));
    }

    /**
     * IDでプロジェクトを取得
     * @param id プロジェクトID
     */
    public void getProjectById(@Nonnull Long id) {
        // FIXME: これは普通にフロントレイヤーでやるべきでは..?
        if (StringUtils.isEmpty(id)) {
            return;
        }

        projectRepository.findById(id);
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
     * TODO: フロントレイヤーがIDをチェックする想定だが、排他などにより、ここでIDが存在していない可能性ある。普通ならここで排他エラースローすべきだが、今回はNULL返す
     * @param id プロジェクトID
     * @param code 難易度コード
     */
    public void updateDifficulity(@Nonnull Long id, @Nullable String code) {
        //FIXME: ここ違和感感じてる。なんでDBからエンティティー取得しなければならないか？リポジトリ層は、本当に「このビジネスロジックと合わせるようなメソッド」を定義すべきでは・・
        Project prj = projectRepository.findById(id);

        if (prj == null) {
            return;
        }

        prj.setDiificulty(code);
        projectRepository.update(prj);
    }
}
