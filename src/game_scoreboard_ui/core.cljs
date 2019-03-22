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
(defonce app-state (atom {:text "Hello world!"}))


;; Web page components
;;;;;;;;;;;;;;;;;;;;;;

(defn hello-world []
  [:div
   [:h1 (:text @app-state)]
   [:h3 "A simple component that also displays the data model"]])


;; System related functions
;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn get-app-element []
  (gdom/getElement "app"))

(defn mount [el]
  (reagent/render-component [hello-world] el))

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
