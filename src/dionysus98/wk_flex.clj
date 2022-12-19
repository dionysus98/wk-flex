(ns dionysus98.wk-flex)

(defn style
  "Receives a map of style attributes as key-val and returns a map with a single key called :style, 
   holding all the style attributes in a string as required by html inline styles.   
   e.g: (style {:margin '45px' :text-align 'center}) -> {:style 'margin:45px; text-align:center;'}     
   "
  [params]
  (let [fmt-str #(let [[kwd val] %]
                   (str (name kwd) ":" val "; "))
        create-style (->> params (map fmt-str) (apply str) .trim)]
    {:style create-style}))

(defn wk-flex-box-styles
  "Params @map: with params => (wk-flex-box-styles {:margin-top '0.4rem'})
                or without  => (wk-flex-box-style)
   return @map"
  ([params]
   (let [p params
         wk-flex {:display "flex"
                  :justify-content (if (:justify-content p) (:justify-content p) "center")
                  :align-items (if (:align-items p) (:align-items p) "center")
                  :-webkit-box-align (if (:align-items p) (:align-items p) "center")
                  :-webkit-box-pack (if (:justify-content p) "justify" "center")
                  :-webkit-box-orient (if (= (:flex-direction p) "column") "vertical" "horizontal")}
         merged-style (-> wk-flex
                          (merge p)
                          style
                          :style
                          (str " display:-webkit-box;"))]
     {:style merged-style}))
  ([]
   (wk-flex-box-styles {})))