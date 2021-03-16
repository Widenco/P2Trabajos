/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.programacion.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ni.edu.uni.programacion.views.panels.PnlCurrency;

/**
 *
 * @author Denzell Connolly
 */
public class CurrencyController implements ActionListener{
    private PnlCurrency pnlCurrency;
    
    public CurrencyController(PnlCurrency pnlCurrency){
        this.pnlCurrency = pnlCurrency;
        initComponent();
    }
    private void initComponent(){
        pnlCurrency.getBtnConv().addActionListener(this);
        pnlCurrency.getBtnNew().addActionListener(this);
        pnlCurrency.getBtnCs().addActionListener(this);
        pnlCurrency.getBtnSc().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getActionCommand().equalsIgnoreCase("C$ - $")){
           pnlCurrency.getLblMoneda1().setText("C$");
           pnlCurrency.getLblMoneda2().setText("$");
       }
       if(e.getActionCommand().equalsIgnoreCase("$ - C$")){
           pnlCurrency.getLblMoneda1().setText("$");
           pnlCurrency.getLblMoneda2().setText("C$");
          
       }
       
       if(e.getActionCommand().equalsIgnoreCase("Convertir")){
           if(pnlCurrency.getLblMoneda1().getText() == "C$"){
               double cordoba = Double.parseDouble(pnlCurrency.getTxtMoneda1().getText());
               pnlCurrency.getTxtMoneda2().setText(String.valueOf(cordobaDolar(cordoba))); 
           }
           if(pnlCurrency.getLblMoneda1().getText() == "$"){
               double dolar = Double.parseDouble(pnlCurrency.getTxtMoneda1().getText());
               pnlCurrency.getTxtMoneda2().setText(String.valueOf(dolarCordoba(dolar))); 
               
           }
       }
       
       if(e.getActionCommand().equalsIgnoreCase("Nuevo")){
           pnlCurrency.getTxtMoneda1().setText("");
           pnlCurrency.getTxtMoneda2().setText("");
       }
       
       
    }
    
    private double cordobaDolar(double cordoba){
        double conversion = cordoba * 0.029;
      
        return conversion;
    }
    private double dolarCordoba(double dolar){
        double conversion = dolar * 34.88;
        
        return conversion;
    }
    
}
