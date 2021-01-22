package org.zerock.guestbook.dto;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.Data;
import org.springframework.data.domain.Page;

//JPA를 이용하는 Repository에서는 페이지 처리 결과를 Page<Entity> 타입으로 반환하게 된다.
//Page<Entity>의 객체물을 DTO객체로 변환해서 자료구조로 담아줘야 한다.
@Data
public class PageResultDTO<DTO, EN> {
  private List<DTO> dtoList;
  public PageResultDTO(Page<EN> result , Function<EN, DTO> fn){ //Function<EN,DTO>는 엔티티 객체들을 DTO로 변환해 주는 기능.
    dtoList = result.stream().map(fn).collect(Collectors.toList());
  }
}
