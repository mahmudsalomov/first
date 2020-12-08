package group_1.first.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskSpecDto {
    private Long id;
    private String question;
    private String title;
    private int attempt;
    private boolean solve;
    private String lastCode;
}
