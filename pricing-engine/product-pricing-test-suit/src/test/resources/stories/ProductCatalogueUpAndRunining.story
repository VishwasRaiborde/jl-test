Feature:
provide list of products that have had a price reduction

Narrative:As a recipient of the Product Catalog perform an action to ensure the provider system is up and running

Scenario: A valid rest url is provided and connection is successful 
Given a rest url for product catalog is given https://jl-nonprod-syst.apigee.net/v1/categories/600001506/products?key=2ALHCAAs6ikGRBoy6eTHA58RaG097Fma
When a connection request is made to product catalog rest url
Then a json array of product should be provided and confirm  end point are up and running