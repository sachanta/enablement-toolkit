package com.appdynamics.enablement.parser

class Node {
	String uniqueHostID; // A -- index 0
	String logicalAppName; // column B  -- index 1
	String logicalTierName; // E  2
	String machinePath; // F   3
	String agentOsBit;  // G  5
	String agentType; // H    6
	String agentAccount;  // I  7
	String logicalNodeName;  //J    8
	String containerType; // K  9
	String deploymentDir;
	
	Node(row) {
		this.uniqueHostID = (row.getCell(0) != null) ? row.getCell(0).getStringCellValue() : '';
		this.logicalAppName = (row.getCell(1) != null) ? row.getCell(1).getStringCellValue() : '';
		this.logicalTierName = (row.getCell(2) != null) ? row.getCell(2).getStringCellValue() : '';
		this.machinePath = (row.getCell(3) != null) ? row.getCell(3).getStringCellValue() : '';
		this.agentOsBit = (row.getCell(5) != null) ? row.getCell(5).getStringCellValue() : '';
		this.agentType = (row.getCell(6) != null) ? row.getCell(6).getStringCellValue() : '';
		this.agentAccount = (row.getCell(7) != null) ? row.getCell(7).getStringCellValue() : '';
		this.logicalNodeName = (row.getCell(8) != null) ? row.getCell(8).getStringCellValue() : '';
		this.containerType = (row.getCell(9) != null) ? row.getCell(9).getStringCellValue() : '';
	}

}
