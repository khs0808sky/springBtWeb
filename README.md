# springBtWeb

## 📅 목차

- [2025-07-30](#2025-07-30)
- [2025-07-31](#2025-07-31)

<br><br><br>

---

# 2025-07-30

---

## 1. Spring Boot란?

* **무엇인가?**
  스프링 프레임워크를 간편하게 사용하도록 도와주는 프레임워크. 복잡한 설정 없이 빠르게 애플리케이션을 실행할 수 있도록 구성됨.

* **주요 특징**

  * 복잡한 XML 설정 없이 **자동 구성(Auto Configuration)**
  * **내장 톰캣 서버**를 사용해 `main()` 메서드만으로 실행 가능
  * 프로젝트 구조와 의존성을 자동으로 관리
  * REST API, JPA, Security 등 다양한 스타터 제공 (`spring-boot-starter-*`)
  * 운영과 개발을 동시에 고려한 설정 (프로파일 관리 등)

* **실행 방법**

  ```java
  @SpringBootApplication
  public class MyApp {
      public static void main(String[] args) {
          SpringApplication.run(MyApp.class, args);
      }
  }
  ```

---

## 2. `build.gradle`을 이용한 환경 설정

* **역할**
  Gradle은 빌드 자동화 도구이며, `build.gradle` 파일을 통해 의존성(dependencies)과 설정을 관리함.

* **기본 예시**

  ```groovy
  plugins {
      id 'org.springframework.boot' version '3.2.0'
      id 'io.spring.dependency-management' version '1.1.0'
      id 'java'
  }

  dependencies {
      implementation 'org.springframework.boot:spring-boot-starter-web'
      implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
      testImplementation 'org.springframework.boot:spring-boot-starter-test'
  }
  ```

* **주요 구성**

  * `plugins`: 스프링 부트, 자바, 의존성 관리 등 선언
  * `dependencies`: 사용할 라이브러리들 (웹, 타임리프, 테스트 등)
  * `bootRun`: 애플리케이션 실행
  * `build`: 컴파일 및 배포

---

## 3. Thymeleaf (타임리프)

* **무엇인가?**
  HTML에 스프링 데이터를 동적으로 출력할 수 있도록 도와주는 템플릿 엔진 (Spring Boot의 대표 뷰템플릿)

* **특징**

  * HTML5와 완전히 호환됨
  * JSP보다 가독성이 뛰어나며, 정적 HTML처럼 브라우저에서 바로 열어볼 수 있음
  * `th:` 접두어를 통해 데이터 바인딩, 조건문, 반복 등 가능

* **기본 문법 예시**

  ```html
  <p th:text="${name}">홍길동</p>   <!-- name 변수 출력 -->
  <div th:if="${isAdmin}">관리자만 보임</div>
  <ul>
    <li th:each="emp : ${empList}" th:text="${emp.ename}"></li>
  </ul>
  ```

---

## 4. EL (Expression Language) 문법

* **무엇인가?**
  JSP 또는 타임리프 등에서 **서버의 데이터(모델 객체)를 HTML에 출력**할 수 있도록 도와주는 문법

* **기본 문법**

  ```jsp
  ${변수명}              → 변수 출력
  ${user.name}           → 객체의 속성 접근
  ${list[0]}             → 리스트의 0번째 요소
  ${param.id}            → 요청 파라미터(id)
  ```

* **Spring MVC에서 model 데이터 전달**

  ```java
  model.addAttribute("name", "철수");
  ```

  ```html
  <p>안녕하세요, ${name}님!</p>
  ```

---

📅[목차로 돌아가기](#-목차)

---

# 2025-07-31

## 📘 Thymeleaf 문법 총정리

---

### ✅ 1. EL (Expression Language) 사용

| 문법                   | 설명                       |
| -------------------- | ------------------------ |
| `${변수}`              | 모델 데이터 출력                |
| `${obj.prop}`        | 객체 속성 접근                 |
| `${a + 10}`          | 연산 가능                    |
| `${a > 0 ? 'A':'B'}` | 삼항연산자                    |
| `<!--/* ... */-->`   | Thymeleaf 전용 주석 (출력 안 됨) |

---

### ✅ 2. Thymeleaf 표현식 종류

| 표현식      | 설명                                     |
| -------- | -------------------------------------- |
| `${...}` | 일반 변수 표현식 (Model, Request, Session 등)  |
| `*{...}` | 선택 변수 표현식 (`th:object` 내부에서 주로 사용)     |
| `#{...}` | 메시지 표현식 (`message.properties` 국제화 메시지) |
| `@{...}` | URL 표현식 (링크, 리다이렉트 등)                  |
| `~{...}` | Fragment 조각 표현식 (재사용 템플릿)              |

---

### ✅ 3. 조건문과 연산

```html
<span th:if="${a > 5}">5보다 큼</span>
<span th:unless="${a > 5}">5 이하</span>

<th:block th:switch="${grade}">
  <span th:case="A">90점 이상</span>
  <span th:case="*">기타</span>
</th:block>
```

* Elvis 연산자: `${val}?:'기본값'`
* No-Op: `${val}?:_` → 값이 없을 경우 아무 것도 출력 안 함

---

### ✅ 4. 반복문 (Loop)

```html
<ul>
  <li th:each="item : ${list}" th:text="${item}"></li>
</ul>

<th:block th:each="item, stat : ${list}">
  <div th:text="${stat.index} + ':' + ${item}"></div>
</th:block>
```

| 변수                               | 설명           |
| -------------------------------- | ------------ |
| `stat.index`                     | 0부터 시작하는 인덱스 |
| `stat.count`                     | 1부터 시작하는 순서  |
| `stat.first / last / even / odd` | 반복 상태 정보     |

---

### ✅ 5. Form 바인딩

```html
<form th:object="${user}" method="post">
  <input type="text" th:field="*{userId}" />
  <input type="checkbox" th:field="*{agree}" />
  <input type="radio" th:field="*{gender}" value="M" />
</form>
```

* `th:field="*{속성}"`은 `id`, `name`, `value`를 자동 처리
* `th:checked`, `th:selected`를 통해 초기 선택 설정 가능
* `th:classappend`, `th:attrappend`, `th:attr` 등으로 속성 제어 가능

---

### ✅ 6. Fragment (템플릿 조각 재사용)

```html
<div th:insert="~{/fragment/layout::footer}"></div>
<div th:replace="~{/fragment/layout::header}"></div>
```

| 구분                       | 설명                   |
| ------------------------ | -------------------- |
| `insert`                 | 조각 내용을 포함 (기존 요소 유지) |
| `replace`                | 조각으로 완전히 대체됨         |
| `th:fragment="fragName"` | 조각 정의할 때 사용          |

---

### ✅ 7. JavaScript와의 연동

```html
<script>
  let userName = "[[${user.userName}]]";
  let userObj = [[${user}]];
</script>

<script th:inline="javascript">
  let msg = [[${session.msg}]];
</script>
```

* `[[...]]` : 출력값을 문자열로 삽입
* `[(${...})]` : JS 문자열로 안전하게 출력
* `th:inline="javascript"` 필수

---

### ✅ 8. Utility Object

| 객체 이름                                                        | 용도           |
| ------------------------------------------------------------ | ------------ |
| `#numbers`                                                   | 숫자 범위 시퀀스 생성 |
| `#dates`, `#strings`, `#lists`, `#maps`, `#bools`, `#arrays` | 다양한 유틸 함수 제공 |

```html
<div th:with="nums=${#numbers.sequence(1, 5)}">
  <span th:each="n : ${nums}" th:text="${n}"></span>
</div>
```

---

📅[목차로 돌아가기](#-목차)

---

