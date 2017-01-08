/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linearregression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Welcome
 */
public class Normalization {
    
    private Double normTarget;
    
    
    private List<Double> normInputs;

    private Double normMeanTarget;
    
    
    private List<Double> normMeanInputs;
    
    
    public Normalization() {
        normInputs = new ArrayList<Double>();
         normTarget=1.0;
         normMeanInputs = new ArrayList<Double>();
         normMeanTarget=1.0;
    }
    
     List<List<Double>> normalizeInputsByDivision(List<List<Double>> values){
       
         for(int j=0;j<values.size();j++){
             normInputs.add(Collections.max(values.get(j))-Collections.min(values.get(j)));
             normMeanInputs.add(mean(values.get(j)));
            for(int i=0;i<values.get(0).size();i++){
                values.get(j).set(i, (values.get(j).get(i)-normMeanInputs.get(j))/ normInputs.get(j));
            }
         }
        return values;
    }

    
    
    List<Double> normalizeTargetByDivision(List<Double> values){
        normTarget=Collections.max(values)-Collections.min(values);
        normMeanTarget=mean(values);
        for(int i=0;i<values.size();i++){
            values.set(i, (values.get(i)-normMeanTarget)/ normTarget);
        }
        return values;
    }
    void denormalizeThetaByDivision(List<Double> theta){
        for(int i=0;i<theta.size();i++){
            if(i==0){
                theta.set(i, theta.get(i)/normTarget);
                Double temp=0.0;
                for(int j=0;j<normInputs.size();j++){
                    temp=temp+((normMeanInputs.get(j)*normTarget)/normInputs.get(j));
                }
                theta.set(i, theta.get(i)-normMeanTarget+temp);
                
                
            }
            else{
                theta.set(i, theta.get(i)*normInputs.get(i-1)/normTarget);
           
            }
        }
    }
  

    public Double getNormTarget() {
        return normTarget;
    }

    public void setNormTarget(Double normTarget) {
        this.normTarget = normTarget;
    }

    public List<Double> getNormInputs() {
        return normInputs;
    }

    public void setNormInputs(List<Double> normInputs) {
        this.normInputs = normInputs;
    }
    
    
    public static Double mean(List<Double> m) {
    double sum = 0;
    for (int i = 0; i < m.size(); i++) {
        sum += m.get(i);
    }
    return sum / m.size();
}
    
}
