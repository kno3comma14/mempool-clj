(ns kno3comma14.mempool-clj.client.general
  (:require [kno3comma14.mempool-clj.client.util :as util]))

(defn get-difficulty-adjustment []
  (util/execute-get-request "/v1/difficulty-adjustment"))
