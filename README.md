# 프로젝트명 : 404WeFound

배포 url: http://404wefound.com:8080
---
## 1. 개요

### 팀원 소개 및 역할분배

- 강석찬 : 요구사항 및 기능 명세 / 로그인과 유저 설계 및 답변과 등급을 위한 점수 구현
- 고경욱 : 참고문서 수집 및 정리, ERD작성 / ERD 및 산출물 개선/ 좋아요 기능 구현/TDD 코드 작성 및 테스트
- 김정용 : 와이어 프레임, 사이트맵 작성 / 게시판 CRUD 구현/ 질문에 대한 댓글 구현 / 렌더링 처리
- 백승진 : 깃 설정, 컨벤션, 일정, 기능정의 / 회원 권한 및 관리자 페이지 구현 / 베포 환경 준비 및 ppt작성

### 무엇을 만드나요?

저희는 개발 과정에서 여러 어려움을 겪게 되는 개발자와 학생들을 위해,
질문과 답변을 공유하고 토론할 수 있는 지식 공유 플랫폼을 만들고자 합니다.
이런 플랫폼을 통해 문제 해결 시간을 단축하고 효율성을 높일 수 있습니다.
또한 개발자와 학생들의 경험과 지식을 공유함으로써 개발 역량을 향상시킬 수 있으며,
협력적인 개발 문화를 조성하여, 개발자와 학생들 간의 네트워크를 강화할 수 있습니다.

### 왜 "404WeFound" 인가요?

‘404WeFound’는 흔히 볼 수 있는 404 Not Found에서 가운데 Not만 We로 바꾸어서 지었습니다.
***
## 2. 개발 목표 및 내용

### 시스템 구성

- 웹 기반 플랫폼으로 개발
- Data Flow Software Architectures 첨부 예정

### 프로젝트 설정

- 운영체제: Windows 10, macOS
- 개발 언어: Java, JavaScript, HTML, CSS
- 프론트엔드: HTML, CSS, JavaScript
- 백엔드: Spring, Spring Data JPA
- 데이터베이스: H2, Mysql
- 배포환경: AWS EC2, RDS
- 협업도구: Git, GitHub, Notion, erdcloud, Discord

### 개발 범위(요구사항)

- 회원 관리 기능 (회원가입, 아이디/비밀번호 찾기, 프로필 조회, 내 정보 페이지, 계정 삭제)
- 게시판 기능 (질문 작성, 답변 작성, 댓글 조회/생성/삭제/수정, 게시글 정렬, 필터링, 검색)
- 등급 및 점수 시스템 (답변 채택 시 점수 부여, 좋아요 받을 시 점수 부여, 등급 부여, 등급순위)

### 데이터베이스 모델링 ERD

