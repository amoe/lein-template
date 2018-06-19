(ns leiningen.new.solasistim
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files project-name multi-segment sanitize-ns]]
            [leiningen.core.main :as main]))

;; Using a nil renderer will just slurp the file.
;; This is questionable API design perhaps, so we conceal it here.

(def template-name "solasistim")

(def expand-mustache (renderer template-name))
(def slurp-file (fn [path]
                  (apply (renderer template-name)
                         [path nil])))

;; Entry point -- Must be named the same as the template.
(defn solasistim [name]
  (let [main-ns (multi-segment (sanitize-ns name))
        data {:raw-name name
              :name (project-name name)
              :nested-dirs (name-to-path main-ns)
              :namespace main-ns
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' lein-template project.")
    (->files data
             ["src/{{nested-dirs}}.clj" (expand-mustache "core.clj" data)]
             ["test/{{nested-dirs}}_test.clj" (expand-mustache "test.clj" data)]
             [".gitignore" (slurp-file "gitignore")]
             ["project.clj" (expand-mustache "project.clj" data)]
             ["resources/logback.xml" (expand-mustache "logback.xml" data)]
             ["literal_file.dat" (slurp-file "literal_file.dat")])))
