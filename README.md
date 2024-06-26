## 목차
0. [404WeFound](#404WeFound-개발자-커뮤니티)
1. [Feature Introduction](#Feature-Introduction)
2. [Architecture](#Architecture)
3. [Sitemap](#Sitemap)
4. [Flowchart](#Flowchart)
5. [Use Case diagram](#Use-Case-diagram)
6. [ER diagram](#ER-diagram)
7. [Class diagram](#Class-diagram)
8. [Sequence diagram](#Sequence-diagram)
9. [API documentation](#API-documentation)
10. [Project structure](#Project-structure)
11. [Docs](#Docs)


# 404WeFound 개발자 커뮤니티
<img alt="image" src="https://github.com/BaxDailyGit/BaxDailyGit/assets/99312529/c61c3556-4cf1-48ec-8939-f7ff6a81afa8">

### 개발자 및 학생들을 위한 it 관련 질문과 답변을 공유하고 토론할 수 있는 지식 공유 플랫폼

#### 배포 url: http://404wefound.com:8080 (현재 서비스 종료)
#### 전체 시연영상: https://www.youtube.com/watch?v=HlBxpM8Yg4o

#### 프로젝트 기간: 24년 3월 22일 ~ 4월 9일 (18일)

<table>
    <tr>
        <th>강석찬</th>
        <th>고경욱</th>
        <th>김정용</th>
        <th>백승진</th>
    </tr>
    <tr>
        <td>
		<img src="https://github.com/BaxDailyGit/BaxDailyGit/assets/99312529/b7a23faa-26bb-4ac3-813f-2ceabcf434e7" width="500px">
	</td>
        <td>
		<img src="https://github.com/BaxDailyGit/BaxDailyGit/assets/99312529/b9c04d5e-9f77-4780-be63-54edd838d0f4" width="500px">
	</td>
        <td>
		<img src="https://github.com/BaxDailyGit/BaxDailyGit/assets/99312529/6d3a73d6-a026-4e48-a54c-872635a2c606" width="500px">
	</td>
        <td>
	        <img src="https://github.com/BaxDailyGit/BaxDailyGit/assets/99312529/463a507d-f3d5-4c81-80e6-bc4297fdb738" width="500px">
        </td>
    </tr>
    <tr>
	<td>
	    - 요구사항 및 기능 정의<br>
      - 답글 기능 구현<br>
      -  코드 리팩토링 및 산출물 개선<br>
        </td>
        <td>
	    - 문서 작업 및 ERD 설계<br>
      - 사용자 관련 기능 개선<br>
      - 좋아요 기능 구현
        </td>
        <td>
	    - 사이트 설계 및 와이어프레임 작성<br>
      - 게시판 및 질문, 댓글 관련 기능 구현<br>
      - 렌더링 처리 및 프론트엔드 개발
        </td>
        <td>
	    - 프로젝트 설정 및 일정 관리<br>
      - 시큐리티, 포인트, 프리미엄 질문 게시판, 관리자 페이지 기능 구현<br>
      - 배포
        </td>
    </tr>
</table>


<div align="right">

[맨 위로](#목차)

</div>


## Feature Introduction

### 회원가입, 로그인
https://github.com/BaxDailyGit/BaxDailyGit/assets/99312529/302ea3fe-8cb3-44c8-a2ba-5cb1f7b62551

<div align="right">

[맨 위로](#목차)

</div>

### 질문,답변,댓글 CRUD
https://github.com/BaxDailyGit/BaxDailyGit/assets/99312529/8791b2f9-aa8f-4492-bfc0-78e5bc502ae6

<div align="right">

[맨 위로](#목차)

</div>

### 좋아요,포인트,등급
https://github.com/BaxDailyGit/BaxDailyGit/assets/99312529/313d228e-c794-4f6a-a8d5-5fb4a8389c0c

<div align="right">

[맨 위로](#목차)

</div>

### 관리자 페이지
https://github.com/BaxDailyGit/BaxDailyGit/assets/99312529/22a57c9d-e2b7-439f-9656-21f3b8827201

<div align="right">

[맨 위로](#목차)

</div>

### 등급에 따른 프리미엄 질문 게시판, 회원탈퇴
https://github.com/BaxDailyGit/BaxDailyGit/assets/99312529/0e9f179d-a13d-4125-81ba-ca3e4fe92bc8

<div align="right">

[맨 위로](#목차)

</div>

## 기술 스택
#### FE
<div>
    <img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white">
    <img src="https://img.shields.io/badge/css3-1572B6?style=for-the-badge&logo=css3&logoColor=white">
    <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=white">
    <img src="https://img.shields.io/badge/thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white">
</div>

#### BE
<div>
    <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white">
    <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
    <img src="https://img.shields.io/badge/spring data jpa-6DB33F?style=for-the-badge&logo=amazondocumentdb&logoColor=white">
    <img src="https://img.shields.io/badge/spring security-6DB33F?style=for-the-badge&logo=spring security&logoColor=white">
</div>

#### DB
<div>
    <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white">
</div>

#### DEPLOY
<div>
    <img src="https://img.shields.io/badge/aws ec2-FF9900?style=for-the-badge&logo=amazonec2&logoColor=white">
    <img src="https://img.shields.io/badge/aws rds-527FFF?style=for-the-badge&logo=amazonrds&logoColor=white">
</div>

#### Collabo Tools
<div>
    <img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">
    <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
    <img src="https://img.shields.io/badge/notion-white?style=for-the-badge&logo=notion&logoColor=000000">
    <img src="https://img.shields.io/badge/erdcloud-000000?style=for-the-badge&logo=erdcloud&logoColor=white">
    <img src="https://img.shields.io/badge/discord-5865F2?style=for-the-badge&logo=discord&logoColor=white">

</div>


<div align="right">

[맨 위로](#목차)

</div>


## Architecture
<img alt="image" src="https://github.com/BaxDailyGit/BaxDailyGit/assets/99312529/a6899298-88aa-41d6-8356-983b272c726f">

<div align="right">

[맨 위로](#목차)

</div>

## Sitemap
<img alt="image" src="https://github.com/BaxDailyGit/BaxDailyGit/assets/99312529/521cc652-c18f-4017-875e-8dbe8d0682e2">

<div align="right">

[맨 위로](#목차)

</div>

## Flowchart

<img alt="image" src="https://github.com/BaxDailyGit/BaxDailyGit/assets/99312529/5bdc5581-ae51-473f-9470-f54d1c356f9b">

<div align="right">

[맨 위로](#목차)

</div>


## Use Case diagram

<img alt="image" src="https://github.com/BaxDailyGit/BaxDailyGit/assets/99312529/05d52367-be58-4be4-b485-f68b44359464">

<div align="right">

[맨 위로](#목차)

</div>

## ER diagram
![404wefound_3](https://github.com/BaxDailyGit/BaxDailyGit/assets/99312529/ba3df124-c6e8-49d3-8788-0d798a2e315d)
premium_questions의 댓글, 답변은 아직 구현하지 않아 ERD에 반영하지 않았습니다.

<div align="right">

[맨 위로](#목차)

</div>

## Class diagram

<img alt="image" src="https://github.com/BaxDailyGit/BaxDailyGit/assets/99312529/ce3e9e44-2c40-4bba-a7a0-2418a34f332a">  

premium_questions의 댓글, 답변은 아직 구현하지 않아 Class diagram에 반영하지 않았습니다.

<div align="right">

[맨 위로](#목차)

</div>

## Sequence diagram

### 포인트, 등급, 프리미엄 게시판 접근

404WeFound에서 핵심 기능인 <ins>**질문 게시글에 답변을 작성한 작성자가 다른 사용자로부터 좋아요를 받았을때 포인트를 얻고 등급이 올라서 프리미엄 게시판에 접근하는 과정**</ins>을 시퀀스 다이어그램으로 나타내었습니다.

<img alt="image" src="https://github.com/BaxDailyGit/BaxDailyGit/assets/99312529/f2c4946e-15d6-4f80-931a-414abe129735">


<div align="right">

[맨 위로](#목차)

</div>


## API documentation


사용자 관련 API:

| API 엔드포인트          | HTTP 메서드 | 설명             |
|--------------------|----------|----------------|
| /admin/updateGrade | POST     | 사용자의 등급을 업데이트  |
| /admin/updatePoint | POST     | 사용자의 포인트를 업데이트 |
| /joinProc          | POST     | 회원 가입 처리       |
| /withdraw          | POST     | 회원 탈퇴          |

질문 관련 API:

| API 엔드포인트                                 | HTTP 메서드 | 설명              |
|-------------------------------------------|----------|-----------------|
| /api/questions/{questionId}/answers       | POST     | 질문에 답변 작성       |
| /api/questions/{questionId}/answers/new   | GET      | 답변 작성 페이지 표시    |
| /api/questions/{questionId}               | GET      | 특정 질문 조회        |
| /api/questions/{questionId}               | POST     | 질문에 댓글 작성       |
| /api/questions/{question_id}/comment      | GET      | 질문의 모든 댓글 조회    |
| /api/questions/{question_id}/{comment_id} | GET      | 특정 댓글 조회        |
| /api/questions/{question_id}/{comment_id} | DELETE   | 특정 댓글 삭제        |
| /api/questions                            | POST     | 질문 작성           |
| /api/questions/{questionId}               | PUT      | 질문 수정           |
| /api/questions/{questionId}               | DELETE   | 질문 삭제           |
| /questions                                | GET      | 질문 목록 조회        |
| /inputQuestion                            | GET      | 질문 작성/수정 페이지 표시 |

프리미엄 질문 관련 API:

| API 엔드포인트                       | HTTP 메서드 | 설명                |
|---------------------------------|----------|-------------------|
| /api/premium-questions          | POST     | 프리미엄 질문 작성        |
| /api/{questionId}               | PUT      | 프리미엄 질문 수정        |
| /api/{questionId}               | DELETE   | 프리미엄 질문 삭제        |
| /premium-questions              | GET      | 프리미엄 질문 목록 조회     |
| /premium-questions/{questionId} | GET      | 특정 프리미엄 질문 조회     |
| /premium-questions/new          | GET      | 프리미엄 질문 작성 페이지 표시 |

답변 및 댓글 관련 API:

| API 엔드포인트                              | HTTP 메서드 | 설명           |
|----------------------------------------|----------|--------------|
| /api/answers/{answerId}/answerComments | POST     | 답변에 댓글 작성    |
| /api/answers/{answerId}/answerComments | GET      | 답변의 댓글 목록 조회 |
| /api/answers/{answerId}/like           | POST     | 답변에 좋아요 추가   |

페이지 관련 API:

| API 엔드포인트      | HTTP 메서드 | 설명        |
|----------------|----------|-----------|
| /              | GET      | 메인 페이지    |
| /login         | GET      | 로그인 페이지   |
| /join          | GET      | 회원가입 페이지  |
| /admin         | GET      | 관리자 페이지   |
| /access-denied | GET      | 접근 거부 페이지 |
| /mypage        | GET      | 마이페이지     |


<div align="right">

[맨 위로](#목차)

</div>

## Project structure

```
📁 src.main
├── 📁 java.com.wefound.weFound
│   ├── 📁 config
│   │   └── 📃 WebSecurityConfig.java
│   ├── 📁 controller
│   │   ├── 📃 AdminController.java
│   │   ├── 📃 AnswerCommentController.java
│   │   ├── 📃 AnswerController.java
│   │   ├── 📃 CommentController.java
│   │   ├── 📃 JoinController.java
│   │   ├── 📃 LoginController.java
│   │   ├── 📃 MainController.java
│   │   ├── 📃 MyPageController.java
│   │   ├── 📃 PremiumQuestionController.java
│   │   └── 📃 PremiumQuestionPageController.java
│   │   ├── 📃 QuestionController.java
│   │   ├── 📃 QuestionPageController.java
│   │   └── 📃 UserController.java
│   ├── 📁 dto
│   │   ├── 📃 AddAnswerCommentRequest.java
│   │   ├── 📃 AddCommentRequest.java
│   │   ├── 📃 AddQuestionRequest.java
│   │   ├── 📃 AllAnswerCommentResponse.java
│   │   ├── 📃 AllCommentResponse.java
│   │   ├── 📃 AnswerCommentResponse.java
│   │   ├── 📃 CommentResponse.java
│   │   ├── 📃 CustomUserDetails.java
│   │   ├── 📃 JoinDto.java
│   │   ├── 📃 QuestionResponse.java
│   │   └── 📃 QuestionViewResponse.java
│   ├── 📁 entity
│   │   ├── 📃 Answer.java
│   │   ├── 📃 AnswerComment.java
│   │   ├── 📃 Comment.java
│   │   ├── 📃 Point.java
│   │   ├── 📃 PremiumQuestion.java
│   │   ├── 📃 Question.java
│   │   └── 📃 User.java
│   ├── 📁 repository
│   │   ├── 📃 AnswerCommentRepository.java
│   │   ├── 📃 AnswerRepository.java
│   │   ├── 📃 CommentRepository.java
│   │   ├── 📃 PointRepository.java
│   │   ├── 📃 PremiumQuestionRepository.java
│   │   ├── 📃 QuestionRepository.java
│   │   └── 📃 UserRepository.java
│   ├── 📁 service
│   │   ├── 📃 AdminService.java
│   │   ├── 📃 AnswerCommentService.java
│   │   ├── 📃 AnswerService.java
│   │   ├── 📃 CommentService.java
│   │   ├── 📃 JoinService.java
│   │   ├── 📃 MainService.java
│   │   ├── 📃 MyPageService.java
│   │   ├── 📃 PremiumQuestionService.java
│   │   ├── 📃 QuestionService.java
│   │   ├── 📃 UserDetailsService.java
│   │   └── 📃 UserService.java
│   └── 📃 Team404WeFoundApplication
├── 📁 resources
.   ├── 📁 static
.   │   ├── 📁 css
.   │   ├── 📁 img
    │   └── 📁 script
    │       ├── 📃 answer-comment.js
    │       ├── 📃 comment.js
    │       ├── 📃 joinValidation.js
    │       ├── 📃 premium-question.js
    │       ├── 📃 premium-question-detail.js
    │       ├── 📃 premium-question-form.js
    │       ├── 📃 question.js
    │       └── 📃 userWithdraw.js
    ├── 📁 templates
    │   ├── 📁 fragments
    │   │   ├── 📃 footer.html
    │   │   └── 📃 header.html
    │   ├── 📃 access-denied.html
    │   ├── 📃 admin.html
    │   ├── 📃 answerForm.html
    │   ├── 📃 firstMain.html
    │   ├── 📃 inputQuestion.html
    │   ├── 📃 join.html
    │   ├── 📃 login.html
    │   ├── 📃 mypage.html
    │   ├── 📃 premium-question-detail.html
    │   ├── 📃 premium-question-form.html
    │   ├── 📃 premium-question.html
    │   ├── 📃 questionDetail.html
    │   ├── 📃 questionDetailNoComment.html
    │   └── 📃 question.html
    └── 📃 application.properties
```

<div align="right">

[맨 위로](#목차)

</div>


## Docs
(1) [개발계획서](https://github.com/Team-404WeFound/404WeFound/blob/main/src/main/resources/docs/SDP_%EA%B0%9C%EB%B0%9C%EA%B3%84%ED%9A%8D%EC%84%9C_WeFound.md)  
(2) [요구사항 정의서](https://github.com/Team-404WeFound/404WeFound/blob/main/src/main/resources/docs/SRS_%EC%9A%94%EA%B5%AC%EC%82%AC%ED%95%AD%20%EC%A0%95%EC%9D%98%EC%84%9C_WeFound.md)  
(3) [요구사항 추적표](https://github.com/Team-404WeFound/404WeFound/blob/main/src/main/resources/docs/RTM_%EC%9A%94%EA%B5%AC%EC%82%AC%ED%95%AD%20%EC%B6%94%EC%A0%81%ED%91%9C_WeFound.md)  
(4) [컨벤션](https://github.com/Team-404WeFound/404WeFound/blob/main/src/main/resources/docs/%EC%BB%A8%EB%B2%A4%EC%85%98_WeFound.md)  
(5) [협업 메뉴얼](https://github.com/Team-404WeFound/404WeFound/blob/main/src/main/resources/docs/%ED%98%91%EC%97%85%20%EB%A9%94%EB%89%B4%EC%96%BC_WeFound.md)  

<div align="right">

[맨 위로](#목차)

</div>