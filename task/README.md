# 용어 정리
## JVM 구조
<img width="527" alt="2018-07-31 10 44 57" src="https://user-images.githubusercontent.com/37525926/43463742-52472d64-9514-11e8-9546-21dce4654daa.png">
  
  - 메서드 영역
    - 모든 스레드가 공유한다.
    - classLoader가 읽은 클래스의 정보들이 저장된다.
    - 멤버 변수(필드), 클래스 변수(Static 변수), 생성자와 메소드를 저장하는 공간이다.
  - 힙 영역
    - JVM이 관리하는 프로그램 상에서 데이터를 저장하기 위해 런타임 시 동적으로 할당하여 사용하는 영역이다
    - new로 생성된 객체(인스턴스)와 배열이 저장 된다
  - 스택 영역
    - 각 스레드마다 하나씩 생성된다.
    - 메서드가 호출될 때 메서드 정보를 저장하고 메서드가 끝나면 제거한다.
    - 메서드 정보, 지역변수, 매개변수, 연산결과 등이 저장된다. 
    
## AOP Proxy
  - 런타임 시 AOP를 적용할 때 소스 코드나 클래스 정보 자체를 변경하지 않고 프록시를 이용해 적용한다.
  - 핵심 로직을 구현한 객체에 직접 접근하는 것이 아니라 중간에 프록시를 생성해 프록시를 통해 핵심 로직을 구현한 객체에 접근한다. 
  - 이 과정에서 프록시는 공통 기능을 실행한 뒤 대상 객체의 실제 메서드를 호출하거나, 또는 대상 객체의 실제 메서드를 호출한 뒤 공통 기능을 실행하게 된다. 
  = 스프링 컨테이너를 초기화하는 과정서 설정 정보에 지정한 빈 객체에 대한 프록시 객체를 생성하고, 원본 빈 객체 대신 프록시 객체를 사용하도록 한다. 
  - 프록시는 핵심 로직을 실행하기 전 또는 후에 공통 기능을 적용하는 방식으로 AOP를 구현한다. 
  - 스프링은 Aspect의 적용 대상이 되는 객체에 대한 프록시를 만들어 제공한다. 
  - 대상객체가 인터페이스를 구현하고 있다면 스프링이 제공하는 방법으로 객체를 생성하고, 인터페이스가 구현도지 않았다면 CGLIB을 이용해 프록시를 생성한다. 

## AOP 용어
  - Advice
    - 언제 공통 관심 기능을 핵심 로직에 적용할지 정의
    - 메서드 호추전에 할지 후에 할지 등등
  - JoinPoint
    - Advice를 적용 가능한 지점을 의미. 
    - 메서드 호출, 필드값 변경 등
  - Pointcut
    - Jointpoint의 부분 집합으로, 실제 Advice가 적용되는 JoinPoint.
  - Weaving 
    - Advice를 핵심 로직 코드에 적용하는 것을 말한다.
  - Aspect
    - 여러 객체에 공통으로 적용되는 기능.

##  쓰레드 공유객체
  - 하나의 객체를 여러 쓰레드가 사용한다는 의미.
  - 싱글스레드에선 상관 없지만 멀티 스레드에선 공유객체를 작업할 때 동기화 작업이 필요하다.
  - 동기화란?
    - 여러 개의 쓰레드가 한 공유자원을 서로 사용하려 할 때, 하나의 쓰레드만 제외하고 나머지는 사용을 못하도록 막는 방법이다.
    - 동기화 방법들 중 하나는 동기화 하고 싶은 메서드 앞에 synchronized를 붙이면 된다. 
    - 메서드 전체에 동기화가 걸리므로 일부분만 원한다면 동기화 블록을 만들면 된다.

## 클래스 로더
  - classPath에 있는 '.class' 바이트코드를 읽어 class 객체를 생성한다.
  - 클래스 로더는 클래스가 요청될 때 파일로부터 읽어 메모리로 로딩한다. 
    - 로딩 : 클래스 파일을 바이트 코드로 읽어 메모리로 가져오는 것.
    - 클래스 로딩 과정 : 로딩 --> 링크 --> 초기화
  - 클래스 로더 계층에서 하위 계층은 부모 계층을 참조할 수 있지만 그 반대는 안된다.
  - 클래스 로더 계층구조

