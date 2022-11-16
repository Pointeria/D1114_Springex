package net.ict.d1110_springex.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.ict.d1110_springex.dto.PageRequestDTO;
import net.ict.d1110_springex.dto.TodoDTO;
import net.ict.d1110_springex.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Log4j2
@Controller
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;
//    private final CheckboxFormatter checkboxFormatter;

    @RequestMapping("/list")  // 최종경로: todo슬래쉬list
    public void list(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model) {
        log.info("..................todo list()........................");
        if (bindingResult.hasErrors()) {
            pageRequestDTO = PageRequestDTO.builder().build();
        }
        model.addAttribute("responseDTO", todoService.getList(pageRequestDTO));
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

    @PostMapping("/register")//@Valid : 검증대상이다
    public String registerPost(@Valid TodoDTO dto,BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        log.info("................todo register..................");
        if (bindingResult.hasErrors()) {
         log.error("..................has errors.................");
         redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
         return "redirect:/todo/register";
        }
        log.info(dto);
        todoService.register(dto);
        return "redirect:/todo/list";
    }

    @GetMapping({"/read", "/modify"})
    public void readGet(Long tno, Model m) {
        TodoDTO dto = todoService.getOne(tno);
        log.info(dto);
        m.addAttribute("dto", dto);
    }

    @PostMapping("/remove")
    public String removePost(Long tno, RedirectAttributes rA) {
        log.info("------------remove-----------");
        log.info("tno : "+ tno);
        todoService.delete(tno);
        return "redirect:/todo/list";
    }

    @PostMapping("/modify")
    public String modifyPost(@Valid TodoDTO dto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            log.info("-------has errors-------------");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("tno", dto.getTno());
            return "redirect:/todo/modify";
        }
        log.info(dto);
        todoService.modify(dto);
        return "redirect:/todo/list";
    }
}