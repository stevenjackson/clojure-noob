(ns clojure-noob.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "I'm a little teapot!"))

(def name "Chewbacca")
(println (str "\"Uggglglglglglglglglggg\" - " name))

(def one {:a 1
 :b "boring example"
 :c []})

(def two{"string-key" +})
(def three{:name {:first "John" :middle "Jacob" :last "Jingleheimerschmidt"}})

(get one :a)
(:a one)
(get two "string-key")
(get (get three :name) :middle)

((get two "string-key") 1 2)

(def v [3 2 1])
(get v 0)

(def l '(100 200 300 400))
(nth l 3)

(def s #{"hannah montana" 2 400.2})
(get s 2)

(def failed-protagonist-names
  ["Larry Potter"
   "Doreen the Explorer"
   "The Incredible Bulk"])

(inc 3.3)

(map inc [0 1 2 3])

(+ (inc 12)(/ (- 20 2) 100.0))

(defn too-enthusiastic
  "Return a cheer that might be a bit too enthusiastic"
  [name]
  (str "OH. MY. GOD!" name "YOU ARE THE BESTEST MAN SLASH WOMAN EVER"))

(too-enthusiastic "Zelda")

(defn no-params
  []
  "I take no params")

(defn one-param
  [x]
  (str "I take one param, it better be a string!" x))

(defn two-params
  [x y]
  (str "Two params. SMOOSH  " x y))

(defn multi-arity
  ([]
    "No params")
  ([x]
    "One param")
  ([x y]
    "Two params"))

(defn x-chop
  ([name chop-type]
    (str "I " chop-type name "hai-ya!"))
  ([name]
   (x-chop name "karate!")))

(defn codger-communication
  [whippersnapper]
  (str "Get off my lawn, " whippersnapper))

(defn codger
  [& whippersnappers]
  (map codger-communication whippersnappers))

(defn favorite-things
  [name & things]
  (str "Hi, " name " here are some of my favorite things: "
       (clojure.string/join ", " things)))

(defn destructuring
  [[f s t]]
  s)

(defn named-args
  [{:keys [lat lon]}]
  (println (str "Lat is " lat))
  (println (str "Lon is " lon)))

(defn anon-functions
  ([x]
    (#(* % 3) x))
  ([x y]
    (#(* %1 %2) x y)))
