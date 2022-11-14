package net.ict.d1110_springex.controller;

import lombok.extern.log4j.Log4j2;
import net.ict.d1110_springex.dto.TodoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; //≒request.setAttribute
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Log4j2
@Controller
public class SampleController {

    @GetMapping("/hello") //지구모양: 매핑태그
    public void hello(){
        log.info("hello.........................");
    }

    @GetMapping("/ex3")
    public void ex3(LocalDate dueDate){
        log.info("..............ex3...............");
        log.info(dueDate);
    }

    //Model이라는 특별한 parameter!
    @GetMapping("/ex4")
    public void ex4(Model model){
        log.info(".............model info...............");
        model.addAttribute("message", "hello!! Spring MVC");

    }

    @GetMapping("/ex5") //객체도 전달받을 수 있다
    public void ex5(TodoDTO dto, Model m){
        log.info(".............dto info...............");
        //log.info(dto);  //TodoDTO(tno=null, title=null, dueDate=null, finished=false, writer=null)
        m.addAttribute("dto", dto);
    }

    @GetMapping("/ex6")
    public String ex6(RedirectAttributes rA){
       rA.addAttribute("name", "ABC");
       rA.addFlashAttribute("result", "success");
       return "redirect:/ex7";
    }

    @GetMapping("/ex7")
    public void ex7() {
    }

    // CommonExceptionAdvice.java Test
    @GetMapping("/ex8")
    public void ex8(String p1, int p2){
        log.info("p1-----------------" + p1);
        log.info("p2-----------------" + p2); //일부러 문자열등 입력
    }
}














