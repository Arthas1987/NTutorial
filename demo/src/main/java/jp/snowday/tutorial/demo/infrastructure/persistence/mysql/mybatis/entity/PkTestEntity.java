package jp.snowday.tutorial.demo.infrastructure.persistence.mysql.mybatis.entity;


import jp.snowday.tutorial.demo.infrastructure.util.annotation.Column;
import lombok.Getter;
import lombok.Setter;

/**
 * 簡単なシーケンテスト用テーブル
 * @author snowday
 * @date 2018-10-6
 */
public class PkTestEntity {
    @Getter
    @Setter
    @Column(name = "id")
    private String id;

    @Getter
    @Setter
    @Column(name = "hoge")
    private String hoge;
}
