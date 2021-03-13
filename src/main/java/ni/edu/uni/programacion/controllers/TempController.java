/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.programacion.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ni.edu.uni.programacion.views.panels.PnlTemp;

/**
 *
 * @author Denzell Connolly
 */
public class TempController implements ActionListener{
    private PnlTemp pnlTemp;
    
    public TempController(PnlTemp pnlTemp){
        this.pnlTemp = pnlTemp;
        initComponent();
    }
    
    private void initComponent(){
        pnlTemp.getBtnConv().addActionListener(this);
        pnlTemp.getBtnNew().addActionListener(this);
        pnlTemp.getBntFc().addActionListener(this);
        pnlTemp.getBtnCf().addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equalsIgnoreCase("C - F")){
            pnlTemp.getLblTemp1().setText("C");
            pnlTemp.getLblTemp2().setText("F");
        }else if(e.getActionCommand().equalsIgnoreCase("F - C")){
            pnlTemp.getLblTemp1().setText("F");
            pnlTemp.getLblTemp2().setText("C");
        }

        if(e.getActionCommand().equalsIgnoreCase("Convertir")){
            double temp;
            if(pnlTemp.getLblTemp1().getText() == "C"){
            temp = Double.parseDouble(pnlTemp.getTxtTemp1().getText());
            pnlTemp.getTxtTemp2().setText(String.valueOf(conversionCf(temp)));
            }else if(pnlTemp.getLblTemp1().getText() == "F"){
            temp = Double.parseDouble(pnlTemp.getTxtTemp1().getText());
            pnlTemp.getTxtTemp2().setText(String.valueOf(conversionFc(temp)));  
            }
        }
        
        if(e.getActionCommand().equalsIgnoreCase("Nuevo")){
            pnlTemp.getTxtTemp1().setText("");
            pnlTemp.getTxtTemp2().setText("");
        }
    }
    
    private double conversionFc(double temp){
        double conversion = 0;
        
        conversion = (temp - 32) / 1.8;
        
        return conversion;
    }
    
    private double conversionCf(double temp){
        double conversion = 0;
        
        conversion = (temp * 1.8) + 32;
        
        return conversion;
    }
    
}
