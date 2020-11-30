package group_1.first.method;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import group_1.first.model.JDoodle;
import group_1.first.model.JDoodleResponse;
import org.springframework.stereotype.Component;

import javax.sql.rowset.JdbcRowSet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public final class Methods {


    public static JDoodleResponse generate(String s) throws JsonProcessingException {
        String script = s;
        String language = "cpp";
        String versionIndex = "4";
        String stdin="1 2";


        JDoodle apiModel=new JDoodle();
        apiModel.setArgs(null);
        apiModel.setClientId(Keys.CLIENT_ID);
        apiModel.setClientSecret(Keys.CLIENT_SECRET);
        apiModel.setLanguage(language);
        apiModel.setStdin(stdin);
        apiModel.setLibs(new String[0]);
        apiModel.setScript(script);
        apiModel.setVersionIndex(versionIndex);
        return send(apiModel);
    }


    public static JDoodleResponse send(JDoodle jDoodle) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String api = objectMapper.writeValueAsString(jDoodle);
        try {
            URL url = new URL("https://api.jdoodle.com/v1/execute");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");

//            String input = "{\"clientId\": \"" + clientId + "\",\"clientSecret\":\"" + clientSecret + "\",\"script\":\"" + script +
//                    "\",\"language\":\"" + language + "\",\"versionIndex\":\"" + versionIndex +"\",\"stdin\":\""+stdin+"\"}";

            System.out.println(api);

            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(api.getBytes());
            outputStream.flush();

            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Please check your inputs : HTTP error code : "+ connection.getResponseCode());
            }

            BufferedReader bufferedReader;
            bufferedReader = new BufferedReader(new InputStreamReader(
                    (connection.getInputStream())));

            String output;
            StringBuilder all= new StringBuilder();
            System.out.println("Output from JDoodle .... \n");
            while ((output = bufferedReader.readLine()) != null) {
                all.append(output);
//                System.out.println(output);
            }
//            System.out.println(all);
            String k= String.valueOf(all);
            JDoodleResponse result = objectMapper.readValue(k, JDoodleResponse.class);
//            System.out.println(result);
            connection.disconnect();
            return result;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
