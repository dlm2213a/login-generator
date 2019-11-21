package geco;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginGeneratorTest {

    private LoginService loginService;
    private LoginGenerator loginGenere;

    @Before
    public void setUp() throws Exception {
        loginService = new LoginService(new String[]{"JROL", "BPER", "CGUR", "JDU", "JRAL", "JRAL1"});
        loginGenere = new LoginGenerator(loginService);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGenerateLoginForNomAndPrenom() {
        assertEquals("PDUR", loginGenere.generateLoginForNomAndPrenom("Durand", "Paul"));
        assertTrue(loginService.loginExists("PDUR"));
    }

    @Test
    public void testGenerateLoginForNomAndPrenomExiste() {
        assertEquals("JRAL2", loginGenere.generateLoginForNomAndPrenom("Ralling", "John"));
        assertTrue(loginService.loginExists("JRAL2"));
    }

    @Test
    public void testGenerateLoginJeanRolling() {
        assertEquals("JROL1", loginGenere.generateLoginForNomAndPrenom("Rolling", "Jean"));
        assertTrue(loginService.loginExists("JROL1"));
    }

    @Test
    public void testGenerateLoginPaulDurandAccent() {
        assertEquals("PDUR", loginGenere.generateLoginForNomAndPrenom("Dùrand", "Paul"));
        assertTrue(loginService.loginExists("PDUR"));
    }
}