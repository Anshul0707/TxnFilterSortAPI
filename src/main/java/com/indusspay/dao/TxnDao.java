package com.indusspay.dao;

import com.indusspay.model.Txn;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TxnDao {
    public void save(Txn txn);
    List<Txn> findByAmountBetween(float initialRange, float finalRange);

    List<Txn> findAllByOrderByAmountAsc();
}
