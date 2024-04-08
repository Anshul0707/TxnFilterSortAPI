package com.indusspay.service;

import com.indusspay.dao.DAOService;
import com.indusspay.dao.TxnDao;
import com.indusspay.model.Txn;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TxnService {
    private final DAOService daoService;
    private final TxnDao txnDao;

    public TxnService(DAOService daoService) {
        this.txnDao = daoService.getTxnDao();
        this.daoService = daoService;
    }

    public void addTxn(Txn txn) {
        try {
            if (txn.getAmount() < 0) {
                throw new IllegalArgumentException("Amount cannot be negative.");
            }
            txnDao.save(txn);
        } catch (Exception e) {
            // Handle exception appropriately, e.g., log it
            e.printStackTrace();
            throw e; // Rethrow the exception for controller to handle
        }
    }

    public List<Txn> getTxnsByAmountRange(float initialRange, float finalRange) {
        try {
            return txnDao.findByAmountBetween(initialRange, finalRange);
        } catch (Exception e) {
            // Handle exception appropriately, e.g., log it
            e.printStackTrace();
            throw e; // Rethrow the exception for controller to handle
        }
    }

    public List<Txn> getTxnsSortedByAmount() {
        try {
            return txnDao.findAllByOrderByAmountAsc();
        } catch (Exception e) {
            // Handle exception appropriately, e.g., log it
            e.printStackTrace();
            throw e; // Rethrow the exception for controller to handle
        }
    }
}
