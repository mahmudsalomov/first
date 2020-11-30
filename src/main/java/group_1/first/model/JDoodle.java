package group_1.first.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JDoodle {
    private String script;
    private String args;
    private String stdin;
    private String language;
    private String[] libs;
    private String versionIndex;
    private String clientId;
    private String clientSecret;
}
