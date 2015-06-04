(ns reframe-test.core
    (:require [reagent.core :as reagent]
              [re-frame.core :as re-frame]
              [reframe-test.handlers]
              [reframe-test.subs]
              [reframe-test.routes :as routes]
              [reframe-test.views :as views]))

(defn mount-root []
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init [] 
  (routes/app-routes)
  (re-frame/dispatch-sync [:initialize-db])
  (mount-root))