<img width="212" alt="default" src="https://user-images.githubusercontent.com/37525926/43535077-fc1ac032-95f3-11e8-861f-e900eb7414c3.png">

  - 부트스트랩 클래스로더
    - JVM이 실행될 때 처음 실행되는 클래스 로더
  - 익스텐션 클래스로더
    - BootStrap 로딩 후 기본적으로 로딩되는 클래스\
  - 시스템 클래스 로더
    - Class Path에 정의되거나, JVM Option에서 -cp, -classpath에 저장된 클래스들을 로딩
  - 사용자 정의 클래스 로더

## 스프링 MVC
  - 기본내용
    - DispatherServlet은 내부적으로 스프링 컨테이너를 생성하는데, contextConfigLocation 초기화 파라미터를 이용해 컨테이너를 생성할 설정 파일을 지정한다. 
    - 스프링 컨트롤러
      - MVC 컨트롤러는 클라이언트의 요청을 처리하는 기능을 제공한다. 
      - /hello 주소로 요청을 하면 /hello가 매핑된 메서드를 이용해 요청을 처리한다.
      - 컨트롤러서 응답 결과를 생성할 수 있지만, 보통 결과를 보여줄때 사용할 뷰 이름을 리턴한다. 
      - 컨트롤러는 뷰에서 사용할 데이터를 모델에 담아서 전달하고, 뷰에서는 모델에 담긴 데이터를 이용해 알맞은 응답결과를 생성한다.
    - 뷰 구현
      - 뷰는 응답 결과를 생성해 준다. 
      - ${} 형식으로 컨트롤러에서 모델에 보낸 값이 온다. 
    - 뷰리졸버
      - 뷰 이름을 실제 어떤 뷰와 연결할지 설정한다. 
      - prefix + 뷰 이름 + suffix 형식으로 뷰를 선택한다.  
  - 기본 흐름과 주요 컴포넌트
    - DispacherServlet : 클라이언트 요청을 전부 전달 받음. 컨트롤러에게 클라이언트 요청을 전달하고 컨트롤러가 리턴한 결과값을 View에 전달. 또는 알맞은 응답 생성하도록 함.
    - HandlerMapping : 클라이언트의 요청 URL을 어떤 컨트롤러가 처리할지 결정.
    - HandlerAdapter : 디스패처서블릿의 처리 요청을 변환해 컨트롤러에게 전달하고, 컨트롤러의 응답 결과를 디스패처서블릿이 원하는 형식으로 변환한다. 
    - 컨트롤러 : 클라이언트 요청 처리 후, 결과를 리턴한다. 응답 결과에서 보여줄 데이터를 모델에 담아 전달
    - ModelAndView : 컨트롤러가 처리한 결과 정보 및 뷰 선택에 필요한 정보를 담는다.
    - ViewResolver 컨트롤러의 처리 결과를 보여줄 뷰를 결정한다. jsp, http, text, 엑셀 등등..
    - View : 컨트롤러의 처리 결과 화면을 생성한다. 
  - 스프링 MVC 설정
    - 스프링 MVC를 설정하려면 최소 다음 구성 요소를 빈 객체로 등록해야 한다.
      - HandlerMapping 구현객체
      - HanderAdapter 구현 객체
      - ViewResolver 구현 객체
  - 서블릿 매핑
    - 컨트롤러 매핑 경로로 전체 경로를 사용하고 싶을때 다음 2가지를 사용하자
      - 서블릿 매핑 설정에서 URL 패턴을 "/"로 지정.
      - 스프링 MVC 설정에서 디폴트 서블릿 핸들러를 작성
    - 서블릿 매핑 설정에서 URL 패턴을 <url-pattern>/</url-pattern>으로 하면 jsp 요청을 제외한 나머지 요청을 DispatcherServlet이 받는다. 
    - DispatcherServlet에 매핑 되지 않는 경로로 요청이 오면 404 응답 코드를 웹 브라우저에 전송한다. 
    - 404 메시지 대신 컨테이너의 디폴트 서블릿을 이용해 처리하도록 하려면 <mvc:default-servlet-hander> 설정을 해야한다.
    - 디폴트 서블릿은 각 WAS 마다 제공하고 있다. 
  - 컨트롤러
    - @RequestMapping 메서드가 String을 리턴할 경우, 처리 결과를 보여줄 뷰 이름을 리턴한다. 
    - 뷰 이름을 리턴하기 전에 다음 두 작업을 수행 한다. 
      - 클라이언트 요청 처리 ex) 회원 목록 조회 요청 오면 DAO등을 이용해 List에 담아줌.
      - 처리 결과 데이터를 뷰에 전달. ex) 회원목록 List를 모델에 담아 전달.
    - ModelAndView
      - 모델 설정과 뷰 이름을 합쳐 놓은 것이다. 
      - @Controller 나오기 전에 나왔던 기술. @Controller가 나오고선 잘 사용 안한다. 
    - @RequestMapping
      - 같은 경로를 공유하는 경우 클래스위에 @RequestMapping을 적용시킨다. 
      - method 속성을 이용해 get/post method를 설정할 수 있다. 
      - method에는 GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE 가 있따. 
    - @PathVariable
      - localhost:8080/article?id=10 대신에 localhost:8080/article/10 같이 파라미터를 사용하지 않고 표현할 수 있다.
      - RESTful API URL 구성방식인데, @PathVariable을 이용하면 위와 같은 URL을 처리할 수 있다. 
        > @RequestMapping("/article/{id})
          public String articleDetail(@PathVariable String id) ...
      - @PathVariable로 경로변수의 값을 파라미터로 전달 받는다. 
  - HTTP 요청 파라미터와 폼 처리
    

## REST API
  - REST 구성
    - 자원 - URI
    - 행위 - HTTP Method
    - 표현
  - REST 특징
    - Uniform
      - URI로 지정한 리소스에 대한 조작을 통일되고 한적적인 인터페이스로 수행하는 아키텍처 스타일
    - Stateless
      - REST는 무상태성을 갖는다. 단순 서버에 들어오는 API 요청만 하면 된다.
      - 이로 인한 서비스의 자유도가 높아지고 서버에 불필요한 정보를 관리 안해도 되어 구현에 쉬워진다.
    - Cacheable
      - HTTP 기존 웹표준을 사용하기 떄문에, 캐싱 기능이 적용 가능 하다. 
    - Self-descriptivness
      - REST-API만 보고도 이를 쉽게 이해할 수 있는 구조로 되어있다.
    - Client-Server 구조
      - 서버와 클라이언트간 역할이 분명해 개발해야할 내용이 명확해 지고, 서로간 의존성이 줄어들게 된다.
    - 계층형 구조
  - REST API 디자인 구조
    - REST API 중심규칙
      - URI는 정보의 자원을 표현해야 한다.
      > GET /boards/delete/1   // delte와 같은 행동이 들어가면 안된다.
      - 자원의 행위는 HTTP Method로 표현하자. 위식을 다음과 같이 쓸 수 있다.
      > DELTE /boards/1  // 1번 게시물 삭제
      > GET /boards/1
      > POST /boards/2 // 2번 게시물 등록

## ThreadLocal
  - 쓰레드로컬?
    - 일반 변수는 코드 블록 밖에서 참조를 할수가 없다.
    - 그런데 쓰레드 로컬은 같은 선언한 쓰레드에서 코드 블록이건 어디건 서로 참조를 할 수가 있는 객체다.
  - 어떻게 사용하나?
    - 1) 객체생성 
      > ThreadLocal<UserInfo> userInfo = new ThreadLocal<>();
    - 2) ThreadLocal.set()으로 현재 쓰레드의 로컬 값 세팅
      > userInfo.set(new UserInfo());
    - 3) ThreadLocal.get()으로 쓰레드 로컬 값 읽어오기
      > UserInfo info = userInfo.get();
  - 어디에 활용되나?
    - 사용자 인증정보 전파 : Spring Security에서 사용자 인증 정보를 전파하는데 사용한다.
    - 쓰레디에 안전해야 되는 데이터 보관
  - 주의할 점
    - ThreadLocal 사용이 끝나면 반드시 삭제 해 주자. remove();

