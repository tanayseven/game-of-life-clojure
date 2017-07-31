(ns game-of-life-clojure.universe)
(defn new-empty-universe
      []
      (set []))

(defn new-universe-of
      [& cells]
      (set cells))

(defn neighboring-cells-for
      [cell]
      (set [cell (+ cell 1)] [cell (- cell 1)]
           [(+ cell 1) cell] [(- cell 1) cell]
           [(+ cell 1) (+ cell 1)] [(- cell 1) (- cell 1)]
           [(- cell 1) (+ cell 1)] [(+ cell 1) (- cell 1)]))

(defn universe-empty?
      [universe]
      (empty? universe))

(defn next-generation-of-universe
      [universe]
      (let [alive-neighbours 
                (clojure.set/intersection universe ())]
           (set (remove #(= [0 0] %) universe))))
