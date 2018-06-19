1(ns leiningen.new.lein-template
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

;; Using a nil renderer will just slurp the file.
;; This is questionable API design perhaps, so we conceal it here.

(def expand-mustache (renderer "lein-template"))
(def slurp-file (fn [path]
                  (apply (renderer "lein-template")
                         [path nil])))


(defn lein-template [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' lein-template project.")
    (->files data
             ["src/{{sanitized}}/foo.clj" (expand-mustache "foo.clj" data)]
             ["literal_file.dat" (slurp-file "literal_file.dat")])))
