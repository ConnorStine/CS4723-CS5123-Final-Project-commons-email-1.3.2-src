package org.apache.commons.mail;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import junit.framework.TestCase;

public class TestReply extends TestCase{
	  Email testEmail;
	  public void setUp() {
		    testEmail = new SimpleEmail();
	  }
	
	  //addReplyTo
	  @Test
	  public void testAddReplyTo() throws EmailException{
		    //Add a reply and check that it was added to the list correctly
		    testEmail.addReplyTo("a@b.com", "name");
		    assertEquals("a@b.com", testEmail.replyList.get(0).getAddress());
	  }

}
