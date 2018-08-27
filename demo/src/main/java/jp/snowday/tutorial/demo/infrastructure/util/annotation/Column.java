package jp.snowday.tutorial.demo.infrastructure.util.annotation;

/**
 * 対応しているDBカラムのアノテーション
 * <p>今は実効果ないが・・・</p>
 *
 * @author zhangnan
 * @date 2018/08/26
 */
public @interface Column {
    String name() default "";
}
