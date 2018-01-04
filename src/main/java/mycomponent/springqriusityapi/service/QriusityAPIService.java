package mycomponent.springqriusityapi.service;

import mycomponent.springqriusityapi.model.Question;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class QriusityAPIService {

    public Question[] getAQuestionFromQriusity(String questionId){
        final String uri = "https://qriusity.com/v1/questions/" + questionId;
        RestTemplate restTemplate = new RestTemplate();
        Question[] result = restTemplate.getForObject(uri, Question[].class);
        return result;
    }

}
