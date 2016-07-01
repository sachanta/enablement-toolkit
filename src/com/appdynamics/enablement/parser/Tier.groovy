package com.appdynamics.enablement.parser

class Tier {
	String tierName; // column B  -- index 1
	
		Tier(row) {
			this.tierName = (row.getCell(1) != null) ? row.getCell(1).getStringCellValue() : '';
		}

}
