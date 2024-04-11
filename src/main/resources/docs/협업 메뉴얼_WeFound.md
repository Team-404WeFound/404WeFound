## 🌱 개발 단계

### 0. clone하기 (로컬에 저희레포 복제)

최초 실행 후에는 하실 필요 없습니다.

### 1. 프로젝트(대시보드) todo에서 기능 하나를 진행중으로 옮기고 이슈 생성하기

### 2. 해당 이슈에서 브랜치 새로 만들기 (예시: feature/login)

- 이때 소스는 develop으로 하기

### 3. 로컬에서 clone한 디렉토리에서 cmd창기

```bash
git fetch origin
git checkout feature/login
```



### 4. 이후 해당 브랜치에서 기능 구현

참고코드

```bash
#내 로컬에서 브랜치 목록과 현재 내 위치의 브랜치 확인 
git branch 

featuer/login브랜치로 이동
git switch featuer/login
```

### 5. 이후 해당 브랜치에 push

### 6. 깃헙 사이트에서 pr 보내기 ( develop ← feature/login )

---

## 🌴 충돌이 난 경우

push후 깃허브 사이트에서 pr을 보낼때 충돌이 난 경우

다시 cmd로 돌아가서

```bash
git switch develop
# 주의: "방금 커밋 or 푸시한 브랜치"에서 다음 작업 하시면 안됩니다.

git pull origin develop

git switch "방금 커밋 or 푸시한 브랜치"

git merge develop
# 주의: develop브랜치를 "방금 커밋 or 푸시한 브랜치"에 합칩니다.
# "방금 커밋 or 푸시한 브랜치"를 develop브랜치에 합치는게 아닙니다.)
```

그러면 인텔리제이에서 충돌난부분이 **표시**됩니다.

이때
기존 코드와 내 코드가 공존해도 괜찮은 경우와 공존하면 안되는경우가 있습니다.

- 공존해도 괜찮은 경우
-> 기존 코드를 건들지 않고 내 코드를 빈곳에 위치시키면 됩니다.
- 기존 코드와 내 코드가 공존하면 안되는경우
-> 이때는 팀원과 의논해서 충돌 해결을 해야합니다.

---

## 🍏커밋 메시지 예시

커밋 컨벤션은 [여기](https://www.notion.so/c2576c005e1b4735ad2910bb9111205d?pvs=21)를 참고해주세요.

작업하실때
브랜치를 만들고 작업을 프로세스마다 커밋해주시면 좋습니다. 

만약 개발 과정이 

> 1. 인가
> 2. 회원가입 로직 구현
> 3. 로그인 로직 구현

이렇다면 아래처럼 커밋하시면 됩니다.

1. 인가 작업 끝내셨으면

```bash
git commit -m "feat: config 클래스 생성 및 기본적인 인가 구현"
```

1. 회원가입 로직 기본 구현하셨으면

```bash
git commit -m "feat: 회원가입 로직 기본구현"
```

1. 동일한 username 막는 메서드 구현하셨으면

```bash
git commit -m "feat: 회원 중복 검증 구현"
```

1. 아이디, 비밀번호에 대한 정규식 처리를 하셨으면

```bash
git commit -m "feat: 가입 불가 문자 정규식 처리"
```

1. 로그인 로직기본 구현하셨으면

```bash
git commit -m "feat: 로그인 로직 기본 구현"
```

이후 마지막에 푸시 하시고 깃허브 홈페이지에서 pr을 올리시면 됩니다.

---

## ☘️️push 전 커밋 메세지 수정하는법

- ### 가장 최근의 commit 수정

```bash
git commit --amend
```
i (입력모드)를 눌러 메시지를 수정하고, 이후 esc -> :wq(저장 + 창 닫기) 

- ### 세번째 전에 커밋을 수정하고 싶다면


```bash
# 현재 작업중인 브랜치의 가장 최근 commit 3개를 보여주는 명령어
git rebase -i HEAD~3
```
  
이후 다음과 같은 창이 나옵니다.
```
pick e499d89 feat: 배고파
pick 0c39034 refactor: 생성자 주입으로 변경
pick f7fde4a fix: 렌더링 매핑된 html 수정
```
  
i (입력모드)를 눌러 수정하고 싶은 커밋 옆의 pick 이라는 문구를 reword 로 바꿔줍니다.
```
reword e499d89 feat: 배고파
pick 0c39034 refactor: 생성자 주입으로 변경
pick f7fde4a fix: 렌더링 매핑된 html 수정
```
esc -> :wq 를 통해 커밋 리스트를 저장을 해주고 나면, reword로 바꿨던 해당 커밋을 수정할 수 있는 창이 순서대로 띄워집니다.

원하는대로 커밋을 수정하시고, :wq 를 통해 저장해주세요.

수정이 잘 되었는지 git log 를 통해 확인합니다.

---

## 🌿브랜치 변경
단순히 브랜치를 변경(이동)하려는 경우에는
```bash
git checkout
```
보다는
```bash
git switch
```
를 사용합니다.

---

## 📗깃 플로우

저희팀은 Git-flow 전략을 사용합니다. 아래 그림을 참고해주세요.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/e8f11927-b70c-4524-9227-a3efac08e7aa/e2570b31-be32-4566-bcfc-685d29d2a96b/Untitled.png)

---

## 🌲우리팀 약속

- **컨벤션** 잘 지키기
- 팀원의 빠른 이해를 위해서 코드에 **주석 많이 남기기**
- pr 보내기 전 최대한 **리팩토링 해보기**
- **강제 merge 하기 전** 꼭 팀원과 의논하기
- **push --force, reset, rm, pull --rebase**같은 작업을 할 때는 꼭 팀원과 의논하기.