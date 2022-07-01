package utils;

import java.io.File;

public class ManageJsonPayload {

    public static File getFile(String jsonFile) {

        return new File(
                "src/test/resources/" + jsonFile);
    }


}
