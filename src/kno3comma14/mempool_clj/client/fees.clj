(ns kno3comma14.mempool-clj.client.fees
  (:require [kno3comma14.mempool-clj.client.util :as util]))

(defn get-mempool-blocks-fees
  []
  (let [complete-url (str "/" "v1/fees" "/" "mempool-blocks")]
    (util/execute-get-request complete-url)))

(defn get-recommended-fees
  []
  (let [complete-url (str "/" "v1/fees" "/" "recommended")]
    (util/execute-get-request complete-url)))



(comment
  (get-mempool-blocks-fees)
  (get-recommended-fees))
