(ns kno3comma14.mempool-clj.client.transactions
  (:require [kno3comma14.mempool-clj.client.util :as util]))

(defn get-children-pay-for-parent
  [txid]
  (let [complete-url (str "/" "v1/cpfp" "/" txid)]
    (util/execute-get-request complete-url)))

(defn get-transaction-info
  [txid]
  (let [complete-url (str "/" "tx" "/" txid)]
    (util/execute-get-request complete-url)))

(defn get-transaction-hex
  [txid]
  (let [complete-url (str "/" "tx" "/" txid "/" "hex")]
    (util/execute-get-request complete-url :string)))

(defn get-transaction-merkleblock-proof
  [txid]
  (let [complete-url (str "/" "tx" "/" txid "/" "merkleblock-proof")]
    (util/execute-get-request complete-url :string)))

(defn get-transaction-merkle-proof
  [txid]
  (let [complete-url (str "/" "tx" "/" txid "/" "merkle-proof")]
    (util/execute-get-request complete-url)))

(defn get-transaction-outspend ;; PENDING play with other parameters
  [txid vout]
  (let [complete-url (str "/" "tx" "/" txid "/" "outspend" "/" vout)]
    (util/execute-get-request complete-url)))

(defn get-transaction-outspends
  [txid]
  (let [complete-url (str "/" "tx" "/" txid "/" "outspends")]
    (util/execute-get-request complete-url)))

(defn get-transaction-status
  [txid]
  (let [complete-url (str "/" "tx" "/" txid "/" "status")]
    (util/execute-get-request complete-url)))

(defn create-transaction
  [hash] ;; This is returning me a 400 error. Still figure out how to test it in a good way
  (let [complete-url (str "/" "tx")]
    (util/execute-post-request complete-url hash)))






