package com.conga.tools.mokol.plugin.priam;

import java.util.List;

import com.amazonaws.services.simpledb.model.Attribute;
import com.amazonaws.services.simpledb.model.Item;
import com.amazonaws.services.simpledb.model.SelectRequest;
import com.conga.tools.mokol.CommandContext;
import com.conga.tools.mokol.ShellException;
import com.conga.tools.mokol.spi.annotation.Help;

/**
 * @author jflexa
 * 
 */
@Help("List the available instances on Priam's SimpleDB instanceIdentity")
public class ListInstancesCommand extends PriamCommand {

	private String appId = null;

	@Override
	protected void execute(CommandContext ctx, List<String> args)
			throws ShellException {
		auth();

		String switchName = null;
		for (String arg : args) {
			if (switchName != null) {
				handleSwitch(switchName, arg);
				switchName = null;
			} else if (arg.startsWith("--")) {
				switchName = arg.substring(2);
				// The next arg will be the switch value
			}
		}
		String selectExpression = "select * from " + instanceIdentity
				+ (appId == null ? "" : " where appId='" + appId + "'");

		ctx.printf("Selecting Instances\n");
		SelectRequest selectRequest = new SelectRequest(selectExpression);
		for (Item item : sdb.select(selectRequest).getItems()) {
			ctx.printf("\tItem\n");
			ctx.printf("\t\tName: %s\n", item.getName());
			for (Attribute attribute : item.getAttributes()) {
				ctx.printf("\tAttribute\n");
				ctx.printf("\t\tName:  %s\n", attribute.getName());
				ctx.printf("\t\tValue: %s\n", attribute.getValue());
			}
		}

	}

	private void handleSwitch(String switchName, String switchValue) {
		if (switchName.equals("appId") || switchName.equals("i")) {
			appId = switchValue;
		}
	}
}