## Thymeleaf 사용법
### 표현식
  - Variable Expression : ${..}
    - context에 포함된 변수들을 사용할 수 있다. 
  >   <p>Hi <span th:text="${user.userName}"></span>
  - Selection Variable Expression : *{...}
    - 가까운 DOM에 th:Object로 정의된 변수가 있다면 그 변수에 포함된 값을 나타낸다.
  >
    <div th:Object="${session.user}">
      <p>Name: <span th:text="*{firstName"}></span></p>
    <div>
  - Message Expression : #{...}
    - 미리 정의된 message properties 파일이 존재하고 thymeleaf engine에 등록됬으면 #를 사용할 수 있다.
    - home.welcome=안녕. 방가워
    - <p th:text="#{home.welcome}">인사</p>
  - Link URL Expression : @{...}
    - <a href="list.html" th:href="@{/member/list(memId=${m.id})}">View</a>
  - 반복문
    - th:each 또는 data-th-each 속성으로 사용 가능하다. 
    - java.util.Iterable 인터페이스를 구현한 객체 사용 가능하다. 
    - java.util.Map 인터페이스 구현한 객체도 가능하다. 
  >
      <table>
        <tr th:each="mem : ${members}">
          <td> th:text="${mem.id}"></td>
        </tr> </table>
    - 반복을 돌면서 index 마다 상태값 가져올 수 있다. 변수 옆에 ','찍고 status 변수를 정의하면 된다.
  >
      <table>
        <tr th:each="mem, iter : ${members} th:class="${iter.odd}? 'odd">
          <td> th:text="${mem.id}"></td>
        </tr> </table>
    - iter에는 다음 상태 값들을 가진다.
      - index : 0부터 시작하는 인덱스
      - count : 1 부터 시작하는 인덱스
      - size : list의 size
      - current - 현재 인덱스의 변수
      - even/odd : 홀짝 여부
      - first/last : 처음/마지막 여부
  - 조건문
    - 특정 조건일때 th:if 반대의 경우 th:unless 상용한다. 
  >
    <table>
      <tr th:if"${#lists.size(users)}>0" th:each, iter : ${users}">...
  - fragment
    - <div th:fragment="bottom">...</div>   (footer.html)인 경우
    - <div thLinclude="footer :: bottom"></div> 
    - 위와 같이 사용하려면 뷰지졸버에 prefix를 /WEB-INF/templates/ suffix를 .html로 설정되 있어야 한다. 
    - fragment 대신 id를 참조해 include 할 수 있다. 
      - <div id="bottom"> ...</div>
      - <div th:include="footer::#bottom>></div>
    - fragment로 parameter 전달 하기 
  > 
      <div th:fragment="frag(onevar, twovar)">
        <p th:text="${onever}+'-'+${twovar}">..</p>
      <div>
  >
      <div th:include="::frag(${value1},${value2})>...</div>  

