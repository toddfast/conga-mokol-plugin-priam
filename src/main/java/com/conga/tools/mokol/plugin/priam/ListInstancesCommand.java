package com.conga.tools.mokol.plugin.priam;

import java.util.List;

import com.amazonaws.services.simpledb.model.Attribute;
import com.amazonaws.services.simpledb.model.Item;
import com.amazonaws.services.simpledb.model.SelectRequest;
import com.conga.tools.mokol.CommandContext;
import com.conga.tools.mokol.ShellException;

/**
 * @author jflexa
 * 
 */
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
				+ (appId == null ? "" : "where appId='" + appId + "'");

		ctx.printf("Selecting Instances\n");
		SelectRequest selectRequest = new SelectRequest(selectExpression);
		for (Item item : sdb.select(selectRequest).getItems()) {
			ctx.printf("  Item\n");
			ctx.printf("    Name: %s\n", item.getName());
			for (Attribute attribute : item.getAttributes()) {
				ctx.printf("      Attribute\n");
				ctx.printf("        Name:  %s\n", attribute.getName());
				ctx.printf("        Value: %s\n", attribute.getValue());
			}
		}

	}

	private void handleSwitch(String switchName, String switchValue) {
		if (switchName.equals("appId") || switchName.equals("i")) {
			appId = switchValue;
		}
	}
}
