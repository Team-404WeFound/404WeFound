# 컨벤션

## 🌱커밋 규칙

| 프리픽스(prefix) | 설명 |
| --- | --- |
| feat | 새로운 기능 추가 |
| fix | 버그 수정, 충돌 해결 |
| docs | 문서 수정 |
| style | 코드 포맷팅, 세미콜론 누락 등 코드 변경이 없는 경우 |
| refactor | 리팩토링 |
| test | 테스트 코드 추가 및 수정 |
| chore | 빌드 프로세스나 도구 설정의 변경 |

예시)
feat: 게시판 엔티티 생성

## 🌲네이밍 규칙

### **변수명**:

- Camel Case를 기본으로 한다.
- 최대한 의도를 밝혀 명확하게 작성한다.
- 명확성의 차이가 없을 때는 길이가 짧은 네이밍을 선택한다.
- 변수명은 맥락을 고려해서 짓는다. 예를들어 클래스 이름이 `User`일 때 변수명에 `userName`과 같이 `user`를 붙이지 않는다.
- 변수이름에 자료형을 쓰지 않는다. 예를들어 `memberList` 대신에 `members` 처럼 복수형으로 표현한다.
    
    ```java
    // 변수명 예시
    int numberOfUsers;
    int userId;
    ```
    

### **패키지명**:

- 대문자를 사용하지 않고 소문자로만 구성한다.

### **Enum과 상수**:

- 대문자로 구성하고 밑줄(_)로 각 단어를 분리한다.
    
    ```java
    // Enum 및 상수 예시
    public enum DayOfWeek {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
    public static final int MAX_ATTEMPTS = 3;
    ```
    

### **메서드**:

- 동사로 작성한다.
- 값 반환하는 메서드의 경우 반환하는 값을 알 수 있게 메서드명을 지어야 한다.
    
    ```java
    // 메서드명 예시
    public void calculateTotalPrice() { ... }
    public boolean isLoggedIn() { ... }
    EMPTS = 3;
    ```
    

### **클래스명과 인터페이스명**:

- 명사로 작성하고, Upper Camel Case를 사용한다.
    
    ```java
    // 클래스명 및 인터페이스명 예시
    public class UserService { ... }
    interface DataAccess { ... }
    ```
    

### **엔티티 이름**:

- 단수로 작성한다.
    
    ```java
    // 엔티티 이름 예시
    public class User { ... }
    public interface Product { ... }
    ```
    

### **boolean 메서드**:

- 문법적으로 맞지 않은 `is`+동사원형의 형태는 사용하지 않는다.

```java
// 올바른 boolean 메서드 예시
public boolean isActive() { ... }
public boolean isValidUser() { ... }
public boolean hasPermission() { ... }

// 잘못된 boolean 메서드 예시
public boolean isRunning() { ... } // 잘못된 형태
public boolean isFinished() { ... } // 잘못된 형태
public boolean hasAccess() { ... } // 올바른 형태
```

## 🌳브랜치 역할 및 네이밍 규칙

| 브랜치명 | 설명 |
| --- | --- |
| main | 메인 브랜치로, 배포 버전을 관리합니다. |
| develop | 개발용 브랜치로, 기능을 개발하고 통합하는 데 사용됩니다. |
| feature/기능명 | 새로운 기능을 추가하는 데 사용되는 브랜치로, 각 기능의 명칭을 사용하여 생성합니다. |
| bugfix | 버그를 수정하기 위한 작업을 진행하는 브랜치로, 버그 수정이 완료되면 Develop브랜치에 병합됩니다. |
| release | 새로운 릴리즈를 준비하는 단계에서 생성되며, 릴리즈 후보 버전을 테스트하고 안정화하는 데 사용됩니다. |
| refactor | 코드를 재구성하거나 리팩토링하는 작업을 위한 브랜치로, 주로 기능의 개선이나 코드의 가독성을 향상시키는 데 사용됩니다. |
| backup | 백업용 브랜치로, 주요 작업 이전의 안전한 상태를 보존하기 위해 사용됩니다. |

## 🌵브랜치 룰

| 브랜치명 | 브랜치 보호 규칙 |
| --- | --- |
| main | - 브랜치 잠금 (읽기전용)(push불)(기한: 배포전까지) |
| develop | - 코드 리뷰어 1명 이상 승인을 통해 Pull Request를 Merge가능 |
| feature/기능명 | x |
| bugfix | x |
| release | x |