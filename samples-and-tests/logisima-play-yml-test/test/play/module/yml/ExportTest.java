package play.module.yml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import models.Comment;
import models.Post;
import models.Tag;
import models.User;
import models.test.Comment2;
import models.test.Date2;
import models.test.Post2;
import models.test.Tag2;
import models.test.User2;

import org.junit.Before;
import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import play.Play;
import play.modules.yml.YmlExtractor;
import play.test.Fixtures;
import play.test.UnitTest;

public class ExportTest extends UnitTest {

    @Before
    public void tearsUp() {
        Date2.deleteAll();
        Comment2.deleteAll();
        Post2.deleteAll();
        User2.deleteAll();
        Tag2.deleteAll();
    }

    @Test
    public void generateYml() throws Exception {

        // generation of the YML file
        String filename = "data";
        String output = "conf/";
        YmlExtractor ymlExtract = new YmlExtractor();
        ymlExtract.mainWork(filename, output);

        // we load the generated file to yaml
        InputStream is = Play.classloader.getResourceAsStream("data.yml");
        Yaml yml = new Yaml();
        Map<String, Object> object = (Map<String, Object>) yml.load(is);

        changeYmlFile();
        Fixtures.loadModels("data2.yml");

        List<Post> posts = Post.find("order by id").fetch();
        List<models.Tag> tags = models.Tag.find("order by id").fetch();
        List<models.Comment> comments = models.Comment.find("order by id").fetch();
        models.Date date = models.Date.find("order by id").first();
        List<User> users = User.find("order by email").fetch();

        List<Post2> post2s = Post2.find("order by id").fetch();
        List<Tag2> tag2s = Tag2.find("order by id").fetch();
        List<Comment2> comment2s = Comment2.find("order by id").fetch();
        Date2 date2 = Date2.find("order by id").first();
        List<User2> user2s = User2.find("order by email").fetch();

        // tests for posts
        assertEquals(posts.size(), post2s.size());
        Collections.sort(posts);
        Collections.sort(post2s);
        for (int p = 0; p < posts.size(); p++) {
            Post post1 = posts.get(p);
            Post2 post2 = post2s.get(p);
            assertEquals(0, post1.compareTo(post2));
        }

        // tests for tags
        assertEquals(tags.size(), tag2s.size());
        Collections.sort(tags);
        Collections.sort(tag2s);
        for (int t = 0; t < tags.size(); t++) {
            Tag tag1 = tags.get(t);
            Tag2 tag2 = tag2s.get(t);
            assertEquals(0, tag1.compareTo(tag2));
        }

        // test for comment
        assertEquals(comments.size(), comment2s.size());
        Collections.sort(comments);
        Collections.sort(comment2s);
        for (int c = 0; c < comments.size(); c++) {
            Comment cmt1 = comments.get(c);
            Comment2 cmt2 = comment2s.get(c);
            assertEquals(0, cmt1.compareTo(cmt2));
        }

        // test for date
        assertEquals(0, date.compareTo(date2));

        // test for user
        assertEquals(users.size(), user2s.size());
        for (int u = 0; u < users.size(); u++) {
            User usr1 = users.get(u);
            User2 usr2 = user2s.get(u);
            assertEquals(0, usr1.compareTo(usr2));
        }

    }

    public static void changeYmlFile() throws IOException {
        File file = new File("conf/data.yml");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = "", oldtext = "";
        while ((line = reader.readLine()) != null) {
            oldtext += line + "\r\n";
        }
        reader.close();

        // To replace a line in a file
        String newtext = oldtext.replaceAll("Post\\(", "models.test.Post2(");
        newtext = newtext.replaceAll("Comment\\(", "models.test.Comment2(");
        newtext = newtext.replaceAll("Tag\\(", "models.test.Tag2(");
        newtext = newtext.replaceAll("Date\\(", "models.test.Date2(");
        newtext = newtext.replaceAll("User\\(", "models.test.User2(");
        // newtext = newtext.replaceAll("!!models.Address", "");

        FileWriter writer = new FileWriter("conf/data2.yml");
        writer.write(newtext);
        writer.close();
    }
}
