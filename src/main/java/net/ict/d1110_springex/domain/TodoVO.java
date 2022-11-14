package net.ict.d1110_springex.domain;

/*MyBatis와 Spring을 이용한 영속처리 4단계
1. VO 선언
2. Mapper interface 개발
3. xml 개발(SQL문)
4. test code 개발
 */

import lombok.*;

import java.time.LocalDate;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoVO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
    private String writer;
}
