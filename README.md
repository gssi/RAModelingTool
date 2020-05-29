**Process to test the running examples**

 1. Register the metamodel referencearchitecturemodeling.ecore in the metamodels package.
 2. An exemplary model is located in the referencearchitectures package, called RA_web_browsers.model
 3. If you want to test an ASV, as for instance the one placed in the validation package called LayeredArchitecture.evl , run ASV.java placed in the same directory.
 4. If the message "All constraints have been satisfied" pops up in the console, the promotion transformation T will be run and next step will be executed automatically.
 5. Run the ETL transformation in order to produce the ecore model of the reference architecture, running the promotion.java file in the promotion package.
 6. The produced ecore model will be named RAmm.ecore.
 7. Now it is time to create RAW using Modelink. 
			1. We first create an emf model conforms to RA_ADL.ecore
			2. then we create a modelink file where on the left panel we place the generated raMM.ecore, in the central panel the model created at point 1 and in the right panel we link an architectural model, e.g., mozilla.model (see the models.architectures package).
			3. When the weaving is completed go to step 8.
8.   Run the RAW.java file in order to run the validation script respect to the generated raMM.
9. If the validation script returns "All constraints have been satisfied" your architecture (mozilla in this example) is virtually conform to the declared RA (web browser).
