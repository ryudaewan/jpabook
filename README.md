# 자바 ORM 표준 JPA 프로그래밍 - 책 예제

## 전체 프로젝트 다운로드 경로: [download](https://codeload.github.com/ryudaewan/jpabook/zip/refs/heads/master)

### [인텔리제이에 예제 프로젝트 설정하기(최성훈님 제공)](https://medium.com/@oopchoi/jpa-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D-fc443b647ec8)

## 예제 코드 문제 해결

### 데이터베이스
- 본 예제에서는 h2 데이터베이스의 in-memory 데이터베이스를 씁니다. 따라서 본 예제들을 돌리기 위해 별도의 DBMS를 요하지는 않습니다.

### 웹 애플리케이션 구동
- ch11-jpa-shop 과 ch12-springdata-shop 은 웹 애플리케이션입니다. 별도의 JSP/Servlet 엔진이나 WAS를 쓰지 않고 간편하게 메이븐 jetty
플러그인을 쓰시면 됩니다. jetty:run 골(goal)을 실행시키면 메이븐이 jetty를 기동시키고, jetty는 개발자가 개발한 웹 애플리케이션을 끌고 올라
갑니다. jetty 구동이 다 끝나면 브라우저에 http://localhost:8080/ URL을 입력하면 개발한 웹 시스템을 브라우저에서 실제로 보고 구동/테스트할
수 있습니다. 

