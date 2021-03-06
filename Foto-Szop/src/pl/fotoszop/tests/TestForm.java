package pl.fotoszop.tests;

import org.junit.Test;
import pl.fotoszop.dto.Form;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TestForm {

    @Test
    public void testCheckPassword() {
        Form f = new Form();
        f.setPassword("Haslo123");
        f.setPassword2("Haslo123");
        assertEquals(true, f.checkPasswords());
        f.setPassword("123HasloHaslo");
        assertEquals(false, f.checkPasswords());
    }

    @Test
    public void testHashGenerator() {
        Form f = new Form();
        f.setPassword("Haslo");
        f.setPassword2("Haslo");
        String s = f.getPassword();
        f.doHash();
        assertFalse(s.equals(f.getPassword()));
    }

	/*@Test
	public void */

}
