SpringBoot_テストリポジトリ

## Qiita での記載内容

#### GET・POSTの実装

https://qiita.com/NagaJun/items/dfa9f8606b64593a11db

#### JSON でのリクエスト、レスポンス

https://qiita.com/NagaJun/items/4adf80d2bcd931938fe8


#### docker コマンド
〇イメージの作成
```
docker build --build-arg JAR_FILE=build/libs/test_spring_boot-0.0.1-SNAPSHOT.jar -t test_spring_boot .
```
※ビルドによって生成された`.jar`が`test_spring_boot-0.0.1-SNAPSHOT.jar`である場合のコマンド。

〇コンテナの起動
```
docker run -p 8081:8080 test_spring_boot
```
※コンテナ内の`spring boot アプリ`はポート`8080`で稼働し、ローカル環境では`http://localhost:8081`で接続できる様になる。

