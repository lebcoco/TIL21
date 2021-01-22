package org.zerock.guestbook.service;
import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.zerock.guestbook.dto.GuestbookDTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.dto.PageResultDTO;
import org.zerock.guestbook.entity.Guestbook;
import org.zerock.guestbook.repository.GuestbookRepository;
@Service
@Log4j2
@RequiredArgsConstructor  //의존성 자동 주입
public class GuestbookServiceImpl implements GuestbookService {
  private final GuestbookRepository repository; //반드시 final로 선언
  @Override
  public Long register(GuestbookDTO dto) {
    log.info("DTO------------------------");
    log.info(dto);
    Guestbook entity = dtoToEntity(dto);
    log.info(entity);
    repository.save(entity);
    return entity.getGno();
  }
  
  //서비스 계층에서의 목록 처리
  @Override
  public PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO) {

    Pageable pageable = requestDTO.getPageable(Sort.by("gno").descending());

    Page<Guestbook> result = repository.findAll(pageable);

    Function<Guestbook, GuestbookDTO> fn = (entity -> entityToDto(entity));

    //  PageResultDTO에는 JPA의 처리 결과인 Page<Entity>와 Function을 전달해
    //  엔티티 객체들을 DTO의 리스트로 변환하고,
    //  화면에 페이지 처리와 필요한 값들을 생성한다.
    return new PageResultDTO<>(result, fn);
  }


}