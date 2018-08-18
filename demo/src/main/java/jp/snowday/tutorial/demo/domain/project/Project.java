package jp.snowday.tutorial.demo.domain.project;

import jp.snowday.tutorial.demo.infrastructure.util.codeenum.CodeEnum;
import jp.snowday.tutorial.demo.infrastructure.util.codeenum.CodeEnums;
import lombok.Getter;
import org.springframework.util.StringUtils;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * プロジェクトエンティティ
 * @author zhangnan
 * @date 2018/8/18
 */
public class Project {

    //================
    // Member変数

    /** プロジェクトID */
    @Nullable
    @Getter
    private Long projectId;

    /** プロジェクト名 */
    @Nonnull
    @Getter
    private String projectName;

    /** 組織ID */
    @Nonnull
    @Getter
    private Long deptId;

    /** 難易度 */
    @Nullable
    @Getter
    private CodeEnums.ProjectDifficultyEnum diificulty;

    //================
    // コンストラクター

    /**
     * デフォルトコンストラクター
     */
    private Project() {
        // Do Nothing
    }

    /**
     * 全部パラメタを指定してプロジェクトを生成する
     * @param id プロジェクトID
     * @param name プロジェクト名
     * @param deptId 組織ID
     * @param code 難易度。難易度指定されない場合はNULLとする
     */
    public Project(@Nonnull Long id, @Nonnull String name, @Nonnull Long deptId, @Nullable String code) {
        this.projectId = id;
        this.projectName = name;
        this.deptId = deptId;
        this.diificulty = setDiff(code);
    }

    /**
     * プロジェクト登録時のコンストラクター。IDは空欄。 <br/>
     * 新規登録以外なら利用禁止となるため、Factoryパターンを利用してprivateとする
     * @param name プロジェクト名
     * @param deptId 組織ID
     * @param code 難易度。難易度指定されない場合はNULLとする
     */
    private Project(@Nonnull String name, @Nonnull Long deptId, @Nullable String code) {
        this.projectName = name;
        this.deptId = deptId;
        this.diificulty = setDiff(code);
    }

    //================
    // メソッド

    /**
     * 新規プロジェクトを登録する時、IDなしのプロジェクトを生成するFactoryメソッド
     * @param name プロジェクト名
     * @param deptId 組織ID
     * @param code 難易度。難易度指定されない場合はNULLとする
     * @return 生成されたプロジェクト
     */
    @Nonnull
    public static Project registerNewProject(@Nonnull String name, @Nonnull Long deptId, @Nullable String code) {
        return new Project(name, deptId, code);
    }

    public void setDiificulty(@Nullable  String code) {
        this.setDiff(code);
    }

    //================
    // 私用メソッド

    /**
     * コードに基づいて、難易度を設定する
     * <p> コードがからの値なら、nullを返す</p>
     * @param code コード
     * @return 難易度
     */
    @Nullable
    private CodeEnums.ProjectDifficultyEnum setDiff(String code) {
        if (StringUtils.isEmpty(code)) {
            return null;
        }

        return CodeEnum.getEnum(CodeEnums.ProjectDifficultyEnum.class, code);
    }
}
