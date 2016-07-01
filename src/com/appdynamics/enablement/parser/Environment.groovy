package com.appdynamics.enablement.parser

class Environment {
	String appName; // column B  -- index 1
	String proxyHost; // N  13
	String proxyPort; // O   14
	String proxyUserName;  // P   15
	String proxyPassword; // Q    16
	String controllerHost;  // R   17
	String controllerPort;  //S    18
	String controllerAccountName; // T  19
	  String controllerAccountAccessKey; // U    20
	
	Environment(row) {
		this.appName = (row.getCell(1) != null) ? row.getCell(1).getStringCellValue() : '';
		this.proxyHost = (row.getCell(13) != null) ? row.getCell(13).getStringCellValue() : '';
		this.proxyPort = (row.getCell(14) != null) ? row.getCell(14).getStringCellValue() : '';
		this.proxyUserName = (row.getCell(15) != null) ? row.getCell(15).getStringCellValue() : '';
		this.proxyPassword = (row.getCell(16) != null) ? row.getCell(16).getStringCellValue() : '';
		this.controllerHost = (row.getCell(17) != null) ? row.getCell(17).getStringCellValue() : '';
		this.controllerPort = (row.getCell(18) != null) ? (int)row.getCell(18).getNumericCellValue() : '';
		this.controllerAccountName = (row.getCell(19) != null) ? row.getCell(19).getStringCellValue() : '';
		this.controllerAccountAccessKey = (row.getCell(20) != null) ? (int)row.getCell(20).getNumericCellValue() : '';
	}

}
