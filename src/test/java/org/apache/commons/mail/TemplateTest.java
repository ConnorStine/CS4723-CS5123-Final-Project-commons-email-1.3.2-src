package org.apache.commons.mail;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import junit.framework.TestCase;

public class TemplateTest extends TestCase{
	Email testEmail;
	public void setUp() {
		testEmail = new SimpleEmail();
	}
	public void testAddBcc() throws EmailException {
		System.out.println("This is a message from the template test.");
		testEmail.addBcc("a@b.com");
		assertEquals("a@b.com", testEmail.getBccAddresses().get(0).toString());
	}

	//addCc
	@Test
	public void testAddCc() throws EmailException{
		//Add an email and see if it was added correctly
		testEmail.addCc("a@b.com");
		assertEquals("a@b.com", testEmail.getCcAddresses().get(0).toString());
	}
	//addHeader
	@Test
	public void testAddHeader() throws IllegalArgumentException{
		//Check for exceptions to be thrown if either field is empty
		try {
			testEmail.addHeader("", "a");
			fail("Exception not thrown for empty name.");
		}
		catch(IllegalArgumentException e){}
		try {
			testEmail.addHeader("a", "");
			fail("Exception not thrown for empty value.");
		}
		catch(IllegalArgumentException e){}
		//Add a header and check that it was mapped correctly
		testEmail.addHeader("name", "value");
		assertNotNull("The name should not be null.", testEmail.headers.get("name"));
		assertEquals("value", testEmail.headers.get("name"));
	}
	//addReplyTo
	@Test
	public void testAddReplyTo() throws EmailException{
		//Add a reply and check that it was added to the list correctly
		testEmail.addReplyTo("a@b.com", "name");
		assertEquals("a@b.com", testEmail.replyList.get(0).getAddress());
	}

}
