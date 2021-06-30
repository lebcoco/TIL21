# TIL

:date: **2021. 02. 04 목**

:bookmark_tabs: **개념정리** 

**:bookmark: javascript와 jQuery의 DOM접근** 

---

> 2021.01.30 TIL-DOM에 이어 javascript와 jQuery의 DOM 접근에 대한 차이를 알아본다.
>
> [2021.30 TIL-DOM 바로가기](https://github.com/lebcoco/TIL21/blob/main/Front-end/20210130_TIL-DOM.md)



#### 1. **DOM 이란?**

**DOM**은 문서 객체 모델(The Document Object Model, 이하 DOM)로, XML이나 HTML 문서에 접근하기 위한 API(W3C 표준 권고안)이다.

 

![](https://upload.wikimedia.org/wikipedia/commons/5/5a/DOM-model.svg)

<center><그림1-1> The HTML DOM Tree of Objects<center>

​    

![](http://www.tcpschool.com/lectures/img_xml_nodetree.png)

<center><그림1-2> The HTML DOM Tree of Objects<center>

​    

![](https://www.w3schools.com/js/pic_htmltree.gif)

<center><그림1-3> The HTML DOM Tree of Objects<center>

​    

<그림1-3> 위 트리 구조를 보면, Element(태그)뿐만 아니라 Attribute, Text까지 **노드**로 표현되어 있음을 알 수 있다. 즉, **DOM을 통해** 스크립트가 <span style="color:blue">문서 내의 모든 요소에 동적으로 접근할 수 있다</span>는 것이다.

* DOM을 통해 문서상 요소에 접근하여 속성을 조작하고, 웹 페이지상의 다양한 상호작용 작업을 할 수 있다.
  * 이를 순수 Javascript로 하게 되면, 다수의 반복문과 긴 스크립트를 작성해야 하는 경우가 많은데, jQuery가 이를 해결해준다.



#### 2. **jQuery와 javascript의 DOM 접근**

* :blue_heart: **jQuery**는 DOM객체 생성함수인 `$();`을 사용하여 CSS의 <u>**선택자(Selector)**</u> 방식을 사용해서 간단하게 DOM에 접근한다.
* :yellow_heart: **javascript**는 브라우저의 여러 가지 내장 **<u>메소드(method)</u>**를 통해 DOM에 접근한다.

<img src="https://www.nextree.co.kr/content/images/2021/01/yrkim-140510-jquery_dom-02-1024x381.png" style="zoom:60%;" />

<center><그림2-1> CSS선택자와 jQuery선택자<center>

​    

|              | jQuery                 | javascript                                                   |
| ------------ | ---------------------- | ------------------------------------------------------------ |
| id 선택자    | `$("#id")`             | 1. document.getElementsById("id");<br />2. document.querySelectorAll("#id") |
| tag 선택자   | `$("tag")`             | 1. document.getElementsByTag("tag");<br />2. document.querySelectorAll("tag") |
| Class 선택자 | `$(".Class")`          | 1. document.getElementsByClassName("Class");<br />2. document.querySelectorAll(".Class") |
| 속성 선택자  | `$("[name=property]")` | 1. document.getElementsByName("property");<br />2. document.querySelectorAll("name=property") |

 <center><표2-1> DOM접근을 위한 선택자(jQuery)와 메소드(javscript) <center>



```javascript
$(function(){
    //javascript 메소드를 활용한 DOM 접근1
	var a = document.getElementsByTagName("id");
	console.log(a);
    
    //javascript 메소드를 활용한 DOM 접근2
	var b = document.querySelectorAll("#id");
	console.log(b);
    
    //jQuery 선택자를 활용한 DOM 접근
	var c = $("#id");
	console.log(c);
});
```

 <center><코드2-1> jQuery와 javascript의 DOM 접근 예시 <center>

​     

---

"jQuery를 사용하면, 아무래도 순수 JavaScript에 비해 속도가 느린 것이 사실입니다. 물론 DOM접근 자체를 최소화하는 것이 성능 면에서는 가장 좋은 것이지요. 하지만 단순하면서도 다양한 기능들을 사용할 수 있게 해주는 편리함은, jQuery를 가장 널리 쓰이는 JavaScript라이브러리로 만들어 주었습니다. jQuery의 장점을 최대화하면서도 성능의 측면을 함께 고민하는 개발을 해야겠다는 생각이 듭니다." **:speech_balloon: *넥스트리소프트 blog***

---







:tulip: **Reference**

[1. velog_DOM이란 무엇인가](https://velog.io/@surim014/DOM%EC%9D%B4%EB%9E%80-%EB%AC%B4%EC%97%87%EC%9D%B8%EA%B0%80)

[2. wiki_문서객체모델](https://ko.wikipedia.org/wiki/%EB%AC%B8%EC%84%9C_%EA%B0%9D%EC%B2%B4_%EB%AA%A8%EB%8D%B8)

[3. WIT블로그_DOM이란 정확히 무엇일까?](https://wit.nts-corp.com/2019/02/14/5522)

[4. Dom이란_TCP SCHOOL.com](http://www.tcpschool.com/xml/xml_dom_concept)

[5. DOM이란](https://www.nextree.co.kr/p9747/)

[6. jQuery와 DOM 첫걸음](https://www.nextree.co.kr/p9747/)

