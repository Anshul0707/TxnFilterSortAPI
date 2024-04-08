package com.indusspay.controller;

import com.indusspay.model.Txn;
import com.indusspay.service.TxnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/txn")
public class TxnController {

    @Autowired
    private TxnService txnService;

    @PostMapping("/add")
    public ResponseEntity<Void> addTxn(@RequestBody Txn txn) {
        try {
            txnService.addTxn(txn);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/amount/{initialRange}/{finalRange}")
    public ResponseEntity<List<Txn>> getTxnsByAmountRange(@PathVariable float initialRange, @PathVariable float finalRange) {
        try {
            List<Txn> txns = txnService.getTxnsByAmountRange(initialRange, finalRange);
            if (txns.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            return ResponseEntity.ok(txns);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/sort/amount")
    public ResponseEntity<List<Txn>> getTxnsSortedByAmount() {
        try {
            List<Txn> txns = txnService.getTxnsSortedByAmount();
            return ResponseEntity.ok(txns);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
