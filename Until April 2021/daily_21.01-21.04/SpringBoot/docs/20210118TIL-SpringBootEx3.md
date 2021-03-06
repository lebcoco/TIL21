**:date: 2021. 01. 18. 월**

:clock8: **08:30-**

:bookmark_tabs: **스프링부트**-화면 구성을 위한 스프링 **MVC**설정과 **Thymeleaf** 기술활용

:green_book: **코드로 배우는 스프링부트 웹프로젝트**

* [도서정보 바로가기](http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9791189184070&orderClick=LEA&Kc=)

---



####  :tulip: Thymeleaf 

* **사용이유**
  * JSP와 유사하게 ${}을 별도 처리 없이 이용 가능
  * Model에 담긴 객체를 화면에서 Javascript로 처리하기 편리
  * 연산, 포맷 관련 기능을 추가적인 개발 없이 지원
  * 개발 도구 이용시 .html파일로 생성하는데 문제 없음. 별도 확장자 이용X
* **학습내용**
  * Thymeleaf를 이요한 화면 출력과 반복, 제어처리
  * 기본 객체를 이용한 날짜, 시간 처리
  * 레이아웃 기능을 활용해 템플릿 구성하기



####  :tulip: Thymeleaf와 jsp 차이

* **Thymeleaf**는 HTML, XML, JavaScript, CSS 및 일반 텍스트를 처리 할 수 있는 웹 및 독립형 환경에서 사용할 수 있는 <u>Java 템플릿 엔진</u>입니다. Thymeleaf는 html파일을 가져와서 파싱해서 분석후 정해진 위치에 데이터를 치환해서 웹 페이지를 생성합니다.
  * 장단점
    1. 톰캣 같은 웹서버를 실행하지 않고 오프라인에서 수정을 할 수 가 있다. JSP 페이지를 웹브라우저로 열어보면 제대로 된 모양이 보이지 않습니다. => (오프라인에서 템플릿 페이지가 완성된 웹 페이지의 프로토타입을 제공할 수 있다) 
    2. Java 코드를 뷰 내에서 사용할 수 없다.



* **JSP**는 서블릿으로 변환되어 실행이 되어집니다. JSP 내에서 자바 코드를 사용할 수도 있습니다(사용하지 못하도록 설정할 수 있습니다). Thymeleaf는 자바코드를 사용할 수 없고, jsp에서 처럼 커스텀 태그와 같은 기능도 없습니다.
  * 장단점
    1. JSP는 사실 서블릿이다보니 뭐든지 할 수 있다는게 장점이자 단점이 되겠습니다. MVC 구조가 주로 사용되면서 JSP는 뷰만 담당하고, JSP에 비즈니스 로직을 넣으면 디버깅 및 유지보수가 힘들어진다고 하여 요즘은 JSP에서는 자바 코드를 사용하지 못하게 하는게 일반적입니다.

---



####  :tulip: loop in Thymeleaf

* **th:each**

  ```html
  <!DOCTYPE html>
  <html lang="en"  xmlns:th="http://www.thymeleaf.org">
  <head>
    <meta charset="UTF-8">
    <title>Title</title>
  </head>
  <body>
  <ul>
    <li th:each="dto : ${list}">
      [[${dto}]]
    </li>
  </ul>
  </body>
  </html>
  ```

  * 실행화면
    ![](C:\Users\ADMIN\IdeaProjects\TIL21\SpringBoot\docs\img\0118실습1_loopinThymeleaf.PNG)



* **state(상태) 객체**

  * 상태 객체에는 index, count 속성을 이용할 수 있다.
  * index는 0부터 시작하고, count는 1부터 시작한다. 

    ```html
    <li th:each="dto, state : ${list}">
        [[${state.index}]] --- [[${dto}]]
    </li>
    ```

  * 실행화면

    ![](C:\Users\ADMIN\IdeaProjects\TIL21\SpringBoot\docs\img\0118실습1_loopinThymeleaf2_state.PNG)



* **th:if**

  * sno의 값이 5인 배수들만 출력하라

    ```html
     <!--  Thymeleaf 반복문과 if처리 -->
      <p> ▼ Thymeleaf 반복문과 if처리 ▼ </p>
      <li th:each="dto, status : ${list}" th:if="${dto.sno % 5 == 0}">
        [[${dto}]]
      </li>
    ```

  * 실행화면

    ![](C:\Users\ADMIN\IdeaProjects\TIL21\SpringBoot\docs\img\0118실습1_loopinThymeleaf3_if.PNG)



* **th:if 와 th:unless**

  * Thymeleaf는 'if~else' 묶음으로 처리하지 않고, 단독으로 처리한다.

  * sno가 5로 나눈 나머지가 0인 경우에는 sno만을 출력하고, 그렇지 않다면 SampleDTO의 first를 출력하라

    ```html
    <!--  Thymeleaf th:if 와 th:unless -->
      <p> ▼ Thymeleaf th:if 와 th:unless ▼ </p>
      <li th:each="dto, status : ${list}">
        <span th:if="${dto.sno % 5 == 0}" th:text="${'-----------------' +dto.sno}"></span>
        <span th:unless="${dto.sno % 5 == 0}" th:text="${dto.first}"></span>
      </li>
    ```

  * 실행화면

    <img src="C:\Users\ADMIN\IdeaProjects\TIL21\SpringBoot\docs\img\0118실습1_loopinThymeleaf3_ifelse.PNG" style="align:left; zoom:70%; "/>

