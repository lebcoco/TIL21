**:date: 2021. 01. 20. 수**

:clock8: **08:30-**

:bookmark_tabs: **스프링부트** Part2 - Spring/MVC/JPA/Thmeleaf 미니프로젝트 - 방명록 만들기~! 뚜둥

:green_book: **코드로 배우는 스프링부트 웹프로젝트**

* [도서정보 바로가기](http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9791189184070&orderClick=LEA&Kc=)

---



####  :tulip: 엔티티 클래스와 Querydsl 설정

* **동적 쿼리 처리를 위한 Querydsl 설정**
  
  * JPA 쿼리메서드의 기능과 @Query는 선언시 고정된 형태의 값만 가진다는 단점.
  * 경우의 수가 많은 상황에서 동적 쿼리 생성 처리 기능 필요. <-**Querydsl**이 할 수 있다:smile:
* **Querydsl**

  * Querydsl을 이용하면 코드 내부 상황에 맞는 쿼리 생성 가능. 이를 위해 **Q도메인**을 이용해야 한다.

  * build.gradle에 설정 추가

    ```java
    plugins {
        //생략
        id 'com.ewerk.gradle.plugins.querydsl' version '1.0.10' //추가된 항목1
    }
    dependencies {
        //생략
        implementation 'com.querydsl:querydsl-jpa' //추가된 항목2
    }
    //추가된 항목3
    def querydslDir = "$buildDir/generated/querydsl"
    
    querydsl {
        jpa = true
        querydslSourcesDir = querydslDir
    }
    
    sourceSets {
        main.java.srcDir querydslDir
    }
    
    configurations {
        querydsl.extendsFrom compileClasspath
    }
    
    compileQuerydsl {
        options.annotationProcessorPath = configurations.querydsl
    }
    ```

    :point_right: build.gradle 파일 **갱신** (ㅔㄴ..3시간 걸림)

    :point_right: 실행 가능한 task가 추가되었다.		![](C:\Users\ADMIN\IdeaProjects\TIL21\SpringBoot\docs\img\0120실습1_guestbook-querydsl-gradle추가.png)



* **엔티티 테스트**

  * GuestbookRepositoryTests에 300개의 테스트 데이터를 넣는다.

  * 실행화면

    ![](C:\Users\ADMIN\IdeaProjects\TIL21\SpringBoot\docs\img\0120실습2_guestbook-엔티티테스트 300개DB.PNG)



* **수정시간 테스트**

  * 제목(title), 내용(content)을 수정할 수 있도록 `changeTitle()`, `changeContent()`와 같은 메서드를 추가하여 Guestbook클래스를 수정한다.

  * 수정 코드

    ![](C:\Users\ADMIN\IdeaProjects\TIL21\SpringBoot\docs\img\0120실습3_guestbook-수정시간테스트144.png)

  * 실행화면

    ![](C:\Users\ADMIN\IdeaProjects\TIL21\SpringBoot\docs\img\0120실습3_guestbook-수정시간테스트145.png)

---



####  :tulip: Querydsl 테스트

* **단일 항목 검색 테스트**

  * '제목(title)'에 '1'이라는 글자가 있는 엔티티들 검색

  * 실행화면

    ![](C:\Users\ADMIN\IdeaProjects\TIL21\SpringBoot\docs\img\0120실습4_guestbook-단일항목검색테스트.PNG)



* **다중 항목 검색 테스트**

  * '제목(title)' 혹은 내용(content)에 특정한 키워드가 있고 'gno가 0보다 크다'같은 조건을 처리해보자.

  * 실행화면

    ![](C:\Users\ADMIN\IdeaProjects\TIL21\SpringBoot\docs\img\0120실습4_guestbook-다중항목검색테스트.PNG)

---



#### :tulip: 서비스 계층과 DTO

* **서비스 계층의 테스트**

  * testRegister()는 실제로 데이터베이스에 저장되지는 않지만 GuestbookDTO를 Guestbook엔티티로 변환한 결과를 확인할 수 있다.

  * 실행화면

    ![](C:\Users\ADMIN\IdeaProjects\TIL21\SpringBoot\docs\img\0120실습5-1_guestbook-서비스계층의테스트.png)

    :point_right: 변환작업에 문제가 없다. 

  * 문제가 없으니! GuestbookServiceImpl클래스를 수정해 실제로 데이터베이스에 처리가 완료되도록 해보자~~

    * GuestbookServiceImpl클래스는 JPA처리를 위해 GuestbookRepository를 주입하고, 클래스 선언시 @RequiredArgsConstructor를 이용해 자동으로 주입한다.

  * 실행화면

    ![](C:\Users\ADMIN\IdeaProjects\TIL21\SpringBoot\docs\img\0120실습5-2_guestbook-DTO DB에추가.png)

---



#### :tulip: Reference

[1. DAO, DTO. Entity Class의 차이 - 출처:블로그 heejeong Kwon](https://gmlwjd9405.github.io/2018/12/25/difference-dao-dto-entity.html)