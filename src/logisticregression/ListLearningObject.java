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
public class ListLearningObject {
 private List<Double> hypothesis = new ArrayList<Double>();
 private List<Double> minCost = new ArrayList<Double>();
  private List<Double> theta = new ArrayList<Double>();
  
  private Double cost= 0.0;
  private Double learningRate=0.1;
private Double regularizingValue=10.0;
  public ListLearningObject(List theta) {
     
        this.theta=theta;
    }

    public ListLearningObject() {
    }
  
    public List<Double> getHypothesis() {
        return hypothesis;
    }

    public void setHypothesis(List<Double> hypothesis) {
        this.hypothesis = hypothesis;
    }

    public List<Double> getMinCost() {
        return minCost;
    }

    public void setMinCost(List<Double> minCost) {
        this.minCost = minCost;
    }

    public List<Double> getTheta() {
        return theta;
    }

    public void setTheta(List<Double> theta) {
        this.theta = theta;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getLearningRate() {
        return learningRate;
    }

    public void setLearningRate(Double learningRate) {
        this.learningRate = learningRate;
    }

    public Double getRegularizingValue() {
        return regularizingValue;
    }

    public void setRegularizingValue(Double regularizingValue) {
        this.regularizingValue = regularizingValue;
    }

}
