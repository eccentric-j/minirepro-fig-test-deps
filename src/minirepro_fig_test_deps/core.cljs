(ns ^:figwheel-hooks minirepro-fig-test-deps.core
  (:require
    [fs :as fs]
    [clojure.pprint :refer [pprint]]))

(defn multiply
  [x y]
  (* x y))

(defn -main
  []
  (println "Running main fn")
  (pprint (fs/readdirSync ".")))


(set! *main-cli-fn* -main)
(println "Loaded main script")
