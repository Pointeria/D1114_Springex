package net.ict.d1110_springex.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.ict.d1110_springex.domain.TodoVO;
import net.ict.d1110_springex.dto.TodoDTO;
import net.ict.d1110_springex.mapper.TodoMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
//DB 처리하는 todoMapper와 DTO-VO 변환을 처리하는 ModelMapper 주입

@Service
@Log4j2
@RequiredArgsConstructor //생정자 자동 주입 방식
public class TodoServicelmql implements TodoService {

    private final TodoMapper tM;
    private final ModelMapper mM;

    @Override
    public void register(TodoDTO dto){
        log.info(mM);
        TodoVO tVO = mM.map(dto, TodoVO.class);
        log.info((tVO));
        tM.insert(tVO);
    }

    @Override
    public List<TodoDTO> getAll() {           //자바8 이후 stream≒build
        List<TodoDTO> dtoList = tM.selectAll().stream().
                map(vo -> mM.map(vo, TodoDTO.class)).collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public TodoDTO getOne(Long tno) {
        TodoVO vO = tM.selectOne(tno);
        TodoDTO dto = mM.map(vO, TodoDTO.class);
        return dto;
    }

    @Override
    public void delete(Long tno) {
        tM.delete(tno);
    }

    @Override
    public void modify(TodoDTO dto) {
        TodoVO tVO = mM.map(dto, TodoVO.class);
        tM.update(tVO);
    }


}
