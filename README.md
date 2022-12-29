# 개발 환경 만들기

## 과제 1. IntelliJ IDE 설치
#### 학생은 IntelliJ Ultimate 라이센스 얻을 수 있으니 가능하면 엔터프라이즈 추천합니다.
[IntelliJ 학생 라이센스 관련 링크](https://www.jetbrains.com/ko-kr/community/education/#students)

###### IntelliJ Ultimate 라이센스가 안되면 IntelliJ Community 버전 설치 하세요.

[IntelliJ 다운로드 페이지](https://www.jetbrains.com/ko-kr/idea/download/#section=windows)

###### 오른쪽에 있는 Ultimate 또는 Community 버전 받으시면 됩니다.

## 과제 2. 인프라 환경 만들기
#### 현재 사용하고 있는 컴퓨터에 도커(Docker)환경을 구성해 주세요.

[Docker Desktop 다운로드 페이지](https://docs.docker.com/desktop/windows/install/)

###### 위 링크에서 Docker Desktop for 자신의 운영체제 버튼을 눌러 설치해 주세요.

## 과제 3. 현재 저장소를 클론해서 테스트 실행해보기
#### 도커 실행 해서 MariaDB 실행 하기
```shell
$ ./gradlew.bat clean build startDocker # linux or mac -> ./gradlew startDocker 
# 도커 실행 성공 로그
> Task :startDocker
Network infra_test-network  Creating
Network infra_test-network  Created
Container local-mariadb  Creating
Container local-mariadb  Created
Container skku-app  Creating
Container skku-app  Created
Container local-mariadb  Starting
Container local-mariadb  Started
Container skku-app  Starting
Container skku-app  Started

BUILD SUCCESSFUL in 1s
1 actionable task: 1 executed

```

#### 애플리케이션 도커 로그 보기 
```shell
$ ./gradlew logDocker

# 도커 전체 로그 조회

> Task :logDocker
local-mariadb  | 2022-12-27 07:46:12+00:00 [Note] [Entrypoint]: Entrypoint script for MariaDB Server 1:10.6.8+maria~focal started.
local-mariadb  | 2022-12-27 07:46:13+00:00 [Note] [Entrypoint]: Switching to dedicated user 'mysql'
local-mariadb  | 2022-12-27 07:46:13+00:00 [Note] [Entrypoint]: Entrypoint script for MariaDB Server 1:10.6.8+maria~focal started.
local-mariadb  | 2022-12-27 07:46:13+00:00 [Note] [Entrypoint]: Initializing database files

이하 생략
```


#### 애플리케이션 테스트 실행해보기 
```shell
$ ./gradlew.bat clean test # linux or mac -> ./gradlew clean test

# 애플리케이션 테스트 성공 로그
> Task :test
2022-12-26 00:11:33.219  INFO 21202 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2022-12-26 00:11:33.230  INFO 21202 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.

BUILD SUCCESSFUL in 3s
5 actionable tasks: 5 executed
```

### 위 내용까지 완료 되었으면 DB 연동 까지 완료 했습니다.

## 실패시 확인 사항

#### 1. 도커가 제대로 설치 되었는가?
###### 도커데스크탑 설치 필요[다운로드 링크](https://www.docker.com/products/docker-desktop/) 
#### 2. JDK17이 설치되었는가?
###### JDK17은 현재 시점 (2022년) LTS버전으로 앞으로 오랫동안 사용될 버전 추측 됨 ([참고 링크](https://techblog.gccompany.co.kr/%EC%9A%B0%EB%A6%AC%ED%8C%80%EC%9D%B4-jdk-17%EC%9D%84-%EB%8F%84%EC%9E%85%ED%95%9C-%EC%9D%B4%EC%9C%A0-ced2b754cd7))
###### JDK17은 는 Eclipse Temurin([다운로드 링크](https://adoptium.net/)) 또는 Amazon Corretto([다운로드 링크](https://aws.amazon.com/ko/corretto)) 설치
#### 그 이외의 문제는 자세한 상황과 함께 슬랙으로 알려주세요. 
