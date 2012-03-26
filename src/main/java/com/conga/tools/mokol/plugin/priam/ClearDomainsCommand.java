package com.conga.tools.mokol.plugin.priam;

import java.util.List;

import com.amazonaws.services.simpledb.model.CreateDomainRequest;
import com.amazonaws.services.simpledb.model.DeleteDomainRequest;
import com.conga.tools.mokol.CommandContext;
import com.conga.tools.mokol.ShellException;
import com.conga.tools.mokol.spi.annotation.Help;

/**
 * @author jflexa
 * 
 */
@Help("Clear Priam domains on SimpleDB: priamProperties and instanceIdentity")
public class ClearDomainsCommand extends PriamCommand {

	@Override
	protected void execute(CommandContext context, List<String> args)
			throws ShellException {
		auth();
		context.printf("Clearing domains %s %s", priamProperties,
				instanceIdentity);
		sdb.deleteDomain(new DeleteDomainRequest(priamProperties));
		sdb.createDomain(new CreateDomainRequest(priamProperties));
		sdb.deleteDomain(new DeleteDomainRequest(instanceIdentity));
		sdb.createDomain(new CreateDomainRequest(instanceIdentity));
	}
}
