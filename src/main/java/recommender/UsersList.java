package recommender;

/**
 * A custom linked list that stores user info. Each node in the list is of type
 * recommender.UserNode.
 * FILL IN CODE. Also, add other methods as needed.
 *
 * @author okarpenko
 *
 */
public class UsersList {
    private UserNode head = null;
    private UserNode tail = null; // ok to store tail here, will be handy for appending


    /** Insert the rating for the given userId and given movieId.
     *
     * @param userId  id of the user
     * @param movieId id of the movie
     * @param rating  rating given by this user to this movie
     */
    public void insert(int userId, int movieId, double rating) {

        // Check if recommender.UserNode already exists;
        // if not, create it and append to this list.
        // Then call insert(movieId, rating) method on the recommender.UserNode
        // FILL IN CODE

    }

    /**
     * Append a new node to the list
     * @param newNode a new node to append to the list
     */
    public void append(UserNode newNode) {
        // This is where tail will come in handy
        // FILL IN CODE
    }

    /** Return a recommender.UserNode given userId
     *
     * @param userId id of the user (as defined in ratings.csv)
     * @return recommender.UserNode for a given userId
     */
    public UserNode get(int userId) {
        // FILL IN CODE

        return null; // don't forget to change it
    } // get method


    /**
     * The method computes the similarity between the user with the given userid
     * and all the other users. Finds the maximum similarity and returns the
     * "most similar user".
     * Calls computeSimilarity method in class MovieRatingsList/
     *
     * @param userid id of the user
     * @return the node that corresponds to the most similar user
     */
    public UserNode findMostSimilarUser(int userid) {
        UserNode mostSimilarUser = null;
        // FILL IN CODE


        return mostSimilarUser;

    }

    /** Print recommender.UsersList to a file  with the given name in the following format:
     (userid) movieId:rating; movieId:rating; movieId:rating;
     (userid) movieId:rating; movieId:rating;
     (userid) movieId:rating; movieId:rating; movieId:rating; movieId:rating;
     Info for each userid should be printed on a separate line
     * @param filename name of the file where to output recommender.UsersList info
     */
    public void print(String filename) {
        // FILL IN CODE

    }
}