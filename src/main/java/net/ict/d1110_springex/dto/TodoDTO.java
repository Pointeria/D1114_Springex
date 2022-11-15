package net.ict.d1110_springex.dto;

import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//객체 자료형을 parameter 처리하려면 객체로 생성하고 setXXX() 이용한다.

public class TodoDTO {

    private Long tno;

    @NotEmpty
    private String title;

    @Future //해당 시간보다 과거일 수 없다
    private LocalDate dueDate;

    private boolean finished;

    @NotEmpty
    private String writer; //작성자

}
