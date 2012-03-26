package com.conga.tools.mokol.plugin.priam;

import java.util.List;

import com.amazonaws.services.simpledb.model.CreateDomainRequest;
import com.conga.tools.mokol.CommandContext;
import com.conga.tools.mokol.ShellException;
import com.conga.tools.mokol.metadata.Usage;
import com.conga.tools.mokol.spi.annotation.Help;

/**
 * 
 * @author jflexa
 */
@Help("Create the domains used by Priam on SimpleDB: priamProperties and instanceIdentity")
public class CreateDomainsCommand extends PriamCommand {

	@Override
	public Usage getUsage(CommandContext context) {
		return super.getUsage(context);
	}

	@Override
	public void execute(CommandContext context, List<String> args)
			throws ShellException {
		auth();
		if (!sdb.listDomains().getDomainNames().contains(instanceIdentity)) {
			context.printf("Creating domain %s\n", instanceIdentity);
			sdb.createDomain(new CreateDomainRequest(instanceIdentity));
		}
		if (!sdb.listDomains().getDomainNames().contains(priamProperties)) {
			context.printf("Creating domain %s\n", priamProperties);
			sdb.createDomain(new CreateDomainRequest(priamProperties));
		}
	}
}
