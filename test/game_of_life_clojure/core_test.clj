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
        (testing "A universe with one neighbouring cells should have no cells in the next generation"
                 (is (universe-empty? (next-generation-of-universe (new-universe-of [0 0] [0 1]))))))

(deftest universe-with-three-adjacent-cells-to-next-generaton
        (testing "A universe with two neighbouring cells in one line should have one cell in the next generation"
                 (is (not (universe-empty? (next-generation-of-universe (new-universe-of [0 0] [0 1] [0 2])))))))

(deftest universe-with-three-adjacent-cells-to-next-generaton-should-have-one-cell
        (testing "A universe with 3 cells in a diagonal pattern should end up with 1 cell in the next generation"
                 (is (= 1 (total-cells (next-generation-of-universe (new-universe-of [0 0] [1 1] [2 2])))))))

(deftest universe-with-four-adjacent-cells-to-next-generation-should-have-one-cell
        (testing "A universe with 3 neighbouring cells in a diagonal pattern shoule end up with 2 cell in the next generaiton"
                 (is (= 2 (total-cells (next-generation-of-universe (new-universe-of [0 0] [1 1] [2 2] [0 -1])))))))
