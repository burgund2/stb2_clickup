package pl.akademiaqa.properties;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ResourceBundle;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClickUpProperties {

    private static final String TOKEN = "clickup.token";
    private static final String TEAM_ID = "clickup.team.id";

    public static String getToken() {

        if (getProperty(TOKEN).isEmpty() || getProperty(TOKEN).startsWith("YOUR")) {
            return System.getProperty("TOKEN");
        }
        return getProperty(TOKEN);
    }

    public static String getTeamId() {

        if (getProperty(TEAM_ID).isEmpty() || getProperty(TEAM_ID).startsWith("YOUR")) {
            return System.getProperty("TEAM_ID");
        }
        return getProperty(TEAM_ID);
    }

    private static String getProperty(String key) {
        return ResourceBundle.getBundle("clickup").getString(key);
    }
}
