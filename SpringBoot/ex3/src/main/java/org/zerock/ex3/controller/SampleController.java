package org.zerock.ex3.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.ex3.dto.SampleDTO;

@Controller
@RequestMapping("/sample")
@Log4j2
public class SampleController {

  //
  @GetMapping("/ex1")
  public void ex1() {
    log.info("ex1...............");
  }

  // Sample DTO의 객체를 Model에 추가해서 전달합니다.
  @GetMapping({"/ex2", "/exLink"})
  public void exModel(Model model) {
    // SampleDTO 타입의 객체 20개 추가하고 이를 Model에 담아서 전송합니다.
    List<SampleDTO> list = IntStream.rangeClosed(1, 20).asLongStream().
        mapToObj(i -> {
          SampleDTO dto = SampleDTO.builder()
              .sno(i)
              .first("First.." + i)
              .last("Last.." + i)
              .regTime(LocalDateTime.now())
              .build();
          return dto;
        }).collect(Collectors.toList());
    model.addAttribute("list", list);
  }

  // inline 속성
  @GetMapping({"/exInline"})
  public String exInline(RedirectAttributes redirectAttributes) {
    log.info("exInline..............");
    SampleDTO dto = SampleDTO.builder()
        .sno(100L)
        .first("First..100")
        .last("Last..100")
        .regTime(LocalDateTime.now())
        .build();
    redirectAttributes.addFlashAttribute("result", "success");
    redirectAttributes.addFlashAttribute("dto", dto);
    return "redirect:/sample/ex3";
  }

  //
  @GetMapping("/ex3")
  public void ex3() {
    log.info("ex3");
  }
  // Thymeleaf 레이아웃
//  @GetMapping("/exLayout1")
//  public void exLayout1(){
//    log.info("exLayout............");
//  }

//  //parameter 방식의 처리
//  @GetMapping({"/exLayout1","/exLayout2"})
//  public void exLayout1(){
//    log.info("exLayout............");
//  }

  //layout template
  @GetMapping({"/exLayout1", "/exLayout2", "/exTemplate"})
  public void exLayout() {
    log.info("exLayout............");
  }

//  @GetMapping("/exLayout1")
//  public String exLayout1(){
//    log.info("exLayout............");
//    return "sample/exLayout1";
//  }
//
//  @GetMapping("/exTemplate")
//  public String exTemplate(){
//    log.info("exLayout............");
//    return "sample/exTemplate";
//  }

  @GetMapping("/exView")
  public String exView1(@RequestParam("sno") Long sno) {
    System.out.println("RequestParam: " +sno);
    return "sample/exTemplate";
  }


  @GetMapping("/exView/{sno}")
  public String exView2(@PathVariable("sno") Long sno) {
    System.out.println("RequestPath: " + sno);
    return "sample/exTemplate";
  }

  // 부트스트랩 템플릿
  @GetMapping({"/exLayout1","/exLayout2", "/exTemplate", "/exSidebar"})
  public void exLayout1() {
    log.info("exLayout............");
  }
}