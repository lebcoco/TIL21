package org.zerock.guestbook.service;
import org.zerock.guestbook.dto.GuestbookDTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.dto.PageResultDTO;
import org.zerock.guestbook.entity.Guestbook;
// 방명록 등록하는 시나리오 처리
public interface GuestbookService {
  Long register(GuestbookDTO dto);
  // default기능을 활용해 구현 클래스에서 동작할 수 있는 dtoToEntity()구성
  PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO);

  default Guestbook dtoToEntity(GuestbookDTO dto) {
    Guestbook entity = Guestbook.builder()
        .gno(dto.getGno())
        .title(dto.getTitle())
        .content(dto.getContent())
        .writer(dto.getWriter())
        .build();
    return entity;
  }

  default GuestbookDTO entityToDto(Guestbook entity){

    GuestbookDTO dto  = GuestbookDTO.builder()
        .gno(entity.getGno())
        .title(entity.getTitle())
        .content(entity.getContent())
        .writer(entity.getWriter())
        .regDate(entity.getRegDate())
        .modDate(entity.getModDate())
        .build();

    return dto;
  }

  GuestbookDTO read(long gno);
}