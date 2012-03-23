/**
 * 
 */
package com.conga.tools.mokol.plugin.priam;

import java.util.List;

import com.amazonaws.services.simpledb.model.DeleteDomainRequest;
import com.conga.tools.mokol.CommandContext;
import com.conga.tools.mokol.ShellException;

/**
 * @author jflexa
 * 
 */
public class DropDomainsCommand extends PriamCommand {

	@Override
	protected void execute(CommandContext context, List<String> args)
			throws ShellException {
		auth();
		context.printf("Droping domains %s %s\n", priamProperties,
				instanceIdentity);

		sdb.deleteDomain(new DeleteDomainRequest(priamProperties));
		sdb.deleteDomain(new DeleteDomainRequest(instanceIdentity));
	}
}
