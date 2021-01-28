package org.zerock.guestbook.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.guestbook.dto.GuestbookDTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.service.GuestbookService;

@Controller
@RequestMapping("/guestbook")
@Log4j2

@RequiredArgsConstructor //자동 주입을 위한 Annotation
public class GuestbookController {

  private final GuestbookService service; //final로 선언

  @GetMapping("/")
  public String index(){
    return "redirect:/guestbook/list";
  }

  @GetMapping("/list")
  public void list(PageRequestDTO pageRequestDTO, Model model){

    log.info("list............." + pageRequestDTO);

    model.addAttribute("result", service.getList(pageRequestDTO));
  }

  // 등록 페이지와 등록 처리
  // GET방식: 화면을 보여주고, POST방식: 처리 후 목록 페이지로 이동
  // RedirectAttributes를 이용해 한 번만 화면에서 'msg'라는 이름의 변수를 사용할 수 있도록 처리
  // addFlashAttribute() 단 한 번만 데이터를 전달하는 용도
  @GetMapping("/register")
  public void register(){
    log.info("regiser get...");
  }

  @PostMapping("/register")
  public String registerPost(GuestbookDTO dto, RedirectAttributes redirectAttributes){

    log.info("dto..." + dto);

    //새로 추가된 엔티티의 번호
    Long gno = service.register(dto);

    redirectAttributes.addFlashAttribute("msg", gno);

    return "redirect:/guestbook/list";
  }
}