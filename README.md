# manage to coupon web Page
>3학년 겨울방학에 진행하는 개인 프로젝트<br>

## project purpose
동아리 회원 정보를 입력받으면 DB에 저장하는 프로젝트
- 회원 정보 CRUD (진행 중)
- REST API json 파일로 문서화
- password 암호화 (Spring Security)

## develop environment
### JDK (Java Development Kit)
- Java 1.8.x

### Server (Controller)
- Spring Boot

### Database (Model)
- MariaDB
- Lombok plugin
- JPA

#### 테이블 설계
![DB테이블](./image/databasetable.jpg)

### Front-End (View)
- jsp
- CSS (bootstrap)
- javascript

#### manageMember.html
![회원관리](./image/managemember.jpg)

## Dependency
|dependency|Version|
|:------:|:---:|
|**Server**||
|SpringBoot|2.2.2 RELEASE|
|**TEST**||
|junit|-|
|**Database**||
|JPA|2.2.2.RELEASE|
|Lombok|1.18.10|
|Mariadb.jdbc|2.5.2|
|**front-end**||
|JSTL|1.2|
<br>[의존성 참고](https://mvnrepository.com/)

## API Specification
JSON 파일로 REST API 명세서 작성 예정


## todolist
- [x] project 개발 환경 셋팅 (2019-12-16)
- [x] mamagemember.html bootstrap, css 이용하여 디자인 (2019-12-17)
- [x] Database 테이블 설계 (2019-12-17)
- [X] user CRUD 작업 (2019-12-19)
- [ ] 게시글 10개 단위로 보여주기
- [ ] REST API JSON 파일로 파싱하는 방법 공부
- [ ] REST API 명세서 작성