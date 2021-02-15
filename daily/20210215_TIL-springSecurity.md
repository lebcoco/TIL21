**:date: 2021. 02. 15**

:clock8: **09:00-**

:bookmark_tabs: **업무 관련 용어 및 개념정리** 

---



**SSO (Single Sign-On)**

* SSO(Single Sign-On)는 사용자가 사용하는 모든 애플리케이션에 로그인할 필요가 없음을 의미합니다. 사용자가 한 번 로그인하면 다른 앱에도 해당 자격 증명이 사용됩니다.

**SpringSecurity**

* 스프링 시큐리티의 기본 Maximum Session 설정은 전역으로 적용되게 되어있다. 

  *  `ConcurrentSessionControlAuthenticationStrategy`의 `getMaximumSessionsForThisUser`메소드를 사용하면 권한 또는 사용자의 정보에 따라서 세션수를 조절하는게 가능하다.

* SecurityConfig.java

  ```java
  @Configuration
  @EnableWebSecurity
  @Slf4j
  public class SecurityConfig extends WebSecurityConfigurerAdapter {
  
      //기존코드시작
      //스프링시큐리티가 사용자를 인증하는 방법이 담긴 객체
      @Override
      protected void configure(AuthenticationManagerBuilder auth) throws Exception {
          String password = passwordEncoder().encode("1111");
          auth.inMemoryAuthentication().withUser("user").password(password).roles("USER");
          auth.inMemoryAuthentication().withUser("manager").password(password).roles("USER","MANAGER");
          auth.inMemoryAuthentication().withUser("admin").password(password).roles("USER","MANAGER","ADMIN");
      }
  
      @Bean
      public PasswordEncoder passwordEncoder() {
          return new BCryptPasswordEncoder();
      }
  
      @Override
      protected void configure(final HttpSecurity http) throws Exception {
          http
                  .authorizeRequests()    //보호된 리소스 URI에 접근할 수 있는 권한 설정
                  .antMatchers("/").permitAll()   //전체 접근 허용
                  .antMatchers("/mypage").hasRole("USER")     //USER 롤만 접근 허용
                  .antMatchers("/messages").hasRole("MANAGER")    //MANAGER 롤만 접근 허용
                  .antMatchers("/config").hasRole("ADMIN")    //ADMIN 롤만 접근 허용
                  .anyRequest().authenticated()
  
          .and()
              .formLogin()
          .and()
              .logout().permitAll()
          .and()
              .sessionManagement()
              .maximumSessions(1)
              .maxSessionsPreventsLogin(true);
      }
  }
  ```

  

:pineapple: **Reference**

[1. 중복 로그인 방지](https://fknd12.tistory.com/5)

[2. 스프링시큐리티](https://velog.io/@jayjay28/2019-09-04-1109-%EC%9E%91%EC%84%B1%EB%90%A8)

[3. Http시큐리티](https://yellowh.tistory.com/138)

[4. MaxSession](https://blusky10.tistory.com/313)

[5. 권한별 MaximumSession 결정하기](https://blusky10.tistory.com/313)



