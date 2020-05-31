package it.univaq.disim.architecturemodeling.launcher.validation;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.execute.FixInstance;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;

import it.univaq.disim.architecturemodeling.launcher.EpsilonStandaloneExample;
import it.univaq.disim.architecturemodeling.launcher.promotion.RAPromotion2Ecore;
import it.univaq.disim.architecturemodeling.launcher.visualization.GenGraphical;


public class RAV extends EpsilonStandaloneExample {

	public static void main(String[] args) throws Exception {
		new RAV().execute();
		
	}
	
	@Override
	public IEolModule createModule() {
		return new EvlModule();
	}

	@Override
	public List<IModel> getModels() throws Exception {
		List<IModel> models = new ArrayList<IModel>();
	
		
		
		models.add(createEmfModel("weaving", "models/weaving/rawebbrowser-mozilla2.model", "metamodels/RA_ADL.ecore", true, true));
		models.add(createEmfModel("ramm", "models/referencearchitectures/Ramm.ecore", "metamodels/Ecore.ecore", true, false));
		
		return models;
	}

	@Override
	public String getSource() throws Exception {
		return "validation/RA-ADL-validator.evl";
	}

	@Override
	public void postProcess() {
		
		EvlModule module = (EvlModule) this.module;
		
		Collection<UnsatisfiedConstraint> unsatisfied = module.getContext().getUnsatisfiedConstraints();
	
		if (unsatisfied.size() > 0) {
			System.err.println(unsatisfied.size() + " constraint(s) have not been satisfied");
			for (UnsatisfiedConstraint uc : unsatisfied) {
				System.err.println(uc.getMessage());
				for (FixInstance fix : uc.getFixes()) {
					try {
						fix.perform();
					} catch (EolRuntimeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}
		else {
			
			System.out.println("All constraints have been satisfied");
			
			
		}
		//GenGraphical graphicalgenerator= new GenGraphical("instances/RA_web_browsers.model", "model/referencearchitecturemodeling.ecore");
		/*try {
			graphicalgenerator.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
