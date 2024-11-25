package skyds.example.first.repository;

import skyds.example.first.domain.Row;
import skyds.example.first.domain.Sql;

import java.util.List;

public interface SqlRepository {
    Sql cud(Sql sql);
    List<Row> findRows(String column, String table);
}
