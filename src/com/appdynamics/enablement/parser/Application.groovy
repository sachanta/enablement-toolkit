package com.appdynamics.enablement.parser

class Application {
	String appName; // column B  -- index 1
	String admin1; // E  4
	String admin2; // F   5
	String admin3;  // G   6
	String user1; // H    7
	String user2;  // I  8
	String user3;  //J    9
	String user4; // K  10
	
	Application(row) {
		this.appName = (row.getCell(1) != null) ? row.getCell(1).getStringCellValue() : '';
		this.admin1 = (row.getCell(4) != null) ? row.getCell(4).getStringCellValue() : '';
		this.admin2 = (row.getCell(5) != null) ? row.getCell(5).getStringCellValue() : '';
		this.admin3 = (row.getCell(6) != null) ? row.getCell(6).getStringCellValue() : '';
		this.user1 = (row.getCell(7) != null) ? row.getCell(7).getStringCellValue() : '';
		this.user2 = (row.getCell(8) != null) ? row.getCell(8).getStringCellValue() : '';
		this.user3 = (row.getCell(9) != null) ? row.getCell(9).getStringCellValue() : '';
		this.user4 = (row.getCell(10) != null) ? row.getCell(10).getStringCellValue() : '';
	}

}
