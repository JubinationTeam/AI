/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralnetworks;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Welcome
 */
public class ProcessingEngine {
     
    

    public void initialize(DataObject data) {
    //initializing and linking layers
        
        System.out.println("inputs");
        for(List<Double> val:data.getInputs()){
            System.out.println(val);
        }
        System.out.println("targets");
        for(List<Double> val:data.getTargets()){
            System.out.println(val);
        }
        
        
    Layer iLayer = new InputLayer(data.getInputs().size(), 0.01,data.getInputs().get(0).size());
   Layer oLayer = new OutputLayer(iLayer,data.getTargets().size(), 0.01,data.getInputs().get(0).size());
    
    //Setting up parameters
  iLayer.insertValues(data.getInputs());
  oLayer.insertValues(data.getTargets());
  
  //Activating Layers
  iLayer.activateLayer();
  
 
  
  //Hypothesis
       System.out.println("Weights");
        System.out.println("Input Layer");      
        iLayer.printWeights();
        System.out.println("Output Layer");
        oLayer.printWeights();
 //Target
       
        System.out.println("Output Layer ");
         System.out.println("Hypothesis");
        oLayer.printHypothesis();
         System.out.println("Target");
        oLayer.printTarget();
   
  
    System.out.println("Cost "+oLayer.findCost());
        
//    Adjusting weight
        for(int i=0;i<20000;i++){
            
        oLayer.adjustDelta();
        iLayer.activateLayer();
        }
//        Hypothesis
        System.out.println("Weights after manipulation");
        System.out.println("Input Layer");      
        iLayer.printWeights();
         System.out.println("Output Layer");
        oLayer.printWeights();
        
        
       
  //error
//        System.out.println("Error");
//        System.out.println("Hidden Layer 1");
//        hLayer1.printError();
//        System.out.println("Hidden Layer 2");
//        hLayer2.printError();
//        System.out.println("Hidden Layer 3");
//        hLayer3.printError();
//        System.out.println("Output Layer");
//        oLayer.printError();
        
        //Target
       
        System.out.println("Output Layer ");
         System.out.println("Hypothesis");
        oLayer.printHypothesis();
         System.out.println("Target");
        oLayer.printTarget();
        
        System.out.println("Cost "+oLayer.findCost());
        
    
    }

    
    
    
    
}
