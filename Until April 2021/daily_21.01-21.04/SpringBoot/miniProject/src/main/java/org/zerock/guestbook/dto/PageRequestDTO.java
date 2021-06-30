package org.zerock.guestbook.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Builder
@AllArgsConstructor
@Data
public class PageRequestDTO {

  private int page; //화면에서 전달되는 page라는 parameter
  private int size; //화면에서 전달되는 size라는 parameter

  // 페이지 번호는 기본 값을 갖는게 좋다. 1과, 10 기본 값
  // PageRequestDTO의 목적은 JPA에서 사용하는 pageable타입의 객체를 생성하는 것.
  public PageRequestDTO(){
    this.page = 1;  
    this.size = 10;
  }

  public Pageable getPageable(Sort sort){

    // JPA를 이용하는 경우 페이지 번호가 0부터 시작하므로 page-1을 해준다.
    return PageRequest.of(page -1, size, sort);

  }
}
