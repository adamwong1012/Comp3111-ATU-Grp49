package com.example.comp3111_project;
import com.example.comp3111_project.Algorithms.Person;
import com.example.comp3111_project.Algorithms.Team;
import com.example.comp3111_project.outputScene.OutputHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloApplicationTest {
    private static HelloApplication.Person test;
    private static HelloApplication app;

    private static OutputHelper outputHelper;

    @BeforeEach
    void definePerson() {

        Team team = new Team(0,new Person("20001122",
                "Peter Parker",    "peterparker@connect.ust.hk",
                "28","55","0","0","1",
                "I want to work alone"));
        Team team2 = new Team(0,new Person("20001123",
                "Spider Man",    "spiderman@connect.ust.hk",
                "28","55","0","0","1",
                "I want to work alone"));
        Team[] teams = {team,team2};
        outputHelper = new OutputHelper(teams);
        test = new HelloApplication.Person("20001122",
                "Peter Parker",    "peterparker@connect.ust.hk",
                "28","55","0","0","1",
                "I want to work alone");
    }

    @Test
    void read() {
        app.read("");
        assertEquals(app.selectedFile,null);
        //to ensure nothing is inside selectedFile UNTIL someone chooses a file
    }

    @Test
    void start() {
        assertEquals(1,1);
    }

    @Test
    void main() {
        assertEquals(1,1);
    }

    @Test
    void getStudentIDTest() {
        assertEquals("20001122",test.getStudentid());
    }

    @Test
    void getStudentEmailTest() {
        assertEquals("peterparker@connect.ust.hk",test.getStudentemail());
    }

    @Test
    void getStudentNameTest() {
        assertEquals("Peter Parker",test.getStudentname());
    }

    @Test
    void getK1EnergyTest() {
        assertEquals("28",test.getK1energy());
    }

    @Test
    void getK2EnergyTest() {
        assertEquals("55",test.getK2energy());
    }

    @Test
    void getK3Trick1Test() {
        assertEquals("0",test.getK3trick1());
    }

    @Test
    void getK3Trick2Test() {
        assertEquals("0",test.getK3trick2());
    }

    @Test
    void getMyPreferenceTest() {
        assertEquals("1",test.getMypreference());
    }

    @Test
    void getConcernsTest() {
        assertEquals("I want to work alone",test.getConcerns());
    }

    @Test
    void getEntryTest() {

        HelloApplication.Statistics test = new HelloApplication.Statistics("Total Number of Students", "100");
        assertEquals("Total Number of Students",test.getEntry());
        assertEquals("100",test.getValue());
    }

    @Test
    public void checkGetInputResult() {
        assertEquals(0, outputHelper.checkForValidInput("Sam Wong"));
        assertEquals(-1, outputHelper.checkForValidInput("Sam121Wong"));
        assertEquals(-1, outputHelper.checkForValidInput("154546"));
        assertEquals(0, outputHelper.checkForValidInput("12345678"));
    }

    @Test
    public void checkFormat() {
        assertEquals(1, outputHelper.checkForFormat("Sam Wong"));
        assertEquals(-1, outputHelper.checkForFormat("Sam, Wong"));
        assertEquals(-1, outputHelper.checkForValidInput(",..Sam, Wong"));
    }

    @Test
    public void checkExistingIDRecord() {
        assertEquals(1, outputHelper.checkForExistingStudentID("20001122"));
        assertEquals(1, outputHelper.checkForExistingStudentID("20001123"));
        assertEquals(0, outputHelper.checkForExistingStudentID("20001126"));
        assertEquals(0, outputHelper.checkForExistingStudentID("20001125"));
    }

    @Test
    public void checkExistingNameRecord() {
        assertEquals(1, outputHelper.checkForExistingStudentName("Peter Parker"));
        assertEquals(1, outputHelper.checkForExistingStudentName("Spider Man"));
        assertEquals(0, outputHelper.checkForExistingStudentName("Iron Man"));
    }

//    @SuppressWarnings("unused")
//    public class TeamingProcess_test {
//        @Test
//        public void testSomeLibraryMethod() {
//            TeamingProcess classUnderTest = new TeamingProcess();
//            //assertTrue("someLibraryMethod should return 'true'", classUnderTest.someLibraryMethod());
//        }
//    }

}
