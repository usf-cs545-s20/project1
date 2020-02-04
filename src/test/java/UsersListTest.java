import org.junit.Assert;
import org.junit.Test;
import recommender.UsersList;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/** Test file for UsersList.
 *  You may NOT modify this file. Modifying this file
 *  will result in a 0 for the tests.
 *  Note: the tests rely on your iterator working.
 *  This class provides the minimum tests. You are responsible for thoroughly
 *  testing project1 code on your own.
 *  */
public class UsersListTest {

    public static final int[] MOVIES1 = {1, 2, 3, 4, 5, 6, 7};
    public static final double[] RATINGS1 = {5, 5, 2, 5, 4, 3, 4};
    public static final int[] MOVIES2 = {2, 4, 7};
    public static final double[] RATINGS2 = {4, 1, 2};
    public static final int[] MOVIES3 = {1, 4, 5, 7};
    public static final double[] RATINGS3 = {3, 2, 5, 1};

    @Test
    public void testUsersList() {
        UsersList users = new UsersList();
        addData(users, 1, MOVIES1, RATINGS1);
        addData(users, 2, MOVIES2, RATINGS2);
        addData(users, 3, MOVIES3, RATINGS3);
        //Path test = Paths.get(".").toAbsolutePath();
        //System.out.println(test);

        Path actual = Paths.get("src" + File.separator + "test" + File.separator + "usersDataSimple");  // your output
        users.print(actual.toString());
        Path expected = Paths.get("src" + File.separator + "test" + File.separator + "expectedUsersDataSimple"); // instructor's

        // Compare your output with expected output
        int count = 0;
        try {
            count = TestUtils.checkFiles(expected, actual);
            if (count <= 0)
                Assert.fail("testUsersList Failed. Expected result is not equal to the actual result.");
        } catch (IOException e) {
            Assert.fail(" File check failed: " + e.getMessage());
        }
    }

    @Test
    public void testMostSimilarUser() {
        UsersList users = new UsersList();
        addData(users, 1, MOVIES1, RATINGS1);
        double[] ratings2 = {5, 4, 4};
        addData(users, 2, MOVIES2, ratings2);
        addData(users, 3, MOVIES3, RATINGS3);

        int mostSimilar1 = users.findMostSimilarUser(1).getId();
        Assert.assertEquals("Most similar user for user 1 should be 2, but got  " + mostSimilar1, mostSimilar1, 2);
    }

    /**
     * Insert a given data for a given user id into the usersList
     * @param users
     * @param userId
     * @param movies
     * @param ratings
     */
    public void addData(UsersList users, int userId, int[] movies, double[] ratings) {
        if (users == null)
            users = new UsersList();
        if (movies.length != ratings.length) {
            Assert.fail("Wrong parameters in addData. # of movies != # of ratings");
        }
        for (int i = 0; i < movies.length; i++) {
            users.insert(userId, movies[i], ratings[i]);
        }

    }
}
