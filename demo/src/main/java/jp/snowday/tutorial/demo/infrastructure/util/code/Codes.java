package jp.snowday.tutorial.demo.infrastructure.util.code;

import javax.annotation.Nonnull;

/**
 * Enumの集合
 * @author zhangnan
 * @date 2018/8/19
 */
public final class Codes {
    public enum ProjectDifficultyEnum implements CodeEnum<ProjectDifficultyEnum> {
        /**
         * デフォルトで三つ難易度を用意する
         */
        EASY("EASY", "簡単"),
        NORMAL("NORMAL", "普通"),
        HARD("HARD", "難しい");

        private String code;
        private String name;

        /**
         * デフォルトコンストラクター
         * @param code コード値
         * @param name 表示名
         */
        ProjectDifficultyEnum(@Nonnull String code, @Nonnull String name) {
            this.code = code;
            this.name = name;
        }

        @Override
        public String getCode() {
            return this.code;
        }

        @Override
        public String getName() {
            return this.name;
        }
    }
}
