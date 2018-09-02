# 6-2-1 詳細設計 - ProjectController

## Package

`jp.snowday.tutorial.demo.presentation.controller.ProjectController`

## 責務

- Url Mapping
- リクエストを受け入れ、処理の結果をJSONとして返却

## クラスアノテーション

- `@RestController`

## DI

```Java
@Autowired
private ProjectUseCase projectUseCase;
```

## プロジェクト一覧取得メソッド

- 処理を`projectUseCase` に委譲し、返却値をそのまま返却

- Method Signatureの一例

  ```Java
  public List<Project> getAllProjects() {
          //処理はここ
  }
  ```
