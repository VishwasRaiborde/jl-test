Feature:
provide list of products that have had a price reduction

Narrative:priceLabel<String>. An optional query parm called labelType can be set to any of
ShowWasNow - in which case return a string saying “Was £x.xx, now £y.yyy”. 
ShowWasThenNow - in which case return a string saying “Was £x.xx, then £y.yy, now £z.zzz”. If the original price.then2 is not empty use that for the “then” price otherwise use the then1 price. If the then1 price is also empty then don’t show the “then” price
ShowPercDscount  - in which case return “x% off - now £y.yy” If the query parm is not set default to use ShowWasNow format in all cases use the price formatting as described for nowPrice


Scenario: when the price label is set to ShowWasNow should return now price in the format  “Was £x.xx, now £y.yyy”.
Given a rest url for product catalog is given https://jl-nonprod-syst.apigee.net/v1/categories/600001506/products?key=2ALHCAAs6ikGRBoy6eTHA58RaG097Fma
When a connection request is made to product catalog rest url
When filter on catalog data is ShowWasNow and sort order is highest reducing first
Then an  array of product should be provided as per the given condition

Scenario: when the price label is set to ShowWasThenNow should return now price in the format  “Was £x.xx, then £y.yy, now £z.zzz”.
Given a rest url for product catalog is given https://jl-nonprod-syst.apigee.net/v1/categories/600001506/products?key=2ALHCAAs6ikGRBoy6eTHA58RaG097Fma
When a connection request is made to product catalog rest url
When filter on catalog data is ShowWasThenNow and sort order is highest reducing first
Then an  array of product should be provided as per the given condition

Scenario: when the price label is set to ShowWasNow should return now price in the format  ““x% off - now £y.yy”.
Given a rest url for product catalog is given https://jl-nonprod-syst.apigee.net/v1/categories/600001506/products?key=2ALHCAAs6ikGRBoy6eTHA58RaG097Fma
When a connection request is made to product catalog rest url
When filter on catalog data is ShowPercDscount and sort order is highest reducing first
Then an  array of product should be provided as per the given condition


