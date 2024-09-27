package hexlet.code.repository;

import hexlet.code.model.UrlCheck;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UrlChecksRepository extends BaseRepository {

    private Integer statusCode;
    private String title;
    private String h1;
    private String description;
    private Long urlId;

    public static void save(UrlCheck urlCheck) throws SQLException {
        String sql = "INSERT INTO url_checks (statusCode, title, h1, description, urlId) VALUES (?,?,?,?,?)";
        try (var conn = dataSource.getConnection();
             var preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, String.valueOf(urlCheck.getStatusCode()));
            preparedStatement.setString(2, String.valueOf(urlCheck.getTitle()));
            preparedStatement.setString(3, String.valueOf(urlCheck.getH1()));
            preparedStatement.setString(4, String.valueOf(urlCheck.getDescription()));
            preparedStatement.setString(5, String.valueOf(urlCheck.getUrlId()));
            preparedStatement.executeUpdate();
            var generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                urlCheck.setId(generatedKeys.getLong(1));
            } else {
                throw new SQLException("DB have not returned an id after saving an entity");
            }
        }
    }

    public static List<UrlCheck> getEntitiesByUrlId(Long urlIdToFind) throws SQLException {
        String sql = "SELECT * FROM url_checks WHERE urlId = ?";  // Ensure the column name is correct
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {

            // Use setLong to pass a bigint (Long) value to the query
            stmt.setLong(1, urlIdToFind);

            var resultSet = stmt.executeQuery();
            var result = new ArrayList<UrlCheck>();
            while (resultSet.next()) {
                var id = resultSet.getLong("id");
                var statusCode = resultSet.getInt("statusCode");
                var title = resultSet.getString("title");
                var h1 = resultSet.getString("h1");
                var description = resultSet.getString("description");
                var urlId = resultSet.getLong("urlId");
                var createdAt = resultSet.getTimestamp("created_at");

                var urlCheck = new UrlCheck(id, statusCode, title, h1, description, urlId, createdAt);
                result.add(urlCheck);
            }
            return result;
        }
    }


    public static List<UrlCheck> getLatestUrlChecksBySQL() throws SQLException {
        String sql = "SELECT uc.* "
                + "FROM url_checks uc "
                + "INNER JOIN ("
                + "SELECT urlId, MAX(created_at) as max_created_at "
                + "FROM url_checks "
                + "GROUP BY urlId"
                + ") latest ON uc.urlId = latest.urlId "
                + "AND uc.created_at = latest.max_created_at";

        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            var resultSet = stmt.executeQuery();
            var result = new ArrayList<UrlCheck>();
            while (resultSet.next()) {
                var id = resultSet.getLong("id");
                var statusCode = resultSet.getInt("statusCode");
                var title = resultSet.getString("title");
                var h1 = resultSet.getString("h1");
                var description = resultSet.getString("description");
                var urlId = resultSet.getLong("urlId");
                var createdAt = resultSet.getTimestamp("created_at");

                var urlCheck = new UrlCheck(id, statusCode, title, h1, description, urlId, createdAt);
                result.add(urlCheck);
            }
            return result;
        }
    }

}
