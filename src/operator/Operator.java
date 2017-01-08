/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operator;

import java.util.Scanner;




/**
 *
 * @author Welcome
 */

public class Operator {

   
    public static void main(String[] args) {
        System.out.println("Enter which regression to use");
        System.out.println("1. Linear Regression");
        System.out.println("2. Logistic Regression");
         Scanner sc =new Scanner(System.in);
         if(sc.nextInt()==1){
                Thread t = new Thread(new OperateLinearRegression());
        t.start();
             
         }
         else if(sc.nextInt()==2){
                Thread t = new Thread(new OperateLogisticRegression());
        t.start();
         }
        
      
       
    }
    
}
