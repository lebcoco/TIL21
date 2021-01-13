**:date: 2021. 01. 13. 수**

:clock8: **09:00-19:00**

:bookmark_tabs: **스프링부트**

:green_book: **코드로 배우는 스프링부트 웹프로젝트**

:heavy_check_mark: **이슈 : Cannot resolve symbol 'SpringBootTest'**



:heavy_multiplication_x: **오류** : Cannot resolve symbol 'SpringBootTest'

![](C:\Users\ADMIN\IdeaProjects\TIL21\SpringBoot\docs\img\0113_1_오류.PNG)  

:tulip: [참고-최혜선 블로그](https://hyesun03.github.io/2019/08/27/intellij-cannot-resolve-symbol-error/) 

* **1차 시도**
  * 상단 메뉴바에서 `Build > Clean Project` 하고나서 `Build > Rebuild Project`를 한다.

* **2차 시도**
  * 1차 시도로 해결이 안되면 캐시를 비우고 재실행 하는것이다. 상단 메뉴바에서 `File > Invalidate Caches / Restart…`를 선택하고 IDE를 재실행 한다.