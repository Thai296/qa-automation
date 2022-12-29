package com.bankguru.qaautomation.pageui;

public class AbstractBankPageUI {
	// textbox
	public static final String DYNAMIC_TEXTBOX = "//input[@name = '%s']";
	// textarea
	public static final String DYNAMIC_TEXTAREA = "//*[@name='%s']";
	// select
	public static final String DYNAMIC_SELECT = "//select[@name='%s']";
	// radio button
	public static final String DYNAMIC_RADIO_BUTTON = "//input[@type='radio' and @value='%s']";
	// menu link
//	public static final String DYNAMIC_MENU_LINK = "//*[@class = 'menusubnav']//a[text()='%s']";
	public static final String DYNAMIC_LINK = "//a[text()='%s']";
	// button
	public static final String DYNAMIC_BUTTON = "//*[@value='%s']";
	// message
	public static final String DYNAMIC_MESSAGE = "//p[@class='heading3' and text()='%s']";
	// column value
	public static final String DYNAMIC_VALUE_BY_COLUMN_NAME = "//td[contains(text(), '%s')]/following-sibling::td";
	// message
	public static final String DYNAMIC_MESSAGE_LABEL = "//label[text()='%s']";
}
