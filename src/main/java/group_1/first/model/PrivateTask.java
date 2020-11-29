package group_1.first.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrivateTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    private String title;
    @Column(columnDefinition = "text")
    private String question;
    private int rank;
    private boolean permission;
    private int attempt;
    private String stdin;
    private String answer;
    private String lastResult;
    public String lastCode;
    private boolean solve;
}
