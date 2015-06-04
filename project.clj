(defproject reframe-test "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-3211"]
                 [reagent "0.5.0"]
                 [re-frame "0.4.0"]
                 [secretary "1.2.3"]
                 [lein-cljsbuild "1.0.6"]
                 [lein-figwheel "0.3.3"]]

  :source-paths ["src/clj"]

  :plugins [[lein-cljsbuild "1.0.6"]
            [lein-figwheel "0.3.3"]]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]

  :figwheel {:nrepl-port 7888}

  :cljsbuild {:builds [{:id "dev"
                        :source-paths ["src/cljs"]

                        :figwheel {:on-jsload "reframe-test.core/mount-root"}

                        :compiler {:main reframe-test.core
                                   :output-to "resources/public/js/compiled/app.js"
                                   :output-dir "resources/public/js/compiled/out"
                                   :asset-path "js/compiled/out"
                                   :source-map-timestamp true}}

                       {:id "min"
                        :source-paths ["src/cljs"]
                        :compiler {:main reframe-test.core
                                   :output-to "resources/public/js/compiled/app.js"
                                   :optimizations :advanced
                                   :pretty-print false}}]})
