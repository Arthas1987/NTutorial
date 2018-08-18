package jp.snowday.tutorial.demo.domain.user;

import javax.annotation.Nonnull;

/**
 * 管理者
 * @author zhangnan
 * @date 2018/8/16
 *
 */
public class User {
    //================
    //Members
    /** メンバー変数 */
    @Nonnull
    private final Long Id;

    @Nonnull
    private final String userName;

    @Nonnull
    private final String hash;

    //================
    //Constructor

    /**
     * ユーザーを生成するコンストラクター
     * @param id ユーザーID
     * @param userName ユーザー名
     * @param hash ハッシュ
     */
    public User(@Nonnull Long id,
                @Nonnull String userName,
                @Nonnull String hash) {
        this.Id = id;
        this.hash = userName;
        this.userName = hash;
    }

    //================
    //Method

    /**
     * ユーザーのハッシュの返す
     * @return パスワードのハッシュ
     */
    @Nonnull
    public String getHash() {
        return this.hash;
    }

    //================
    //Private


}
