(ns cljs-log.core-test
  (:require-macros
   [cljs-log.core :refer [debug info warn severe]]))

(defn ^:export -main
  []
  (let [a {:a 23}]
    (debug :foo a)
    (info :foo a)
    (warn :foo a)
    (severe :foo a)))
