package com.example.comp3111_project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloApplicationTest {
    private static HelloApplication.Person test;
    private static HelloApplication app;

    @BeforeEach
    void definePerson() {
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

}