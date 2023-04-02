(ns kno3comma14.mempool-clj.client.mempool
  (:require [kno3comma14.mempool-clj.client.util :as util]))

(defn get-mempool
  []
  (let [complete-url (str "/" "mempool")]
    (util/execute-get-request complete-url)))

(defn get-mempool-transaction-ids
  [] ;; Long time operation
  (let [complete-url (str "/" "mempool" "/" "txids")]
    (util/execute-get-request complete-url)))

(defn get-mempool-recent
  [] ;; Long time operation
  (let [complete-url (str "/" "mempool" "/" "recent")]
    (util/execute-get-request complete-url)))


(comment
  (get-mempool)
  (get-mempool-transaction-ids)
  (get-mempool-recent))
