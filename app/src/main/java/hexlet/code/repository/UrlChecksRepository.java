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
        String sql = "INSERT INTO url_checks (statusCode, title, h1, description, url_Id) VALUES (?,?,?,?,?)";
        try (var conn = dataSource.getConnection();
             var preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            // Fix the data type setters here:
            preparedStatement.setInt(1, urlCheck.getStatusCode()); // Use setInt for statusCode (integer)
            preparedStatement.setString(2, urlCheck.getTitle());    // Use setString for title (string)
            preparedStatement.setString(3, urlCheck.getH1());       // Use setString for h1 (string)
            preparedStatement.setString(4, urlCheck.getDescription()); // Use setString for description (string)
            preparedStatement.setLong(5, urlCheck.getUrlId());      // Use setLong for urlId (bigint)

            preparedStatement.executeUpdate();

            var generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                urlCheck.setId(generatedKeys.getLong(1));
            } else {
                throw new SQLException("DB has not returned an id after saving the entity");
            }
        }
    }


    public static List<UrlCheck> getEntitiesByUrlId(Long urlIdToFind) throws SQLException {
        String sql = "SELECT * FROM url_checks WHERE url_Id = ?";  // Ensure the column name is correct
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
                var urlId = resultSet.getLong("url_Id");
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
                + "SELECT url_Id, MAX(created_at) as max_created_at "
                + "FROM url_checks "
                + "GROUP BY url_Id"
                + ") latest ON uc.url_Id = latest.url_Id "
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
                var urlId = resultSet.getLong("url_Id");
                var createdAt = resultSet.getTimestamp("created_at");

                var urlCheck = new UrlCheck(id, statusCode, title, h1, description, urlId, createdAt);
                result.add(urlCheck);
            }
            return result;
        }
    }

}
