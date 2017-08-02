(ns game-of-life-clojure.core-test
    (:require [clojure.test :refer :all]
      [game-of-life-clojure.core :refer :all]
      [game-of-life-clojure.universe :refer :all]))

(deftest an-empty-universe-no-cells
         (testing "Test for an empty universe with no cells"
                  (is (universe-empty? (new-empty-universe)))))

(deftest non-empty-universe-one-cell
         (testing "A universe with one cell should not be empty"
                   (is (not (universe-empty? (new-universe-of [0 0]))))))

(deftest universe-with-one-cell-to-next-generation
         (testing "A universe with one cell should die because it has not neighbours"
                  (is (universe-empty? (next-generation-of-universe (new-universe-of [0 0]))))))

(deftest universe-with-two-cells-to-next-generation
        (testing "A universe with two neighbouring cells should have no cells in the next generation"
                 (is (universe-empty? (next-generation-of-universe (new-universe-of [0 0] [0 1]))))))