## 웹 어플리케이션 4가지 영역(scope)
  - Page 영역
    - 하나의 JSP 페이지를 처리할 때 사용되는 영역.
    - 한 번의 클라이언트 요청에 대해 하나의 JSP 페이지를 범위로 갖는다. 
    - 웹 브라우저의 요청이 들어오면 JSP 페이지를 실행하는데, 이때 JSP 페이지를 실행하는 범위가 하나의 PAGE가 된다. 
  - REQUEST 영역
    - 하나의 HTTP 요청을 처리할 때 사용되는 영역
    - 한 번의 웹 브라우저 요청과 관련.
    - 웹 브라우저가 웹 서버에 전송하는 요청이 하나의 REQUEST 영역이 된다.
    - 웹 브라우저가 결과를 받으면 요청과 관련된 request 기본 객체는 사라진다. 
    - 웹 바르우저가 요청할 때마다 새로운 request 기본객체가 생성된다. 
  - SESSION 영역
    - 하나의 웹 브라우저와 관련된 영역.
    - 서로 다른 두개의 웹 브라우저가 같은 페이지를 사용하더라도, 두 웹브라우저는 서로 다른 세션 영역에 포함된다. 
    - 세션이 생성되면 하나의 웹 브라우저와 관련된 모든 요청은 하나의 SESION 영역에 포함된다. 
  - APPLICATION 영역
    - 하나의 웹 어플리케이션과 관련된 영역
    - 웹 어플리케이션에 포함된 모든 JSP 페이지, 이 웹 어플리케이션을 사용하는 모든 요청, 브라우저의 세션은 모두 하나의 APPLICATION 영역에 속한다. 
    - 모든 JSP는 한 개의 application 기본 객체를 공유한다. 