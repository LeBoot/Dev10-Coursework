/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.mp3project.controller.dao;

import bl.mp3project.dto.MP3File;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Boone
 */
public class mp3ProjectDaoTest {
    
    private mp3ProjectDao dao = new mp3ProjectDaoFileImpl();
    
    public mp3ProjectDaoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        mp3ProjectDaoFileImpl.textFile = "library-test.txt";
    }
    
    @AfterAll
    public static void tearDownClass() {
        mp3ProjectDaoFileImpl.textFile = "library.txt";
    }
    
    @BeforeEach
    public void setUp() throws Exception {
        List<MP3File> fileList = dao.getAllMP3Files();
        for (MP3File file : fileList) {
            dao.removeMP3File(file.getTitle());
        }
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addMP3File method, of class mp3ProjectDao.
     */
    @Test
    public void testAddAndGetMP3File() throws Exception {
        
        //create a new mp3File
        MP3File fileToTest = new MP3File("New Song");
        fileToTest.setReleaseDate(LocalDate.parse("2020-05-05"));
        fileToTest.setGenre("Country");
        fileToTest.setAlbum("Great Songs");
        fileToTest.setArtist("New Artist");
        fileToTest.setComment("So good!");
        
        //use DAO to add that file to memory
        dao.addMP3File(fileToTest.getTitle(), fileToTest);
        
        //pull the mp3 from memory, save it as a new object
        MP3File fromDao = dao.getMP3File(fileToTest.getTitle());
        
        //see if what was put-into and pulled-outfrom memory match
        assertEquals(fromDao, fileToTest);
    }

    /**
     * Test of removeMP3File method, of class mp3ProjectDao.
     */
    @Test
    public void testRemoveMP3File() throws Exception {
        
        //create and add a new mp3File
        MP3File file1 = new MP3File("New Song");
        file1.setReleaseDate(LocalDate.parse("2020-05-05"));
        file1.setGenre("Country");
        file1.setAlbum("Great Songs");
        file1.setArtist("New Artist");
        file1.setComment("So good!");
        dao.addMP3File(file1.getTitle(), file1);
        
        //ensure that memory contains exactly one file
        assertEquals(1, dao.getAllMP3Files().size());
        
        //remove that file, and check that memory now contains exactly 0 files
        //also, check that the memory of that removed file is null
        dao.removeMP3File(file1.getTitle());
        assertEquals(0, dao.getAllMP3Files().size());
        assertNull(dao.getMP3File(file1.getTitle()));
    }

    /**
     * Test of getAllMP3Files method, of class mp3ProjectDao.
     */
    @Test
    public void testGetAllMP3Files() throws Exception {
        
        //check that getAllFiles yeilds exactly 0
        assertEquals(0, dao.getAllMP3Files().size());
        
        //add a file
        MP3File file1 = new MP3File("New Song");
        file1.setReleaseDate(LocalDate.parse("2020-05-05"));
        file1.setGenre("Country");
        file1.setAlbum("Great Songs");
        file1.setArtist("New Artist");
        file1.setComment("So good!");
        dao.addMP3File(file1.getTitle(), file1);
        
        //now, ensure that memory contains exactly one file
        assertEquals(1, dao.getAllMP3Files().size());
        
        //add another file
        MP3File file2 = new MP3File("Another song");
        file2.setReleaseDate(LocalDate.parse("2020-05-05"));
        file2.setGenre("Pop");
        file2.setAlbum("Amazing Songs");
        file2.setArtist("Newer Artist");
        file2.setComment("So great!");
        dao.addMP3File(file2.getTitle(), file2);
        
        //now, ensure that memory contains exactly two files
        assertEquals(2, dao.getAllMP3Files().size());
    }

    /**
     * Test of getMP3File method, of class mp3ProjectDao.
     */
    @Test
    public void testGetMP3File() throws Exception {
        //tested with add method (above)
    }
    
}
