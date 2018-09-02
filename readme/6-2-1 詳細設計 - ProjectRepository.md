# 6-2-1 詳細設計 - ProjectRepository

## Package

`jp.snowday.tutorial.demo.domain.project.ProjectRepository`

## 責務

- Projectドメインのデータ操作を定義する `interface`
- 実装はしない
- Infrastructureレイヤーが `implement`する

## Method Signature

`List<Project> findAll();`

