package org.zerock.ex2.repository;


import java.util.Optional;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.ex2.entity.Memo;

@SpringBootTest
class MemoRepositoryTests {

  @Autowired
  MemoRepository memoRepository;

  @Test
  public void testClass() {
    System.out.println(memoRepository.getClass().getName());
  }

  // 등록 작업 테스트
  @Test
  public void testInsertDummies() {
    IntStream.rangeClosed(1, 100).forEach(i -> {
      Memo memo = Memo.builder().memoText("Sample..." + i).build();
      memoRepository.save(memo);
    });
  }

  // 조회 작업 테스트 - findById()
  @Test
  public void testSelect() {
    //데이터베이스에 존재하는 mno
    Long mno = 100L;
    Optional<Memo> result = memoRepository.findById(mno);
    System.out.println("==================================");
    if (result.isPresent()) {
      Memo memo = result.get();
      System.out.println(memo);
    }
  }

  // 조회 작업 테스트 - getOne()
  @Transactional
  @Test
  public void testSelect2() {
    //데이터베이스에 존재하는 mno
    Long mno = 100L;
    Memo memo = memoRepository.getOne(mno);
    System.out.println("===============================");
    System.out.println(memo);
  }

  // 수정 작업 테스트
  @Test
  public void testUpdate() {
    Memo memo = Memo.builder().mno(100L).memoText("Update Text").build();
    System.out.println(memoRepository.save(memo));
  }

  // 삭제 작업 테스트
  @Test
  public void testDelete() {
    Long mno = 100L;
    memoRepository.deleteById(mno);
  }
}