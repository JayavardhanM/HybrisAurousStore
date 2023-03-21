/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package my.aurous.fulfilmentprocess.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import my.aurous.fulfilmentprocess.constants.AurousFulfilmentProcessConstants;

public class AurousFulfilmentProcessManager extends GeneratedAurousFulfilmentProcessManager
{
	public static final AurousFulfilmentProcessManager getInstance()
	{
		ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (AurousFulfilmentProcessManager) em.getExtension(AurousFulfilmentProcessConstants.EXTENSIONNAME);
	}
	
}
