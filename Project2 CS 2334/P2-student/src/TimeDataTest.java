import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.junit.Assert;

import org.junit.Test;

/**
 * 
 * @author Kyle Murphey
 * @version 2018/11/4
 * Test file for TimeData
 *
 */
public class TimeDataTest
{

    /**
     * Testing the TimeData ctor
     */
    @Test
    public void testTimeDataStringIntIntIntIntMeasurementMeasurementMeasurement()
    {
        TimeData t = new TimeData("NRMN", 2018, 10, 8, 15, new Measurement(4.0), 
                new Measurement(5.0), new Measurement(6.0));
        Assert.assertEquals("NRMN", t.getStationID());
        
    }
    
    /**
     * Testing wrong time zone
     */
    @Test
    public void wrongTimeZoneTest()
    {
        GregorianCalendar g = new GregorianCalendar(2018, 10, 8);
        try
        {
            TimeData t = new TimeData("NRMN", g, new Measurement(4.0), 
                    new Measurement(5.0), new Measurement(6.0));
            t.getDay();
            Assert.fail();
        }
        catch (WrongTimeZoneException e)
        {
            //succeed
        }
    }

    /**
     * Testing the other ctor for TimeData
     * @throws WrongTimeZoneException wrong tz
     */
    @Test
    public void testTimeDataStringGregorianCalendarMeasurementMeasurementMeasurement() throws WrongTimeZoneException
    {
        GregorianCalendar g = new GregorianCalendar(2018, 10, 8);
        g.setTimeZone(TimeZone.getTimeZone("UTC"));
        TimeData t = new TimeData("NRMN", g, new Measurement(4.0), 
                new Measurement(5.0), new Measurement(6.0));
        Assert.assertEquals("NRMN", t.getStationID());
    }

    /**
     * Testing the measurement date
     */
    @Test
    public void testGetMeasurementDateTime()
    {
        TimeData t = new TimeData("NRMN", 2018, 10, 8, 15, new Measurement(4.0), 
                new Measurement(5.0), new Measurement(6.0));
        
        GregorianCalendar g = new GregorianCalendar();
        g.setTime(new GregorianCalendar(2018, 10, 8, 0 ,15).getTime());
        
        SimpleDateFormat dateFormat = new SimpleDateFormat(CsAbstractFile.dateTimeFormat);
        dateFormat.setCalendar(g);
        dateFormat.format(g.getTime());
        g.setTimeZone(TimeZone.getTimeZone("UTC"));
        
        Assert.assertEquals(g, t.getMeasurementDateTime());
    }

    /**
     * Testing the minute
     */
    @Test
    public void testGetMinute()
    {
        TimeData t = new TimeData("NRMN", 2018, 10, 8, 15, new Measurement(4.0), 
                new Measurement(5.0), new Measurement(6.0));
        Assert.assertEquals(15, t.getMinute());
    }

    /**
     * Testing the month
     */
    @Test
    public void testGetMonth()
    {
        TimeData t = new TimeData("NRMN", 2018, 10, 8, 15, new Measurement(4.0), 
                new Measurement(5.0), new Measurement(6.0));
        Assert.assertEquals(10, t.getMonth());
    }

    /**
     * Testing the day
     */
    @Test
    public void testGetDay()
    {
        TimeData t = new TimeData("NRMN", 2018, 10, 8, 15, new Measurement(4.0), 
                new Measurement(5.0), new Measurement(6.0));
        Assert.assertEquals(8, t.getDay());
    }

    /**
     * Testing the year
     */
    @Test
    public void testGetYear()
    {
        TimeData t = new TimeData("NRMN", 2018, 10, 8, 15, new Measurement(4.0), 
                new Measurement(5.0), new Measurement(6.0));
        Assert.assertEquals(2018, t.getYear());
    }

    /**
     * Testing the station ID
     */
    @Test
    public void testGetStationID()
    {
        TimeData t = new TimeData("NRMN", 2018, 10, 8, 15, new Measurement(4.0), 
                new Measurement(5.0), new Measurement(6.0));
        Assert.assertEquals("NRMN", t.getStationID());
    }

    /**
     * Testing the ta9m
     */
    @Test
    public void testGetTa9m()
    {
        TimeData t = new TimeData("NRMN", 2018, 10, 8, 15, new Measurement(4.0), 
                new Measurement(5.0), new Measurement(6.0));
        Assert.assertEquals(5.0, t.getTa9m().getValue(), 0.01);
    }

    /**
     * Testing the srad
     */
    @Test
    public void testGetSolarRadiation()
    {
        TimeData t = new TimeData("NRMN", 2018, 10, 8, 15, new Measurement(4.0), 
                new Measurement(5.0), new Measurement(6.0));
        Assert.assertEquals(6.0, t.getSolarRadiation().getValue(), 0.01);
    }

    /**
     * Testing the tair
     */
    @Test
    public void testGetTair()
    {
        TimeData t = new TimeData("NRMN", 2018, 10, 8, 15, new Measurement(4.0), 
                new Measurement(5.0), new Measurement(6.0));
        Assert.assertEquals(4.0, t.getTair().getValue(), 0.01);
    }

}
