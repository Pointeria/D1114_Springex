package net.ict.d1110_springex.dto;

import lombok.*;

import java.time.LocalDate;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//객체 자료형을 parameter 처리하려면 객체로 생성하고 setXXX() 이용한다.
public class TodoDTO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
    private String writer; //작성자

}
