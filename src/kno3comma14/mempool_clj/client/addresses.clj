(ns kno3comma14.mempool-clj.client.addresses
  (:require [kno3comma14.mempool-clj.client.util :as util]))

(defn get-address-info
  [address]
  (let [complete-endpoint (str "/" "address" "/" address)]
    (util/execute-get-request complete-endpoint)))

(defn get-address-transactions
  [address]
  (let [complete-endpoint (str "/" "address" "/" address "/" "txs")]
    (util/execute-get-request complete-endpoint)))

(defn get-address-transactions-chain
  [address]
  (let [complete-endpoint (str "/" "address" "/" address "/" "txs" "/" "chain")]
    (util/execute-get-request complete-endpoint)))

(defn get-address-transactions-mempool
  [address]
  (let [complete-endpoint (str "/" "address" "/" address "/" "txs" "/" "mempool")]
    (util/execute-get-request complete-endpoint)))

(defn get-address-utxo
  [address]
  (let [complete-endpoint (str "/" "address" "/" address "/" "utxo")]
    (util/execute-get-request complete-endpoint)))
