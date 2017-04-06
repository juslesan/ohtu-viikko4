package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan
        String studentNr = "014613700";
        if (args.length > 0) {
            studentNr = args[0];
        }

        String url = "http://ohtustats2017.herokuapp.com/students/" + studentNr + "/submissions";
        String bodyText = Request.Get(url).execute().returnContent().asString();
        String kurssiurl = "https://ohtustats2017.herokuapp.com/courses/1.json";
        String bodyText2 = Request.Get(kurssiurl).execute().returnContent().asString();

        Gson mapper = new Gson();
        Course course = mapper.fromJson(bodyText2, Course.class);
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        System.out.println(course);
        System.out.println("opiskelijanumero: " + subs[0].getStudent_number());
        Integer hours = 0;
        Integer exercises = 0;
        for (Submission submission : subs) {
            submission.setCourse(course);
            System.out.println(submission);
            exercises += submission.amountOfExercises();
            hours += submission.getHours();
        }
        System.out.println("yhteensä: " + exercises + " tehtävää " + hours + " tuntia");

    }
}
