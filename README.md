# Dagger2を活用してAndroid SDKの依存関係をクリーンにする
## DroidKaigi 2018 Day2 14:00～ Room1

発表用のサンプルコードです。

## パッケージ構造

+ /app - アプリケーション層、UseCaseがここにある
+ /data - データ層、API通信のEntityとインターフェース（今回はモック）
+ /di - DI用のComponentやModule置き場
+ /infra - インフラストラクチャ層、もろもろのラッパーがここに
+ /view - ビュー層
    - /ui - Activity/Fragment、ViewModelはここ
    - /widget - View関連はここ
