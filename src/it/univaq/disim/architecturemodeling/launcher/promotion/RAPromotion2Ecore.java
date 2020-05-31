/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package it.univaq.disim.architecturemodeling.launcher.promotion;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.etl.EtlModule;
import it.univaq.disim.architecturemodeling.launcher.EpsilonStandaloneExample;

public class RAPromotion2Ecore extends EpsilonStandaloneExample {
	
	private List<IModel> models;
	
	public RAPromotion2Ecore(List<IModel> models) throws EolModelLoadingException, URISyntaxException {
		super();
		
		
		this.models = models;
	}

	
	@Override
	public IEolModule createModule() {
		return new EtlModule();
	}

	@Override
	public List<IModel> getModels() throws Exception {
		
		return this.models;
	}

	@Override
	public String getSource() throws Exception {
		return "promotion/RA2Ecore.etl";
	}

	@Override
	public void postProcess() {
		
	}

}
