(ns kno3comma14.mempool-clj.client.util
  (:require [java-http-clj.core :as http]
            [clojure.data.json :as json]
            [camel-snake-kebab.core :as csk]))

(def root-domain "https://mempool.space")
(def api-prefix "/api")


(defn- to-clojure-map
  [response]
  (let [body (:body response)]
    (json/read-str body :key-fn #(csk/->kebab-case-keyword %))))

(defn execute-get-request
  [endpoint]
  (let [complete-url (str root-domain api-prefix endpoint)
        response (http/get complete-url)]
    (to-clojure-map response)))
