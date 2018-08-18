package jp.snowday.tutorial.demo.infrastructure.util.codeenum;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Enumクラスの抽象クラス
 * @author zhangnan
 * @date 2018/8/18
 */
public interface CodeEnum<E extends Enum<E>> {

    /**
     * Enumのコード値を返却する
     * @return コード値
     */
    String getCode();

    /**
     * Enumの名称を返却する
     * @return 名称
     */
    String getName();

    /**
     * Enumに変換する
     * @return 変換されたEnum
     */
    @SuppressWarnings("unchecked")
    default E toEnum() {
        return (E) this;
    }

    /**
     * コード値が同一かどうかをチェックする
     * @param code Enumのコード値
     * @return true(コード値同じ) / false(コード値異なる)
     */
    default boolean equalsByCode(@Nonnull String code) {
        return getCode().equals(code);
    }

    /**
     * 指定されたCodeEnumを実装したEnumの、指定されたコード値の列挙子を返却する
     * @param clazz 指定されたクラス
     * @param code コード値
     * @param <E> 拡張されたEnumクラス
     * @return 取得されたEnumクラス
     */
    @Nullable
    static <E extends Enum<E>> E getEnum(@Nonnull Class<? extends CodeEnum<E>> clazz, @Nonnull String code) {
        return Arrays.stream(clazz.getEnumConstants())
                .filter(e -> e.equalsByCode(code))
                .map(CodeEnum::toEnum)
                .findFirst()
                .orElse(null);
    }

    /**
     * 指定されたCodeEnumのコード値をキー、コード値に該当するCodeEnumを値に持つMapを返却する
     * @param clazz 指定されたクラス
     * @param <E> 指定されたクラス
     * @return CodeEnumのコード値をキー、コード値に該当するCodeEnumを値に持つMap
     */
    @Nonnull
    static <E extends Enum<E>> Map<String, E> getMap(@Nonnull Class<? extends CodeEnum<E>> clazz) {
        return Arrays.stream(clazz.getEnumConstants())
                .collect(Collectors.toMap(CodeEnum::getCode, CodeEnum::toEnum));
    }

    /**
     * 指定されたCodeEnumに、指定されたコード値を持つ列挙子が存在するかチェックする
     * @param clazz クラス
     * @param code コード値
     * @param <E> Enumクラス
     * @return true(存在する) / false(存在しない)
     */
    static <E extends Enum<E>> boolean hasCode(@Nonnull Class<? extends CodeEnum<E>> clazz, @Nonnull String code) {
        return Arrays.stream(clazz.getEnumConstants())
                .anyMatch(e -> e.equalsByCode(code));
    }
}
