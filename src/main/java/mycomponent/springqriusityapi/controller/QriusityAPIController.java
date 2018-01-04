package mycomponent.springqriusityapi.controller;

import mycomponent.springqriusityapi.model.Question;
import mycomponent.springqriusityapi.service.QriusityAPIService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QriusityAPIController {

    @Autowired
    QriusityAPIService qriusityAPIService;

    Logger logger = LoggerFactory.getLogger(QriusityAPIController.class);

    @RequestMapping(value = "/getQuestion/{id}", method = RequestMethod.GET)
    private ResponseEntity<Question[]> getQuestion(@PathVariable String id) {
        logger.info("Getting random question");
        Question[] question = qriusityAPIService.getAQuestionFromQriusity(id);
        return new ResponseEntity<Question[]>(question, HttpStatus.OK);
    }
}
