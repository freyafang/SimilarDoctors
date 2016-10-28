import java.util.List;

/**
 * Created by freya on 10/27/2016.
 */
//
//Assumption:
//1. Doctors in the list have the same speciality (Assume the list has already been filtered based on speciality)
//2. Doctors are going to be sorted by two factors: review score and locations. Doctors will first be sorted
//   by their score, and then the location.
//3. Because of the time limitation, I sort the location based on the zip code only.
//
public interface SimilarDoctors_interface {
    void sort_doctors(List<Doctors> doctors, int zip_code);
}
