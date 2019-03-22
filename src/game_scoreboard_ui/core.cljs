;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; game-scoreboard-ui
;;
;; A figwheel-main project with reagent
;;
;; A Single Page App to show how to consume
;; the Game Scoreboard API.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(ns ^:figwheel-hooks game-scoreboard-ui.core
  (:require
   [goog.dom :as gdom]
   [reagent.core :as reagent :refer [atom]]))

;; Helper functions
;;;;;;;;;;;;;;;;;;;

(println "This text is printed from src/game_scoreboard_ui/core.cljs. Go ahead and edit it and see reloading in action.")

(defn multiply [a b] (* a b))

;; Data model
;;;;;;;;;;;;;
;; define your app data so that it doesn't get over-written on reload
(defonce app-state (atom {:website-title    "Global Scoreboard"
                          :website-subtitle "Player scores from around the world"}))

;; local test data - to be replaced by api call
(def scoreboard-source [{:player-name "RachelRiot"
                         :score       5448983438944}
                        {:player-name "JennyJetpack"
                         :score       489743984372}])

;; Web page components
;;;;;;;;;;;;;;;;;;;;;;

(defn score-card
  "Visualises score details using Bluma styles"
  [score-details]
  [:div {:class "box"}
   [:h1 {:class "title"}(:player-name score-details)]
   [:h3 {:class "subtitle"}(:score score-details)]])

(defn scoreboard
  "Display all the player scores
  Takes a vector of maps, for each map a player-card is created "
  [score-map]
  [:section {:class "section"}
   [:div {:class "content"}
    (for [player-details score-map]
      [score-card player-details])]])


(defn scoreboard-page []
  [:div
   [:section {:class "hero is-info is-bold"}
    [:div {:class "hero-body"}
     [:div {:class "container"}
      [:h1 {:class "title"}(:website-title @app-state)]
      [:h3 {:class "subtitle"}(:website-subtitle @app-state)]]]]

   [scoreboard scoreboard-source]
   ]
  )


;; System related functions
;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn get-app-element []
  (gdom/getElement "app"))

(defn mount [el]
  (reagent/render-component [scoreboard-page] el))

(defn mount-app-element []
  (when-let [el (get-app-element)]
    (mount el)))

;; conditionally start your application based on the presence of an "app" element
;; this is particularly helpful for testing this ns without launching the app
(mount-app-element)

;; specify reload hook with ^;after-load metadata
(defn ^:after-load on-reload []
  (mount-app-element)
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)


;; REPL Design Journal
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; The code in this section is commented so it will only be run when
;; a developer manually evaluates it.
;; Code is commented using the reader macro comment, `#_`

;; Manipulating the state of the UI
;;;;;

;; The UI state is held in a reagent atom, a mutable container
;; Reagent watches for changes to the atom and calls any components
;; that would be affected by that change, causing the component to be redrawn.

;; The atom is named `app-state` and was created by the figwheel Leiningen
;; template when we created the project.

;; The atom is defined using `defonce` so the atom does not change when
;; you save code changes, unless the code specifically updates the atom.

;; The state can be changed using the `swap!` and `reset!` functions
;; either in functions you call or when just experimenting in the repl.


;; Replace an existing value
#_(swap! app-state assoc :text "Hello REPL, my friend")

;; Create a new value
#_(swap! app-state assoc :title "Hello REPL, my friend")

;; Reset the state back to the original state
#_(reset! app-state {:text "Hello world!"})




;; Bulma CSS Library
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Bulma is a CSS library for websites based on flexbox
;; Bluma is said to be a little simpler than Bootstrap and considerably
;; smaller.  Not sure if this is just due to not having an JavaScript.

;; Getting started
;; https://bulma.io/documentation/overview/start/

;; CDN
;; There are three links, I am assuming bluma.min.css is the only one
;; needed as we will just be using it minified.
;; https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.4/css/bulma.min.css

;; need to add this to either an index.html page or as a hiccup page in the Clojure code.

;; In the index.html, add the following in the <head></head> tag (uncommented)
;; <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.4/css/bulma.min.css">
;; <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>

;; Then add styles to our existing Clojure code, specifically our `hello-world` component

;; Add a section (provides a nice margin), with a container, that displays our title and some paragraph text

#_
(defn hello-world []
  [:section {:class "section"}
   [:div {:class "container"}
    [:h1 {:class "title"}(:text @app-state)]
    [:h3 "A simple component that also displays the data model"]]])


;; Refactor to scoreboard
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; update the app-state to include basic info about the website

#_
(defonce app-state (atom {:website-title    "Global Scoreboard"
                          :website-subtitle "Player scores from around the world"}))

;; update the component function that represents the scoreboard single page app

#_
(defn scoreboard []
  [:section {:class "section"}
   [:div {:class "container"}
    [:h1 {:class "title"}(:website-title @app-state)]
    [:h3 (:website-subtitle @app-state)]]])

;; update the system code to use the new component

#_
(defn mount [el]
  (reagent/render-component [scoreboard] el))


;; scoreboard-source
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; local test data - to be replaced by api call
#_
(def scoreboard-source [{:player-name "RachelRiot"
                         :score       5448983438944}
                        {:player-name "JennyJetpack"
                         :score       489743984372}])
