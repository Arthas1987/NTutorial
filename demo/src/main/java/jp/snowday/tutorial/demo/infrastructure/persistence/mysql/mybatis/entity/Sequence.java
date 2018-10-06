package jp.snowday.tutorial.demo.infrastructure.persistence.mysql.mybatis.entity;

import lombok.Getter;
import lombok.Setter;

public class Sequence {
    @Getter
    @Setter
    private String seqName;

    @Getter
    @Setter
    private Long value;
}
