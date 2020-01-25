package recommender; /**
 * recommender.RatingsList.
 * A class that stores movie ratings for a user in a custom singly linked list of
 * recommender.RatingNode objects. Has various methods to manipulate the list. Stores
 * only the head of the list (no tail! no size!). The list should be sorted by
 * rating (from highest to smallest).
 * Fill in code in the methods of this class.
 * Do not modify signatures of methods. Not all methods are needed to compute recommendations,
 * but all methods are required for the assignment.
 */

import java.util.Iterator;

public class RatingsList implements Iterable<RatingNode> {

    private RatingNode head;
    // Note: you are *not* allowed to store the tail or the size of this list


    /**
     * Changes the rating for a given movie to newRating. The position of the
     * node within the list should be changed accordingly, so that the list
     * remains sorted by rating (from largest to smallest).
     *
     * @param movieId id of the movie
     * @param newRating new rating of this movie
     */
    public void setRating(int movieId, double newRating) {
        // FILL IN CODE

    }

    /**
     * Return the rating for a given movie. If the movie is not in the list,
     * returns -1.
     * @param movieId movie id
     * @return rating of a movie with this movie id
     */
    public double getRating(int movieId) {
        // FILL IN CODE
        return -1; // don't forget to change it

    }


    /**
     * Insert a new node (with a given movie id and a given rating) into the list.
     * Insert it in the right place based on the value of the rating. Assume
     * the list is sorted by the value of ratings, from highest to smallest. The
     * list should remain sorted after this insert operation.
     *
     * @param movieId id of the movie
     * @param rating rating of the movie
     */
    public void insertByRating(int movieId, double rating) {
        // FILL IN CODE. Make sure to test this method thoroughly


    }

    /**
     * Computes similarity between two lists of ratings using Pearson correlation.
     * https://en.wikipedia.org/wiki/Pearson_correlation_coefficient
     * Note: You are allowed to use a HashMap for this method.
     *
     * @param otherList another RatingList
     * @return similarity computed using Pearson correlation
     */
    public double computeSimilarity(RatingsList otherList) {
        double similarity = 0;
        // FILL IN CODE


        return similarity;

    }
    /**
     * Returns a sublist of this list where the rating values are in the range
     * from begRating to endRating, inclusive.
     *
     * @param begRating lower bound for ratings in the resulting list
     * @param endRating upper bound for ratings in the resulting list
     * @return sublist of the recommender.RatingsList that contains only nodes with
     * rating in the given interval
     */
    public RatingsList sublist(int begRating, int endRating) {
        RatingsList res = new RatingsList();

        // FILL IN CODE
        return res;
    }

    /** Traverses the list and prints the ratings list in the following format:
     *  movieId:rating; movieId:rating; movieId:rating;  */
    public void print() {
        // FILL IN CODE
    }

    /**
     * Returns the middle node in the list - the one half way into the list.
     * Needs to have the running time O(n), and should be done in one pass
     * using slow & fast pointers (as described in class).
     *
     * @return the middle recommender.RatingNode
     */
    public RatingNode getMiddleNode() {

        // FILL IN CODE
        return null; // don't forget to change it
    }

    /**
     * Returns the median rating (the number that is halfway into the sorted
     * list). To compute it, find the middle node and return it's rating. If the
     * middle node is null, return -1.
     *
     * @return rating stored in the node in the middle of the list
     */
    public double getMedianRating() {
        // FILL IN CODE

        return -1; // don't forget to change it
    }

    /**
     * Returns a recommender.RatingsList that contains n best rated movies. These are
     * essentially first n movies from the beginning of the list. If the list is
     * shorter than size n, it will return the whole list.
     *
     * @param n the maximum number of movies to return
     * @return recommender.RatingsList containing movies rated as 5
     */
    public RatingsList getNBestRankedMovies(int n) {
        // FILL IN CODE

        return null; // don't forget to change
    }

    /**
     * * Returns a recommender.RatingsList that contains n worst rated movies for this user.
     * Essentially, these are the last n movies from the end of the list.
     * Note: This method should compute the result in one pass. Do not use the size variable.
     * Note: To find the n-th node from the end of the list, use the technique we discussed in class:
     * use two pointers, where first, you move only one pointer so that pointers are n-nodes apart,
     * and then move both pointers together until the first pointer reaches null; when it happens,
     * the second pointer would be pointing at the correct node.
     * Do NOT use reverse(). Do NOT destroy the list.
     *
     * @param n the maximum number of movies to return
     * @return recommender.RatingsList containing n lowest ranked movies (ranked by this user)
     */
    public RatingsList getNWorstRankedMovies(int n) {

        // FILL IN CODE
        return null; // don't forget to change
    }

    /**
     * Return a new list that is the reverse of the original list. The returned
     * list is sorted from lowest ranked movies to the highest rated movies.
     * Use only one additional recommender.RatingsList (the one you return) and constant amount
     * of memory. You may NOT use arrays, ArrayList and other built-in Java Collections classes.
     * Read description carefully for requirements regarding implementation of this method.
     *
     * @param head head of the RatingList to reverse
     * @return reversed list
     */
    public RatingsList reverse(RatingNode head) {
        RatingsList r = new RatingsList();
        // FILL IN CODE

        return r;
    }

    /**
     * Returns an iterator for the list
     * @return iterator
     */
    public Iterator<RatingNode> iterator() {

        return new RatingsListIterator(0);
    }

    // ------------------------------------------------------
    /**
     * Inner class, RatingsListIterator
     * The iterator for the ratings list. Allows iterating over the recommender.RatingNode-s of
     * the list.
     */
    private class RatingsListIterator implements Iterator<RatingNode> {

        // FILL IN CODE: add instance variable(s)

        /**
         * Creates a new the iterator starting at a given index
         * @param index index
         */
        public RatingsListIterator(int index) {
            // FILL IN CODE

        }

        /**
         * Checks if there is a "next" element of the list
         * @return true, if there is "next" and false otherwise
         */
        public boolean hasNext() {
            // FILL IN CODE

            return true; // don't forget to change
        }

        /**
         * Returns the "next" node and advances the iterator
         * @return next node
         */
        public RatingNode next() {
            // FILL IN CODE
            return null; // don't forget to change
        }

        public void remove() {
            // No need to implement for this assignment
            throw new UnsupportedOperationException();
        }

    }

}