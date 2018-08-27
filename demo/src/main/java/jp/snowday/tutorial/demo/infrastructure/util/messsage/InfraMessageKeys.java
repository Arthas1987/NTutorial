package jp.snowday.tutorial.demo.infrastructure.util.messsage;

import javax.annotation.Nonnull;

/**
 * 共通処理関連エラーメッセージ
 * @author zhangnan
 * @date 2018/08/26
 */
public enum InfraMessageKeys implements MessageKeyEnum<InfraMessageKeys>{
    /** 楽観排他エラー */
    OPTIMISTIC_EXCLUSIVE_ERROR("common.businesslogic.err.exclusive");
    /** エラーメッセージキー */
    private String key;

    InfraMessageKeys(@Nonnull String key) {
        this.key = key;
    }


    @Override
    @Nonnull
    public String getMessageKey() {
        return key;
    }
}