* **삼항 연산자**

  * 단순 if와 같이 2개의 항만으로 처리할 수 있다.

  * sno가 5로 나눈 나머지가 0인 경우 sno만 출력하고, 나머지는 first를 출력하고 싶다면

    ```html
    <!--  Thymeleaf 삼항연산자 -->
      <p> ▼ Thymeleaf 삼항연산자 ▼ </p>
      <li th:each="dto, status : ${list}" th:text="${dto.sno % 5==0}? ${dto.sno}: ${dto.first}">
      </li>
    ```

  * 실행화면

    ![](C:\Users\ADMIN\IdeaProjects\TIL21\SpringBoot\docs\img\0118실습1_loopinThymeleaf4_Ternary operation.PNG)



* **삼항연산자 + CSS**

  * sno를 5로 나눈 나머지가 0인 경우에만 특정한 CSS를 적용한다면

    ```html
    <!--  Thymeleaf 삼항연산자 + 특정 CSS -->
      <p> ▼ Thymeleaf 삼항연산자 + 특정 CSS ▼ </p>
      <li th:each="dto, status : ${list}" th:class="${dto.sno % 5==0}? 'target'" th:text="${dto}">
      </li>
    ```

  * 실행화면

    ![](C:\Users\ADMIN\IdeaProjects\TIL21\SpringBoot\docs\img\0118실습1_loopinThymeleaf4_Ternary operation+css.PNG)

---



####  :tulip: inline property

* **th:inline**

  * 속성값을 javascript로 지정

    ```html
    <script th:inline="javascript">
      var msg = [[${result}]];
      var dto = [[${dto}]];
    </script>
    ```

    * 브라우저에서 경로는 sample/exInline으로 호출하고, 브라우저는 sample/ex3을 다시 호출하여 결과를 보여준다.

  * 실행화면

    ![](C:\Users\ADMIN\IdeaProjects\TIL21\SpringBoot\docs\img\0118실습2_loopinThymeleaf4_inline.PNG)

    * 별도의 처리가 없음애도 문자열을 자동으로 `""`이 추가되어 문자열이 된다.
    * 같이 전송된 dto는 Json 포맷의 문자열이 된 것을 볼 수 있다.

* **th:blcok**

  * 별도의 태그가 필요하지 않다. 반드시 태그에 붙어 `th:text`나 `th:value`등을 써야 하는 제약이 없다.

  * 앞서 'sno가 5로 나눈 나머지가 0인 경우에는 sno를 출력하고, 그렇지 않다면 first를 출력해야하는 경우' 다시 구성해보자.

    ```html
    <!-- th:blcok -->
      <p> ▼ Thymeleaf th:block ▼ </p>
      <ul>
        <th:block th:each="dto: ${list}">
          <li th:text="${dto.sno % 5 == 0}?${dto.sno}:${dto.first}"></li>
        </th:block>
      </ul>
    </ul>
    ```



---



####  :tulip: 링크 처리

* **@{ }**

  ```html
  <ul>
    <li th:each="dto : ${list}" >
      <a th:href="@{/sample/exView(sno=${dto.sno})}">[[${dto}]]</a>
    </li>
  </ul>
  ```

  * 실행화면

    ![](C:\Users\ADMIN\IdeaProjects\TIL21\SpringBoot\docs\img\0118실습3_tymeleaf_link.PNG)

  * sno와 같은 파라미터를 추가하기 위해서는 다음과 같이 '키'와 '값'의 형태를 추가한다.

    ```html
    <li th:each="dto : ${list}" >
         <a th:href="@{/sample/exView/{sno}(sno = ${dto.sno})}">[[${dto}]]</a>
    </li>
    ```

    * 실행화면

      ![](C:\Users\ADMIN\IdeaProjects\TIL21\SpringBoot\docs\img\0118실습4_tymeleaf_link2.PNG)

---



####  :tulip: Thymeleaf의 기본 객체와 LocalDateTime

* **basic objects**

  * sno를 모두 5자리로 만들어라

    ```html
      <!-- 기본 객체와 LocalDateTime-->
      <p> ▼ Thymeleaf localDateTime ▼ </p>
      <li th:each="dto : ${list}">
        [[${#numbers.formatInteger(dto.sno,5)}]]
      </li>
    ```

  * 실행화면

    ![](C:\Users\ADMIN\IdeaProjects\TIL21\SpringBoot\docs\img\0118실습5_tymeleaf_localDateTime1.PNG)

  

  :point_right: 편리하게 처리하기 위해 build.gradle에 의존성을 추가합니다. 

  * [의존성 추가 링크 바로가기](https://github.com/thymeleaf/thymeleaf-extras-java8time)







####  :tulip: Reference 

1. Thymeleaf와 jsp 차이 
   * [참고-블로그 쉬고싶은 개발자](https://offbyone.tistory.com/410)

