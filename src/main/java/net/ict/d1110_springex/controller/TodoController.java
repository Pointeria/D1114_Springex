package net.ict.d1110_springex.controller;

import lombok.extern.log4j.Log4j2;
import net.ict.d1110_springex.dto.TodoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Log4j2
@Controller
@RequestMapping("/todo")
public class TodoController {

    @RequestMapping("/list")  // 최종경로: todo슬래쉬list
    public void list(Model model) {
        log.info("..................todo list()........................");
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET) // 최종경로: todo슬래쉬register
    public void registerGet() {
        log.info("................todo register() get..................");
    }

//    @PostMapping("/register")
//    public void registerPost() {
//        log.info("................todo register() post..................");
//    }

    @GetMapping("/ex1")
    public void ex1(String name, int age) {
        log.info("................ex1.....................");
        log.info("........name: "+ name +"..................");
        log.info("........age: "+ age +"..................");
    }

    @GetMapping("/ex2") //requestParam에 parameter 기본값을 지정해주는 방법!
    public void ex2(@RequestParam(name="name", defaultValue = "AAA")String name, @RequestParam(name="age", defaultValue = "20")int age) {
        log.info("................ex2.....................");
        log.info("........name: "+ name +"..................");
        log.info("........age: "+ age +"..................");
    }

//    //TodoDTO 생성 후 작성. todo register를 post 방식으로 처리하는 registerPost()는 todoDTO를 parameter로 적용해서 자동 형변환을 지원한다.
//    @PostMapping("/register")
//    public void registerPost(TodoDTO dto) {
//        log.info("................todo register..................");
//        log.info(dto);
//    }

    @PostMapping("/register")
    public String registerPost(TodoDTO dto, RedirectAttributes redirectAttributes) {
        log.info("................todo register..................");
        log.info(dto);
        return "redirect:/todo/list";
    }

}
