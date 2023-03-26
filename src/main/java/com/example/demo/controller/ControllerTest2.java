package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.constant.Path;
import com.example.demo.controller.model.SampleJson2Response;
import com.example.demo.controller.model.SampleJsonRequest;

@RestController
@RequestMapping(Path.CONTROLLER_TEST_2)
public class ControllerTest2 {

	/**
	 * JSON リクエストを取得、レスポンスする
	 * @param request <SampleJsonRequest> リクエスト
	 * @return response <SampleJson2Response> 
	 */
	@GetMapping(Path.GET_SAMPLE_JSON)
	public ResponseEntity<SampleJson2Response> getSampleJson(
			@RequestBody SampleJsonRequest request) {

		// リクエストパラメータ paramA に "key_ok"が設定されていない場合はエラー
		if (request != null) {

			String paramA = request.getParamA();

			if (StringUtils.hasText(paramA) && paramA.equals("key_ok")) {

				SampleJson2Response response = new SampleJson2Response();
				response.setDataA("ok_data");

				return ResponseEntity.ok(response);
			}
		}

		// リクエストに問題がある場合のレスポンス
		return this.errorBadRequestResponse();
	}

	/**
	 * リクエストに問題がある場合のレスポンス
	 * @return
	 */
	private ResponseEntity<SampleJson2Response> errorBadRequestResponse() {
		SampleJson2Response response = new SampleJson2Response();
		response.setDataA("error data");

		return ResponseEntity.badRequest().body(response);
	}
}
