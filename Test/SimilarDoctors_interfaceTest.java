import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * Created by freya on 10/27/2016.
 */
public class SimilarDoctors_interfaceTest extends TestCase {
    List<Doctors> doctors = new ArrayList<Doctors>();
    public void setUp() throws Exception {
        System.out.println("Setting up...");
        String street = "123 Street";
        int zip = 94000;
        String city = "San Francisco";
        String state = "CA";
        for(int i=0; i<100;i++) {
            Address address = new Address(street,city, state, zip+i%10);
            String name = "A"+i;
            int score = new Random().nextInt(6);
            Doctors doctor = new Doctors(name, address, score);
            doctors.add(doctor);
        }
    }

    public void tearDown() throws Exception {
        System.out.println("Tearing down...");
        doctors.clear();
    }
    @Test
    public void testSimilarDoctors() {
        SimilarDoctors similarDoctors = new SimilarDoctors();
        int zip = 94105;
        similarDoctors.sort_doctors(doctors, zip);
        for(int i=1; i<100; i++) {
            Doctors d1 = doctors.get(i-1);
            Doctors d2 = doctors.get(i);
            boolean condition1 = d1.review_score>=d2.review_score;
            boolean condition2 = d1.review_score==d2.review_score && Math.abs(d1.address.zip-zip)<=Math.abs(d2.address.zip-zip);
            assertTrue(condition1 || condition2);
            assertTrue(doctors.size()==100);
        }
    }

    public void testSimilarDoctors2() {
        SimilarDoctors similarDoctors = new SimilarDoctors();
        int zip = 94105;
        similarDoctors.sort_doctors(doctors, zip);
        for(int i=1; i<100; i++) {
            Doctors d1 = doctors.get(i-1);
            Doctors d2 = doctors.get(i);
            boolean condition1 = d1.review_score<d2.review_score;
            assertFalse(condition1);
        }
    }

}