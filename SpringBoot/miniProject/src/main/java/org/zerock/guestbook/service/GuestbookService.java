package org.zerock.guestbook.service;
import org.zerock.guestbook.dto.GuestbookDTO;
import org.zerock.guestbook.entity.Guestbook;
// 방명록 등록하는 시나리오 처리
public interface GuestbookService {
  Long register(GuestbookDTO dto);
  // default기능을 활용해 구현 클래스에서 동작할 수 있는 dtoToEntity()구성
  default Guestbook dtoToEntity(GuestbookDTO dto) {
    Guestbook entity = Guestbook.builder()
        .gno(dto.getGno())
        .title(dto.getTitle())
        .content(dto.getContent())
        .writer(dto.getWriter())
        .build();
    return entity;
  }
}