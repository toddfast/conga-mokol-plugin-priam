package com.conga.tools.mokol.plugin.priam;

import com.conga.tools.mokol.CommandClassFactory;
import com.conga.tools.mokol.Plugin;
import com.conga.tools.mokol.Shell;
import com.conga.tools.mokol.ShellException;

/**
 *
 * @author Todd Fast
 */
public class PriamPlugin implements Plugin {

	/**
	 *
	 *
	 */
	@Override
	public String getName() {
		return getClass().getName()
			.substring(0,getClass().getName().lastIndexOf("."));
	}


	/**
	 *
	 *
	 */
	@Override
	public String getVersion() {
		return "0.1";
	}


	/**
	 *
	 *
	 */
	@Override
	public void initialize(Shell shell) throws ShellException {
//		shell.aliasCommand("alias",new CommandClassFactory(<clazz>.class));
	}
}
