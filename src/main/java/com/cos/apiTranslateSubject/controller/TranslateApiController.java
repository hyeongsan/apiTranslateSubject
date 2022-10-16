package com.cos.apiTranslateSubject.controller;

import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.apiTranslateSubject.domain.Text;
import com.cos.apiTranslateSubject.handler.ex.CustomApiException;
import com.cos.apiTranslateSubject.service.ApiExamTranslateNmt;
import com.cos.apiTranslateSubject.web.dto.CMRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class TranslateApiController {

	private final ApiExamTranslateNmt apiExamTranslateNmt;
	
	@PostMapping("/translate")
	public ResponseEntity<?> translate(@RequestBody Text text) throws ParseException {

		// 한글이 아닌 경우의 유효성검사
		if(!text.getContent().matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {

			throw new CustomApiException("한글이 아닙니다.");
			
		}
		
		String content = ApiExamTranslateNmt.translateExecute(text.getContent());		
		
		text.setContent(content);						
		
		return new ResponseEntity<>(new CMRespDto<>(1,"성공",text.getContent()), HttpStatus.OK);
	}

}
