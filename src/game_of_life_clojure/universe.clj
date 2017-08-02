(ns game-of-life-clojure.universe
      (:require [clojure.set :refer :all]))
(defn new-empty-universe
      []
      (set []))

(defn new-universe-of
      [& cells]
      (set cells))

(defn neighboring-cells-for
      [cell]
      (let 
      [x (first cell)
       y (second cell)]
        (set [[x (+ y 1)] [x (- y 1)]
             [(+ x 1) y] [(- x 1) y]
             [(+ x 1) (+ y 1)] [(- x 1) (- y 1)]
             [(- x 1) (+ y 1)] [(+ x 1) (- y 1)]])))

(defn universe-empty?
      [universe]
      (empty? universe))

(defn next-generation-of-universe
      [universe]
      (let 
      []
      (set 
         (filter #(> (count (clojure.set/intersection universe (neighboring-cells-for %))) 2) universe))))


