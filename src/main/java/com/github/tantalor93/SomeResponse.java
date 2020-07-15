package com.github.tantalor93;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SomeResponse {

	@JsonProperty
	private String msg;

	public SomeResponse() {
	}

	public SomeResponse(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
