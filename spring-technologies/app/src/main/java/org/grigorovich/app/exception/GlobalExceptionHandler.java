package org.grigorovich.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler { // любой JSON контроллер может пользоваться обработкой исключений
    @ExceptionHandler //метод ответственный за обратботку исключений (нет такого id)
    public ResponseEntity<IncorrectData> handleException(NoSuchEntityException entityException) {
        IncorrectData data = new IncorrectData();
        data.setInfo(entityException.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler //метод ответственный за обработку всех исключений
    public ResponseEntity<IncorrectData> handleException(Exception exception) {
        IncorrectData data = new IncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
