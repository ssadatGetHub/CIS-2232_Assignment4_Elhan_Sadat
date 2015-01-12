/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import database.JournalEntryDAO;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;

/**
 *
 * @author Aziz
 */
@WebService(serviceName = "findMaxWebService")
public class findMaxWebService {
    /**
     * This is a sample web service operation
     * @return 
     * @throws java.lang.Exception 
     */
    
    @WebMethod(operationName = "getMaxBenchPressFromTable")
    public ArrayList<String> findMaxBenchPress() throws Exception{
//        System.out.println("Max is: " + JournalEntryDAO.getMaxBenchPressFromJournalEntry());
        return JournalEntryDAO.getMaxBenchPressFromJournalEntry();  
    }
}
