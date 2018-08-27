package jp.snowday.tutorial.demo.infrastructure.persistence.mysql.mybatis.mapper;

import jp.snowday.tutorial.demo.infrastructure.persistence.mysql.mybatis.entity.DepartmentEntity;
import org.apache.ibatis.annotations.*;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * 組織テーブルのMapperクラス
 * @author zhangnan
 * @date 2018/08/28
 */
@Mapper
public interface DepartmentMapper {

    /**
     * 組織IDをキーにして、組織を取得する
     * @param id 組織ID
     * @return 組織エンティティ
     */
    @Nullable
    @Results(value = {
            @Result(id=true, column="dept_id", property="deptId")
            ,@Result(column="dept_nm", property="deptName")
    })
    @Select("select dept_id, dept_nm from DEPT where dept_id = #{id}")
    DepartmentEntity findById(@Nonnull @Param("id") Long id);
}
