(ns game-of-life-clojure.universe
      (:require [clojure.set :refer :all]))
(defn new-empty-universe
      []
      (set []))

(defn new-universe-of
      [& cells]
      (set cells))

(defn -potential-neighboring-cells-for
      [cell]
      (let 
      [x (first cell)
       y (second cell)]
        (set [[x (+ y 1)] [x (- y 1)]
             [(+ x 1) y] [(- x 1) y]
             [(+ x 1) (+ y 1)] [(- x 1) (- y 1)]
             [(- x 1) (+ y 1)] [(+ x 1) (- y 1)]])))

(defn -actual-neighboring-cells-for
      [cell universe]
      (clojure.set/intersection 
               universe 
               (-potential-neighboring-cells-for cell)))

(defn -check-conditions-for-live-cell
     [cell universe]
     (let [count-live-neighbours (count 
                                    (-actual-neighboring-cells-for cell universe))]
     (clojure.set/intersection 
            (and (> count-live-neighbours 1) (< count-live-neighbours 3)))))

(defn universe-empty?
      [universe]
      (empty? universe))

(defn next-generation-of-universe
      [universe]
      (let 
          [filter-fn #(-check-conditions-for-live-cell % universe)]
          (set
              (filter filter-fn universe))))


