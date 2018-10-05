package edu.orangecoastcollege.cs272.ic12.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.orangecoastcollege.cs272.ic12.model.DBModel;

public class TestDBModel
{

    private static final String DB_NAME = "cs272_test.db";
    private static final String TABLE_NAME = "car";
    private static final String[] FIELD_NAMES = { "id", "make", "description", "horsepower", "fuelType", "cityMPG", "hwyMPG", "hybrid" };
    private static final String[] FIELD_TYPES = { "INTEGER PRIMARY KEY", "TEXT", "TEXT", "INTEGER", "TEXT", "INTEGER", "INTEGER", "INTEGER" };

    private static DBModel db;

    private String[] values;

    // Set up before class defines variables, resources, etc
    // Static method, so only executes once before all testing begins
    // Anything you need to setup before testing, do it here
    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {
        // Instantiate our database
        db = new DBModel(DB_NAME, TABLE_NAME, FIELD_NAMES, FIELD_TYPES);
    }

    // Tear down after class cleans up any open resources
    // Static method, only executes once at the end of all testing
    @AfterClass
    public static void tearDownAfterClass() throws Exception
    {
        db.close();
    }

    // set up is executed before each individual test
    @Before
    public void setUp() throws Exception
    {
        values = new String[] { "1", "BMW", "2018 M3 Manual", "300", "Gas", "25", "45", "0" };
        
    }

    // tear down is executed after each individual test
    @After
    public void tearDown() throws Exception
    {
    	db.deleteAllRecords();
    }

    /**
     * This test makes sure that we are able to get all the records from the database
     */
    @Test
    public void testGetAllRecords()
    {
        try
        {
            db.getAllRecords();
        }
        catch (SQLException e)
        {
            fail("Getting all records on empty database should not generate SQLException");
        }
    }

    /**
     * This tests to make sure we can get a single record from the database.
     */
    @Test
    public void testGetRecord()
    {
        try
        {
            db.createRecord(Arrays.copyOfRange(FIELD_NAMES, 1, FIELD_NAMES.length), Arrays.copyOfRange(values, 1, values.length));
            assertTrue("Before deletion, count should be positive", db.getRecordCount() > 0);
            db.getRecord(FIELD_NAMES[1]);
        }
        catch (SQLException e)
        {
            fail("Getting record on empty database should not generate SQLException");
        }
    }

    /**
     * This test ensures correctness of the record count in the database.
     */
    @Test
    public void testGetRecordCount()
    {
        try
        {
        	db.createRecord(Arrays.copyOfRange(FIELD_NAMES, 1, FIELD_NAMES.length), Arrays.copyOfRange(values, 1, values.length));
        	assertEquals("Testing to see if record count is 1 after creating a record.", 1, db.getRecordCount());
        	db.createRecord(Arrays.copyOfRange(FIELD_NAMES, 1, FIELD_NAMES.length), Arrays.copyOfRange(values, 1, values.length));
        	assertEquals("Testing to see if record count is 2 after creating a record.", 2, db.getRecordCount());
        	db.deleteRecord("1");
        	assertEquals("Testing to see if record count is 1 after deleting a record.", 1, db.getRecordCount());
        	db.deleteRecord("2");
        	assertEquals("Testing to see if record count is 0 after deleting a record.", 0, db.getRecordCount());
        }
        catch(SQLException e)
        {
            fail("Getting record count should not generate SQLException");
        }
    }

    /**
     * This tests to make sure we can create a brand new record in the database.
     */
    @Test
    public void testCreateRecord()
    {
        try
        {
            assertEquals("Testing creation of car with id provided", 1, db.createRecord(FIELD_NAMES, values));
            assertEquals("Testing the count of records", 1, db.getRecordCount());
            assertEquals("Testing creation of car, no id provided", 2, db.createRecord(Arrays.copyOfRange(FIELD_NAMES, 1, FIELD_NAMES.length), Arrays.copyOfRange(values, 1, values.length)));
            assertEquals("Testing the count of records", 2, db.getRecordCount());
        }
        catch (SQLException e)
        {
        	e.printStackTrace();
            fail("Creation of records should not generate SQLException");
        }

        try
        {
            db.createRecord(FIELD_NAMES, values);
            fail("Creating a record with a duplicate id should generate a SQLException.");
        }
        catch (SQLException e)
        {
            // Expected
        }
    }

    /**
     * This tests to make sure we can update our records
     */
    @Test
    public void testUpdateRecord()
    {
        try
        {
            db.createRecord(Arrays.copyOfRange(FIELD_NAMES, 1, FIELD_NAMES.length), Arrays.copyOfRange(values, 1, values.length));
            assertTrue("Update should be successful", db.updateRecord("1", Arrays.copyOfRange(FIELD_NAMES, 1, FIELD_NAMES.length), Arrays.copyOfRange(values, 1, values.length)));
            assertFalse("Update should be successful", db.updateRecord("1", FIELD_NAMES, Arrays.copyOfRange(values, 1, values.length)));
            assertTrue("Update of id that does not exist should return true", db.updateRecord("10", Arrays.copyOfRange(FIELD_NAMES, 1, FIELD_NAMES.length), Arrays.copyOfRange(values, 1, values.length)));
        }
        catch (SQLException e)
        {
            fail("Update of records should not generate SQLException");
        }        
    }

    /**
     * This tests to make sure we can delete all our records
     */
    @Test
    public void testDeleteAllRecords()
    {
        try
        {
            db.createRecord(Arrays.copyOfRange(FIELD_NAMES, 1, FIELD_NAMES.length), Arrays.copyOfRange(values, 1, values.length));
            assertTrue("Before deletion, count should be positive", db.getRecordCount() > 0);
            db.deleteAllRecords();
            assertEquals("Count after deletion should be 0.", 0, db.getRecordCount());
        }
        catch (SQLException e)
        {
            fail("Deletion should not generate an SQLException.");
        }
    }

    /**
     * This tests to make sure we can delete one record
     */
    @Test
    public void testDeleteRecord()
    {
        try
        {
            db.createRecord(Arrays.copyOfRange(FIELD_NAMES,  1,  FIELD_NAMES.length), Arrays.copyOfRange(values,  1, values.length));
            assertTrue("Before deletion, count should be positive", db.getRecordCount() > 0);
            db.deleteRecord("1");
            assertEquals("Count after deletion should be 0.", 0, db.getRecordCount());
            }
        catch (SQLException e)
        {
            fail("Deletion should not generate an SQLException.");
        }
    }

}