package jp.snowday.tutorial.demo.presentation.controller;

import jp.snowday.tutorial.demo.infrastructure.persistence.mysql.mybatis.entity.PkTestEntity;
import jp.snowday.tutorial.demo.usecase.PkTestUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PkController {
    private PkTestUseCase pkTestUseCase;

    @GetMapping("/add/")
    public List<PkTestEntity> add() {
        return pkTestUseCase.selfIncrement();
    }

    @GetMapping("/cur/")
    public Long current() {
        return pkTestUseCase.getCurrentVal();
    }
}
