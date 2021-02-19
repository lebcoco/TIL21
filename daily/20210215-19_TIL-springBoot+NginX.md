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



3. **Test 진행**

   * TEST 구성도

     ![](C:\Users\ADMIN\IdeaProjects\TIL21\daily\img\0218_X-Frame-Options to deny+CORS 이슈.PNG)

   * TEST 이전 오류 화면

     ![](C:\Users\ADMIN\IdeaProjects\TIL21\daily\img\0218_X-Frame-Options to deny+CORS 이슈-에러화면.PNG)

   * TEST 이후 해결 화면

     ![](C:\Users\ADMIN\IdeaProjects\TIL21\daily\img\0218_X-Frame-Options to deny+CORS 이슈-해결화면.PNG)
     
     
 4. **$.ajax**
    * TE
      ```
      <script>
      $.ajax({
        type: 'get',
        url:'http://iframeTestEB:8080',
        data: {},
        success: function(response){
        console.log('CHECK THE RESPONSE(success):'+response);
        $("#innerFrame").attr("src", response);
        },
        error: function(data){
        console.log('CHECK DATA(error):'+data);
        }
        });
        </script>        
    * $.ajax
     1. $.get() : 서버에서 데이터를 http get 방식으로 전송한 후 서버 측 응답을 받을 때 사용.
       ```
       $.ajax({

      type: 'GET',

      url: url,

      data: data,

      success: success,

      dataType: dataType
      });
:smile: 
1. url : 요청 Url
2. data : 요청과 함께 서버로 데이터를 전송 할 string 또는 map
3. dataType : 서버측에서 전송받은 데이터의 형식 (default : xml, json, script, text, html)
4. seccess (PlainObject data, String textStatus, jqXHR jqXHR) : 요청이 성공 했을 때 호출할 콜백 함수
5. type : 데이터를 전송하는 방법 (get, post)

:pineapple: **Reference**

[1. 스프링부트에서 톰캣 말고 다른 내장 서버 쓰고싶을 때](https://engkimbs.tistory.com/755)

[2. Reverse Proxy](https://www.lesstif.com/system-admin/forward-proxy-reverse-proxy-21430345.html)

[3. jQuery ajax통신](https://electronic-moongchi.tistory.com/72)
