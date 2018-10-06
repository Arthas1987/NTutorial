package jp.snowday.tutorial.demo.infrastructure.persistence.mysql.mybatis.mapper;

import jp.snowday.tutorial.demo.infrastructure.persistence.mysql.mybatis.entity.Sequence;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

import javax.annotation.Nonnull;

@Mapper
public interface SequenceMapper {

    @Results(value = {
            @Result(column = "curr")
    })
    @Select("Select currseq(#{seqName}) AS curr")
    Long currnetSeq(@Nonnull @Param("seqName") String seqName);


    @Insert("call nextseq(#{seqName, mode=IN, jdbcType=VARCHAR, javaType=String}, #{value,mode=OUT,jdbcType=INTEGER})")
    @Options(statementType = StatementType.CALLABLE)
    void nextSeq(Sequence seqName);
}
