(ns cljs-log.core
  (:require
   [environ.core :refer [env]]))

(defmacro deflogfn
  [fn-name level f]
  (let [prefix    (.toUpperCase (name fn-name))
        msg       (gensym)
        env-level (env :log-level 0)
        env-level (if (number? env-level)
                    env-level
                    (try (Integer/parseInt env-level)
                         (catch Exception e 0)))]
    (if (<= env-level level)
      `(defmacro ~fn-name
         [& ~msg]
         `(. js/console ~~f (js/Date.) (apply str (interpose " " (list ~~prefix ~@~msg)))))
      `(defmacro ~fn-name [& _#]))))

(deflogfn debug  1 'debug)
(deflogfn info   2 'info)
(deflogfn warn   3 'warn)
(deflogfn severe 4 'error)
