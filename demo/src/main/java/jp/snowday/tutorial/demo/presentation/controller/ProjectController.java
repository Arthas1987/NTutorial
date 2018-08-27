package jp.snowday.tutorial.demo.presentation.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jp.snowday.tutorial.demo.domain.project.Project;
import jp.snowday.tutorial.demo.presentation.form.CreateProject;
import jp.snowday.tutorial.demo.usecase.ProjectUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.websocket.server.PathParam;
import java.util.List;


/**
 * プロジェクト関連のController
 * @author zhangnan
 * @date 2018/08/26
 */
@RestController
@AllArgsConstructor
@RequestMapping(ProjectController.BASE_URL)
@Api(value = ProjectController.BASE_URL, produces = "application/json", consumes = "application/json")
public class ProjectController {

    private ProjectUseCase projectUseCase;

    //FIXME: URLを外で管理したい・・
    /** 基礎URL */
    static final String BASE_URL = "/projects";

    //===================
    //URL Mapping
    @GetMapping
    @ApiOperation(value="登録されている全プロジェクトを取得する"
                    ,notes="登録されている全プロジェクトを取得する"
                    ,response = Project.class
                    ,responseContainer = "List")
    @ApiParam(hidden = true)
    public List<Project> getAllProjects() {
        return projectUseCase.getAllProjects();
    }

    @GetMapping("/{id}/")
    @ApiOperation(value="URLに指定されてるプロジェクトIDに持っているプロジェクトを取得する"
                    ,notes="プロジェクトのPK(プロジェクトID)で、DBからプロジェクトを指定する"
                    ,response = Project.class)
    public Project getProjectById(
            @ApiParam(value="プロジェクトID", required = true)
            @PathVariable(value = "id") @Nonnull String id) {
        return projectUseCase.getProjectById(id);
    }

    @PostMapping
    @ApiOperation(value="新しいプロジェクトを生成する"
            ,notes="JSONで指定されたパスで、プロジェクトを新規作る。実施後、すでに登録されているプロジェクトを全部取得して返却する"
            ,response = Project.class
            ,responseContainer = "List")
    public List<Project> createNewProject(
            @ApiParam(value="プロジェクトクラスに相当するJSON", required = true)
            @RequestBody @Nullable CreateProject prj) {
        projectUseCase.createProject(prj);

        return projectUseCase.getAllProjects();
    }

    @DeleteMapping("/{id}/")
    @ApiOperation(value="IDを指定して、プロジェクトを削除する"
            ,notes="IDを指定して、プロジェクトを削除する。<br>削除後、すでに登録されているプロジェクトを全部取得して返却する"
            ,response = Project.class
            ,responseContainer = "List")
    public List<Project> deleteProjectById(
            @ApiParam(value="プロジェクトID", required = true)
            @PathVariable(value = "id") @Nonnull String id) {
        projectUseCase.deleteProject(id);

        return projectUseCase.getAllProjects();
    }

    @PutMapping("/{id}/")
    @ApiOperation(value="URLに指定されてるプロジェクトIDに対して、難易度を更新する"
            ,notes="更新後、更新されたプロジェクト対象を返却する"
            ,response = Project.class)
    public Project updateProjectDifficulty(
            @ApiParam(value="プロジェクトID", required = true)
            @PathVariable(value = "id") @Nonnull String id,

            @ApiParam(value="プロジェクトクラスに相当するJSON", required = true)
            @RequestBody @Nonnull CreateProject prj) {
        projectUseCase.updateProjectDifficulty(id, prj.getDifficultyCode());

        return projectUseCase.getProjectById(id);
    }
}
