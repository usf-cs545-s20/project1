import org.junit.Assert;
import org.junit.Test;
import recommender.MovieRecommender;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/** Test file for MovieRecommender class.
 *  Note that this class provides the minimum tests.
 *  You are responsible for thoroughly testing project1 code on your own. */
public class MovieRecommenderTest {

    @Test
    public void testRecommend() {
        MovieRecommender recommender = new MovieRecommender();
        recommender.loadData("input" + File.separator + "movies.csv","input" + File.separator + "ratings.csv");
        System.out.println("Loaded data...");
        String filenameRecommendations = "src" + File.separator + "test" + File.separator + "recommendations";
        recommender.findRecommendations(3, 5, filenameRecommendations);

        Path actual = Paths.get(filenameRecommendations);  // your output
        Path expected = Paths.get("src" + File.separator + "test" + File.separator + "expectedRecommendations"); // instructor's

        // Compare your recommendations with expected recommendations
        int count = 0;
        try {
            count = TestUtils.checkFiles(expected, actual);
            //System.out.println(count);
            if (count <= 0)
                Assert.fail("Recommendations do not match expected recommendations.");
        } catch (IOException e) {
            Assert.fail(" File check failed: " + e.getMessage());
        }
    }

    @Test
    public void testAntiRecommend() {
        MovieRecommender recommender = new MovieRecommender();
        recommender.loadData("input" + File.separator + "movies.csv","input" + File.separator + "ratings.csv");
        System.out.println("Loaded data...");
        String filenameAntiRecommendations = "src" + File.separator + "test" + File.separator + "antiRecommendations";
        recommender.findAntiRecommendations(3, 5, filenameAntiRecommendations);

        Path actual = Paths.get(filenameAntiRecommendations);  // your output
        //Path expected = Paths.get("src/test/expectedOutput" + File.separator + "expectedAntiRecommendations"); // instructor's
        Path expected = Paths.get("src" + File.separator + "test" + File.separator + "expectedAntiRecommendations"); // instructor's

        // Compare your anti-recommendations with expected anti-recommendations
        int count = 0;
        try {
            count = TestUtils.checkFiles(expected, actual);
            if (count <= 0)
                Assert.fail("Anti-recommendations do not match expected anti-recommendations.");
        } catch (IOException e) {
            Assert.fail(" File check failed: " + e.getMessage());
        }
    }


}

