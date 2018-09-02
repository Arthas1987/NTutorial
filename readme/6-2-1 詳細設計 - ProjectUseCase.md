# 6-2-1 詳細設計 - ProjectUseCase

## Package

`jp.snowday.tutorial.demo.usecase.ProjectUseCase`

## 責務

- プロジェクト新規登録やプロジェクト一覧取得などの機能を実現するためのユースケース
- トランザクション管理の対象

## クラスアノテーション

- `@Service`
- `@Transactional(rollbackFor = Exception.class)`

## DI

```Java
@Autowired
private ProjectService projectService;
```

## プロジェクト一覧取得メソッド

- 処理を `projectService` に委譲し、返却値をそのまま返却

- Method Signatureの一例

  ```Java
  public List<Project> getAllProjects() {
          //処理はここ
  }
  ```
