package com.example.demo.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CsvDownloadController {

//	private static final String CONTENT_DISPOSITION_FORMAT = "attachment; filename=\"%s\"; filename*=UTF-8''%s";

	@GetMapping("/download_test")
	public ResponseEntity<byte[]> getDownload() {
		String csvFileName = "test.csv";

		HttpHeaders headers = new HttpHeaders();
		String dispositionValue = "attachment; filename=\"" + csvFileName + "\"";
		headers.add(HttpHeaders.CONTENT_DISPOSITION, dispositionValue);

		try {
			return new ResponseEntity<>(this.csvText().getBytes("MS932"), headers, HttpStatus.OK);
		} catch (UnsupportedEncodingException e) {
			System.out.println("エラー");
			System.out.println(e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/** csvのファイルテキスト */
	private String csvText() {
		StringBuffer sb = new StringBuffer();
		sb.append("列1").append(",").append("列2").append(",").append("列3").append("\n");
		sb.append("param1").append(",").append("パラメータ2").append(",").append("パラメータ３");
		return sb.toString();
	}
}
