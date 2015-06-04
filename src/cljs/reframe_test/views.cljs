(ns reframe-test.views
    (:require [re-frame.core :as re-frame]))

;; --------------------
(defn home-panel []
  (let [name (re-frame/subscribe [:name])]
    (fn []
      [:div (str "Bye !!!" @name ". This is the Home Page.")
       [:div [:a {:href "#/about"} "go to About Page"]]])))

(defn about-panel []
  (fn []
    [:div "This is the About Page."
     [:div [:a {:href "#/"} "go to Home Page"]]]))

;; --------------------
(defmulti panels identity)
(defmethod panels :home-panel [] [home-panel])
(defmethod panels :about-panel [] [about-panel])
(defmethod panels :default [] [:div])

(defn main-panel []
  (let [active-panel (re-frame/subscribe [:active-panel])]
    (fn []
      (panels @active-panel))))


(reset! re-frame.db/app-db {:name "re-frame" :active-panel :about-panel})
