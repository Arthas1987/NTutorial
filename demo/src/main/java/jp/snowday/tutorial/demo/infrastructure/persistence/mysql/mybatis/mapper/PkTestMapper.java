package jp.snowday.tutorial.demo.infrastructure.persistence.mysql.mybatis.mapper;

import jp.snowday.tutorial.demo.infrastructure.persistence.mysql.mybatis.entity.PkTestEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PkTestMapper {
    @Insert("Insert into id_table1(id, hoge) values(#{id}, #{hoge})")
    void add(PkTestEntity entity);

    @Select("Select id, hoge from id_table1")
    List<PkTestEntity> getAll();
}
