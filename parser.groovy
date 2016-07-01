@Grapes([
	@Grab('org.apache.poi:poi:3.10.1'),
	@Grab('org.apache.poi:poi-ooxml:3.10.1')])

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import static org.apache.poi.ss.usermodel.Cell.*

import java.nio.file.Paths
import com.appdynamics.enablement.parser.Application;
import com.appdynamics.enablement.parser.Environment;
import com.appdynamics.enablement.parser.Tier;
import com.appdynamics.enablement.parser.Node;
import com.appdynamics.enablement.parser.PackagerConfig;
import com.appdynamics.enablement.parser.DeployerConfig;

ArrayList<Application> applications = new ArrayList<Application>();
ArrayList<Environment> environments = new ArrayList<Environment>();
ArrayList<Tier> tiers = new ArrayList<Tier>();
ArrayList<Node> nodes = new ArrayList<Node>();

if (args.length == 0) {
	println "This program requires an xlsx file as input";;
	System.exit(0);
}

Paths.get(args[0]).withInputStream { input ->

	def workbook = new XSSFWorkbook(input)
	// Reading Applications
	def sheet = workbook.getSheetAt(0)

	int cptRow=0;
	int cptCell=0;
	for (row in sheet.rowIterator()) {
	cptRow++;
		if (cptRow>3) {  // we have 4 rows of headers
		if ((row.getCell(1) != null)) { // the line is not null
				def anApp = new Application(row);
			applications.add(anApp);
			println "my app is " + anApp.appName;
		}
	}
	}
	//  reading Environments
	sheet= workbook.getSheetAt(1)

	cptRow=0;
	for (row in sheet.rowIterator()) {
	cptRow++;
		if (cptRow>3) {  // we have 4 rows of headers
		if ((row.getCell(1) != null)) { // the line is not null
				def anEnv = new Environment(row);
			environments.add(anEnv);
			println "my env app is " + anEnv.appName;
		}
	}
	}
	//  reading Tiers
	sheet= workbook.getSheetAt(2)

	cptRow=0;
	for (row in sheet.rowIterator()) {
	cptRow++;
		if (cptRow>3) {  // we have 4 rows of headers
		if ((row.getCell(1) != null)) { // the line is not null
				def aTier = new Tier(row);
			tiers.add(aTier);
			println "my app tier is " + aTier.tierName;
		}
	}
	}
	//  reading Nodes
	sheet= workbook.getSheetAt(3)

	cptRow=0;
	for (row in sheet.rowIterator()) {
	cptRow++;
		if (cptRow>3) {  // we have 4 rows of headers
		if ((row.getCell(1) != null)) { // the line is not null
				def aNode = new Node(row);
			nodes.add(aNode);
			println "my app node is " + aNode.uniqueHostID;
		}
	}
	}

	println "Generating Config Files"; // for now generating for 1 tier 1 node

	def packager=new PackagerConfig(applications[0].appName,environments[0].controllerAccountName,environments[0].controllerAccountAccessKey,environments[0].controllerHost,environments[0].controllerPort,"true");
	packager.WriteToFile("target/", applications[0]);
	
	nodes.each { node ->
							//appName,tierName,nodeName,uniqueHostId,machinePath,user
		def deployer=new DeployerConfig(applications[0].appName,node.logicalTierName,node.logicalNodeName,node.uniqueHostID,node.machinePath,node.agentAccount);
		deployer.WriteToFile("target/");
	}
}

