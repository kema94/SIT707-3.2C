package sit707_tasks;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author Ahsan Habib
 */
public class DateUtilTest {
	
	@Test
	public void testStudentIdentity() {
		String studentId = "223188749";
		Assert.assertNotNull("Student ID is", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "KEMA SANKA SRINATH DISSANAYAKE GARUSINGHE ARACHCHIGE";
		Assert.assertNotNull("Student name is", studentName);
	}

	@Test
	public void testMaxJanuary31ShouldIncrementToFebruary1() {
		// January max boundary area: max+1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
	}
	
	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		// January max boundary area: max-1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldDecrementToJanuary30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testNominalJanuary() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        System.out.println("testJanuaryNominal > " + date);
        date.increment();
        System.out.println(date);
	}
	
	/*
	 * Complete below test cases.
	 */
	
	@Test
    public void testIncrementD1() {
        DateUtil date = new DateUtil(15, 5, 2024);
        date.increment();
        assertEquals("Increment D1: Incrementing day within a 28-day month", "16 May 2024", date.toString());
    }

    @Test
    public void testIncrementD2() {
        DateUtil date = new DateUtil(29, 2, 2024);
        date.increment();
        assertEquals("Increment D2: Incrementing from day 29", "1 March 2024", date.toString());
    }

    @Test
    public void testIncrementD3() {
        DateUtil date = new DateUtil(30, 4, 2022);
        date.increment();
        assertEquals("Increment D3: Incrementing from a 30-day month", "1 May 2022", date.toString());
    }

    @Test
    public void testIncrementD4() {
        DateUtil date = new DateUtil(31, 7, 2021);
        date.increment();
        assertEquals("Increment D4: Incrementing from a 31-day month", "1 August 2021", date.toString());
    }

    @Test
    public void testDecrementD1() {
        DateUtil date = new DateUtil(20, 9, 2020);
        date.decrement();
        assertEquals("Decrement D1: Decrementing day within a 28-day month", "19 September 2020", date.toString());
    }

    @Test
    public void testDecrementD2() {
        DateUtil date = new DateUtil(29, 2, 2024);
        date.decrement();
        assertEquals("Decrement D2: Decrementing from day 29", "28 February 2024", date.toString());
    }

    @Test
    public void testDecrementD3() {
        DateUtil date = new DateUtil(30, 4, 2023);
        date.decrement();
        assertEquals("Decrement D3: Decrementing from a 30-day month", "29 April 2023", date.toString());
    }

    @Test
    public void testDecrementD4() {
        DateUtil date = new DateUtil(31, 12, 2022);
        date.decrement();
        assertEquals("Decrement D4: Decrementing from a 31-day month", "30 December 2022", date.toString());
    }

    @Test
    public void testIncrementM1() {
        DateUtil date = new DateUtil(30, 4, 2022);
        date.increment();
        assertEquals("Increment M1: Incrementing from a 30-day month", "1 May 2022", date.toString());
    }

    @Test
    public void testIncrementM2() {
        DateUtil date = new DateUtil(31, 7, 2021);
        date.increment();
        assertEquals("Increment M2: Incrementing from a 31-day month", "1 August 2021", date.toString());
    }

    @Test
    public void testIncrementM3() {
        DateUtil date = new DateUtil(28, 2, 2023);
        date.increment();
        assertEquals("Increment M3: Incrementing from February (non-leap year)", "1 March 2023", date.toString());
    }

    @Test
    public void testDecrementM1() {
        DateUtil date = new DateUtil(30, 4, 2022);
        date.decrement();
        assertEquals("Decrement M1: Decrementing from a 30-day month", "29 April 2022", date.toString());
    }

    @Test
    public void testDecrementM2() {
        DateUtil date = new DateUtil(31, 7, 2021);
        date.decrement();
        assertEquals("Decrement M2: Decrementing from a 31-day month", "30 July 2021", date.toString());
    }

    @Test
    public void testDecrementM3() {
        DateUtil date = new DateUtil(28, 2, 2023);
        date.decrement();
        assertEquals("Decrement M3: Decrementing from February (non-leap year)", "27 February 2023", date.toString());
    }

    @Test
    public void testIncrementY1() {
        DateUtil date = new DateUtil(28, 2, 2024);
        date.increment();
        assertEquals("Increment Y1: Incrementing from a leap year", "29 February 2024", date.toString());
    }

    @Test
    public void testIncrementY2() {
        DateUtil date = new DateUtil(28, 2, 2023);
        date.increment();
        assertEquals("Increment Y2: Incrementing from a non-leap year", "1 March 2023", date.toString());
    }

    @Test
    public void testDecrementY1() {
        DateUtil date = new DateUtil(28, 2, 2024);
        date.decrement();
        assertEquals("Decrement Y1: Decrementing from a leap year", "27 February 2024", date.toString());
    }

    @Test
    public void testDecrementY2() {
        DateUtil date = new DateUtil(28, 2, 2023);
        date.decrement();
        assertEquals("Decrement Y2: Decrementing from a non-leap year", "27 February 2023", date.toString());
    }
	
}