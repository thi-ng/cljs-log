(ns cljs-log.core
  (:require-macros [cljs-log.core :refer [deflogfn]]))

(deflogfn debug  1)

(deflogfn info   2)

(deflogfn warn   3)

(deflogfn severe 4)
