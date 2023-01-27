# GeunTae_hobby 개인 프로젝트

- 현재까지 내가 좋아한 게임의 업적 및 사진을 표시한 프로젝트

## 1. 사용한 기술 스택

|Architecture|Library|
|:------:|---|
|언어|Kotlin, Coroutine|
|아키텍처|MVVM|
|DI|Dagger-Hilt|
|AAC|DataBinding, LiveData, DataBinding, Room, ViewModel, Lifecycles, Navigation, WorkManager, Glide, RecyclerView DiffUtil, BindingAdapter, ViewPager2|
|DB|Firebase RealTime DB|
|네트워크|Retrofit, OkHttp|
|개발 툴|git, Android Studio|

<br>

## 2. 데이터 베이스 구조 설계
- 각 ```Json```의 데이터를 ```respones```를 만들어서 파이어베이스의 리얼타임에 추가하여 파싱해서 가져오도록 설계

![Untitled](https://user-images.githubusercontent.com/80413888/213824714-5fe3bfbf-0566-44b4-9545-06e93fbc46ea.png)

<br>

## 3. 폴더링 구조

```
🔖
.
├── common
├── di
├── model
├── network
├── repository
│   ├── DataSoruce
│   └── Repository
│
├──ui
│  ├── Adapter
│  ├── Fragment
│  ├── ViewModel
│  └──commone
│      ├── BindingAdapter
│      ├── DiffCallback
│      ├── Event
│      ├── ClickListenr
│      └── Adapter
│ 
.
    
``` 
<br>

## 4. Navigation 설계
- 하단에 메뉴틀 만들어서 각 프로그맨트에 네비게이션으로 구성

<img width="685" alt="スクリーンショット 2023-01-20 17 23 43" src="https://user-images.githubusercontent.com/80413888/213824660-a8150fdc-ec7b-46ac-b160-e6b22da1ad26.png">

<br>

## 5. 앱 UI

|홈|카테고리|
|------|---|
|![330700](https://user-images.githubusercontent.com/80413888/213951471-a5a0ead4-e27d-4bd2-b169-b14ee52b4c17.gif)|![3307002](https://user-images.githubusercontent.com/80413888/213951733-3361552d-6789-44b8-8583-4ffbbc7c96fe.gif)|

|셋팅|
|------|
|![3307003](https://user-images.githubusercontent.com/80413888/213951737-952bd80c-5669-4ddb-a828-fa4437c6d67c.gif)|

<br>
<br>

## 6. 성과
- Json형태로 레트로핏을 파싱하여 파이어베이스로 설정하는 경험
- Android 아키텍처 컴포넌트 학습 및 실습
- DI를 설정하여 데이터소스에 의존성 주입을 설정하여 확장을 쉽게 설정, 뷰모델에 팩토리 패턴을 추가하지 않고 DI로 처리하는 경험








