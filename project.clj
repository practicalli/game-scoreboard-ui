(defproject game-scoreboard-ui "0.1.0-SNAPSHOT"
  :description "Web UI to show the results of calling the Game Scoreboard API"
  :url "https://github.com/practicalli/game-scoreboard-ui"
  :license {:name "Creative Commons Attribution Share-Alike 4.0 International"
            :url  "https://creativecommons.org"}

  :min-lein-version "2.7.1"

  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/clojurescript "1.10.339"]
                 [reagent "0.8.1"]
                 [cljs-http "0.1.46"]]

  :source-paths ["src"]

  :aliases {"fig"       ["trampoline" "run" "-m" "figwheel.main"]
            "fig:build" ["trampoline" "run" "-m" "figwheel.main" "-b" "dev" "-r"]
            "fig:min"   ["run" "-m" "figwheel.main" "-O" "advanced" "-bo" "dev"]
            "fig:test"  ["run" "-m" "figwheel.main" "-co" "test.cljs.edn" "-m" game-scoreboard-ui.test-runner]}

  :profiles {:dev {:dependencies [[com.bhauman/figwheel-main "0.1.9"]
                                  [com.bhauman/rebel-readline-cljs "0.1.4"]]
                   }})
