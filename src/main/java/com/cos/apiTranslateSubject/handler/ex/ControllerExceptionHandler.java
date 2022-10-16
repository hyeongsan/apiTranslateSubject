package com.cos.apiTranslateSubject.handler.ex;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.apiTranslateSubject.web.dto.CMRespDto;


@RestController
@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(CustomApiException.class) // RuntimeException을 발생하는 모든 exception을 이 함수가 가로챔
	public ResponseEntity<?> apiException(CustomApiException e) {
		return new ResponseEntity<>(new CMRespDto<>(-1,"실패",e.getMessage()),HttpStatus.BAD_REQUEST);
	}
}
 