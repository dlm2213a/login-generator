package geco;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LoginServiceTest {

    private LoginService logins;

    @Before
    public void setUp() throws Exception {
        String[] loginsExistants = new String[]{"login1", "login2", "identifiant"};
        logins = new LoginService(loginsExistants);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testLoginExists() {
        assertTrue(logins.loginExists("login1"));
    }

    @Test
    public void testLoginDoesNotExists() {
        assertFalse(logins.loginExists("login10"));
    }

    @Test
    public void testAddLogin() {
        logins.addLogin("login3");
        assertTrue("", logins.loginExists("login3"));
    }

    @Test
    public void findAllLoginsStartingWith() {
        List loginsStart = new ArrayList(){};
        loginsStart = logins.findAllLoginsStartingWith("log");
        assertTrue(loginsStart.contains("login1"));
        assertTrue(loginsStart.contains("login2"));
        assertFalse(loginsStart.contains("identifiant"));
    }

    @Test
    public void testFindAllLogins() {
        List loginsAll = new ArrayList(){};
        loginsAll = logins.findAllLogins();
        assertTrue(loginsAll.contains("login1"));
        assertTrue(loginsAll.contains("login2"));
        assertTrue(loginsAll.contains("identifiant"));
    }
}