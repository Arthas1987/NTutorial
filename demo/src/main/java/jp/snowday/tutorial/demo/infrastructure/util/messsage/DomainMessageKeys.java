package jp.snowday.tutorial.demo.infrastructure.util.messsage;

import javax.annotation.Nonnull;

/**
 * ドメイン内でのエラーメッセージ
 * @author zhangnan
 * @date 2018/08/26
 */
public final class DomainMessageKeys {
    public enum Project implements MessageKeyEnum<Project>{
        /** 無効な組織コード */
         ERROR_INVALID_DEPARTMENT_ID("domain.project.err.invalidDepartmentId")
        ,ERROR_INVALID_PROJECT_BODY("domain.project.err.invalidProjectBody");
        private String key;

        Project(@Nonnull String key) {
            this.key = key;
        }

        @Override
        public String getMessageKey() {
            return key;
        }
    }
}
