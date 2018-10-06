package jp.snowday.tutorial.demo.usecase;

import jp.snowday.tutorial.demo.infrastructure.persistence.mysql.mybatis.entity.PkTestEntity;
import jp.snowday.tutorial.demo.infrastructure.persistence.mysql.mybatis.entity.Sequence;
import jp.snowday.tutorial.demo.infrastructure.persistence.mysql.mybatis.mapper.PkTestMapper;
import jp.snowday.tutorial.demo.infrastructure.persistence.mysql.mybatis.mapper.SequenceMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * シーケンスをテストするユースケース
 * @author snowday
 * @date 2018-10-6
 */
@Service
@AllArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class PkTestUseCase {
    private SequenceMapper sequenceMapper;
    private PkTestMapper pkTestMapper;

    public List<PkTestEntity> selfIncrement() {

        Sequence seq = new Sequence();
        seq.setSeqName("seq_id_table1");
        sequenceMapper.nextSeq(seq);

        PkTestEntity e = new PkTestEntity();
        e.setId(String.format("CC%08d", seq.getValue()));
        e.setHoge(seq.getValue().toString());

        pkTestMapper.add(e);
        return pkTestMapper.getAll();
    }


    public Long getCurrentVal() {
        return sequenceMapper.currnetSeq("seq_id_table1");
    }
}
