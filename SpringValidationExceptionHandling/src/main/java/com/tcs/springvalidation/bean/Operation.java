package com.tcs.springvalidation.bean;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class Operation {

	@Min(value = Integer.MIN_VALUE, message = "must not be 0")
	@Max(value = Integer.MAX_VALUE)
	private int input1;

	@Min(value = Integer.MIN_VALUE, message = "must not be 0")
	@Max(value = Integer.MAX_VALUE)
	private int input2;

	private int result;

	public int getInput1() {
		return input1;
	}

	public void setInput1(int input1) {
		this.input1 = input1;
	}

	public int getInput2() {
		return input2;
	}

	public void setInput2(int input2) {
		this.input2 = input2;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

}
