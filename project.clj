(defproject cljs-log "0.2.1"
  :description  "Logging macros for Clojurescript"
  :url          "https://github.com/postspectacular/cljs-log"
  :license      {:name "Apache Software License 2.0"
                 :url "http://www.apache.org/licenses/LICENSE-2.0"}

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-3117"]
                 [environ "1.0.0"]]

  :plugins      [[lein-cljsbuild "1.0.5"]
                 [lein-environ "1.0.0"]]

  :cljsbuild    {:builds [{:id "dev"
                           :source-paths ["src" "test"]
                           :compiler {:output-to "resources/public/js/app.js"
                                      :optimizations :whitespace}}]}

  :pom-addition [:developers [:developer
                              [:name "Karsten Schmidt"]
                              [:url "http://postspectacular.com"]
                              [:timezone "0"]]])
