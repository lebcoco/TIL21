**:date: 2021. 01. 21. 목**

:clock8: **08:30-**

:bookmark_tabs: **스프링부트** Part1 2차 학습

:green_book: **참고 도서** : 코드로 배우는 스프링부트 웹프로젝트

* [도서정보 바로가기](http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9791189184070&orderClick=LEA&Kc=)

---



:bookmark_tabs: **TIL 요약**

> 도서 코드로 배우는 스프링부트 웹프로젝트 Part1 부분에 대한 복습(2차 학습)
>
> 도서 흐름대로 용어 및 개념을 정리한 문서이다.



:pushpin: **개념 및 용어 정리 1**

**:bookmark: chapter01. [1.1]개발 도구의 준비 ~ [1.3.2]테스트코드의 실행**

* **Lombok**

  * Lombok(롬복)은 Java 라이브러리로 반복되는 `getter`, `setter`, `toString` 등의 메소드 작성 코드를 줄여주는 코드 다이어트 라이브러리.

  * 여러가지 **어노테이션을 제공**하고 이를 기반으로 코드를 컴파일과정에서 생성해 주는 방식으로 동작하는 라이브러리. 
    * **getter & setter 메소드(함수)** 

      1. 객체 지향 프로그래밍에서는 데이터는 외부에서 접근하지 않도록 막고, 메소드는 공개하여, 외부에서 메소드를 통해 데이터에 접근하도록 유도하고, 메소드를 통해 데이터를 변경한다.

    * **메서드(함수)**

      1. 자바의 함수는 클래스 내에 존재하고, 이 클래스 내의 함수를 메소드라고 부른다.

         * 클래스 내의 변수를 필드라고 부른다.

      2. 우리는 믹서기에 과일을 넣는다. 믹서를 이용해 과일을 갈아서 과일 쥬스를 만들어 낸다. 믹서기에 넣는 과일은 입력이 되고 과일 쥬스는 그 출력(리턴값)이 된다. <u>입력을 가지고 어떤 일을 수행한 다음에 결과물을 내어놓는 것</u>, 이것이 메소드가 하는 일이다.

      3. 사용이유: 여러 번 반복해서 사용된다는 것은 언제고 또다시 사용할 만한 가치가 있는 부분이라는 뜻이다. 즉, 이러한 경우 이것을 한 뭉치로 묶어서 <u>“어떤 입력값을 주었을 때 어떤 리턴값을 돌려준다”라는 식의 메소드를 작성하는 것</u>이 현명한 일일 것이다.

      4. 사용예시

         *“sum이라는 메소드는 입력값으로 두개의 값(int 자료형 a, int 자료형 b)을 받으며 리턴값은 두 개의 입력값을 더한 값(int 자료형)이다.”*

         ```java
         public class Test {
             public int sum(int a, int b) {
                 return a+b;
             }
         
             public static void main(String[] args) {
                 int a = 3;
                 int b = 4;
         
                 Test myTest = new Test();
                 int c = myTest.sum(a, b);
         
                 System.out.println(c);
             }
         }
         ```

         

* **Maven & Gradle** 

  * 빌드 배포 도구(Build Tool)이다. 

    * **컴파일** : 사용자가 작성한 코드를 컴퓨터가 이해할 수 있는 언어로 번역하는 일
    * **빌드** : 컴파일된 코드를 실제 실행할 수 있는 상태로 만드는 일->.jar파일 생성된다.
    * **배포** : 빌드가 완성된 실행 가능한 파일을 사용자가 접근할 수 있는 환경에 배치시키는 일

    * 장점으로는 스크립트 언어로 구성되어 있기때문에, XML과 달리 변수선언, if, else, for등의 <u>로직이 구현가능</u>하여 간결하게 구성 가능하다.



* **Maven**
  * Maven은 내가 사용할 라이브러리 뿐만 아니라 해당 라이브러리가 작동하는데 필요한 다른 <u>라이브러리</u>들까지 <u>관리</u>하여 네트워크를 통해 자동으로 다운 받아준다.
    * **라이브러리**란 재사용이 필요한 **기능**으로 반복적인 코드 작성을 없애기 위해 언제든지 필요한 곳에서 호출하여 사용할 수 있도록 Class나 Function으로 만들어진 것이다.



* **Gradle**
  * Maven의 경우 XML로 라이브러리를 정의하고 활용하도록 되어 있으나, Gradle의 경우 별도의 <u>빌드스크립트</u>를 통하여 사용할 <u>어플리케이션 버전, 라이브러리등의 항목을 설정</u> 할 수 있다.



