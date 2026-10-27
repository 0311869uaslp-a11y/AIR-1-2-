package com.ejemplo;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AnnonceDAOTest {

    private AnnonceDAO dao;

    @BeforeEach
    void setUp() {
        dao = new AnnonceDAO();
    }

    @Test
    void testGetById() {
        Annonce a = dao.getById(1);
        assertNotNull(a, "Debe existir una annonce con ID=1");
    }
    
    @Test
    void testInsertAnnonce() {
        Annonce a = new Annonce("Title", "Desc", "Adress", "mail@example.com");
        dao.insert(a);
        assertNotNull(a, "Debe existir una annonce con ID>1");
    }

   

    @Test
    void testUpdateAnnonce() {
        Annonce a = dao.getById(1);
        a.setTitle("Nuevo título");
        dao.update(a);
        Annonce updated = dao.getById(1);
        assertEquals("Nuevo título", updated.getTitle());
    }
}
