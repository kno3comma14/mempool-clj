(ns kno3comma14.mempool-clj.client.mining
  (:require [kno3comma14.mempool-clj.client.util :as util]))

(defn get-mining-pools
  ([] ;; weird this implementation is not working but documentation mentioned it
   (let [complete-url (str "/" "v1/mining" "/" "pools")]
     (util/execute-get-request complete-url)))
  ([time-period]
   (let [complete-url (str "/" "v1/mining" "/" "pools" "/" time-period)]
     (util/execute-get-request complete-url))))

(defn get-mining-pool
  [slug] ;; working and tested with foundryusa as slug. Documentation example is wrong
  (let [complete-url (str "/" "v1/mining" "/" "pool" "/" slug)]
    (util/execute-get-request complete-url)))

(defn get-mining-pool-hashrates
  [time-period]
  (let [complete-url (str "/" "v1/mining" "/" "hashrate" "/" time-period)]
    (util/execute-get-request complete-url)))

(defn get-mining-pool-hashrate
  [slug]
  (let [complete-url (str "/" "v1/mining" "/" "pool" "/" slug "/" "hashrate")]
    (util/execute-get-request complete-url)))

(defn get-mining-pool-blocks
  ([slug]
   (let [complete-url (str "/" "v1/mining" "/" "pool" "/" slug "/" "blocks")]
     (util/execute-get-request complete-url)))
  ([slug block-height]
   (let [complete-url (str "/" "v1/mining" "/" "pool" "/" slug "/" "blocks" "/" block-height)]
     (util/execute-get-request complete-url))))

(defn get-hashrate
  [time-period]
  (let [complete-url (str "/" "v1/mining" "/" "hashrate" "/" time-period)]
    (util/execute-get-request complete-url)))

(defn get-reward-stats
  [block-count]
  (let [complete-url (str "/" "v1/mining" "/" "reward-stats" "/" block-count)]
    (util/execute-get-request complete-url)))

(defn get-block-fees
  [time-period]
  (let [complete-url (str "/" "v1/mining" "/" "blocks" "/" "fees" "/" time-period)]
    (util/execute-get-request complete-url)))

(defn get-block-rewards
  [time-period]
  (let [complete-url (str "/" "v1/mining" "/" "blocks" "/" "rewards" "/" time-period)]
    (util/execute-get-request complete-url)))

(defn get-block-fee-rates
  [time-period]
  (let [complete-url (str "/" "v1/mining" "/" "blocks" "/" "fee-rates" "/" time-period)]
    (util/execute-get-request complete-url)))

(defn get-block-sizes-weights
  [time-period]
  (let [complete-url (str "/" "v1/mining" "/" "blocks" "/" "sizes-weights" "/" time-period)]
    (util/execute-get-request complete-url)))




(comment
  (get-mining-pools "1w")
  (get-mining-pool "foundryusa")
  (get-mining-pool-hashrates "1m")
  (get-mining-pool-hashrate "foundryusa")
  (get-mining-pool-blocks "foundryusa")
  (get-mining-pool-blocks "foundryusa" 730000)
  (get-hashrate "3d")
  (get-reward-stats 100)
  (get-block-fees "1w")
  (get-block-rewards "1d")
  (get-block-fee-rates "1m")
  (get-block-sizes-weights "3y"))
