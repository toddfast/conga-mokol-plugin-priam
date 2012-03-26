package com.conga.tools.mokol.plugin.priam;

import com.conga.tools.mokol.CommandContext;
import com.conga.tools.mokol.spi.Plugin;
import com.conga.tools.mokol.spi.annotation.Command;

/**
 * 
 * @author Todd Fast
 */
@com.conga.tools.mokol.spi.annotation.Plugin
public class PriamPlugin extends Plugin {

	/**
	 *
	 *
	 */
	@Override
	public String getName() {
		return "Priam";
	}

	/**
	 *
	 *
	 */
	@Override
	public String getVersion() {
		return getClass().getPackage().getImplementationVersion();
	}

	/**
	 *
	 *
	 */
	@Command(alias = "createDomains")
	public CreateDomainsCommand createDomains(CommandContext context) {
		return new CreateDomainsCommand();
	}

	/**
	 *
	 *
	 */
	@Command(alias = "dropDomains")
	public DropDomainsCommand dropDomains(CommandContext context) {
		return new DropDomainsCommand();
	}

	/**
	 *
	 *
	 */
	@Command(alias = "clearDomains")
	public ClearDomainsCommand clearDomains(CommandContext context) {
		return new ClearDomainsCommand();
	}
	/**
	 *
	 *
	 */
	@Command(alias = "listInstances")
	public ListInstancesCommand listInstances(CommandContext context) {
		return new ListInstancesCommand();
	}
	/**
	 *
	 *
	 */
	@Command(alias = "createApp")
	public CreateAppCommand createApp(CommandContext context) {
		return new CreateAppCommand();
	}

}
