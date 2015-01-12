/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import fitness.JournalEntry;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Aziz
 */
@WebService(serviceName = "JournalEntryDAO")
public class JournalEntryDAO {

    JournalEntryDAO je = new JournalEntryDAO();
  
    /**
     * Web service operation
     * to get all entries from the database.
     */
    @WebMethod(operationName = "getAllEntries")
    public ArrayList<JournalEntry> getAllEntries() {    
        System.out.println("jflsjf:" + database.JournalEntryDAO.getAllEntries());
        return je.getAllEntries();
    }  

    /**
     * Web service operation
     * insert entry into data base.
     */
    @WebMethod(operationName = "addEntry")
    public String addEntry(@WebParam(name = "dateOfEntry") String dateOfEntry, @WebParam(name = "weight") String weight, @WebParam(name = "maxBenchPress") String maxBenchPress, @WebParam(name = "entry") String entry) {
        //TODO write your implementation code here:
        JournalEntry journal = new JournalEntry();
        journal.setDateOfEntry(dateOfEntry);
        journal.setWeight(weight);
        journal.setMaxBenchPress(maxBenchPress);
        journal.setEntry(entry);
        return je.addEntry(dateOfEntry, weight, maxBenchPress, entry);
    }    
}
