**:date: 2021. 02. 24** 

:clock8: **09:00-**

:bookmark_tabs: **업무 관련 용어 및 개념정리** 



#### front consoled

---

**스레드(thread)**

스레드(thread)란 프로세스(process) 내에서 실제로 작업을 수행하는 주체.

* 프로그램이 복잡해 지며 단일 프로세스로 프로그램을 실행하기 어려워 졌고, 프로세스보다 저 작은 실행단위 개념이 필요하게 되었는데, 이것이 스레드다.



**스레드의 생성과 실행**

1. Thread 클래스를 상속받는 방법

2. Runnable 인터페이스를 구현하는 방법

   1. class 선언 -> Runnable인터페이스 implements함

      ```java
      class '클래스 이름' implements Runnable
      ```

   2. run() 메서드를 오버라이드하여 구현

---

**주요 외부 프로세스 6개**

1. **mariaDB**
2. **zookeeper**
3. **ifluxDB**
4. **sFlowRT**
5. **hsflowD**
6. **openV switch**

---

**WAS**

* 동적인 데이터를 처리하는 Web Server를 WAS(Web Application Server)라고 함.

- WAS구성
  - 웹서버와 웹 컨테이너의 결합.
  - 사용자 요청(웹 브라우저) -> 웹 서버 -> WAS(동적 처리) -> 웹 서버 -> 사용자 응답 메세지(웹 브라우저)
- 많이 사용하는 WAS는 Apache의 Tomcat, IBM사의 Web Sphere, T-max사의 Jeus..등



**웹서버란?**

- 클라이언트의 요청을 받아 HTML이나 오브젝트를 HTTP 프로토콜을 이용해 전송하는 일.
- 사용자가 요청한 것들 중 웹서버 자체적으로 처리할 수 없는 것들을 톰캣과 같은 컨테이너에게 넘겨 처리 결과를 받아와서 클라이언트에게 넘겨주는 역할도 수행하기도 합니다.
- 웹서버만 구축된 서버는 웹페이지, 이미지 등 정적인 컨텐츠만 제공 가능합니다.
- 컨테이너가 탑재되어 있는 WAS의 경우 동적인 컨텐츠도 제공이 가능합니다.

---







:pineapple: **Reference**

[1. 프로세스와 스레드1](https://velog.io/@raejoonee/%ED%94%84%EB%A1%9C%EC%84%B8%EC%8A%A4%EC%99%80-%EC%8A%A4%EB%A0%88%EB%93%9C%EC%9D%98-%EC%B0%A8%EC%9D%B4)

[2. 프로세스와 스레드2](http://www.tcpschool.com/java/java_thread_concept)

[3. Runable 심화](https://deveric.tistory.com/22)

[4. Apache Tomcat](https://ithub.tistory.com/101)

[5. MyBatis](https://sjh836.tistory.com/127)