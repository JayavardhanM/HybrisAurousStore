/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package my.aurous.core.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import my.aurous.core.constants.AurousCoreConstants;
import my.aurous.core.setup.CoreSystemSetup;


/**
 * Do not use, please use {@link CoreSystemSetup} instead.
 * 
 */
public class AurousCoreManager extends GeneratedAurousCoreManager
{
	public static final AurousCoreManager getInstance()
	{
		final ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (AurousCoreManager) em.getExtension(AurousCoreConstants.EXTENSIONNAME);
	}
}
