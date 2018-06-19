(defproject {{raw-name}} "0.1.0"
  :description "A template for Leiningen"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/tools.logging "0.4.1"]
                 [ch.qos.logback/logback-classic "1.2.3"]
                 [cheshire "5.8.0"]
                 [fipp "0.6.12"]
                 [potemkin "0.4.5"]
                 [medley "1.0.0"]
                 [com.taoensso/truss "1.5.0"] 
                 [slingshot "0.12.2"]
                 [clj-time "0.14.4"]
                 [org.apache.commons/commons-lang3 "3.7"]]
  :main ^:skip-aot {{namespace}}
  :target-path "target/%s"
:profiles {:uberjar {:aot :all}})
