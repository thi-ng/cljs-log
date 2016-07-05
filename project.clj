(defproject cljs-log "0.2.3"
  :description  "Logging macros for Clojurescript"
  :url          "https://github.com/postspectacular/cljs-log"
  :license      {:name "Apache Software License 2.0"
                 :url "http://www.apache.org/licenses/LICENSE-2.0"}

  :dependencies [[environ "1.0.3"]]

  :jar-exclusions [#"^public/"]

  :profiles     {:provided {:dependencies [[org.clojure/clojure "1.8.0"]
                                           [org.clojure/clojurescript "1.9.89"]]}

                 :dev      {:plugins      [[lein-cljsbuild "1.1.3"]
                                           [lein-environ "1.0.3"]]
                            :cljsbuild    {:builds
                                           [{:id "dev"
                                             :source-paths ["src" "test"]
                                             :compiler {:output-to "resources/public/js/app.js"
                                                        :optimizations :whitespace}}]}}}

  :pom-addition [:developers [:developer
                              [:name "Karsten Schmidt"]
                              [:url "http://postspectacular.com"]
                              [:timezone "0"]]])
