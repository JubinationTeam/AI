/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logisticregression;

import logisticregression.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Welcome
 */
public class DataObject {
   private List<List<Double>> inputs = new ArrayList<List<Double>>();
   private List<Double> target = new ArrayList<Double>();
   private List<Double> theta = new ArrayList<Double>();
   private List<String> inputParameters = new ArrayList<String>();
   private String targetParameter=new String();

    public List<List<Double>> getInputs() {
        return inputs;
    }

    public void setInputs(List<List<Double>> inputs) {
        this.inputs = inputs;
    }

    public List<Double> getTarget() {
        return target;
    }

    public void setTarget(List<Double> target) {
        this.target = target;
    }

    public List<Double> getTheta() {
        return theta;
    }

    public void setTheta(List<Double> theta) {
        this.theta = theta;
    }

    public List<String> getInputParameters() {
        return inputParameters;
    }

    public void setInputParameters(List<String> inputParameters) {
        this.inputParameters = inputParameters;
    }

    public String getTargetParameter() {
        return targetParameter;
    }

    public void setTargetParameter(String targetParameter) {
        this.targetParameter = targetParameter;
    }

    
    
    
}
