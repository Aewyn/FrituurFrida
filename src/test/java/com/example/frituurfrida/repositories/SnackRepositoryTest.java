package com.example.frituurfrida.repositories;

import com.example.frituurfrida.domain.Snack;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@JdbcTest
@Import(SnackRepository.class)
@Sql("/insertSnacks.sql")
class SnackRepositoryTest  extends AbstractTransactionalJUnit4SpringContextTests {
    private final String SNACKS = "snacks";
    private final SnackRepository repository;

    public SnackRepositoryTest(SnackRepository repository) {
        this.repository = repository;
    }

    private long idVanSnack1(){
        return jdbcTemplate.queryForObject("select id from snacks where naam = 'snack1'", Long.class);
    }
    private long idVanSnack2(){
        return jdbcTemplate.queryForObject("select id from snacks where naam = 'snack2'", Long.class);
    }

    @Test
    void readSnack1() {
        assertThat(repository.read(idVanSnack1()));
    }

    @Test
    void readSnack2(){
        assertThat(repository.read(idVanSnack2()));
    }

    @Test
    void update() {
        var id = idVanSnack1();
        var snack = new Snack(id, "bouletje", BigDecimal.valueOf(2.5));
        repository.update(snack);
        assertThat(countRowsInTableWhere(SNACKS, "prijs=2.5 and id="+ id)).isOne();
    }

    @Test
    void findByBeginNaam() {
        assertThat(repository.findByBeginNaam("snack")).isNotEmpty();
    }
}