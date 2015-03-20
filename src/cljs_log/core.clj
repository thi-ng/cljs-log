(ns cljs-log.core
  (:require
   [environ.core :refer [env]]))

(defmacro deflogfn
  [fn-name level]
  (let [prefix    (.toUpperCase (name fn-name))
        msg       (gensym)
        env-level (env :log-level 0)
        env-level (if (number? env-level)
                    env-level
                    (try (Integer/parseInt env-level)
                         (catch Exception e 0)))]
    `(defn ~fn-name
       [& ~msg]
       ~(when (<= env-level level)
          `(.log js/console (js/Date.) (apply str (interpose " " (cons ~prefix ~msg))))))))
