package group_1.first.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JDoodleResponse {
    private String output;
    private String statusCode;
    private String memory;
    private String cpuTime;
}
