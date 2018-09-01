/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocks.marketanalysis.Neuralnetwork.dataSet;

import java.util.List;
import stocks.marketanalysis.daos.DatasetmodelImpl;
import stocks.marketanalysis.daos.IDatasetModel;
import stocks.marketanalysis.models.Datasetmodel;

/**
 *
 * @author Prakash Tyata
 */
public class DataSetInitilization {

    public double[][] getNormalizeddataset() {

        IDatasetModel objdataset = new DatasetmodelImpl();
        double[][] data = new double[5][];
        List<Datasetmodel> sList = objdataset.getDatasetmodel();
        int i=0;
        for (Datasetmodel slist : sList) {
                
                        data[i][0]=slist.getMovingavg();
                        data[i][1]=slist.getBollingerband();
                        data[i][2]=slist.getRsi();
                        data[i][3]=slist.getStochastic();
                        data[i][4]=slist.getPeratio();
                        data[i][5]=slist.getTargetvalue();
                        i++;
            
        }
        
       
        
        
        return null;
    }

}
