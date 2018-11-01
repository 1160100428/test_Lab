package CoreTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Core.DataBase;
leo
public class DataBaseTest {

	@Test
	public void addTextTest() {
		DataBase dataBase = new DataBase();
		String testString1 = "Leo";
		String testString2 = "LeoLeoLeo"
				+ "LeoLeoLeoLeoLeoLeoLeoLeoLeoLeoLeoLeoLeoLeoLeoLeoLeoLeo";
		dataBase.addText(testString1);
		assertEquals(testString1, dataBase.getMainText());
		dataBase.addText(testString2);
		assertEquals(testString1, dataBase.getMainText());
	}
	
	@Test
	public void addDotTest() {
		DataBase dataBase = new DataBase();
		dataBase.addDot();
		assertEquals(".", dataBase.getMainText());
		dataBase.addDot();
		assertEquals(".", dataBase.getMainText());
	}
	
	@Test
	public void addZeroTest() {
		DataBase dataBase = new DataBase();
		dataBase.addZero();
		assertEquals("0", dataBase.getMainText());
		dataBase.addZero();
		assertEquals("0", dataBase.getMainText());
	}
	
	@Test
	public void equalTest() {
		//+
		DataBase dataBase = new DataBase();
		dataBase.setMainText("1");
		dataBase.twoSyn("+");
		dataBase.setMainText("2");
		dataBase.equal();
		assertEquals("3.0", dataBase.getMainText());
		//-
		dataBase.reboot();
		dataBase.setMainText("1");
		dataBase.twoSyn("-");
		dataBase.setMainText("2");
		dataBase.equal();
		assertEquals("-1.0", dataBase.getMainText());
		//X
		dataBase.reboot();
		dataBase.setMainText("1");
		dataBase.twoSyn("X");
		dataBase.setMainText("2");
		dataBase.equal();
		assertEquals("2.0", dataBase.getMainText());
		///
		dataBase.reboot();
		dataBase.setMainText("1");
		dataBase.twoSyn("/");
		dataBase.setMainText("2");
		dataBase.equal();
		assertEquals("0.5", dataBase.getMainText());
	}
	
	@Test
	public void oneSynTest() {
		//%
		DataBase dataBase = new DataBase();
		dataBase.setMainText("1");
		dataBase.oneSyn("%");
		assertEquals("100.0", dataBase.getMainText());
		//¡Ì
		dataBase.reboot();
		dataBase.setMainText("1");
		dataBase.oneSyn("¡Ì");
		assertEquals("1.0", dataBase.getMainText());
		//x^2
		dataBase.reboot();
		dataBase.setMainText("2");
		dataBase.oneSyn("x^2");
		assertEquals("4.0", dataBase.getMainText());
		//1/x
		dataBase.reboot();
		dataBase.setMainText("1");
		dataBase.oneSyn("1/x");
		assertEquals("1.0", dataBase.getMainText());
	}
}
