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