* **테스트 코드 실행**

  * 스프링부트프로젝트에는 테스트 환경이 기본으로 갖춰진다.

  * build.gradle에 자동으로 추가되는 테스트 설정

    ```java
    testImplementation('org.springframework.boot:spring-boot-starter-test') {
            exclude group: 'org.junit.vintage', module: 'junit-vintage-engine'
        }
    ```

    * **Junit** : Java에서 독립된 단위테스트(Unit Test)를 지원해주는 프레임워크

      1. `@Test` 메서드가 호출할 때 마다 새로운 인스턴스를 생성하여 <u>독립적인 테스트</u>가 이루어지게 한다.

      2. 사용예시

         ```java
         @Test
         void contextLoads(){
         	System.out.println("contextLoads...");
         }
         ```

         @Test 어노테이을 선언하여 `contextLoads`메서드가 단위 테스트 메서드임을 선언하였다.



* **@SpringBootTest**
  * SpringBoot는 테스트 목적에 따라 다양한 어노테이션을 제공한다.
    1. 통합테스트: @SpringBootTest
    2. 단위테스트: @DataJpaTest, @JsonTest 등
       * **통합테스트**
         1. 실제 운영 환경에서 사용될 <u>클래스들을 통합하여 테스트</u> 한다.
         2. 단위 테스트와 같이 기능 검증을 위한 것이 아니라 spring framework에서 <u>전체적으로 플로우가 제대로 동작하는지 검증</u>하기 위해 사용 한다.
  * 스프링 부트는 @SpringBootTest 어노테이션을 통해 스프링부트 어플리케이션 테스트에 필요한 거의 모든 의존성을 제공한다.
  * @SpringBootTest는 통합 테스트를 제공하는 기본적인 스프링 부트 테스트 어노테이션 이다. 
     - 해당 어노테이션을 사용시 Junit 버전에 따라 유의할 사항이 있다. (공식문서 참고)
       1. Junit4 사용시 @SpringBootTest 기능은 반드시 JUnit의 SpringJUnit4ClassRunner 클래스를 상속 받는 @<u>RunWith</u>(SpringRynnver.class)와 함께 사용해야 한다.
       2.  Junit5 사용시에는 해당 어노테이션은 명시할 필요없다.


---



:pushpin: **개념 및 용어 정리 2**

**:bookmark: chapter01. [1.3.3]간단한 컨트롤러 실습**

* **MVC**
  * **Model** 어플리케이션이 '무엇'을 할 것인지를 정의. <u>내부 비지니스 로직을 처리</u>하기 위한 역할.
  * **View** 컨트롤러 하위에 종속되어, 모델이나 컨트롤러가 보여주려고 하는 모든 요소를 화면에 보여줌.
  * **Controller** 사용자의 요청 내용을 분석해서 Model과 View에 업데이트 요청.



* **Controller와 RestController의 차이점**

  * 전통적인 Spring MVC 컨트롤러와 Restful 웹서비스 컨트롤러의 주요 차이점은 **HTTP Response Body가 생성되는 방식**이다. 
  * 기존의 <u>MVC 컨트롤러</u>는 <u>view기술</u>을 사용하지만 <u>Restful 웹서비스 컨트롤러</u>는 객체를 반환하기만 하면 객체 데이터는 JSON/XML 형식의 HTTP 응답을 직접 작성하게된다.
    * **Spring MVC Rest의 Work Flow**  
      1. 클라이언트는 <u>URI 형식</u>으로 웹서비스에 요청을 보낸다.

  * **@Controller & @RestController** 

    * **@Controller** 

      1. spring MVC의 컨트롤러인 @Controller는 <u>주로 View를 반환</u>하기 위해 사용한다.

      2. Data를 반환해야 하는 경우도 있는데, <u>@ResposeBody</u>를 사용하여 <u>Json형태로 데이터를 반환</u>할 수 있다.

    * **@RestController** 

      1. Spring MVC Controller에 @<u>ResponseBody</u>가 추가된 것. 당연하게도 RestController의 주용도는 Json 형태로 객체 데이터를 반환하는 것



* **@GetMapping**

  * `@RequestMapping` 어노테이션은 HTTP 요청을 처리하는 메서드(RequestMethod)를 맵핑하는 어노테이션.

    * HTTP 메서드
      1. GET; 데이터 가져올 때 
      2. POST; 데이터 게시
      3. PUT; 데이터 수정
      4. DELETE; 데이터 삭제

  * 메서드(url)에 따라 어떤 페이지를 보여줄지 결정하는 역할.

    ```java
    @GetMapping("/hello")
    ```

    :point_right: 브라우저에서 `http://localhost:8080/hello` 호출



* **jar**
  * 자바 프로젝트 압축 파일

---



:pushpin: **개념 및 용어 정리 2**

**:bookmark: chapter02. [2.1]MariaDB의 설치 및 DB생성 - ** 

