package com.conga.tools.mokol.plugin.priam;

import java.io.File;
import java.io.IOException;

import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.services.simpledb.AmazonSimpleDB;
import com.amazonaws.services.simpledb.AmazonSimpleDBClient;
import com.conga.tools.mokol.spi.Command;

public abstract class PriamCommand extends Command {
	static final String instanceIdentity = "InstanceIdentity";
	static final String priamProperties = "PriamProperties";
	protected AmazonSimpleDB sdb;

	protected void auth() {
		try {
			PropertiesCredentials awsCredentials = null;
			File file = new File("/etc/awscredentials.properties");
			if (file.exists()) {
				awsCredentials = new PropertiesCredentials(file);
			} else {

			}
			sdb = new AmazonSimpleDBClient(awsCredentials);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
