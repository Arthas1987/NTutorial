package jp.snowday.tutorial.demo.domain.project;

import jp.snowday.tutorial.demo.infrastructure.util.code.CodeEnum;
import jp.snowday.tutorial.demo.infrastructure.util.code.Codes;
import lombok.Getter;
import org.springframework.util.StringUtils;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Date;

/**
 * プロジェクトエンティティ
 * @author zhangnan
 * @date 2018/8/18
 */
public class Project {

    //================
    // Member変数

    /** プロジェクトID */
    private Long id;

    public Project(Long id, String name, Long deptId, Codes.ProjectDifficultyEnum difficulty, Date lastUpdateTime, Date createdTime) {
        this.id = id;
        this.name = name;
        this.deptId = deptId;
        this.difficulty = difficulty;
        this.lastUpdateTime = lastUpdateTime;
        this.createdTime = createdTime;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getDeptId() {
        return deptId;
    }

    public Codes.ProjectDifficultyEnum getDifficulty() {
        return difficulty;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    /** プロジェクト名 */
    private String name;

    /** 組織ID */
    private Long deptId;

    /** 難易度 */
    private Codes.ProjectDifficultyEnum difficulty;

    /** 最終更新日 */
    private Date lastUpdateTime;

    /** 作成日 */
    private Date createdTime;

    //================
    // コンストラクター

    /**
     * 全部パラメタを指定してプロジェクトを生成する
     * @param id プロジェクトID
     * @param name プロジェクト名
     * @param deptId 組織ID
     * @param difficultyCode 難易度。難易度指定されない場合はNULLとする
     */
    public Project(@Nonnull Long id, @Nonnull String name, @Nonnull Long deptId, @Nullable String difficultyCode) {
        this.id = id;
        this.name = name;
        this.deptId = deptId;
        this.difficulty = setDiff(difficultyCode);
    }

    /**
     * プロジェクト登録時のコンストラクター。IDは空欄。 <br/>
     * 新規登録以外なら利用禁止となるため、Factoryパターンを利用してprivateとする
     * @param name プロジェクト名
     * @param deptId 組織ID
     * @param difficultyCode 難易度。難易度指定されない場合はNULLとする
     */
    private Project(@Nonnull String name, @Nonnull Long deptId, @Nullable String difficultyCode) {
        this.name = name;
        this.deptId = deptId;
        this.difficulty = setDiff(difficultyCode);


    }

    /**
     * 更新用のプロジェクトエンティティを生成する
     * @param id ID
     * @param difficultyCode 難易度コード
     */
    private Project(@Nonnull Long id, @Nonnull String difficultyCode) {
        this.id = id;
        this.difficulty = setDiff(difficultyCode);
    }

    //================
    // メソッド

    /**
     * 新規プロジェクトを登録する時、IDなしのプロジェクトを生成するFactoryメソッド
     * @param name プロジェクト名
     * @param deptId 組織ID
     * @param difficultyCode 難易度。難易度指定されない場合はNULLとする
     * @return 生成されたプロジェクト
     */
    @Nonnull
    public static Project registerNewProject(@Nonnull String name, @Nonnull Long deptId, @Nullable String difficultyCode) {
        return new Project(name, deptId, difficultyCode);
    }

    /**
     * プロジェクト難易度を更新する際に、専用エンティティを生成するFactoryメソッド
     * @param id ID
     * @param difficultyCode 難易度
     * @return 生成された更新用エンティティ
     */
    @Nonnull
    public static Project updateProject(@Nonnull Long id, @Nonnull String difficultyCode) {
        return new Project(id, difficultyCode);
    }

    //================
    // 私用メソッド

    /**
     * コードに基づいて、難易度を設定する
     * <p> コードがからの値なら、nullを返す</p>
     * @param difficultyCode コード
     * @return 難易度
     */
    @Nullable
    private Codes.ProjectDifficultyEnum setDiff(String difficultyCode) {
        if (StringUtils.isEmpty(difficultyCode)) {
            return null;
        }

        return CodeEnum.getEnum(Codes.ProjectDifficultyEnum.class, difficultyCode);
    }
}
