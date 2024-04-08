package com.indusspay.dao;

import com.indusspay.dto.DatabaseConfiguration;
import com.indusspay.model.Txn;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class TxnDaoImpl implements TxnDao {

    private final DatabaseConfiguration databaseConfiguration;

    public TxnDaoImpl(DatabaseConfiguration databaseConfiguration) {
        this.databaseConfiguration = databaseConfiguration;
    }

    public void save(Txn txn) {
        String sql = "INSERT INTO txn (txnId, customerName, service, amount, gst, commission)VALUES (?, ?, ?, ?, ?, ?)";
        JdbcTemplate jdbcTemplate = databaseConfiguration.getJdbcTemplate();
        try {
            jdbcTemplate.update(sql, txn.getTxnId(), txn.getCustomerName(), txn.getService(), txn.getAmount(), txn.getGst(), txn.getCommission());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Txn> findByAmountBetween(float initialRange, float finalRange) {
        String sql = "SELECT * FROM txn WHERE amount BETWEEN ? AND ?";
        JdbcTemplate jdbcTemplate = databaseConfiguration.getJdbcTemplate();
        try {
            return jdbcTemplate.query(sql, new Object[]{initialRange, finalRange}, new BeanPropertyRowMapper<>(Txn.class));
        } catch (Exception e) {
            // Handle exception appropriately, e.g., log it
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public List<Txn> findAllByOrderByAmountAsc() {
        String sql = "SELECT * FROM txn ORDER BY amount ASC";
        JdbcTemplate jdbcTemplate = databaseConfiguration.getJdbcTemplate();
        try {
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Txn.class));
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
