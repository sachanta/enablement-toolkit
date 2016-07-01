package com.appdynamics.enablement.parser

class DeployerConfig {
	String deployment_dir="<CHANGEME_DEPLOYMENT_DIR>";
	String group="<CHANGEME_GROUP_NAME>";
	String user;
	String proxyHost="<CHANGEME_PROXY_HOST>";
	String proxyPort="<CHANGEME_PROXY_PORT>";
	String proxyUser="<CHANGEME_PROXY_USER>";
	String proxyPass="<CHANGEME_PROXY_PASS>";
	String appagent_logs_dir="<CHANGEME_AGENT_LOG_DIR>";
	String appName;
	String tierName;
	String nodeName;
	String uniqueHostId;
	String machinePath;

	DeployerConfig(appName,tierName,nodeName,uniqueHostId,machinePath,user) {
		this.appName=appName;
		this.tierName=tierName;
		this.nodeName=nodeName;
		this.uniqueHostId=uniqueHostId;
		this.machinePath=machinePath;
		this.user=user;
	}
	
	def WriteToFile(folder){
		def file = new File(folder+"deployer_config_"+this.uniqueHostId);
		def w = file.newWriter();
		w << "deployment_dir="+this.deployment_dir;
		w << "\ngroup="+this.group;
		w << "\nuser="+this.user; 
		w << "\nproxyHost="+this.proxyHost;
		w << "\nproxyPort="+this.proxyPort; 
		w << "\nproxyUser="+this.proxyUser;
		w << "\nproxyPass="+this.proxyPass; 
		w << "\nappName="+this.appName; 
		w << "\ntierName="+this.tierName; 
		w << "\nnodeName="+this.nodeName; 
		w << "\nuniqueHostId="+this.uniqueHostId;
		w << "\nmachinePath="+this.machinePath;
		w.close();
	}

}
