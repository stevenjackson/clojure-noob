(ns clojure-noob.hobbit)
(def asym-hobbit-body-parts [ {:name "head" :size 3}
                              {:name "left-eye" :size 1}
                              {:name "left-ear" :size 1}
                              {:name "mouth" :size 1}
                              {:name "nose" :size 1}
                              {:name "neck" :size 2}
                              {:name "left-shoulder" :size 3}
                              {:name "left-upper-arm" :size 3}
                              {:name "chest" :size 10}
                              {:name "back" :size 10}
                              {:name "left-forearm" :size 3}
                              {:name "abdomen" :size 6}
                              {:name "left-kidney" :size 1}
                              {:name "left-hand" :size 2}
                              {:name "left-knee" :size 2}
                              {:name "left-thigh" :size 4}
                              {:name "left-lower-leg" :size 3}
                              {:name "left-achilles" :size 1}
                              {:name "left-foot" :size 2}])

(defn has-matching-part?
  [part]
  (re-find #"^left-" (:name part)))

(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})

(defn symmetrize-body-parts
  "Expects a sequence of maps which have a :name and :size"
  [asym-body-parts]
  (reduce (fn [parts-list part]
    ; in-order to access the "modified" parts-list, all of the code that acts on it needs to be in the same let macro.  It's like an immutable block.
    (let [parts-list (conj parts-list part)]
      (if (has-matching-part? part)
        (conj parts-list (matching-part part))
        parts-list)))
    []
    asym-body-parts))

(def hobbit-body-parts
  (symmetrize-body-parts asym-hobbit-body-parts))

(defn hit
  [body-parts]
  (let [body-part-size-sum (reduce + 0 (map :size body-parts))
       target (inc (rand body-part-size-sum))]
    (loop [[part & rest] body-parts
           accumulated-size (:size part)]
      (if (> accumulated-size target)
         part
        (recur rest (+ accumulated-size (:size part)))))))
