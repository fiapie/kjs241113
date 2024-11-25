package skyds.example.first.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import skyds.example.first.domain.Member;
import skyds.example.first.domain.Row;
import skyds.example.first.domain.Sql;

import javax.sql.DataSource;
import java.util.List;

public class JdbcTemplateSqlRepository implements SqlRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateSqlRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Sql cud(Sql sql) {
        jdbcTemplate.execute(sql.getSql());
        return sql;
    }


    @Override
    public List<Row> findRows(String column, String table) {
        String sql = "select " + column + " from " + table;
        return jdbcTemplate.query(sql, memberRowMapper(column));
    }

    private RowMapper<Row> memberRowMapper(String column){
        return (rs, rowNum) -> {
            Row row = new Row();
            row.setValue(rs.getString(1));
            return row;
        };
    }

}
