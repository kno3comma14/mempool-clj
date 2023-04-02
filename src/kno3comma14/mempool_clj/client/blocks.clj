(ns kno3comma14.mempool-clj.client.blocks
  (:require [kno3comma14.mempool-clj.client.util :as util]))

(defn get-block-info
  [hash]
  (let [complete-url (str "/" "block" "/" hash)]
    (util/execute-get-request complete-url)))

(defn get-block-header
  [hash]
  (let [complete-url (str "/" "block" "/" hash "/" "header")]
    (util/execute-get-request complete-url :string)))

(defn get-block-height
  [height]
  (let [complete-url (str "/" "block-height" "/" height)]
    (util/execute-get-request complete-url :string)))

(defn get-block-status
  [hash]
  (let [complete-url (str "/" "block" "/" hash "/" "status")]
    (util/execute-get-request complete-url)))

(defn get-block-tip-height
  []
  (let [complete-url (str "/" "blocks" "/" "tip" "/" "height")]
    (util/execute-get-request complete-url :integer)))

(defn get-block-tip-hash
  []
  (let [complete-url (str "/" "blocks" "/" "tip" "/" "hash")]
    (util/execute-get-request complete-url :string)))

(defn get-block-transaction-id
  [hash index]
  (let [complete-url (str "/" "block" "/" hash "/" "txid" "/" index)]
    (util/execute-get-request complete-url :string)))

(defn get-block-transaction-ids
  [hash]
  (let [complete-url (str "/" "block" "/" hash "/" "txids")]
    (util/execute-get-request complete-url)))

(defn get-block-transactions
  ([hash]
   (let [complete-url (str "/" "block" "/" hash "/" "txs")]
     (util/execute-get-request complete-url)))
  ([hash start-index]
   (let [complete-url (str "/" "block" "/" hash "/" "txs" "/" start-index)]
     (util/execute-get-request complete-url))))

(defn get-blocks
  ([]
   (let [complete-url (str "/" "v1/blocks")]
     (util/execute-get-request complete-url)))
  ([start-height]
   (let [complete-url (str "/" "v1/blocks" "/" start-height)]
     (util/execute-get-request complete-url))))

(defn get-blocks-by-bulk ;; Failing because need to set config.MEMPOOL.MAX_BLOCKS_BULK_QUERY to a positive number
  [min-height max-height]
  (let [complete-url (str "/" "v1/blocks-bulk" "/" min-height "/" max-height)]
    (util/execute-get-request complete-url)))


