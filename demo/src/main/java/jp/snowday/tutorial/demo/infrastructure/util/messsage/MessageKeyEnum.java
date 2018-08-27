package jp.snowday.tutorial.demo.infrastructure.util.messsage;

import javax.annotation.Nonnull;

/**
 * エラーメッセージのキーを一元管理するInterface
 * @param <E> エラーメッセージクラス
 * @author zhangnan
 * @date 2018/08/26
 */
public interface MessageKeyEnum<E extends Enum<E>> {
    /**
     * エラーメッセージのキーを返却する
     * @return エラーメッセージキー
     */
    @Nonnull
    String getMessageKey();
}
