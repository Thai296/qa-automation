package com.bankguru.qaautomation.commons;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RandomCharacters {
	private final Log log = LogFactory.getLog(getClass());

	public static RandomCharacters getRandomCharacters() {
		return new RandomCharacters();
	}

	// Get random alphabetic characters
	public String getRandomAlphaString(int length) throws Exception {
		String charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		charset = RandomStringUtils.random(length, charset.toCharArray());
		log.info("        Returned Random Alpha String: " + charset);
		return charset;
	}

	// Get random numeric characters
	public String getRandomNumericString(int length) throws Exception {
		String charset = "1234567890";
		charset = RandomStringUtils.random(length, charset.toCharArray());
		log.info("        Returned Random Numeric String: " + charset);
		return charset;
	}

	// Get random alphanumeric characters
	public String getRandomAlphaNumericString(int length) throws Exception {
		String charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		charset = RandomStringUtils.random(length, charset.toCharArray());
		log.info("        Returned Random AlphaNumeric String: " + charset);
		return charset;
	}

	// Get a random Non-Zero numeric characters
	public String getNonZeroRandomNumericString(int length) throws Exception {
		String charset = "123456789";
		charset = RandomStringUtils.random(length, charset.toCharArray());
		log.info("        Returned Non-Zero Random Numeric String: " + charset);
		return charset;
	}

	// Get random alphabetic and special characters
	public String getRandomAlphaStringwithSpecialCharacters(int length) throws Exception {
		String charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZ>&\"'";
		charset = RandomStringUtils.random(length, charset.toCharArray());
		log.info("        Returned Random AlphaNumeric String: " + charset);
		return charset;
	}

	// Get random alphabetic and special characters
	public String getRandomStringwithSpecialCharacters(int length) throws Exception {
		String charset = "@#$%&*!>&\"'";
		charset = RandomStringUtils.random(length, charset.toCharArray());
		log.info("        Returned Random Special Character: " + charset);
		return charset;
	}

	// Get random alphabetic and special characters
	public String getRandomStringNumberSpecialCharacters(int length) throws Exception {
		String charset = "@#$%&*!>&\"'ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		charset = RandomStringUtils.random(length, charset.toCharArray());
		log.info("        Returned Random String, Number and Special Character: " + charset);
		return charset;
	}
}
