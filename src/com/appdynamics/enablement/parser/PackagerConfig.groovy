package com.appdynamics.enablement.parser

class PackagerConfig {
	String agentVersion="4.2.2.0";
	String downloadArtifacts="AppServerAgent-4.2.2.0.zip machineagent-bundle-64bit-linux-4.2.2.0.zip";
	String controllerAccount;
	String controllerAccessKey;
	String controllerHost;
	String controllerPort;
	String controllerSSL;
	String appName;
	String certificate="conf/common/ssl/appdcert.pem";
	String trustStore="conf/common/ssl/cacerts.jks";
	

	PackagerConfig(appName,controllerAccount,controllerAccessKey,controllerHost,controllerPort,controllerSSL) {
		this.appName=appName;
		this.controllerAccount=controllerAccount;
		this.controllerAccessKey=controllerAccessKey;
		this.controllerHost=controllerHost;
		this.controllerPort=controllerPort;
		this.controllerSSL=controllerSSL;
	}
	
	def WriteToFile(folder,application){
		def file = new File(folder+"packager_config_"+this.appName);
		def w = file.newWriter();
		w << "agent_version="+this.agentVersion;
		w << "\ndownload_artifacts=\""+this.downloadArtifacts+"\"";
		w << "\ncontroller_account="+this.controllerAccount;
		w << "\ncontroller_accessKey="+this.controllerAccessKey;
		w << "\ncontroller_host="+this.controllerHost;
		w << "\ndownload_artifacts="+this.controllerSSL;
		w << "\nappName="+this.appName;
		w << "\ncertificate="+this.certificate;
		w << "\ntrustStore="+this.trustStore;
		w << "\nadmin1="+application.admin1;
		w << "\nadmin2="+application.admin2;
		w << "\nadmin3="+application.admin3;
		w << "\nuser1="+application.user1;
		w << "\nuser2="+application.user2;
		w << "\nuser3="+application.user3;
		w << "\nuser4="+application.user4;
		w.close();
	}

}
