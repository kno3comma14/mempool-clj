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

(defn- to-string-body
  [response]
  (let [body (:body response)]
    body))

(defn- to-int-body
  [response]
  (let [body (:body response)]
    (Integer/parseInt body)))

(defn execute-get-request
  ([endpoint]
   (let [complete-url (str root-domain api-prefix endpoint)
         response (http/get complete-url)]
     (to-clojure-map response)))
  ([endpoint encoding-type]
   (let [complete-url (str root-domain api-prefix endpoint)
         response (http/get complete-url)]
     (case encoding-type
       :string (to-string-body response)
       :integer (to-int-body response)))))
