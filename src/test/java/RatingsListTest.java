import org.junit.Assert;
import org.junit.Test;
import recommender.RatingNode;
import recommender.RatingsList;

import java.util.Iterator;

/** Test file for RatingsList.
 *  You may NOT modify this file. Modifying this file
 *  will result in a 0 for the tests.
 *  Note: the tests rely on your iterator working.
 *  This class provides the minimum tests. You are responsible for thoroughly
 *  testing project1 code on your own.
 *  */
public class RatingsListTest {
    public static final int[] MOVIES = {1, 2, 3, 4, 5, 6, 7};
    public static final double[] RATINGS = {5, 5, 2, 5, 4, 3, 4};

    @Test
    public void testInsertByRating() {

        RatingsList movieRatingsList = initalizeListWithValues(MOVIES, RATINGS);
        // Expected: (4,5.0), (2,5.0), (1,5.0), (7,4.0), (5,4.0), (6,3.0), (3,2.0)
        Assert.assertEquals(numNodes(movieRatingsList), 7);

        boolean listSortedCorrectly = isSortedDescending(movieRatingsList);
        if (!listSortedCorrectly)
            Assert.fail("testInsertByRating failed :" + "list should be sorted by rating!");
    }


    @Test
    public void testIterator() {
        int[] movies     = {1, 2, 3, 4};
        double[] ratings = {3, 5, 2, 4};
        RatingsList movieRatingsList = initalizeListWithValues(movies, ratings);
        // Expected: (2,5.0), (4,4.0), (1,3.0), (3,2.0)
        Iterator<RatingNode> it = movieRatingsList.iterator();
        Assert.assertEquals(it.hasNext(), true);
        RatingNode curr = it.next();
        Assert.assertEquals(curr.getMovieId(), 2);
        Assert.assertEquals(curr.getMovieRating(), 5.0, 0.1);

        Assert.assertEquals(it.hasNext(), true);
        curr = it.next();
        Assert.assertEquals(curr.getMovieId(), 4);
        Assert.assertEquals(curr.getMovieRating(), 4.0, 0.1);

        Assert.assertEquals(it.hasNext(), true);
        curr = it.next();
        Assert.assertEquals(curr.getMovieId(), 1);
        Assert.assertEquals(curr.getMovieRating(), 3.0, 0.1);

        Assert.assertEquals(it.hasNext(), true);
        curr = it.next();
        Assert.assertEquals(curr.getMovieId(), 3);
        Assert.assertEquals(curr.getMovieRating(), 2.0, 0.1);

        Assert.assertEquals(it.hasNext(), false);
    }

    @Test
    public void testSetRating() {
        // Check if after calling setRating, the list is updated correctly
        RatingsList movieRatingsList = initalizeListWithValues(MOVIES, RATINGS);

        movieRatingsList.setRating(1, 2.0);
        movieRatingsList.setRating(6, 5.0);
        movieRatingsList.setRating(2, 1.0);
        Assert.assertEquals("Number of nodes is incorrect after changing the rating. ", numNodes(movieRatingsList), 7);
        if (!isSortedDescending(movieRatingsList))
            Assert.fail("Nodes are not sorted by rating from largest to smallest. ");
    }

    @Test
    public void testComputeSimilarity() {
        RatingsList list1 = new RatingsList();
        list1.insertByRating(1, 5);
        list1.insertByRating(2, 5);
        list1.insertByRating(3, 2);
        list1.insertByRating(4, 5);
        list1.insertByRating(6, 3);
        list1.insertByRating(8, 4);


        RatingsList list2 = new RatingsList();
        list2.insertByRating(8, 1);
        list2.insertByRating(2, 4);
        list2.insertByRating(9, 5);
        list2.insertByRating(4, 3.5);
        list2.insertByRating(10, 4);
        list2.insertByRating(6, 2);

        double a = list1.computeSimilarity(list2);
        //System.out.println(a);
        if (Math.abs(a - 0.72696) > 0.0002)
            Assert.fail("In computeSimilarity: expected 0.72696, got: " + a);
    }

    @Test
    public void testMedianRating() {
        RatingsList list = initalizeListWithValues(MOVIES, RATINGS);
        double median = list.getMedianRating(); // median in a list sorted by rating
        if (Math.abs(median - 4.0) > 0.001)
            Assert.fail("In testMedianRating. Expected a 4, got:  " + median);
    }

    @Test
    public void testSublist() {
        int i = 2;
        int j = 4;
        RatingsList movieRatingsList = initalizeListWithValues(MOVIES, RATINGS);
        RatingsList newList = movieRatingsList.sublist(i, j);

        boolean listSortedCorrectly = isSortedDescending(newList);
        if (!listSortedCorrectly)
            Assert.fail("In testSublist:" + "sublist should be sorted by rating.");

        Iterator<RatingNode> it = newList.iterator();
        while (it.hasNext()) {
            RatingNode m = it.next();
            if (m.getMovieRating() < i || m.getMovieRating() > j)
                Assert.fail("In testSublist: ratings are not in the expected range.");
        } // while
    }