![project_erd](https://github.com/Team-404WeFound/404WeFound/blob/develop/src/main/resources/static/img/project_erd2.png)

### API 명세서 (표 정리해서 이미지로 진행)
#### 1. User
##### 1.1 회원가입

request :

  ```json
POST /api/users
  {
    "email": "user@example.com",
    "password": "password123",
    "nickname": "oreumi"
  } 
  ```
response :
```json
{
  "user_id": 1,
  "email": "user@example.com",
  "nickname": "oreumi"
}
```
##### 1.2 로그인
request :
```json
POST /api/users/login
{
  "email": "user@example.com",
  "password": "password123"
}
```
response :
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```
##### 1.3 사용자 정보 조회
request :

```json
GET /api/users/{userId}
Authorization: Bearer {token}
```
response :
```json
{
  "user_id": 1,
  "email": "user@example.com",
  "nickname": "oreumi"
}
```
#### 1.4 사용자 정보 수정
request :
```json
PUT /api/users/{userId}
Authorization: Bearer {token}

{
  "nickname": "oreumi",
  "password": "newpassword123"
}
```
response :
```json
{
  "user_id": 1,
  "email": "user@example.com",
  "nickname": "oreumi"
}
```
##### 1.5 회원 탈퇴
request :
```json
DELETE /api/users/{userId}
Authorization: Bearer {token}
```
response :
```json
HTTP/1.1 204 No Content
```

#### 2. Question)
##### 2.1 질문 생성
request :
```json
POST /api/questions
Authorization: Bearer {token}

{
  "title": "Question Title",
  "content": "Question Content"
}
```
response :
```json
{
  "question_id": 1,
  "title": "Question Title",
  "content": "Question Content",
  "userId": 1,
  "createdAt": "2023-06-08T10:30:00Z",
  "updatedAt": "2023-06-08T10:30:00Z"
}
```
##### 2.2  질문 목록 조회
request :
```json
GET /api/questions?page=1&size=10
```
response :
```json

{
  "content": [
    {
      "question_id": 1,
      "title": "Question Title 1",
      "content": "Question Content 1",
      "userId": 1,
      "createdAt": "2023-06-08T10:30:00Z",
      "updatedAt": "2023-06-08T10:30:00Z"
    },
    {
      "question_id": 2,
      "title": "Question Title 2",
      "content": "Question Content 2",
      "userId": 2,
      "createdAt": "2023-06-08T11:00:00Z",
      "updatedAt": "2023-06-08T11:00:00Z"
    }
  ],
  "pageable": {
    "pageNumber": 1,
    "pageSize": 10,
    "sort": {
      "sorted": false,
      "unsorted": true,
      "empty": true
    }
  },
  "totalPages": 1,
  "totalElements": 2,
  "last": true,
  "size": 10,
  "number": 0,
  "sort": {
    "sorted": false,
    "unsorted": true,
    "empty": true
  },
  "numberOfElements": 2,
  "first": true,
  "empty": false
}
```
##### 2.3 질문 상세 조회
request :
```json
GET /api/questions/{questionId}
```
response : (ex : questionId == 1)
```json
HTTP/1.1 200 OK
Content-Type: application/json

{
  "question_id": 1,
  "title": "Question Title",
  "content": "Question Content",
  "userId": 1,
  "createdAt": "2023-06-08T10:30:00Z",
  "updatedAt": "2023-06-08T10:30:00Z"
}
```
##### 2.4 질문 수정
request :
```json
PUT /api/questions/{questionId}
Authorization: Bearer {token}

{
  "title": "Updated Question Title",
  "content": "Updated Question Content"
}
```
response :
```json
{
  "question_id": 1,
  "title": "Updated Question Title",
  "content": "Updated Question Content",
  "userId": 1,
  "createdAt": "2023-06-08T10:30:00Z",
  "updatedAt": "2023-06-08T11:30:00Z"
}
```

##### 2.5 질문 삭제
```json
DELETE /api/questions/{questionId}
Authorization: Bearer {token}
```
response :
```json
HTTP/1.1 204 No Content

```
#### 3. Answer)
##### 3.1 답변 생성
request :
```json
POST /api/questions/{questionId}
Authorization: Bearer {token}

{
  "content": "Answer Content"
}
```
response :
```json
{
  "answer_id": 1,
  "content": "Answer Content",
  "userId": 1,
  "questionId": 1,
  "createdAt": "2023-06-08T12:00:00Z",
  "updatedAt": "2023-06-08T12:00:00Z"
}
```
##### 3.2 답변 목록 조회
request :
```json
GET /api/questions/{questionId}/answers?page=1&size=10
```
response :
```json
{
  "content": [
    {
      "answer_id": 1,
      "content": "Answer Content 1",
      "userId": 1,
      "questionId": 1,
      "createdAt": "2023-06-08T12:00:00Z",
      "updatedAt": "2023-06-08T12:00:00Z"
    },
    {
      "answer_id": 2,
      "content": "Answer Content 2",
      "userId": 2,
      "questionId": 1,
      "createdAt": "2023-06-08T12:30:00Z",
      "updatedAt": "2023-06-08T12:30:00Z"
    }
  ],
  "pageable": {
    "pageNumber": 1,
    "pageSize": 10,
    "sort": {
      "sorted": false,
      "unsorted": true,
      "empty": true
    }
  },
  "totalPages": 1,
  "totalElements": 2,
  "last": true,
  "size": 10,
  "number": 0,
  "sort": {
    "sorted": false,
    "unsorted": true,
    "empty": true
  },
  "numberOfElements": 2,
  "first": true,
  "empty": false
}
```
##### 3.3 답변 상세 조회
request :
```json
GET /api/answers/{answerId}
```
response :
```json
{
  "answer_id": 1,
  "content": "Answer Content",
  "userId": 1,
  "questionId": 1,
  "createdAt": "2023-06-08T12:00:00Z",
  "updatedAt": "2023-06-08T12:00:00Z"
}
```
##### 3.4 답변 수정
request :
```json
PUT /api/answers/{answerId}
Authorization: Bearer {token}

{
  "content": "Updated Answer Content"
}
```
response :
```json
{
  "answer_id": 1,
  "content": "Updated Answer Content",
  "userId": 1,
  "questionId": 1,
  "createdAt": "2023-06-08T12:00:00Z",
  "updatedAt": "2023-06-08T13:00:00Z"
}
```
##### 답변 삭제
request :
```json
DELETE /api/answers/{answerId}
Authorization: Bearer {token}
```
response :
```json
HTTP/1.1 204 No Content

```
### TDD 이미지
![TDD_1](https://github.com/Team-404WeFound/404WeFound/blob/docs/readme/src/main/resources/static/img/TDD_1.jpg)
![TDD_2](https://github.com/Team-404WeFound/404WeFound/blob/docs/readme/src/main/resources/static/img/TDD_2.jpg)
### 개발 시간

- 3/22 ~ 3/26 (기획 및 설계) 프로젝트 주제를 설정하고 주제에 대한 요구사항을 파악하고 ERD설계 및 깃 설정을 진행했습니다.

- 3/27 ~ 4/4 (백엔드 구현) 엔티티, 컨트롤러, 서비스, 레포지토리 파일들을 만들고 ERD 설계대로 필요한 테이블과 구현 코드들을 작성함으로써 프로젝트를 진행했습니다.

- 4/5 ~ 4/6 (프론트엔드 구현) 구현한 벡엔드를 기준으로 프론트엔드를 작성해서 실제 url에서 실행되는 것을 보여줄 수 있습니다.

- 4/7 ~ 4/8 (테스트 및 배포 준비) 완성된 프로젝트를 테스트 함으로써 버그 수정을 진행하고 베포를 준비했습니다.

### 진행 상황

1. 회원가입 & 로그인 (User & Join) (완료)

2. 질문 게시판 (Question) (완료)

3. 답변과 답변에 대한 질문 (Answer & Comment) (완료)

4. 좋아요 & 점수 & 등급 (Like & Point & Rank) (완료)

5. CSS 작성 (완료)

6. 테스트(TDD) 및 배포 (진행중)

## 3. 마무리
### 프로젝트 이미지

|제목|내용|
|:---|:---:|
|로그인|![로그인페이지](https://github.com/Team-404WeFound/404WeFound/blob/docs/readme/src/main/resources/static/img/%EC%8B%A4%ED%96%89%20%EC%9D%B4%EB%AF%B8%EC%A7%80(%EB%A1%9C%EA%B7%B8%EC%9D%B8).PNG)|
|회원가입|![회원가입페이지](https://github.com/Team-404WeFound/404WeFound/blob/docs/readme/src/main/resources/static/img/%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85%20%ED%8E%98%EC%9D%B4%EC%A7%80.PNG)|
|질문게시판|![질문페이지](https://github.com/Team-404WeFound/404WeFound/blob/develop/src/main/resources/static/img/%EC%A7%88%EB%AC%B8%EA%B2%8C%EC%8B%9C%ED%8C%90.PNG)|
|답변게시판|![답변페이지](https://github.com/Team-404WeFound/404WeFound/blob/develop/src/main/resources/static/img/%EB%8B%B5%EB%B3%80%2B%EB%8C%93%EA%B8%80%EA%B2%8C%EC%8B%9C%ED%8C%90.PNG)|
|마이페이지|![마이페이지](https://github.com/Team-404WeFound/404WeFound/blob/docs/readme/src/main/resources/static/img/%EB%A7%88%EC%9D%B4%ED%8E%98%EC%9D%B4%EC%A7%80.PNG)|

### 프로젝트에 대한 소감

강석찬 : "첫 프로젝트라서 긴장도 많이 했지만 믿을 수 있는 팀원들을 만나서 많은 것을 배웠으며, 잘 해낸거 같습니다."

고경욱 : "부족한 점이 믾았지만 프로젝트 경험으로 실력을 많이 키울 수 있었습니다"

김정용 :  "생각보다 디테일한 부분에서 시간이 많이 필요하다는 점을 알았습니다 이번에 아쉬웠던 점을 다음 프로젝트에서는 보완하고 싶습니다"

백승진 : "프로젝트 기간동안 많이 배울수 있어서 좋았습니다."