* **ORM**(Object-relational mapping)
  * 객체가 DB테이블의 매핑(객체가 테이블처럼 작동할 수 있게 해준다.)
  * SQL Query가 아닌 자바 코드(메서드)로 DB데이터를 제어할 수 있다.
    * MySQL에서는 `SELECT*FROM user`라는 query를 실행하지만
    * ORM을 사용하면 User테이블과 매핑된 객체를 user라고 할 때, `user.findAll()`라는 메서드 호출로 데이터 조회가 가능.



* **JPA**
  * ORM을 Java언어에 맞게 사용하는 '스펙(자바 ORM기술에 대한 API 표준 명세)'
  * JPA는 애플리케이션과 JDBC사이에서 동작한다.



* **Hibernate**
  * JPA 을 구현하는 대표적인 라이브러리



* **Spring Data JPA**

  * Hibernate를 스프링 부트에서 쉽게 사용할 수 있는 추가적인 API제공

  * 그림 참고

    ![img](https://suhwan.dev/images/jpa_hibernate_repository/overall_design.png)

* **Entity 클래스와 JpaRepository**

  * Spring Data JPA개발에 필요한 것은 두 종류의 코드

    1. JPA를 통해 관리되는 객체(Entity Object)를 위한 Entity Class
    2. Entity Object들을 처리하는 기능을 가진 Repository

  * 예시: Memo 클래스(Entity 클래스)

    ```java
    @Entity
    @Table(name= "tbl_memo")
    @ToString
    public class Memo{
    	@Id
    	@GeneratedValue(strategy = GenerationType.INDENTITY)
    	private Long mno;
    }
    ```



* **@Entity**

  * Entity 클래스는 반드시 @Entity어노테이션을 추가해야 한다.
  * 해당 클래스의 <u>인스턴스들</u>이 <u>JPA로 관리되는 엔티티 객체</u>라는 것을 의미

* **@Table**

  * Entity 클래스를 어떤 테이블로 생성할 것인지 정보를 담기 위한 어노테이션.
  * `@Table(name="t_memo")`는 't_memo'라는 이름의 테이블로 생성된다는 뜻이다.

* **@Id**

  * @Entity가 붙은 Entity클래스는 <u>Primary Key에 해당하는 특정 필드</u>를 `@Id`로 지정해야 한다.

    * **필드** : 클래스 안에서 선언되는 변수

      ```java
      class SmartPhone {
        /* fields */
        String name; // 이름
        String color; // 색상
        int price; // 가격
          
        /* methods */
        void call(String phoneNum) {
          // 전화 걸기
        }
        void messege(String phoneNum) {
          // 메세지 보내기
        }
      }
      ```

* 

---

:tulip: **Reference**

**:bookmark: chapter01. [1.1]개발 도구의 준비 ~ [1.3.2]테스트코드의 실행**

1. [Lombok](https://dololak.tistory.com/783)
2. [getter&setter 메소드](https://kephilab.tistory.com/54)
3. [메소드](https://wikidocs.net/225)
4. [Maven&Gradle](https://hyojun123.github.io/2019/04/18/gradleAndMaven/)
5. [Maven](https://jeong-pro.tistory.com/168)
6. [빌드&배포](https://itholic.github.io/qa-compile-build-deploy/)
7. [라이브러리](https://blog.gaerae.com/2016/11/what-is-library-and-framework-and-architecture-and-platform.html)
8. [Junit - 1](https://goddaehee.tistory.com/210)
9. [Junit을 위한 단위테스트](https://epthffh.tistory.com/entry/Junit%EC%9D%84-%EC%9D%B4%EC%9A%A9%ED%95%9C-%EB%8B%A8%EC%9C%84%ED%85%8C%EC%8A%A4%ED%8A%B8)
10. [@SpringBootTest](https://goddaehee.tistory.com/211?category=367461)

**:bookmark: chapter01. [1.1]개발 도구의 준비 ~ [1.3.2]테스트코드의 실행**

1. [MVC](https://medium.com/@jang.wangsu/%EB%94%94%EC%9E%90%EC%9D%B8%ED%8C%A8%ED%84%B4-mvc-%ED%8C%A8%ED%84%B4%EC%9D%B4%EB%9E%80-1d74fac6e256)
2. [@Controller & @RestController-1](https://doublesprogramming.tistory.com/105)
3. [@Controller & @RestController-2](https://mangkyu.tistory.com/49)
4. [Rest](https://gmlwjd9405.github.io/2018/09/21/rest-and-restful.html)

5. [ORM & JPA-1](https://victorydntmd.tistory.com/195)
6. [ORM & JPA-2](https://bamdule.tistory.com/38) :star:
7. [ORM & JPA-3](https://suhwan.dev/2019/02/24/jpa-vs-hibernate-vs-spring-data-jpa/)
8. [field](https://cloudstudying.kr/questions/283)