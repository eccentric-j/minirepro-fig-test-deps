;; This test runner is intended to be run from the command line
(ns minirepro-fig-test-deps.test-runner
  (:require
    ;; require all the namespaces that you want to test
    [minirepro-fig-test-deps.core-test]
    [figwheel.main.testing :refer [run-tests-async]]))

(defn -main [& args]
  (run-tests-async 5000))

(set! *main-cli-fn* -main)
