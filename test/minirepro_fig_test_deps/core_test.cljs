(ns minirepro-fig-test-deps.core-test
    (:require
     [cljs.test :refer-macros [deftest is testing]]
     [minirepro-fig-test-deps.core :refer [multiply]]))

(deftest multiply-test-2
  (is (= (* 75 10) (multiply 10 75))))
