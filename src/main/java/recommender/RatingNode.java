package recommender;

/** Class recommender.RatingNode represents a node in the recommender.RatingsList.
 *  Do not modify this class.
 *  @author okarpenko */
public class RatingNode {

    private int movieId; // id of the movie
    private double movieRating; // movie rating, ranges from 1 to 5
    private RatingNode next;  // reference to the "next" MovieRatingNode

    /** A constructor for MovieRatingNode.
     * @param movieId id of the movie
     * @param rating  rating of the movie
     */
    public RatingNode(int movieId, double rating) {
        this.movieId = movieId;
        next = null;

        if (rating < 0.5 || rating > 5) {
            System.out.println("Invalid rating: " + rating + "; Using a default value of 3.");
            movieRating = 3;
        }
        else
            movieRating = rating;
    }

    /**
     * Advance to the next node in the list.
     * @return next node
     */
    public RatingNode next() {
        return next;
    }

    /** Point next to the given node
     **
     * @param anotherNode given MovieRatingNode
     */
    public void setNext(RatingNode anotherNode) {
        this.next = anotherNode;
    }

    /** Return the id of the movie stored in this node
     * @return movieId
     */
    public int getMovieId() {
        return movieId;
    }

    /**
     * A getter for the movie rating
     * @return movie rating
     */
    public double getMovieRating() {
        return movieRating;
    }

    /**
     * A setter for the movie rating.
     *  Change the rating to newRating.
     * @param newRating new rating value for this movie
     */
    public void setMovieRating(double newRating) {
        movieRating = newRating;
    }

    /** Return a string with the movie id and rating
     * @return string that contains movie info
     */
    public String toString() {
        return movieId + ", " + movieRating;
    }
}