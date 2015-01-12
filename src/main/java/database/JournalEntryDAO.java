package database;

import fitness.JournalEntry;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.ConnectionUtils;
import util.DbUtils;

/**
 * JournalEntryDAO
 * 
 * This class handles all database querying relating to the JournalEntry class.
 * 
 * @author Logan Noonan
 * @since 20141203
 */
public class JournalEntryDAO {
    /**
    * 
    * This method connects to the database to create a new journal entry.
    * 
    * @author Logan Noonan
     * @throws java.lang.Exception
    * @since 20141203
    * 
    * @param entry
    */
    
    
    ////////////////////////////////////////////////////
    // to find the maximum or best of bench press from table.
    ////////////////////////////////////////////////////
    public static ArrayList <String> getMaxBenchPressFromJournalEntry() throws Exception{
        PreparedStatement ps = null;
        String query = null;
        Connection sqlconn = null;
        sqlconn = ConnectionUtils.getConnection(); //create connection object
        
        ArrayList<String> list = new ArrayList();
        try{
            //select max query bench press from all users
            query = "SELECT max(maxBenchPress) FROM journal_entry"; 
            //prepare the statement
            ps = sqlconn.prepareStatement(query);
            ResultSet results = ps.executeQuery(); //execute the select query
            int nextMESequence = 0;
            if (results.next()) {
                nextMESequence = results.getInt(1); //store next entry id
                list.add("0" + nextMESequence);
            }
            System.out.println("Max Bench Press is: " + nextMESequence);
        }catch (Exception e) {
            String errorMessage = e.getMessage();
        } finally {
            DbUtils.close(ps, sqlconn);
        }
        return list;
    }
    
    public static void addEntry(JournalEntry entry) throws Exception {
        /**
         * journal_entry table structure
         *      entry_id        (int)(3)
         *      entry_content   (string)(100)
         *      entry_date      (string)(8)
         *      entry_weight    (string)(3)
         */ 
        PreparedStatement ps = null;
        String query = null;
        Connection sqlconn = null;
        sqlconn = ConnectionUtils.getConnection(); //create connection object
        try {
            //select max query determines the next ID that the new entry will be assigned
            query = "SELECT max(entry_id) FROM journal_entry"; 
            
            //prepare the statement
            ps = sqlconn.prepareStatement(query);
            ResultSet results = ps.executeQuery(); //execute the select query
            int nextMESequence = 1;
            if (results.next()) {
                nextMESequence = results.getInt(1) + 1; //store next entry id
            }
            entry.setEntryId(nextMESequence); //set the new entry id
            //insert query for inserting the entry into the db
            ////////////////////////////////////////////////////
            // I had to change the db table firlds cause my table was already existed in the system.
            ////////////////////////////////////////////////////
            query = "INSERT INTO journal_entry "
                    + "  (`entry_id`, `dateEntry`, `weight`, `maxBenchPress`, `description`)"
                    + "  VALUES (?, ?, ?, ?, ?)";

            ps = sqlconn.prepareStatement(query); //prepare the statement
            //assign statement values
            ps.setInt(1, nextMESequence);
            ps.setString(2, entry.getDateOfEntry());
            ps.setString(3, entry.getWeight());
            ps.setString(4, entry.getMaxBenchPress());
            ps.setString(5, entry.getEntry());
            ps.executeUpdate(); //execute query
            System.out.println("Journal entry written to database.");
            
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            throw e;
        } finally {
            DbUtils.close(ps, sqlconn);
        }
    }
    /**
    * 
    * This method connects to the database and returns all journal entries
    * contained within the journal_entry table, converts them into JournalEntry
    * objects, and places them in an array list.
    * 
    * @author Logan Noonan
    * @since 20141203
    * 
    * @return an ArrayList of JournalEntries
    */
    public static ArrayList<JournalEntry> getAllEntries() {

        PreparedStatement ps = null;
        String query = null;
        Connection sqlconn = null;

        ArrayList<JournalEntry> journal = new ArrayList();
        try {
            sqlconn = ConnectionUtils.getConnection();
            //build select query
            query= "SELECT * FROM journal_entry";
            ps = sqlconn.prepareStatement(query); //prepare the statement
            //execute SQL query
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //put each entry from the db into a new JournalEntry object and assign values
                ////////////////////////////////////////////
                // sorry again, had to change the fields.
                ////////////////////////////////////////////
                JournalEntry newEntry = new JournalEntry();
                newEntry.setEntryId(rs.getInt("entry_id"));
                newEntry.setDateOfEntry(rs.getString("dateEntry"));
                newEntry.setWeight(rs.getString("weight"));
                newEntry.setMaxBenchPress(rs.getString("maxBenchPress"));
                newEntry.setEntry("description");
                //add the newly instantiated entry to the journal ArrayList
                journal.add(newEntry);
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
        } finally {
            DbUtils.close(ps, sqlconn); //close the db connection
        }
        return journal;
    }
}
