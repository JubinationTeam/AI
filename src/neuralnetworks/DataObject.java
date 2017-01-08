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
public class DataObject {
   private List<List<Double>> inputs = new ArrayList<List<Double>>();
   private List<List<Double>> targets = new ArrayList<List<Double>>();
   private List<String> inputParameters = new ArrayList<String>();
   private List<String> targetParameters=new ArrayList<String>();
   private Double learningRate ;

    public List<List<Double>> getInputs() {
        return inputs;
    }

    public void setInputs(List<List<Double>> inputs) {
        this.inputs = inputs;
    }

    public List<List<Double>> getTargets() {
        return targets;
    }

    public void setTargets(List<List<Double>> targets) {
        this.targets = targets;
    }

    public List<String> getInputParameters() {
        return inputParameters;
    }

    public void setInputParameters(List<String> inputParameters) {
        this.inputParameters = inputParameters;
    }

    public List<String> getTargetParameters() {
        return targetParameters;
    }

    public void setTargetParameters(List<String> targetParameters) {
        this.targetParameters = targetParameters;
    }

    public Double getLearningRate() {
        return learningRate;
    }

    public void setLearningRate(Double learningRate) {
        this.learningRate = learningRate;
    }

    
    
}
