package com.igindex.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order implements Serializable {

	@JsonProperty("accont")
	private String account;

	@JsonProperty("SubmittedAt")
	private String submittedTime;

	@JsonProperty("ReceivedAt")
	private String receievedTime;

	@JsonProperty("market")
	private String market;

	@JsonProperty("action")
	private String action;

	@JsonProperty("size")
	private String size;

	public Order() {
	}

	public Order(String account, String submittedTime, String receievedTime, String market, String action,
			String size) {
		super();
		this.account = account;
		this.submittedTime = submittedTime;
		this.receievedTime = receievedTime;
		this.market = market;
		this.action = action;
		this.size = size;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getSubmittedTime() {
		return submittedTime;
	}

	public void setSubmittedTime(String submittedTime) {
		this.submittedTime = submittedTime;
	}

	public String getReceievedTime() {
		return receievedTime;
	}

	public void setReceievedTime(String receievedTime) {
		this.receievedTime = receievedTime;
	}

	public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Order [account=" + account + ", submittedTime=" + submittedTime + ", receievedTime=" + receievedTime
				+ ", market=" + market + ", action=" + action + ", size=" + size + "]";
	}
	
	

}
