package com.example.frituurfrida.repositories;

import com.example.frituurfrida.domain.AantalVerkochteSnacks;
import com.example.frituurfrida.domain.Snack;
import com.example.frituurfrida.exception.SnackRepositoryException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SnackRepository {
    private final JdbcTemplate template;

    public SnackRepository(JdbcTemplate template) {
        this.template = template;
    }

    private final RowMapper<Snack> snackMapper = (rs, rowNum) -> new Snack(rs.getLong("id"), rs.getString("naam"), rs.getBigDecimal("prijs"));

    public List<Snack> findAll() {
        var sql = """
                select id, naam, prijs
                from snacks
                order by id
                """;
        return template.query(sql, snackMapper);
    }

    public Optional<Snack> read(long id) {
        try {
            var sql = """
                    select id, naam, prijs
                    from snacks
                    where id = ?
                    """;
            return Optional.of(template.queryForObject(sql, snackMapper, id));
        } catch (IncorrectResultSizeDataAccessException ex) {
            return Optional.empty();
        }
    }

    public void update(Snack snack) {
        var sql = """
                update snacks
                set naam = ?, prijs = ?
                where id = ?
                """;
        if (template.update(sql, snack.getNaam(), snack.getPrijs(), snack.getNummer()) == 0) {
            throw new SnackRepositoryException("Snack is niet gevonden");
        }
    }

    public List<Snack> findByBeginNaam(String beginNaam) {
        var sql = """
                select id, naam, prijs
                from snacks 0
                where naam like ?
                order by naam
                """;
        return template.query(sql, snackMapper, beginNaam + '%');
    }

    public List<AantalVerkochteSnacks> findAantalVerkochteSnacks(){
        var sql = """
                select id, naam, ifnull(sum(dagverkopen.aantal),0) as 'aantal'
                from snacks
                left join dagverkopen on snacks.id = dagverkopen.snackId
                group by id
                order by id
                """;
        RowMapper<AantalVerkochteSnacks> mapper = (rs, rowNum) ->
                new AantalVerkochteSnacks(rs.getLong("id"), rs.getString("naam"),rs.getInt("aantal"));
        return template.query(sql, mapper);
    }
}
