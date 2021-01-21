**:date: 2021. 01. 14. 목**

:clock8: **08:30-**

:bookmark_tabs: **스프링부트**

:green_book: **코드로 배우는 스프링부트 웹프로젝트**

:heavy_check_mark: **이슈 : 'test코드에서 lombok 적용 안됨'**

---



:heavy_check_mark: **이슈 해결 과정**

**step1. Settings 설정** (참고: [블로그-꾸준함](https://jaimemin.tistory.com/1379))

* **1. File -> Setting -> Build, Execution, Deployment -> Compiler -> Annotation Processors -> Enable annotation processing**

  

  ![img](https://blog.kakaocdn.net/dn/x2NBj/btqC2tY3Abr/PJ0zUrCP2rrlLyrej5AfcK/img.png)

* **2. File -> Invalidate Caches / Restart**



**step2. 테스트 환경에서 Lombok 활용하기** (코드로 배우는 스프링부트 웹프로젝트-26p)

* build.gradle의 설정에서 'testxxx'로 시작하는 설정을 추가해야 한다.

  ```java
  dependencies{
  	testCompile('org.projectlombok:lombok')
      testAnnotationProcessor('org.projectlombok:lombok')
  }
  ```

---



:bookmark_tabs: **용어 및 개념 정리**



* **lombok**

  1. lombok 같은 것들은 컴파일시에만 필요한 대표적인 의존성이다.

  2. @NoArgsConstructor @AllArgsConstructor

     * @NoArgsConstructor는 기본생성자, @AllArgsConstructor는 필드값을 모두 포함한 생성자를 자동 생성해준다.

       :computer: 기본생성자, 모든 필드값을 받는 생성자를 직접 명시한 클래스(**lombok** :x:) 

       ```java
       public class Book {
           private String name;
           private int price;
           private String releaseDate;
       
           //기본생성자
           public Book() {
           }
       
           //모든 필드 값 받는 생성자
           public Book(String name, int price, String releaseDate) {
               this.name = name;
               this.price = price;
               this.releaseDate = releaseDate;
           }
       }
       ```

       :computer: 롬복의 @NoArgsConstructor @AllArgsConstructor를 사용한 경우(**lombok** :o:) 

       ```java
       @NoArgsConstructor
       @AllArgsConstructor
       public class Book {
           private String name;
           private int price;
           private String releaseDate;
       }
       ```

       :cherry_blossom:**필드**: 객체 데이터 <u>저장</u>되는 곳

       :cherry_blossom:**생성자**: 객체 생성시 <u>초기화</u> 역할

       :cherry_blossom:**메서드**: 객체 동작에 해당하는 <u>실행블록</u>

       :cherry_blossom:**오버로딩**: 같은 이름의 함수(메서드)를 여러개 정의하고, 매개변수의 유형과 개수를 다르게 하여 다양한 유형의 호출에 응답할 수 있게됩니다. (메소드가 같아도 파라미터가 다르면)



* **Service 인터페이스와 ServiceImpl을 만드는 이유**
  * **ServiceImpl**은 MVC 패턴에서 비즈니스로직을 수행하는 역할을 합니다. 
    * **비즈니스 로직**이란, 기능을 구현하는 <u>구현부</u>입니다. 예를들면, '글 작성', '글 수정', '글 삭제', '글 조회' 등 기능을 비즈니스 로직이라고 합니다. 
    * 비즈니스 로직을 **수행**하기 위해 <u>Service는 인터페이스(Interface)파일</u>로, <u>ServiceImpl은 클래스(Class)파일</u>로 작성합니다.
    
  * ServiceImpl은 순수 자바객체로 이루어져 있습니다. 
  
  * Service와 ServiceImpl 이해를 위한 테스트 코드
  
    ![](C:\Users\ADMIN\Desktop\서비스서비스임플2-완벽이해.PNG)



:tulip: **Reference**

[1. lombok 적용 (참고:블로그;simple is best)](https://m.blog.naver.com/PostView.nhn?blogId=vefe&logNo=222072718782&proxyReferer=https:%2F%2Fwww.google.com%2F)

[2. @NoArgsConstructor(참고:블로그;siyoon210)](https://siyoon210.tistory.com/24)

[3. 오버로딩&오버라이딩(참고:블로그;공부해서남주자)](https://private.tistory.com/25)

[4. Service 인터페이스와 ServiceImpl을 만드는 이유(참고:블로그;aquarius1997)](https://velog.io/@aquarius1997/Service%EC%99%80-ServiceImpl)

[5. Service, ServiceImpl2](https://elvis-note.tistory.com/entry/9-Spring-MVC-2-Service%EC%99%80-ServiceImpl)

[5. Insert, Update, Delete(참고:블로그;수까락)](http://egloos.zum.com/sweeper/v/3001313)

