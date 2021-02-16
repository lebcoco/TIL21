**:date: 2021. 02. 15 - 19** 

:clock8: **09:00-**

:bookmark_tabs: **업무 관련 용어 및 개념정리** 

:heavy_check_mark: **springBoot+NginX**



1. **스프링부트 내장서버**

* 톰캣
  * ServletWebServerFactoryAutoConfiguration 클래스에 자동으로 Tomcat 설정.



2. **Reverse Proxy**

   클라이언트가 naver.com 웹 서비스에 데이터를 요청하면 **Reverse Proxy**는 이 요청을 받아서 내부 서버에서 데이터를 받은후에 이 데이터를 클라이언트에 전달하게 된다. 내부 서버가 직접 서비스를 제공해도 되지만 이렇게 구성하는 이유중 하나는 보안때문이다.

   **Reverse Proxy** 서버를 두고 실제 서비스 서버는 내부망에 위치시키고 Proxy 서버만 내부에 있는 서비스 서버와 통신해서 결과를 클라이언트에게 제공하는 방식으로 서비스를 하게 된다.



:pineapple: **Reference**

[1. 스프링부트에서 톰캣 말고 다른 내장 서버 쓰고싶을 때](https://engkimbs.tistory.com/755)

[2. Reverse Proxy](https://www.lesstif.com/system-admin/forward-proxy-reverse-proxy-21430345.html)