package com.moilioncircle.message.formatter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Baoyi Chen
 */
public class MessageFormatterTest {
	@Test
	public void test() {
		MessageFormatter formatter = new MessageFormatter();
		
		{
			String pattern = "a {} {} b";
			Object[] args = null;
			assertEquals("a null null b", formatter.format(pattern, args));
		}
		
		{
			String pattern = "a {{}} {{}} b";
			Object[] args = null;
			assertEquals("a {null} {null} b", formatter.format(pattern, args));
		}
		
		{
			String pattern = "a {{}} {b} b";
			Object[] args = null;
			assertEquals("a {null} {b} b", formatter.format(pattern, args));
		}
		
		{
			String pattern = "c {a} {b} d";
			Object[] args = null;
			assertEquals("c {a} {b} d", formatter.format(pattern, args));
		}
		
		{
			String pattern = "c \\{} \\{} d";
			Object[] args = null;
			assertEquals("c {} {} d", formatter.format(pattern, args));
		}
		
		{
			String pattern = "c \\{\\} \\{\\} d";
			Object[] args = null;
			assertEquals("c {} {} d", formatter.format(pattern, args));
		}
		
		{
			String pattern = "c \\\\} \\\\} d";
			Object[] args = null;
			assertEquals("c \\} \\} d", formatter.format(pattern, args));
		}
		
		{
			String pattern = "c \\";
			Object[] args = null;
			assertEquals("c \\", formatter.format(pattern, args));
		}
		
		{
			String pattern = "c {";
			Object[] args = null;
			assertEquals("c {", formatter.format(pattern, args));
		}
		
		{
			String pattern = "c {a {a";
			Object[] args = null;
			assertEquals("c {a {a", formatter.format(pattern, args));
		}
		
		{
			String pattern = "c {\\";
			Object[] args = null;
			assertEquals("c {\\", formatter.format(pattern, args));
		}
		
		{
			String pattern = "c {\\}";
			Object[] args = null;
			assertEquals("c {}", formatter.format(pattern, args));
		}
		
		{
			String pattern = "c {\\a";
			Object[] args = null;
			assertEquals("c {\\a", formatter.format(pattern, args));
		}
		
		{
			String pattern = "a {} {} b";
			Object[] args = new Object[]{"1", 2, 3};
			assertEquals("a 1 2 b", formatter.format(pattern, args));
		}
	}
	
}