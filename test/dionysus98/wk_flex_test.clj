(ns dionysus98.wk-flex-test
  (:require [clojure.test :as ct]
            [dionysus98.wk-flex :refer [style wk-flex-box-styles]]))

(def default-wk
  {:style "display:flex; justify-content:center; align-items:center; -webkit-box-align:center; -webkit-box-pack:center; -webkit-box-orient:horizontal; display:-webkit-box;"})

(def merged-wk
  {:style "display:flex; justify-content:space-around; align-items:center; -webkit-box-align:center; -webkit-box-pack:justify; -webkit-box-orient:horizontal; display:-webkit-box;"})

(def default-style
  {:style "margin:10px;"})

(ct/deftest wk-flex-default-test
  (ct/testing "Check if wk_flex style contents generated without any params"
    (ct/is (= (wk-flex-box-styles) default-wk))))

(ct/deftest style-test
  (ct/testing "Check if wk_flex style contents generated without any params"
    (ct/is (= (style {:margin "10px"}) default-style))))

(ct/deftest wk-flex-merged-params-test
  (ct/testing "Check if wk_flex style contents generated with params"
    (ct/is (= (wk-flex-box-styles {:justify-content "space-around"}) merged-wk))))

(ct/deftest wrong-wk-flex-merged-params-test
  (ct/testing "Check if wk_flex style contents generated with params fails"
    (ct/is (not= (wk-flex-box-styles {:justify-content "space-around"}) default-style))))