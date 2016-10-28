import java.util.*;

/**
 * Created by freya on 10/27/2016.
 */
public class SimilarDoctors implements SimilarDoctors_interface{
    /*
    Assumption:
    1. Doctors in the list have the same speciality (Assume the list has already been filtered based on speciality)
    2. Doctors are going to be sorted by two factors: review score and locations. Doctors will first be sorted
       by their score, and then the location.
    3. Because of the time limitation, I sort the location based on the zip code only.
     */
    public void sort_doctors(List<Doctors> doctors, int zip_code) {
        if(doctors.size()==0 || doctors==null) return;
        Collections.sort(doctors, new Comparator<Doctors>(){
            @Override
            public int compare(Doctors d1, Doctors d2) {
                //First sort by score
                int score1 = d1.review_score;
                int score2 = d2.review_score;
                int comp = Integer.compare(score2, score1);
                if(comp!=0) {
                    return comp;
                } else {
                    // Doctors locates at a closer place should be displayed first.
                    // Distance determined by zip code.
                    int zip1 = d1.address.zip;
                    int zip2 = d2.address.zip;
                    return Integer.compare( Math.abs(zip_code-zip1), Math.abs(zip_code-zip2));
                }
            }
        });
    }
}

