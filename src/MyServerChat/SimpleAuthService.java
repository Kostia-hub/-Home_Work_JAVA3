package MyServerChat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SimpleAuthService implements AuthService {
    private static Connection conn = null;
    private static Statement stmt = null;
    PreparedStatement ps = null;

    static void connection() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:clients.db");
            stmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private class UserData {
        private String login;
        private String password;
        private String nickname;

        public UserData(String login, String password, String nickname) {
            this.login = login;
            this.password = password;
            this.nickname = nickname;
        }
    }

    private List<UserData> users;

    public SimpleAuthService() throws SQLException {
        this.users = new ArrayList<>();
        connection();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM ClientsID");
        while(resultSet.next()){
            String login = resultSet.getString(1);
            String password = resultSet.getString(2);
            String nickname = resultSet.getString(3);
            users.add(new UserData(login, password, nickname));
        }
//        for (int i = 1; i < 4; i++) {
//            users.add(new UserData("login" + i, "pass" + i, "nick" + i));
//        }
    }

    @Override
    public String getNicknameByLoginAndPassword(String login, String password) {
        for (UserData o : users) {
            if (o.login.equals(login) && o.password.equals(password)) {
                return o.nickname;
            }
        }
        return null;
    }
}
