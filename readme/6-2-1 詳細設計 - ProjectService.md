# 6-2-1 詳細設計 - ProjectService

## Package

`jp.snowday.tutorial.demo.domain.project.ProjectService`

## 責務

- ドメインのビジネスロジックを遂行する

## クラスアノテーション

- `@Service`

## DI

```Java
@Autowired
private ProjectRepository projectRepository;
```

## プロジェクト一覧取得メソッド

- 処理を `projectRepository` に委譲し、返却値をそのまま返却

- Method Signatureの一例

  ```Java
  public List<Project> getAllProjects() {
          //処理はここ
  }
  ```