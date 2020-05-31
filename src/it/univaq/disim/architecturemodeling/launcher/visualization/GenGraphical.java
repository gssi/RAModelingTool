package it.univaq.disim.architecturemodeling.launcher.visualization;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.EgxModule;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.models.IModel;

import it.univaq.disim.architecturemodeling.launcher.EpsilonStandaloneExample;


public class GenGraphical extends EpsilonStandaloneExample {
	
	private String ra_model;
	private String ra_mm;
	
	public GenGraphical(String ra_model, String ra_mm) {
		super();
		this.ra_model = ra_model;
		this.ra_mm = ra_mm;
	}

	public static void main(String[] args) {
		try {
			new GenGraphical("models/architectures/mutations/mozilla_1.model", "metamodels/architecturemodeling.ecore").execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public IEolModule createModule() {
		try {
			EglFileGeneratingTemplateFactory templateFactory = new EglFileGeneratingTemplateFactory();
			templateFactory.setOutputRoot(new File("egx-gen").getAbsolutePath());
			return new EgxModule(templateFactory);
		}
		catch (Exception ex) { 
			throw new RuntimeException(ex);
		}
	}

	@Override
	public List<IModel> getModels() throws Exception {
		List<IModel> models = new ArrayList<IModel>();
		models.add(createEmfModel("a", "instances/RA_web_browsers.model", "model/referencearchitecturemodeling.ecore", true, false));
		return models;
	}

	@Override
	public String getSource() throws Exception {
		return "RA2Flexmi/RA2Flexmi.egx";
	}

}
