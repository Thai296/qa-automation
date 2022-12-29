package com.bankguru.qaautomation.browserfactory;

import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeDriverManager extends DriverManager {

	@Override
	protected void initDriver() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}

}
