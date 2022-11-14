package net.ict.d1110_springex.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.ict.d1110_springex.domain.TodoVO;
import net.ict.d1110_springex.dto.TodoDTO;
import net.ict.d1110_springex.mapper.TodoMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
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


}
