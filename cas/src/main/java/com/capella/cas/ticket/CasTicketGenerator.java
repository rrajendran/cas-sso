package com.capella.cas.ticket;

import org.apache.commons.lang.RandomStringUtils;
import org.jasig.cas.util.UniqueTicketIdGenerator;

public class CasTicketGenerator implements UniqueTicketIdGenerator{
	
	private int length;
	private String prefix;
	
	public CasTicketGenerator() {
		this.length = 20;
		this.prefix = "example.org";
	}
	public CasTicketGenerator(String prefix) {
		this.prefix = prefix;
	}
	
	
	public CasTicketGenerator(int length, String prefix) {
		super();
		this.length = length;
		this.prefix = prefix;
	}


	public int getLength() {
		return length;
	}


	public void setLength(int length) {
		this.length = length;
	}


	public String getPrefix() {
		return prefix;
	}


	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}


	@Override
	public String getNewTicketId(String prefix) {
		return RandomStringUtils.randomAlphanumeric(length) + "-" + prefix;
	}
}
