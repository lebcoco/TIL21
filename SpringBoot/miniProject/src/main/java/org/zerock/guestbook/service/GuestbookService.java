package org.zerock.guestbook.service;

import org.zerock.guestbook.dto.GuestbookDTO;
// 방명록 등록하는 시나리오 처리
public interface GuestbookService {
  Long register(GuestbookDTO dto);
}
