package org.zerock.guestbook.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.zerock.guestbook.entity.Guestbook;


import java.util.Optional;
import java.util.stream.IntStream;
import org.zerock.guestbook.entity.QGuestbook;


@SpringBootTest
public class GuestbookRepositoryTests {

  @Autowired
  private GuestbookRepository guestbookRepository;

  // test DB 300개
  @Test
  public void insertDummies() {

    IntStream.rangeClosed(1, 300).forEach(i -> {

      Guestbook guestbook = Guestbook.builder()
          .title("Title...." + i)
          .content("Content..." + i)
          .writer("user" + (i % 10))
          .build();
      System.out.println(guestbookRepository.save(guestbook));
    });
  }

  // 수정 시간 테스트
  @Test
  public void updateTest() {
    Optional<Guestbook> result = guestbookRepository.findById(300L); //존재하는 번호로 테스트

    if (result.isPresent()) {

      Guestbook guestbook = result.get();

      guestbook.changeTitle("Changed Title....");
      guestbook.changeContent("Changed Content...");

      guestbookRepository.save(guestbook);
    }
  }

  // 단일 항목 검색 테스트
  // 제목(title)에 '1'이라는 글자가 있는 entity들을 검색
  @Test
  public void testQuery1() {
    Pageable pageable = PageRequest.of(0, 10, Sort.by("gno").descending());

    // 동적 처리를 위한 Q도메인 클래스를 얻어온다.
    // Q도메인 클래스를 이용하면 entitiy 클래스에 선언된 title, content같은 필드를 변수로 활용할 수 있음.
    QGuestbook qGuestbook = QGuestbook.guestbook; //1

    String keyword = "1";
    
    // BooleanBuilder는 where문에 들어가는 조건들을 넣어주는 컨테이너
    BooleanBuilder builder = new BooleanBuilder();  //2

    // 원하는 조건은 필드 값과 결합하여 생성.
    // BooleanBuilder 안에 들어가는 값은 com.querydsl.core.types.Predicate 타입이어야 한다.
    BooleanExpression expression = qGuestbook.title.contains(keyword); //3

    // 만들어진 조건은 where문에 and나 or같은 키워드와 결합시킨다.
    builder.and(expression); //4

    // BooleanBuilder는 GuestbookRepository에 추가된
    // QuerydslPredicateExcutor인터페이스의 findAll()을 사용할 수 있다.
    Page<Guestbook> result = guestbookRepository.findAll(builder, pageable); //5

    result.stream().forEach(guestbook -> {
      System.out.println(guestbook);
    });
  }
}