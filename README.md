# springBtWeb

## 📅 목차

- [2025-07-30](#2025-07-30)

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