    @Test
    public void testReverse() {
        RatingsList list = initalizeListWithValues(MOVIES, RATINGS);

        Iterator<RatingNode> it = list.iterator();
        Assert.assertEquals(it.hasNext(), true);
        RatingNode head = it.next();

        RatingsList reversed = list.reverse(head);
        Assert.assertEquals("The number of nodes in a reversed list is not the same as in the original list", numNodes(reversed), 7);
        Iterator<RatingNode> itRev = reversed.iterator();
        // After insertions: 4, 2, 1, 7, 5, 6, 3
        // reversed: 3, 6, 5, 7, 1, 2, 4
        try {
            if (!(itRev.next().getMovieId() == 3)
                    || !(itRev.next().getMovieId() == 6)
                    || !(itRev.next().getMovieId() == 5)
                    || !(itRev.next().getMovieId() == 7)
                    || !(itRev.next().getMovieId() == 1)
                    || !(itRev.next().getMovieId() == 2)
                    || !(itRev.next().getMovieId() == 4))
                Assert.fail("The list is not reversed correctly ");
        }
        catch (Exception e) {
            Assert.fail("Incorrect number of nodes in the reversed list");
        }
    }

    @Test
    public void testNBestRankedMovies() {
        RatingsList list = initalizeListWithValues(MOVIES, RATINGS);
        // After insertions: 4, 2, 1, 7, 5, 6, 3
        // Expected best: 4, 2
        RatingsList res = list.getNBestRankedMovies(2); // 4, 2
        int num = numNodes(res);
        Assert.assertEquals("In testNBestRankedMovies. expected a list with 2 nodes, got: " + num, num, 2);

        Iterator<RatingNode> it = res.iterator();
        int i = it.next().getMovieId();
        int j = it.next().getMovieId();
        boolean b1 = (i == 4);
        boolean b2 = (j == 2);
        boolean b3 = (i == 2);
        boolean b4 = (j == 4);

        if ( (!b1 || !b2) && (!b3 || !b4)){
            res.print();
            Assert.fail("In testNBestRankedMovies: Expected movie nodes with movie ids" +
                    " 4 and 2. Instead, got the list above:");

        }
    }

    @Test
    public void testNWorstRankedMovies() {
        RatingsList list = initalizeListWithValues(MOVIES, RATINGS);
        // After insertions: 4, 2, 1, 7, 5, 6, 3
        // Worst: 6, 3

        RatingsList res = list.getNWorstRankedMovies(2);
        int num = numNodes(res);
        Assert.assertEquals("In testNWorstRankedMovies. expected a list with 2 nodes, got: " + num, num, 2);

        Iterator<RatingNode> it = res.iterator();
        boolean b1 = it.next().getMovieId() == 6;
        boolean b2 = it.next().getMovieId() == 3;

        if (!b1 || !b2) {
            res.print();
            Assert.fail("In testNWorstRankedMovies: Expected movie nodes with movie ids" +
                    " 6 and 3. Instead, got the list above:");

        }
    }

    /**
     * Build  a list with the given movie ids and ratings
     *
     * @param movieIds a list of movie ids
     * @param ratings a list of ratings
     * @return
     */
    public static RatingsList initalizeListWithValues(int[] movieIds, double[] ratings) {
        if  (movieIds.length != ratings.length) {
            Assert.fail("In initialieListWithValues method: The number of movies != number of ratings.");
        }
        RatingsList movieRatingsList = new RatingsList();
        for (int i = 0; i < movieIds.length; i++) {
            movieRatingsList.insertByRating(movieIds[i], ratings[i]);
        }
        return movieRatingsList;
    }

    /**
     * Iterate over ratings and return true if the list is sorted by rating from
     * largest to smallest.
     *
     * @param ratings
     * @return true or false (depending on whether list is sorted by rating)
     */
    public static boolean isSortedDescending(RatingsList ratings) {

        Iterator<RatingNode> it = ratings.iterator();
        double prevMovieRating = 6;
        while (it.hasNext()) {
            RatingNode curr = it.next();
            if (!(curr.getMovieRating() <= prevMovieRating)) {
                return false;
            }
            prevMovieRating = curr.getMovieRating();
        }
        return true;
    }

    /** Return the number of nodes in the RatingsList
     *
     * @param ratings
     * @return number of nodes in the list
     */
    public static int numNodes(RatingsList ratings) {
        int count = 0;
        Iterator<RatingNode> it = ratings.iterator();
        while (it.hasNext()) {
            it.next();
            count++;
        }
        return count;
    }
}
