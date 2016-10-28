/**
 * Created by freya on 10/27/2016.
 */
public class Doctors {
    public String name;
    public int review_score;
    public Address address;
    public int total_reviews;

    public Doctors(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Doctors(String name, Address address, int review_score) {
        this.name = name;
        this.address = address;
        this.review_score = review_score;
    }

    public void setReview_score (int review_score) {
        this.review_score = (this.review_score*total_reviews+review_score)/(this.total_reviews++);
    }
}
